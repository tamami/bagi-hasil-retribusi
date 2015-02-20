package lab.aikibo.viewmodel;

import java.io.Serializable;

import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Include;

public class GlobalController extends SelectorComposer<Component> 
		implements Serializable {
	
	private static final long serialVersionUID = -4928664844108666448L;
	
	@Init
	public void init() {}

	@GlobalCommand
	public void updateView() {
		Clients.showNotification("Nama page-nya : " + getPage().getRequestPath());
		Include include = (Include) Selectors.iterable(getPage(), "#mainInclude").iterator().next();
		include.setSrc("/timeout.zul");
		Clients.showNotification("login.zul sudah dipanggil");
	}
	
	@GlobalCommand
	public void showFormPengguna() {
		Include include = (Include) Selectors.iterable(getPage(), "#mainInclude").iterator().next();
		include.setSrc("/form/f_pengguna.zul");
	}
	
	@GlobalCommand
	public void showFormRefKecamatan() {
		Include include = (Include) Selectors.iterable(getPage(), "#mainInclude").iterator().next();
		include.setSrc("/form/f_ref_kecamatan.zul");
	}
	
	@GlobalCommand
	public void showFormRefKelurahan() {
		Include include = (Include) Selectors.iterable(getPage(), "#mainInclude").iterator().next();
		include.setSrc("/form/f_ref_kelurahan.zul");
	}
	
	@GlobalCommand
	public void showFormRefJenisRetribusi() {
		Include include = (Include) Selectors.iterable(getPage(), "#mainInclude").iterator().next();
		include.setSrc("/form/f_ref_jenis_retribusi.zul");
	}
	
	@GlobalCommand
	public void showFormRefSkpd() {
		Include include = (Include) Selectors.iterable(getPage(), "#mainInclude").iterator().next();
		include.setSrc("/form/f_ref_skpd.zul");
	}
	
	@GlobalCommand
	public void showFormPotensi() {
		Include include = (Include) Selectors.iterable(getPage(), "#mainInclude").iterator().next();
		include.setSrc("/form/f_potensi.zul");
	}
	
	@GlobalCommand
	public void showFormRealisasi() {
		Include include = (Include) Selectors.iterable(getPage(), "#mainInclude").iterator().next();
		include.setSrc("/form/f_realisasi.zul");
	}
	
	@GlobalCommand
	public void showFormRekomendasi() {
		Include include = (Include) Selectors.iterable(getPage(), "#mainInclude").iterator().next();
		include.setSrc("/form/f_rekomendasi.zul");
	}
	
	@GlobalCommand
	public void showFormLaporanPerJenis() {
		Include include = (Include) Selectors.iterable(getPage(), "#mainInclude").iterator().next();
		include.setSrc("/form/f_laporan_per_jenis.zul");
	}

}
