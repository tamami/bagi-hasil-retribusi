package lab.aikibo.viewmodel;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import lab.aikibo.entity.Rekomendasi;
import lab.aikibo.manager.BulanManager;
import lab.aikibo.manager.RekomendasiManager;
import lab.aikibo.util.NumberFormatConverter;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Iframe;

public class RekomendasiVM {
	
	private List<String> daftarBulan;
	private int currentBulan;
	private String kodeBulan;
	private String thnRekom;
	private BulanManager bm;
	private RekomendasiManager rm;
	private List<Rekomendasi> daftarRekomendasiUi;
	private List<Rekomendasi> daftarRekomendasi;
	private Rekomendasi currentRekomendasi;
	private NumberFormatConverter nfc;
	
	@Init
	public void init() {
		bm = new BulanManager();
		rm = new RekomendasiManager();
		setNfc(new NumberFormatConverter());
		setDaftarRekomendasi(rm.getDaftarRekomendasi());
		
		clear();
	}
	
	public void clear() {
		daftarBulan = bm.getFormattedDaftarBulan();
		thnRekom = new String();
		setCurrentBulan(0);
		setThnRekom("");
		initDaftarRekomendasiUi();
	}
	
	private void initDaftarRekomendasiUi() {
		daftarRekomendasiUi = new LinkedList<Rekomendasi>();
		for(int i=0;i<daftarRekomendasi.size();i++) {
			Rekomendasi r = daftarRekomendasi.get(i);
			if(r != null) {
				daftarRekomendasiUi.add(r);
			}
		}
	}
	 
	@Command
	public void showReport() throws JRException, IOException {
		JasperPrint print = JasperFillManager.fillReport(
				"..\\webapps\\ZK-Bagihasil-Retribusi\\report\\hello.jasper", null, 
				new JREmptyDataSource());
		JasperExportManager.exportReportToPdfFile(print, 
				"../webapps/ZK-Bagihasil-Retribusi/report/hello.pdf");
		
		//Iframe iframe = (Iframe) this.getFellow("iframe");
		File f = new File("../webapps/ZK-Bagihasil-Retribusi/report/hello.pdf");
		byte[] buffer = new byte[(int) f.length()];
		FileInputStream fs = new FileInputStream(f);
		fs.read(buffer);
		fs.close();
		ByteArrayInputStream is = new ByteArrayInputStream(buffer);
		AMedia amedia = new AMedia("hello_report.pdf", "pdf", "application/pdf", is);
		Filedownload.save(amedia);
		//iframe.setContent(amedia);
	}
	
	@Command 
	@NotifyChange({"daftarRekomendasiUi","daftarRekomendasi","currentBulan","thnRekom"})
	public void prosesReport(@BindingParam("bulan")String bln, @BindingParam("tahun") String thn) {
		daftarRekomendasi = rm.getDaftarByParam(bln, thn);
		clear();
	}
	
	
	// -- setter and getter

	public List<String> getDaftarBulan() {
		return daftarBulan;
	}

	public void setDaftarBulan(List<String> daftarBulan) {
		this.daftarBulan = daftarBulan;
	}

	public String getThnRekom() {
		return thnRekom;
	}

	public void setThnRekom(String thnRekom) {
		this.thnRekom = thnRekom;
	}

	public int getCurrentBulan() {
		return currentBulan;
	}

	public void setCurrentBulan(int currentBulan) {
		kodeBulan = bm.getKodeBulanFromIndex(currentBulan);
		this.currentBulan = currentBulan;
	}

	public RekomendasiManager getRm() {
		return rm;
	}

	public void setRm(RekomendasiManager rm) {
		this.rm = rm;
	}

	public List<Rekomendasi> getDaftarRekomendasi() {
		return daftarRekomendasi;
	}

	public void setDaftarRekomendasi(List<Rekomendasi> daftarRekomendasi) {
		this.daftarRekomendasi = daftarRekomendasi;
	}

	public Rekomendasi getCurrentRekomendasi() {
		//if(currentRekomendasi.getRealGangguan() == null) currentRekomendasi.setRealGangguan(new BigDecimal("0"));
		//if(currentRekomendasi.getRealImb() == null) currentRekomendasi.setRealImb(new BigDecimal("0"));
		//if(currentRekomendasi.getRealLelang() == null) currentRekomendasi.setRealLelang(new BigDecimal("0"));
		return currentRekomendasi;
	}

	public void setCurrentRekomendasi(Rekomendasi currentRekomendasi) {
		this.currentRekomendasi = currentRekomendasi;
	}
	
	public List<Rekomendasi> getDaftarRekomendasiUi() {
		return daftarRekomendasiUi;
	}
	
	public void setDaftarRekomendasiUi(List<Rekomendasi> daftarRekomendasiUi) {
		this.daftarRekomendasiUi = daftarRekomendasiUi;  
	}

	public NumberFormatConverter getNfc() {
		return nfc;
	}

	public void setNfc(NumberFormatConverter nfc) {
		this.nfc = nfc;
	}

	public String getKodeBulan() {
		return kodeBulan;
	}

	public void setKodeBulan(String kodeBulan) {
		this.kodeBulan = kodeBulan;
	}

}
