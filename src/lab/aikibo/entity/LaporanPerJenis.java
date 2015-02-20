package lab.aikibo.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;


@Entity
@NamedNativeQuery(name="lapPerJenis", query="select * from v_real_per_jenis", 
    resultClass=LaporanPerJenis.class)
public class LaporanPerJenis implements Serializable {
	
	private String kodeRetribusi;
	private String namaKelurahan;
	private String namaKecamatan;
	private String bulan;
	private String tahun;
	private BigDecimal realisasi;
	private BigDecimal sepuluhPersen;
	private BigDecimal enamPuluhPersen;
	private BigDecimal empatPuluhPersen;
	private BigDecimal bagiHasil;
	
	public LaporanPerJenis() {}
	
	public LaporanPerJenis(String kodeRetribusi, String namaKelurahan, 
			String namaKecamatan, String bulan, String tahun, BigDecimal realisasi,
			BigDecimal sepuluhPersen, BigDecimal enamPuluhPersen, 
			BigDecimal empatPuluhPersen, BigDecimal bagiHasil) {
		this.kodeRetribusi = kodeRetribusi;
		this.namaKelurahan = namaKelurahan;
		this.namaKecamatan = namaKecamatan;
		this.bulan = bulan;
		this.tahun = tahun;
		this.realisasi = realisasi;
		this.sepuluhPersen = sepuluhPersen;
		this.enamPuluhPersen = enamPuluhPersen;
		this.empatPuluhPersen = empatPuluhPersen;
		this.bagiHasil = bagiHasil;
	}
	
	
	// -- setter and getter
	@Id
	@Column(name="kode_retribusi")
	public String getKodeRetribusi() {
		return kodeRetribusi;
	}
	
	public void setKodeRetribusi(String kodeRetribusi) {
		this.kodeRetribusi = kodeRetribusi;
	}

	@Id
	@Column(name="nama_kelurahan")
	public String getNamaKelurahan() {
		return namaKelurahan;
	}

	public void setNamaKelurahan(String namaKelurahan) {
		this.namaKelurahan = namaKelurahan;
	}

	@Id
	@Column(name="nama_kecamatan")
	public String getNamaKecamatan() {
		return namaKecamatan;
	}

	public void setNamaKecamatan(String namaKecamatan) {
		this.namaKecamatan = namaKecamatan;
	}

	@Id
	@Column(name="bulan")
	public String getBulan() {
		return bulan;
	}

	public void setBulan(String bulan) {
		this.bulan = bulan;
	}

	@Id
	@Column(name="tahun")
	public String getTahun() {
		return tahun;
	}

	public void setTahun(String tahun) {
		this.tahun = tahun;
	}

	@Column(name="realisasi")
	public BigDecimal getRealisasi() {
		return realisasi;
	}

	public void setRealisasi(BigDecimal realisasi) {
		this.realisasi = realisasi;
	}

	@Column(name="sepuluh_persen")
	public BigDecimal getSepuluhPersen() {
		return sepuluhPersen;
	}

	public void setSepuluhPersen(BigDecimal sepuluhPersen) {
		this.sepuluhPersen = sepuluhPersen;
	}

	@Column(name="enam_puluh_persen")
	public BigDecimal getEnamPuluhPersen() {
		return enamPuluhPersen;
	}

	public void setEnamPuluhPersen(BigDecimal enamPuluhPersen) {
		this.enamPuluhPersen = enamPuluhPersen;
	}

	@Column(name="empat_puluh_persen")
	public BigDecimal getEmpatPuluhPersen() {
		return empatPuluhPersen;
	}

	public void setEmpatPuluhPersen(BigDecimal empatPuluhPersen) {
		this.empatPuluhPersen = empatPuluhPersen;
	}

	@Column(name="jumlah_bagihasil")
	public BigDecimal getBagiHasil() {
		return bagiHasil;
	}

	public void setBagiHasil(BigDecimal bagiHasil) {
		this.bagiHasil = bagiHasil;
	}

}
