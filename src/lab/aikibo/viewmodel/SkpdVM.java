package lab.aikibo.viewmodel;

import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.util.Clients;

import lab.aikibo.entity.Skpd;
import lab.aikibo.manager.SkpdManager;

public class SkpdVM {
	
	private Skpd currentSkpd;
	private List<Skpd> daftarSkpd;
	private SkpdManager sm;
	
	@Init
	public void init() {
		sm = new SkpdManager();
		clear();
	}
	
	public void clear() {
		currentSkpd = new Skpd();
		daftarSkpd = sm.getNaturalSkpd();
	}
	
	@Command
	@NotifyChange({"currentSkpd", "daftarSkpd"})
	public void saveOrUpdate() {
		if(currentSkpd != null || !currentSkpd.getKodeSkpd().equals("") ||
				currentSkpd.getKodeSkpd() != null || !currentSkpd.getNamaSkpd().equals("") ||
				currentSkpd.getNamaSkpd() != null) {
			String temp = currentSkpd.getNamaSkpd();
			currentSkpd.setNamaSkpd(temp.toUpperCase());
			sm.saveOrUpdate(currentSkpd);
			Clients.showNotification("Data " + currentSkpd.getKodeSkpd() + " - " +
					currentSkpd.getNamaSkpd() + " berhasil disimpan.",
					Clients.NOTIFICATION_TYPE_INFO, null, "middle_center", 250);
			clear();
		} else {
			Clients.showNotification("Silahkan lengkapi datanya terlebih dahulu", true);
		}
	}
	
	
	// -- setter and getter

	public Skpd getCurrentSkpd() {
		return currentSkpd;
	}

	public void setCurrentSkpd(Skpd currentSkpd) {
		this.currentSkpd = currentSkpd;
	}

	public List<Skpd> getDaftarSkpd() {
		return daftarSkpd;
	}

	public void setDaftarSkpd(List<Skpd> daftarSkpd) {
		this.daftarSkpd = daftarSkpd;
	}

	public SkpdManager getSm() {
		return sm;
	}

	public void setSm(SkpdManager sm) {
		this.sm = sm;
	}

}
