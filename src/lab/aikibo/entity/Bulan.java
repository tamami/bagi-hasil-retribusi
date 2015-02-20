package lab.aikibo.entity;

import java.math.BigDecimal;

public class Bulan {
	
	private BigDecimal angkaBulan;
	private String namaBulan;
	
	public Bulan() {}
	
	public Bulan(BigDecimal angkaBulan, String namaBulan) {
		this.setAngkaBulan(angkaBulan);
		this.setNamaBulan(namaBulan);
	}
	
	
	// -- setter and getter

	public BigDecimal getAngkaBulan() {
		return angkaBulan;
	}

	public void setAngkaBulan(BigDecimal angkaBulan) {
		this.angkaBulan = angkaBulan;
	}

	public String getNamaBulan() {
		return namaBulan;
	}

	public void setNamaBulan(String namaBulan) {
		this.namaBulan = namaBulan;
	}
	
}
