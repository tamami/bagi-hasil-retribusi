package lab.aikibo.viewmodel;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.DependsOn;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.util.Clients;

import lab.aikibo.entity.JenisRetribusi;
import lab.aikibo.entity.Realisasi;
import lab.aikibo.manager.JenisRetribusiManager;
import lab.aikibo.manager.KecamatanManager;
import lab.aikibo.manager.KelurahanManager;
import lab.aikibo.manager.RealisasiManager;
import lab.aikibo.manager.SkpdManager;
import lab.aikibo.services.UserCredential;
import lab.aikibo.util.FormattingList;

public class RealisasiVM {
	
	private List<String> daftarRetribusi;
	private List<Realisasi> daftarRealisasi;
	private List<String> daftarKecamatan;
	private List<String> daftarKelurahan;
	private List<String> daftarSkpd;
	private Long currentNomor;
	private Realisasi currentRealisasi;
	private String currentRetribusi;
	private String currentKecamatan;
	private String currentKelurahan;
	private String currentSkpd;
	private Date currentTanggal;
	private RealisasiManager rm;
	private JenisRetribusiManager jrm;
	private KecamatanManager kecM;
	private KelurahanManager kelM;
	private SkpdManager skpdM;
	
	@Init
	public void init() {
		rm = new RealisasiManager();
		jrm = new JenisRetribusiManager();
		kecM = new KecamatanManager();
		kelM = new KelurahanManager();
		skpdM = new SkpdManager();
		clear();
	}
	
	private void clear() {
		currentNomor = new Long(1);
		currentRealisasi = new Realisasi();
		currentTanggal = null; // Calendar.getInstance().getTime();
		daftarRetribusi = FormattingList.getFormattedRetribusi(jrm.getListJenisRetribusi());
		daftarRealisasi = rm.getDaftarRealisasi();
		currentRetribusi = new String();
		daftarKecamatan = kecM.getFormattedKecamatan();
		currentKecamatan = new String();
		daftarKelurahan = new LinkedList<String>();
		currentKelurahan = new String();
		daftarSkpd = skpdM.getDaftarSkpd();
		currentSkpd = new String();
	}
	
	@Command
	@NotifyChange({"currentNomor","currentRealisasi","daftarRetribusi","currentRetribusi",
		"currentKecamatan", "currentKelurahan", "currentSkpd", "currentTanggal", 
		"daftarRealisasi"})
	public void saveOrUpdate() {
		currentRealisasi.setNomor(currentNomor);
		currentRealisasi.setKodeRetribusi(currentRetribusi.substring(0,2));
		currentRealisasi.setKodeKecamatan(currentKecamatan.substring(0,3));
		currentRealisasi.setKodeKelurahan(currentKelurahan.substring(0,3));
		currentRealisasi.setKodeSkpd(currentSkpd.substring(0,2));
		currentRealisasi.setTanggalRealisasi(currentTanggal);
		rm.saveOrUpdate(currentRealisasi);
		Clients.showNotification("Data telah tersimpan");
		clear();
	}
	
	
	// -- setter and getter

	public Long getCurrentNomor() {
		return currentNomor;
	}

	public void setCurrentNomor(Long currentNomor) {
		this.currentNomor = currentNomor;
		currentRealisasi.setNomor(currentNomor);
	}

	public Realisasi getCurrentRealisasi() {
		return currentRealisasi;
	}

	@NotifyChange({"currentNomor","currentRealisasi","currentRetribusi","currentKecamatan",
		"currentKelurahan","currentSkpd","currentTanggal"})
	public void setCurrentRealisasi(Realisasi currentRealisasi) {
		this.currentRealisasi = currentRealisasi;
		currentNomor = currentRealisasi.getNomor();
		currentRetribusi = jrm.getFormattedJnsRetribusiByKode(currentRealisasi.getKodeRetribusi());
		currentKecamatan = kecM.getFormattedKecamatanByKode(currentRealisasi.getKodeKecamatan());
		currentKelurahan = kelM.getFormattedKelurahanByKode(currentRealisasi.getKodeKecamatan(), 
				currentRealisasi.getKodeKelurahan());
		currentSkpd = skpdM.getFormattedSkpdByKode(currentRealisasi.getKodeSkpd());
		currentTanggal = currentRealisasi.getTanggalRealisasi();
	}

