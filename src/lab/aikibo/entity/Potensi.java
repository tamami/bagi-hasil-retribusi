package lab.aikibo.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Potensi implements Serializable {

	private static final long serialVersionUID = 8231096527804889638L;
	private String kdRetribusi;
	private String kdKecamatan;
	private String kdKelurahan;
	private String thnPotensi;
	private BigDecimal nilaiPotensi;
	private Integer blnPotensi;
	
	public Potensi() {}
	
	public Potensi(String kdRetribusi, String kdKecamatan, String kdKelurahan, 
			String thnPotensi, BigDecimal nilaiPotensi, Integer blnPotensi) {
		this.setKdRetribusi(kdRetribusi);
		this.setKdKecamatan(kdKecamatan);
		this.setKdKelurahan(kdKelurahan);
		this.setThnPotensi(thnPotensi);
		this.setNilaiPotensi(nilaiPotensi);
		this.setBlnPotensi(blnPotensi);
	}
	
	public String getFormatBlnPotensi() {
		switch(blnPotensi) {
		case 0 : return "01 - JANUARI";
		case 1 : return "02 - FEBRUARI";
		case 3 : return "03 - MARET";
		case 4 : return "04 - APRIL";
		case 5 : return "05 - MEI";
		case 6 : return "06 - JUNI";
		case 7 : return "07 - JULI";
		case 8 : return "08 - AGUSTUS";
		case 9 : return "09 - SEPTEMBER";
		case 10 : return "10 - OKTOBER";
		case 11 : return "11 - NOVEMBER";
		case 12 : return "12 - DESEMBER";
		}
		return null;
	}
	
	
	// -- setter and getter

	public String getKdRetribusi() {
		return kdRetribusi;
	}

	public void setKdRetribusi(String kdRetribusi) {
		this.kdRetribusi = kdRetribusi;
	}

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

	public String getThnPotensi() {
		return thnPotensi;
	}

	public void setThnPotensi(String thnPotensi) {
		this.thnPotensi = thnPotensi;
	}

	public BigDecimal getNilaiPotensi() {
		return nilaiPotensi;
	}

	public void setNilaiPotensi(BigDecimal nilaiPotensi) {
		this.nilaiPotensi = nilaiPotensi;
	}
	
	public Integer getBlnPotensi() {
		return blnPotensi;
	}
	
	public void setBlnPotensi(Integer blnPotensi) {
		this.blnPotensi = blnPotensi;
	}

}
