package lab.aikibo.entity;

public class Skpd {
	
	private String kodeSkpd;
	private String namaSkpd;
	
	public Skpd() {}
	
	public Skpd(String kodeSkpd, String namaSkpd) {
		this.kodeSkpd = kodeSkpd;
		this.namaSkpd = namaSkpd;
	}
	
	
	// -- setter and getter
	
	public String getKodeSkpd() {
		return kodeSkpd;
	}
	
	public void setKodeSkpd(String kodeSkpd) {
		this.kodeSkpd = kodeSkpd;
	}
	
	public String getNamaSkpd() {
		return namaSkpd;
	}
	
	public void setNamaSkpd(String namaSkpd) {
		this.namaSkpd = namaSkpd;
	}

}
