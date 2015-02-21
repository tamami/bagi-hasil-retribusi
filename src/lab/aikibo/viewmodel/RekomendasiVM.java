package lab.aikibo.viewmodel;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import org.zkoss.bind.annotation.Command;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Iframe;

public class RekomendasiVM {
	 
	@Command
	public void showReport() throws JRException, IOException {
		JasperPrint print = JasperFillManager.fillReport("../webapps/ZK-Bagihasil-Retribusi/report/hello_report.jasper", null, new JREmptyDataSource());
		JasperExportManager.exportReportToPdfFile(print, "../webapps/ZK-Bagihasil-Retribusi/report/hello_report.pdf");
		
		//Iframe iframe = (Iframe) this.getFellow("iframe");
		File f = new File("../webapps/ZK-Bagihasil-Retribusi/report/hello_report.pdf");
		byte[] buffer = new byte[(int) f.length()];
		FileInputStream fs = new FileInputStream(f);
		fs.read(buffer);
		fs.close();
		ByteArrayInputStream is = new ByteArrayInputStream(buffer);
		AMedia amedia = new AMedia("hello_report.pdf", "pdf", "application/pdf", is);
		Filedownload.save(amedia);
		//iframe.setContent(amedia);
	}
	
	

}
