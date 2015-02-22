package lab.aikibo.viewmodel;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.DependsOn;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.util.Clients;

import lab.aikibo.entity.Potensi;
import lab.aikibo.manager.BulanManager;
import lab.aikibo.manager.JenisRetribusiManager;
import lab.aikibo.manager.KecamatanManager;
import lab.aikibo.manager.KelurahanManager;
import lab.aikibo.manager.PotensiManager;
import lab.aikibo.util.FormattingList;

public class PotensiVM {
	
	private JenisRetribusiManager jrm;
	private KecamatanManager kecM;
	private KelurahanManager kelM;
	private PotensiManager pm;
	private BulanManager bm;
	private List<Potensi> daftarPotensi;
	private List<String> daftarRetribusi;
	private List<String> daftarKecamatan;
	private List<String> daftarKelurahan;
	private List<String> daftarBulan;
	private Potensi currentPotensi;
	private String currentRetribusi;
	private String currentKecamatan;
	private String currentKelurahan;
	private String thnPotensi;
	private BigDecimal nilaiPotensi;
	private Integer blnPotensi;
	
	@Init
	public void init() {
		jrm = new JenisRetribusiManager();
		kecM = new KecamatanManager();
		kelM = new KelurahanManager();
		pm = new PotensiManager();
		bm = new BulanManager();
		
		clear();
	}
	
	private void clear() {
		setDaftarPotensi(pm.getDaftarPotensi());
		setDaftarRetribusi(FormattingList.getFormattedRetribusi(jrm.getListJenisRetribusi()));
		setDaftarKecamatan(FormattingList.getFormattedKecamatan(kecM.getListKecamatan()));
		setDaftarKelurahan(new LinkedList<String>());
		setDaftarBulan(bm.getFormattedDaftarBulan());
		currentPotensi = new Potensi();
		setCurrentRetribusi(new String());
		currentKecamatan = new String();
		setCurrentKelurahan(new String());
		thnPotensi = "";
		nilaiPotensi = new BigDecimal("0");
		blnPotensi = new Integer("0");
	}
	
	@Command
	@NotifyChange("daftarKelurahan")
	public void aturDaftarKelurahan(String kodeKecamatan) {
		setDaftarKelurahan(FormattingList.getFormattedKelurahan(kelM.getListKelurahanByKecamatan(kodeKecamatan)));
	}
	
	@Command
	@NotifyChange({"daftarPotensi", "currentRetribusi", "currentKecamatan", 
		"currentKelurahan", "thnPotensi", "nilaiPotensi", "blnPotensi"})
	public void saveOrUpdate() {
		currentPotensi = new Potensi(currentRetribusi.substring(0,2),
				currentKecamatan.substring(0,3), currentKelurahan.substring(0,3),
				thnPotensi, nilaiPotensi, blnPotensi);
		pm.saveOrUpdate(currentPotensi);
		Clients.showNotification("Data telah tersimpan");
		clear();
	}
	
	
	// -- setter and getter

	public List<Potensi> getDaftarPotensi() {
		return daftarPotensi;
	}

	public void setDaftarPotensi(List<Potensi> daftarPotensi) {
		this.daftarPotensi = daftarPotensi;
	}

	public List<String> getDaftarRetribusi() {
		return daftarRetribusi;
	}

	public void setDaftarRetribusi(List<String> daftarRetribusi) {
		this.daftarRetribusi = daftarRetribusi;
	}

	public List<String> getDaftarKecamatan() {
		return daftarKecamatan;
	}
	
	public void setDaftarKecamatan(List<String> daftarKecamatan) {
		this.daftarKecamatan = daftarKecamatan;
	}

	public List<String> getDaftarKelurahan() {
		return daftarKelurahan;
	}
	
	public void setDaftarKelurahan(List<String> daftarKelurahan) {
		this.daftarKelurahan = daftarKelurahan;
	}

	public Potensi getCurrentPotensi() {
		return currentPotensi;
	} 

	@NotifyChange({"currentRetribusi","currentKecamatan","currentKelurahan",
			"thnPotensi", "blnPotensi","nilaiPotensi"})
	public void setCurrentPotensi(Potensi currentPotensi) {
		this.currentPotensi = currentPotensi;
		currentRetribusi = jrm.getFormattedJnsRetribusiByKode(currentPotensi.getKdRetribusi());
		setCurrentKecamatan(kecM.getFormattedKecamatanByKode(currentPotensi.getKdKecamatan()));
		currentKelurahan = kelM.getFormattedKelurahanByKode(currentPotensi.getKdKecamatan(), 
				currentPotensi.getKdKelurahan());
		thnPotensi = currentPotensi.getThnPotensi();
		blnPotensi = bm.getIndexBulanByName(currentPotensi.getFormatBlnPotensi());
		nilaiPotensi = currentPotensi.getNilaiPotensi();
	}

	public String getCurrentRetribusi() {
		return currentRetribusi;
	}

	public void setCurrentRetribusi(String currentRetribusi) {
		this.currentRetribusi = currentRetribusi;
	}
	
	public String getCurrentKecamatan() {
		return currentKecamatan;
	}
	
	@NotifyChange("daftarKelurahan")
	public void setCurrentKecamatan(String currentKecamatan) {
		this.currentKecamatan = currentKecamatan;
		if(currentKecamatan.length() > 0) {
		    daftarKelurahan = FormattingList.getFormattedKelurahan(kelM.getListKelurahanByKecamatan(currentKecamatan.substring(0,3)));
		}
	}

	@DependsOn("currentKecamatan")
	public String getCurrentKelurahan() {
		return currentKelurahan;
	}

	public void setCurrentKelurahan(String currentKelurahan) {
		this.currentKelurahan = currentKelurahan;
	}
	
	public String getThnPotensi() {
		return thnPotensi;
	}
	
	public void setThnPotensi(String thnPotensi) {
		this.thnPotensi = thnPotensi;
	}
	
	public BigDecimal getNilaiPotensi() {
		return nilaiPotensi;
	}
	
	public void setNilaiPotensi(BigDecimal nilai) {
		this.nilaiPotensi = nilai;
	}
	
	public Integer getBlnPotensi() {
		return blnPotensi;
	}
	
	public void setBlnPotensi(Integer blnPotensi) {
		this.blnPotensi = blnPotensi;
	}

	public List<String> getDaftarBulan() {
		return daftarBulan;
	}

	public void setDaftarBulan(List<String> daftarBulan) {
		this.daftarBulan = daftarBulan;
	}

	public BulanManager getBm() {
		return bm;
	}

	public void setBm(BulanManager bm) {
		this.bm = bm;
	}
	  
}
