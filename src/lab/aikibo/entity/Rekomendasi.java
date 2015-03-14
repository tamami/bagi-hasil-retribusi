package lab.aikibo.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import org.zkoss.math.BigDecimals;

public class Rekomendasi implements Serializable {

	private static final long serialVersionUID = 6979770332090252042L;
	private String bulan;
	private String tahun;
	private String namaKecamatan;
	private String namaKelurahan;
	private BigDecimal realSampah;
	private BigDecimal realParkir;
	private BigDecimal realPasar;
	private BigDecimal realPkb;
	private BigDecimal realPkd;
	private BigDecimal realLelang;
	private BigDecimal realTerminal;
	private BigDecimal realVilla;
	private BigDecimal realRph;
	private BigDecimal realPelabuhan;
	private BigDecimal realOr;
	private BigDecimal realRuasJalan;
	private BigDecimal realImb;
	private BigDecimal realGangguan;
	private BigDecimal realTrayek;
	private BigDecimal realTelkom;
	
	public String getBulan() {
		return bulan;
	}
	
	public void setBulan(String bulan) {
		this.bulan = bulan;
	}

	public String getTahun() {
		return tahun;
	}

	public void setTahun(String tahun) {
		this.tahun = tahun;
	}

	public String getNamaKecamatan() {
		return namaKecamatan;
	}

	public void setNamaKecamatan(String namaKecamatan) {
		this.namaKecamatan = namaKecamatan;
	}

	public String getNamaKelurahan() {
		return namaKelurahan;
	}

	public void setNamaKelurahan(String namaKelurahan) {
		this.namaKelurahan = namaKelurahan;
	}

	public BigDecimal getRealSampah() {
		//if(realSampah == null) realSampah = new BigDecimal("0");
		return realSampah;
	}

	public void setRealSampah(BigDecimal realSampah) {
		//if(realSampah.intValue() == 0) realSampah = null;
		this.realSampah = realSampah;
	}

	public BigDecimal getRealParkir() {
		//if(realParkir == null) realParkir = new BigDecimal("0");
		return realParkir;
	}

	public void setRealParkir(BigDecimal realParkir) {
		//if(realParkir.intValue() == 0) realParkir = null;
		this.realParkir = realParkir;
	}

	public BigDecimal getRealPasar() {
		//if(realPasar == null) realPasar = new BigDecimal("0");
		return realPasar;
	}

	public void setRealPasar(BigDecimal realPasar) {
		//if(realPasar.intValue() == 0) realPasar = null;
		this.realPasar = realPasar;
	}

	public BigDecimal getRealPkb() {
		//if(realPkb == null) realPkb = new BigDecimal("0");
		return realPkb;
	}

	public void setRealPkb(BigDecimal realPkb) {
		//if(realPkb.intValue() == 0) realPkb = null;
		this.realPkb = realPkb;
	}

	public BigDecimal getRealPkd() {
		//if(realPkd == null) realPkd = new BigDecimal("0");
		return realPkd;
	}

	public void setRealPkd(BigDecimal realPkd) {
		//if(realPkd.intValue() == 0) realPkd = null;
		this.realPkd = realPkd;
	}

	public BigDecimal getRealLelang() {
		//if(realLelang == null) realLelang = new BigDecimal("0");
		return realLelang;
	}

	public void setRealLelang(BigDecimal realLelang) {
		//if(realLelang.intValue() == 0) realLelang = null;
		this.realLelang = realLelang;
	}

	public BigDecimal getRealTerminal() {
		//if(realTerminal == null) realTerminal = new BigDecimal("0");
		return realTerminal;
	}

	public void setRealTerminal(BigDecimal realTerminal) {
		//if(realTerminal.intValue() == 0) realTerminal = null;
		this.realTerminal = realTerminal;
	}

	public BigDecimal getRealVilla() {
		//if(realVilla == null) realVilla = new BigDecimal("0");
		return realVilla;
	}

	public void setRealVilla(BigDecimal realVilla) {
		//if(realVilla.intValue() == 0) realVilla = null;
		this.realVilla = realVilla;
	}

	public BigDecimal getRealRph() {
		//if(realRph == null) realRph = new BigDecimal("0");
		return realRph;
	}

	public void setRealRph(BigDecimal realRph) {
		//if(realRph.intValue() == 0) realRph = null;
		this.realRph = realRph;
	}

	public BigDecimal getRealPelabuhan() {
		//if(realPelabuhan == null) realPelabuhan = new BigDecimal("0");
		return realPelabuhan;
	}

