package lab.aikibo.viewmodel;

import java.util.List;

import org.zkoss.bind.annotation.Init;

import lab.aikibo.manager.BulanManager;
import lab.aikibo.manager.JenisRetribusiManager;

public class LaporanPerJenisVM {
	
	private BulanManager bm;
	private JenisRetribusiManager jrm;
	private List<String> daftarBulan;
	private List<String> daftarRetribusi;
	private String currentBulan;
	private String thnRekam;
	private String currentRetribusi;
	
	@Init
	public void init() {
		bm = new BulanManager();
		setJrm(new JenisRetribusiManager());
		clear();
	}
	
	public void clear() {
		daftarBulan = bm.getFormattedDaftarBulan();
		currentBulan = new String();
		setDaftarRetribusi(bm.getFormattedDaftarBulan());
		setCurrentRetribusi(new String());
	}
	
	
	// -- setter and getter
	
	public BulanManager getBm() {
		return bm;
	}
	
	public void setBm(BulanManager bm) {
		this.bm = bm;
	}
	
	public List<String> getDaftarBulan() {
		return daftarBulan;
	}
	
	public void setDaftarBulan(List<String> daftarBulan) {
		this.daftarBulan = daftarBulan;
	}
	
	public String getCurrentBulan() {
		return currentBulan;
	}
	
	public void setCurrentBulan(String bulan) {
		this.currentBulan = bulan;
	}

	public String getThnRekam() {
		return thnRekam;
	}

	public void setThnRekam(String thnRekam) {
		this.thnRekam = thnRekam;
	}

	public JenisRetribusiManager getJrm() {
		return jrm;
	}

	public void setJrm(JenisRetribusiManager jrm) {
		this.jrm = jrm;
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
	}

}
