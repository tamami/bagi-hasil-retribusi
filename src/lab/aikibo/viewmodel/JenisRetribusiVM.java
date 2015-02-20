package lab.aikibo.viewmodel;

import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.util.Clients;

import lab.aikibo.entity.JenisRetribusi;
import lab.aikibo.manager.JenisRetribusiManager;
import lab.aikibo.util.FormattingList;

public class JenisRetribusiVM {
	
	private JenisRetribusiManager jrm;
	private JenisRetribusi currentJenisRetribusi;
	private List<JenisRetribusi> daftarJenisRetribusi;
	
	@Init
	public void init() {
		jrm = new JenisRetribusiManager();
		clear();
	}
	
	public void clear() {
		currentJenisRetribusi = new JenisRetribusi();
		daftarJenisRetribusi = jrm.getListJenisRetribusi();
	}
	
	@Command
	@NotifyChange({"currentJenisRetribusi", "daftarJenisRetribusi"})
	public void save() {
		if(!currentJenisRetribusi.getKdRetribusi().equals("") ||
				currentJenisRetribusi != null) {
			currentJenisRetribusi.setNmRetribusi(FormattingList.getUpperCase(currentJenisRetribusi.getNmRetribusi()));
			jrm.saveOrUpdate(currentJenisRetribusi);
			Clients.showNotification("Data " + currentJenisRetribusi.getKdRetribusi() + "-" + 
					currentJenisRetribusi.getNmRetribusi() + " telah tersimpan", 
					Clients.NOTIFICATION_TYPE_INFO, null, "middle_center", 150);
			clear();
		} else {
			Clients.showNotification("Data anda mungkin belum lengkap, silahkan teliti " +
					"ulang datanya.", true);
		}
	}
	
	
	// -- setter and getter

	public JenisRetribusi getCurrentJenisRetribusi() {
		return currentJenisRetribusi;
	}

	public void setCurrentJenisRetribusi(JenisRetribusi currentJR) {
		this.currentJenisRetribusi = currentJR;
	}

	public List<JenisRetribusi> getDaftarJenisRetribusi() {
		return daftarJenisRetribusi;
	}

	public void setDaftarJenisRetribusi(List<JenisRetribusi> daftarJR) {
		this.daftarJenisRetribusi = daftarJR;
	}

}