	public void setRealPelabuhan(BigDecimal realPelabuhan) {
		//if(realPelabuhan.intValue() == 0) realPelabuhan = null;
		this.realPelabuhan = realPelabuhan;
	}

	public BigDecimal getRealOr() {
		//if(realOr == null) realOr = new BigDecimal("0");
		return realOr;
	}

	public void setRealOr(BigDecimal realOr) {
		//if(realOr.intValue() == 0) realOr = null;
		this.realOr = realOr;
	}

	public BigDecimal getRealRuasJalan() {
		//if(realRuasJalan == null) realRuasJalan = new BigDecimal("0");
		return realRuasJalan;
	}

	public void setRealRuasJalan(BigDecimal realRuasJalan) {
		//if(realRuasJalan.intValue() == 0) realRuasJalan = null;
		this.realRuasJalan = realRuasJalan;
	}

	public BigDecimal getRealImb() {
		//if(realImb == null) realImb = new BigDecimal("0");
		return realImb;
	}

	public void setRealImb(BigDecimal realImb) {
		//if(realImb.intValue() == 0) realImb = null;
		this.realImb = realImb;
	}

	public BigDecimal getRealGangguan() {
		//if(realGangguan == null) realGangguan = new BigDecimal("0");
		return realGangguan;
	}

	public void setRealGangguan(BigDecimal realGangguan) {
		//if(realGangguan.intValue() == 0) realGangguan = null;
		this.realGangguan = realGangguan;
	}

	public BigDecimal getRealTrayek() {
		//if(realTrayek == null) realTrayek = new BigDecimal("0");
		return realTrayek;
	}

	public void setRealTrayek(BigDecimal realTrayek) {
		//if(realTrayek.intValue() == 0) realTrayek = null;
		this.realTrayek = realTrayek;
	}

	public BigDecimal getRealTelkom() {
		//if(realTelkom == null) realTelkom = new BigDecimal("0");
		return realTelkom;
	}

	public void setRealTelkom(BigDecimal realTelkom) {
		//if(realTelkom.intValue() == 0) realTelkom = null;
		this.realTelkom = realTelkom;
	}
	
	public BigDecimal getTotal() {
		BigDecimal result = new BigDecimal("0");
		if(realSampah == null) realSampah = new BigDecimal("0");
		if(realParkir == null) realParkir = new BigDecimal("0");
		if(realPasar == null) realPasar = new BigDecimal("0");
		if(realPkb == null) realPkb = new BigDecimal("0");
		if(realPkd == null) realPkd = new BigDecimal("0");
		if(realLelang == null) realLelang = new BigDecimal("0");
		if(realTerminal == null) realTerminal = new BigDecimal("0");
		if(realVilla == null) realVilla = new BigDecimal("0");
		if(realRph == null) realRph = new BigDecimal("0");
		if(realPelabuhan == null) realPelabuhan = new BigDecimal("0");
		if(realOr == null) realOr = new BigDecimal("0");
		if(realRuasJalan == null) realRuasJalan = new BigDecimal("0");
		if(realImb == null) realImb = new BigDecimal("0");
		if(realGangguan == null) realGangguan = new BigDecimal("0");
		if(realTrayek == null) realTrayek = new BigDecimal("0");
		if(realTelkom == null) realTelkom = new BigDecimal("0");
		result = realSampah.add(realParkir).add(realPasar).
				add(realPkb).add(realPkd).add(realLelang).
				add(realTerminal).add(realVilla).add(realRph).
				add(realPelabuhan).add(realOr).add(realRuasJalan).
				add(realImb).add(realGangguan).add(realTrayek).
				add(realTelkom);
		if(realSampah.intValue() == 0) realSampah = null;
		if(realParkir.intValue() == 0) realParkir = null;
		if(realPasar.intValue() == 0) realPasar = null;
		if(realPkb.intValue() == 0) realPkb = null;
		if(realPkd.intValue() == 0) realPkd = null;
		if(realLelang.intValue() == 0) realLelang = null;
		if(realTerminal.intValue() == 0) realTerminal = null;
		if(realVilla.intValue() == 0) realVilla = null;
		if(realRph.intValue() == 0) realRph = null;
		if(realPelabuhan.intValue() == 0) realPelabuhan = null;
		if(realOr.intValue() == 0) realOr = null;
		if(realRuasJalan.intValue() == 0) realRuasJalan = null;
		if(realImb.intValue() == 0) realImb = null;
		if(realGangguan.intValue() == 0) realGangguan = null;
		if(realTrayek.intValue() == 0) realTrayek = null;
		if(realTelkom.intValue() == 0) realTelkom = null;
		return result;
	}

}
