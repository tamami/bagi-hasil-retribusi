package lab.aikibo.viewmodel;

import java.awt.Toolkit;
import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.event.ClientInfoEvent;
import org.zkoss.zk.ui.util.Clients;

import lab.aikibo.entity.Kecamatan;
import lab.aikibo.manager.KecamatanManager;

public class KecamatanVM {
	
	private KecamatanManager km;
	private Kecamatan currentKecamatan;
	private List<Kecamatan> daftarKecamatan;
	
	@Init
	public void init() {
		km = new KecamatanManager();
		clear();
	}
	
	public void clear() {
		currentKecamatan = new Kecamatan();
		daftarKecamatan = km.getListKecamatan();
	}
	
	@Command
	@NotifyChange({"daftarKecamatan","currentKecamatan"})
	public void simpan() {
		String temp = currentKecamatan.getNmKecamatan();
		currentKecamatan.setNmKecamatan(temp.toUpperCase());
		km.saveOrUpdate(currentKecamatan);
		Clients.showNotification("Data " + currentKecamatan.getKdKecamatan() + 
				" telah tersimpan.", Clients.NOTIFICATION_TYPE_INFO, null, 
				"middle_center", 150);
		
		clear();
	}
	
	
	
	// -- setter and getter
	
	public Kecamatan getCurrentKecamatan() {
		return currentKecamatan;
	}
	
	public void setCurrentKecamatan(Kecamatan kecamatan) {
		this.currentKecamatan = kecamatan;
	}

	public List<Kecamatan> getDaftarKecamatan() {
		return daftarKecamatan;
	}

	public void setDaftarKecamatan(List<Kecamatan> daftarKecamatan) {
		this.daftarKecamatan = daftarKecamatan;
	}

}