	public List<String> getDaftarRetribusi() {
		return daftarRetribusi;
	}

	public void setDaftarRetribusi(List<String> daftarRetribusi) {
		this.daftarRetribusi = daftarRetribusi;
	}

	public String getCurrentRetribusi() {
		
		return currentRetribusi;
	}

	public void setCurrentRetribusi(String currentRetribusi) {
		this.currentRetribusi = currentRetribusi;
		currentRealisasi.setKodeRetribusi(this.currentRetribusi.substring(0,2));
	}
	
	public List<Realisasi> getDaftarRealisasi() {
		return daftarRealisasi;
	}

	public void setDaftarRealisasi(List<Realisasi> daftarRealisasi) {
		this.daftarRealisasi = daftarRealisasi;
	}

	public RealisasiManager getRm() {
		return rm;
	}

	public void setRm(RealisasiManager rm) {
		this.rm = rm;
	}

	public JenisRetribusiManager getJrm() {
		return jrm;
	}

	public void setJrm(JenisRetribusiManager jrm) {
		this.jrm = jrm;
	}

	public List<String> getDaftarKecamatan() {
		return daftarKecamatan;
	}

	public void setDaftarKecamatan(List<String> daftarKecamatan) {
		this.daftarKecamatan = daftarKecamatan;
	}

	public KecamatanManager getKecM() {
		return kecM;
	}

	public void setKecM(KecamatanManager kecM) {
		this.kecM = kecM;
	}

	public KelurahanManager getKelM() {
		return kelM;
	}

	public void setKelM(KelurahanManager kelM) {
		this.kelM = kelM;
	}

	public List<String> getDaftarKelurahan() {
		return daftarKelurahan;
	}

	@DependsOn("currentKecamatan")
	public void setDaftarKelurahan(List<String> daftarKelurahan) {
		this.daftarKelurahan = daftarKelurahan;
	}

	public String getCurrentKecamatan() {
		return currentKecamatan;
	}

	@NotifyChange("daftarKelurahan")
	public void setCurrentKecamatan(String currentKecamatan) {
		this.currentKecamatan = currentKecamatan;
		daftarKelurahan = FormattingList.getFormattedKelurahan(
				kelM.getListKelurahanByKecamatan(currentKecamatan.substring(0,3)));
	}

	public String getCurrentKelurahan() {
		return currentKelurahan;
	}

	public void setCurrentKelurahan(String currentKelurahan) {
		this.currentKelurahan = currentKelurahan;
	}
	
	public List<String> getDaftarSkpd() {
		return this.daftarSkpd;
	}
	
	public void setDaftarSkpd(List<String> daftarSkpd) {
		this.daftarSkpd = daftarSkpd;
	}
	
	public void setCurrentSkpd(String currentSkpd) {
		this.currentSkpd = currentSkpd;
	}
	
	public String getCurrentSkpd() {
		return this.currentSkpd;
	}

	public SkpdManager getSkpdM() {
		return skpdM;
	}

	public void setSkpdM(SkpdManager skpdM) {
		this.skpdM = skpdM;
	}

	public Date getCurrentTanggal() {
		return currentTanggal;
	}

	@NotifyChange("currentNomor")
	public void setCurrentTanggal(Date currentTanggal) {
		this.currentTanggal = currentTanggal;
		currentNomor = rm.getNewNumber(currentRetribusi.substring(0,2), 
				Integer.toString(currentTanggal.getYear() + 1900));
	}

}
