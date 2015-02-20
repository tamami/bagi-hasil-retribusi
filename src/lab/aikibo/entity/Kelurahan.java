package lab.aikibo.entity;

import java.io.Serializable;

public class Kelurahan implements Serializable {

	private static final long serialVersionUID = 835250549542102758L;
	private String kdKecamatan;
	private String kdKelurahan;
	private String nmKelurahan;
	
	public Kelurahan() {}
	
	public Kelurahan(String kdKecamatan, String kdKelurahan, String nmKelurahan) {
		this.setKdKecamatan(kdKecamatan);
		this.setKdKelurahan(kdKelurahan);
		this.setNmKelurahan(nmKelurahan);
	}

	
	// -- setter and getter
	
	public String getKdKecamatan() {
		return kdKecamatan;
	}

	public void setKdKecamatan(String kdKecamatan) {
		this.kdKecamatan = kdKecamatan;
	}

	public String getKdKelurahan() {
		return kdKelurahan;
	}

	public void setKdKelurahan(String kdKelurahan) {
		this.kdKelurahan = kdKelurahan;
	}

	public String getNmKelurahan() {
		return nmKelurahan;
	}

	public void setNmKelurahan(String nmKelurahan) {
		this.nmKelurahan = nmKelurahan;
	}
	
	
	
}
