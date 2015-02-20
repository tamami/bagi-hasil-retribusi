package lab.aikibo.viewmodel;

import java.io.Serializable;

import lab.aikibo.manager.UserManager;
import lab.aikibo.services.UserCredential;

import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Include;

public class MenuController implements Serializable {

	private static final long serialVersionUID = 7503379954543827857L;
	private UserManager um;
	private UserCredential uc;
	private boolean pengaturanMn;
	private boolean penggunaMn;
	private boolean menuMn;
	private boolean refKecamatanMn;
	private boolean refKelurahanMn;
	private boolean refJnsRetribusiMn;
	private boolean refSkpdMn;
	private boolean masukkanMn;
	private boolean potensiMn;
	private boolean realisasiMn;
	private boolean laporanMn;
	private boolean rekomendasiMn;
	private boolean perJnsRetribusiMn;
	
	@Init
	public void init() {
		um = new UserManager();
		Session session = Sessions.getCurrent();
		uc = (UserCredential) session.getAttribute("userCredential");
		setAllMenuFalse();
		prepareMenu();
	}
	
	private void setAllMenuFalse() {
		pengaturanMn = false;
		penggunaMn = false;
		menuMn = false;
		refKecamatanMn = false;
		refKelurahanMn = false;
		refJnsRetribusiMn = false;
		refSkpdMn = false;
		masukkanMn = false;
		potensiMn = false;
		realisasiMn = false;
		laporanMn = false;
		rekomendasiMn = false;
		perJnsRetribusiMn = false;
	}
	
	private void prepareMenu() {
		if(um.isAnyUser(uc.getNama())) {
			String menu = um.getMenu(uc.getNama());
			if(menu.substring(0,1).equals("1")) pengaturanMn = true;
			if(menu.substring(1,2).equals("1")) penggunaMn = true;
			if(menu.substring(2,3).equals("1")) menuMn = false;
			if(menu.substring(3,4).equals("1")) refKecamatanMn = true;
			if(menu.substring(4,5).equals("1")) refKelurahanMn = true;
			if(menu.substring(5,6).equals("1")) refJnsRetribusiMn = true;
			if(menu.substring(6,7).equals("1")) refSkpdMn = true;
			if(menu.substring(7,8).equals("1")) masukkanMn = true;
			if(menu.substring(8,9).equals("1")) potensiMn = true;
			if(menu.substring(9,10).equals("1")) realisasiMn = true;
			if(menu.substring(10,11).equals("1")) laporanMn = true;
			if(menu.substring(11,12).equals("1")) rekomendasiMn = true;
			if(menu.substring(12,13).equals("1")) perJnsRetribusiMn = true;
		} else {
			Clients.showNotification("Maaf, Anda tidak diberikan akses apapun, silahkan hubungi Admin DPPK.");
		}
	}
	
	
	// -- setter and getter
	
	public boolean getPengaturanMn() {
		return pengaturanMn;
	}
	
	public void setPengaturanMn(boolean status) {
		this.pengaturanMn = status;
	}
	
	public boolean getPenggunaMn() {
		return penggunaMn;
	}
	
	public void setPenggunaMn(boolean status) {
		this.penggunaMn = status;
	}
	
	public boolean getMenuMn() {
		return menuMn;
	}
	
	public void setMenuMn(boolean status) {
		this.menuMn = status;
	}
	
	public boolean getRefKecamatanMn() {
		return refKecamatanMn;
	}
	
	public void setRefKecamatanMn(boolean status) {
		this.refKecamatanMn = status;
	}
	
	public boolean getRefKelurahanMn() {
		return refKelurahanMn;
	}
	
	public void setRefKelurahanMn(boolean status) {
		this.refKelurahanMn = status;
	}
	
	public boolean getRefJnsRetribusiMn() {
		return refJnsRetribusiMn;
	}
	
	public void setRefJnsRetribusiMn(boolean status) {
		this.refJnsRetribusiMn = status;
	}
	
	public boolean getRefSkpdMn() {
		return refSkpdMn;
	}
	
	public void setRefSkpdMn(boolean status) {
		this.refSkpdMn = status;
	}
	
	public boolean getMasukkanMn() {
		return masukkanMn;
	}
	
	public void setMasukkanMn(boolean status) {
		this.masukkanMn = status;
	}
	
	public boolean getPotensiMn() { 
		return potensiMn;
	}
	
	public void setPotensiMn(boolean status) {
		this.potensiMn = status;
	}
	
	public boolean getRealisasiMn() {
		return realisasiMn;
	}
	
	public void setRealisasiMn(boolean status) {
		this.realisasiMn = status;
	}
	
	public boolean getLaporanMn() {
		return laporanMn;
	}
	
	public void setLaporanMn(boolean status) {
		this.laporanMn = status;
	}
	
	public boolean getRekomendasiMn() {
		return rekomendasiMn;
	}
	
	public void setRekomendasiMn(boolean status) {
		this.rekomendasiMn = status;
	}
	
	public boolean getPerJnsRetribusiMn() {
		return perJnsRetribusiMn;
	}
	
	public void setPerJnsRetribusiMn(boolean status) {
		this.perJnsRetribusiMn = status;
	}

}
