package lab.aikibo.viewmodel;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Iframe;

public class RekomendasiVM {
	
	private List<String> daftarBulan;
	private String currentBulan;
	private String thnRekom;
	
	@Init
	public void init() {
		daftarBulan = new LinkedList<String>();
		thnRekom = new String();
	}
	 
	@Command
	public void showReport() throws JRException, IOException {
		JasperPrint print = JasperFillManager.fillReport("../webapps/ZK-Bagihasil-Retribusi/report/hello.jasper", null, new JREmptyDataSource());
		JasperExportManager.exportReportToPdfFile(print, "../webapps/ZK-Bagihasil-Retribusi/report/hello.pdf");
		
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

	public String getCurrentBulan() {
		return currentBulan;
	}

	public void setCurrentBulan(String currentBulan) {
		this.currentBulan = currentBulan;
	}

}
