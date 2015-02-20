package lab.aikibo.manager;

public class MenuManager {
	
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
	private boolean perJenisRetribusiMn;
	
	public MenuManager(String menuConfiguration) {
		pengaturanMn = menuConfiguration.substring(0,1).equals("1") ? true : false;
		penggunaMn = menuConfiguration.substring(1,2).equals("1") ? true : false;
		menuMn = menuConfiguration.substring(2,3).equals("1") ? true : false;
		refKecamatanMn = menuConfiguration.substring(3,4).equals("1") ? true : false;
		refKelurahanMn = menuConfiguration.substring(4,5).equals("1") ? true : false;
		refJnsRetribusiMn = menuConfiguration.substring(5,6).equals("1") ? true : false;
		refSkpdMn = menuConfiguration.substring(6,7).equals("1") ? true : false;
		masukkanMn = menuConfiguration.substring(7,8).equals("1") ? true : false;
		potensiMn = menuConfiguration.substring(8,9).equals("1") ? true : false;
		realisasiMn = menuConfiguration.substring(9,10).equals("1") ? true : false;
		laporanMn = menuConfiguration.substring(10,11).equals("1") ? true : false;
		rekomendasiMn = menuConfiguration.substring(11,12).equals("1") ? true : false;
		perJenisRetribusiMn = menuConfiguration.substring(12,13).equals("1") ? true : false;
	}
	
	public String getMenuConfiguration() {
		StringBuffer result = new StringBuffer();
		if(pengaturanMn) result.append("1"); else result.append("0");
		if(penggunaMn) result.append("1"); else result.append("0");
		if(menuMn) result.append("1"); else result.append("0");
		if(refKecamatanMn) result.append("1"); else result.append("0");
		if(refKelurahanMn) result.append("1"); else result.append("0");
		if(refJnsRetribusiMn) result.append("1"); else result.append("0");
		if(refSkpdMn) result.append("1"); else result.append("0");
		if(masukkanMn) result.append("1"); else result.append("0");
		if(potensiMn) result.append("1"); else result.append("0");
		if(realisasiMn) result.append("1"); else result.append("0");
		if(laporanMn) result.append("1"); else result.append("0");
		if(rekomendasiMn) result.append("1"); else result.append("0");
		if(perJenisRetribusiMn) result.append("1"); else result.append("0");
		
		return result.toString();
	}
	
	
	// -- setter and getter
	
	public boolean getPengaturanMn() {
		return pengaturanMn;
	}
	
	public void setPengaturanMn(boolean pengaturanMn) {
		this.pengaturanMn = pengaturanMn;
	}
	
	public boolean getPenggunaMn() {
		return penggunaMn;
	}
	
	public void setPenggunaMn(boolean penggunaMn) {
		this.penggunaMn = penggunaMn;
	}
	
	public boolean getMenuMn() {
		return menuMn;
	}
	
	public void setMenuMn(boolean menuMn) {
		this.menuMn = menuMn;
	}
	
	public boolean getRefKecamatanMn() {
		return refKecamatanMn;
	}
	
	public void setRefKecamatanMn(boolean refKecamatanMn) {
		this.refKecamatanMn = refKecamatanMn;
	}
	
	public boolean getRefKelurahanMn() {
		return refKelurahanMn;
	}
	
	public void setRefKelurahanMn(boolean refKelurahanMn) {
		this.refKelurahanMn = refKelurahanMn;
	}
	
	public boolean getRefJnsRetribusiMn() {
		return refJnsRetribusiMn;
	}
	
	public void setRefJnsRetribusiMn(boolean refJnsRetribusiMn) {
		this.refJnsRetribusiMn = refJnsRetribusiMn;
	}
	
	public boolean getRefSkpdMn() {
		return refSkpdMn;
	}
	
	public void setRefSkpdMn(boolean refSkpdMn) {
		this.refSkpdMn = refSkpdMn;
	}
	
	public boolean getMasukkanMn() {
		return masukkanMn;
	}
	
	public void setMasukkanMn(boolean masukkanMn) {
		this.masukkanMn = masukkanMn;
	}
	
	public boolean getPotensiMn() {
		return potensiMn;
	}
	
	public void setPotensiMn(boolean potensiMn) {
		this.potensiMn = potensiMn;
	}
	
	public boolean getRealisasiMn() {
		return realisasiMn;
	}
	
	public void setRealisasiMn(boolean realisasiMn) {
		this.realisasiMn = realisasiMn;
	}
	
	public boolean getLaporanMn() {
		return laporanMn;
	}
	
	public void setLaporanMn(boolean laporanMn) {
		this.laporanMn = laporanMn;
	}
	
	public boolean getRekomendasiMn() {
		return rekomendasiMn;
	}
	
	public void setRekomendasiMn(boolean rekomendasiMn) {
		this.rekomendasiMn = rekomendasiMn;
	}
	
	public boolean getPerJenisRetribusiMn() {
		return perJenisRetribusiMn;
	}
	
	public void setPerJenisRetribusiMn(boolean perJenisRetribusiMn) {
		this.perJenisRetribusiMn = perJenisRetribusiMn;
	}

}
