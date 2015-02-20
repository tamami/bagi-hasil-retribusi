package lab.aikibo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Realisasi implements Serializable {

	private static final long serialVersionUID = -1242223489884386696L;
	private Long nomor;
	private Date tanggalRealisasi;
	private String kodeRetribusi;
	private BigDecimal nilaiRealisasi;
	private String kodeSkpd;
	private String kodeKecamatan;
	private String kodeKelurahan;
	
	public Realisasi() {}
	
	public Realisasi(Long nomor, Date tanggalRealisasi, String kodeRetribusi,
			String thnRetribusi, BigDecimal nilaiRealisasi, String kodeSkpd,
			String kodeKecamatan, String kodeKelurahan) {
		this.setNomor(nomor);
		this.setTanggalRealisasi(tanggalRealisasi);
		this.setKodeRetribusi(kodeRetribusi);
		this.setNilaiRealisasi(nilaiRealisasi);
		this.setKodeSkpd(kodeSkpd);
		this.kodeKecamatan = kodeKecamatan;
		this.kodeKelurahan = kodeKelurahan;
	}
	
	
	// -- setter and getter

	public Long getNomor() {
		return nomor;
	}

	public void setNomor(Long nomor) {
		this.nomor = nomor;
	}

	public Date getTanggalRealisasi() {
		return tanggalRealisasi;
	}

	public void setTanggalRealisasi(Date tanggalRealisasi) {
		this.tanggalRealisasi = tanggalRealisasi;
	}

	public String getKodeRetribusi() {
		return kodeRetribusi;
	}

	public void setKodeRetribusi(String kodeRetribusi) {
		this.kodeRetribusi = kodeRetribusi;
	}

	public BigDecimal getNilaiRealisasi() {
		return nilaiRealisasi;
	}

	public void setNilaiRealisasi(BigDecimal nilaiRealisasi) {
		this.nilaiRealisasi = nilaiRealisasi;
	}

	public String getKodeSkpd() {
		return kodeSkpd;
	}

	public void setKodeSkpd(String kodeSkpd) {
		this.kodeSkpd = kodeSkpd;
	}

	public String getKodeKecamatan() {
		return kodeKecamatan;
	}

	public void setKodeKecamatan(String kodeKecamatan) {
		this.kodeKecamatan = kodeKecamatan;
	}

	public String getKodeKelurahan() {
		return kodeKelurahan;
	}

	public void setKodeKelurahan(String kodeKelurahan) {
		this.kodeKelurahan = kodeKelurahan;
	}
	

}
