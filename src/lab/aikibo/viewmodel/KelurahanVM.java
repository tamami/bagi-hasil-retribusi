package lab.aikibo.viewmodel;

import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.util.Clients;

import lab.aikibo.entity.Kelurahan;
import lab.aikibo.manager.KecamatanManager;
import lab.aikibo.manager.KelurahanManager;
import lab.aikibo.util.FormattingList;

public class KelurahanVM {
	
	private KelurahanManager km;
	private KecamatanManager kecm;
	private Kelurahan currentKelurahan;
	private String[] currentData;
	private List<Object[]> daftarKelurahan;
	private List<String> daftarKecamatan;
	private String dataKecamatan;
	
	public void clear() {
		currentKelurahan = new Kelurahan();
		daftarKelurahan = km.getDaftarKelurahan();
		dataKecamatan = "";
		daftarKecamatan = FormattingList.getFormattedKecamatan(kecm.getListKecamatan());
	}

	@Init
	public void init() {
		km = new KelurahanManager();
		kecm = new KecamatanManager();
		clear();
	}
	
	@Command
	@NotifyChange({"daftarKelurahan", "currentKelurahan", "currentData", "dataKecamatan"})
	public void save() {
		if(!currentKelurahan.getKdKelurahan().equals("") ||
				currentKelurahan.getKdKelurahan() != null) {
			String temp = currentKelurahan.getNmKelurahan();
			currentKelurahan.setNmKelurahan(temp.toUpperCase());
			km.saveOrUpdate(currentKelurahan);
			Clients.showNotification("Data " + currentKelurahan.getKdKecamatan() +
					"." + currentKelurahan.getKdKelurahan() + " - " +
					currentKelurahan.getNmKelurahan() +
					" telah tersimpan.", Clients.NOTIFICATION_TYPE_INFO, null, 
					"middle_center", 150);
		} else {
			Clients.showNotification("Isikan dulu datanya!");
		}
		clear();
	}
	
	
	// -- setter and getter
	
	public KelurahanManager getKm() {
		return km;
	}
	
	public void setKm(KelurahanManager km) {
		this.km = km;
	}

	public Kelurahan getCurrentKelurahan() {
		return currentKelurahan;
	}

	public void setCurrentKelurahan(Kelurahan currentKelurahan) {
		this.currentKelurahan = currentKelurahan;
	}

	public List<Object[]> getDaftarKelurahan() {
		return daftarKelurahan;
	}

	public void setDaftarKelurahan(List<Object[]> daftarKelurahan) {
		this.daftarKelurahan = daftarKelurahan;
	}

	public String[] getCurrentData() {
		return currentData;
	}

	public void setCurrentData(String[] currentData) {
		this.currentData = currentData;
		this.currentKelurahan.setKdKecamatan(currentData[0].toString());
		this.currentKelurahan.setKdKelurahan(currentData[2].toString());
		this.currentKelurahan.setNmKelurahan(currentData[3].toString());
	}

	public List<String> getDaftarKecamatan() {
		return daftarKecamatan;
	}

	public void setDaftarKecamatan(List<String> daftarKecamatan) {
		this.daftarKecamatan = daftarKecamatan;
	}

	public String getDataKecamatan() {
		return dataKecamatan;
	}

	public void setDataKecamatan(String dataKecamatan) {
		this.dataKecamatan = dataKecamatan;
		this.currentKelurahan.setKdKecamatan(dataKecamatan.substring(0,3));
	}

}
