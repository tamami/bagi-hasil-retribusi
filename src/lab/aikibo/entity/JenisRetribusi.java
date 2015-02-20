package lab.aikibo.entity;

public class JenisRetribusi {
	
	private String kdRetribusi;
	private String nmRetribusi;
	
	public JenisRetribusi() {}
	
	public JenisRetribusi(String kdRetribusi, String nmRetribusi) {
		this.setKdRetribusi(kdRetribusi);
		this.setNmRetribusi(nmRetribusi);
	}
	
	
	// -- setter and getter

	public String getKdRetribusi() {
		return kdRetribusi;
	}

	public void setKdRetribusi(String kdRetribusi) {
		this.kdRetribusi = kdRetribusi;
	}

	public String getNmRetribusi() {
		return nmRetribusi;
	}

	public void setNmRetribusi(String nmRetribusi) {
		this.nmRetribusi = nmRetribusi;
	}

}
