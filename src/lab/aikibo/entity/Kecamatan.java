package lab.aikibo.entity;

public class Kecamatan {
	
	private String kdKecamatan;
	private String nmKecamatan;
	
	public Kecamatan() {}
	
	public Kecamatan(String kdKecamatan, String nmKecamatan) {
		this.setKdKecamatan(kdKecamatan);
		this.setNmKecamatan(nmKecamatan);
	}
	
	
	// -- setter and getter

	public String getKdKecamatan() {
		return kdKecamatan;
	}

	public void setKdKecamatan(String kdKecamatan) {
		this.kdKecamatan = kdKecamatan;
	}

	public String getNmKecamatan() {
		return nmKecamatan;
	}

	public void setNmKecamatan(String nmKecamatan) {
		this.nmKecamatan = nmKecamatan;
	}

}
