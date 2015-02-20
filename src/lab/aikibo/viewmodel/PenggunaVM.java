package lab.aikibo.viewmodel;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import lab.aikibo.entity.Skpd;
import lab.aikibo.entity.User;
import lab.aikibo.manager.MenuManager;
import lab.aikibo.manager.SkpdManager;
import lab.aikibo.manager.UserManager;
import lab.aikibo.util.Encrypt;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.ListModelList;

public class PenggunaVM implements Serializable {
	
	private UserManager um;
	private SkpdManager sm;
	private MenuManager mm;
	private List<User> daftarPengguna;
	private List<String> daftarSkpd;
	private User dataPengguna;
	private String dataSkpd;
	private String untoldPassword;
	private boolean disableMenuConfiguration;
	
	@Init
	public void init() {
		um = new UserManager();
		sm = new SkpdManager();
		dataPengguna = new User();
		daftarPengguna = um.getListUser();
		daftarSkpd = sm.getDaftarSkpd();
		disableMenuConfiguration = true;
		untoldPassword = new String();
		dataSkpd = new String();
	}
	
	@Command
	@NotifyChange({"dataPengguna","untoldPassword", "dataSkpd", "mm", "disableMenuConfiguration"})
	public void prosesNip() {
		disableMenuConfiguration = false;
		dataPengguna = um.getUserByNip(dataPengguna.getNip());
		dataSkpd = sm.getFormattedSkpdByKode(dataPengguna.getKodeSkpd());
		mm = new MenuManager(dataPengguna.getMenu());
		try {
			untoldPassword = um.getDecryptedPasswordByNip(dataPengguna.getNip());
		} catch (InvalidKeyException e) {
			Clients.showNotification("Maaf, ada kesalahan Key enkripsi, hubungi developer!");
		} catch (NoSuchAlgorithmException e) {
			Clients.showNotification("Maaf, ada kesalahan algoritma enkripsi, hubungi developer!");
		} catch (UnsupportedEncodingException e) {
			Clients.showNotification("Maaf, sistem peng-kode-an tidak didukung, hubungi developer!");
		} catch (NoSuchPaddingException e) {
			Clients.showNotification("Maaf, padding tidak ditemukan, hubungi developer!");
		} catch (InvalidAlgorithmParameterException e) {
			Clients.showNotification("Maaf, parameter algoritma enkripsi salah, hubungi developer!");
		} catch (IllegalBlockSizeException e) {
			Clients.showNotification("Maaf, ukuran blok enkripsi salah, hubungi developer!");
		} catch (BadPaddingException e) {
			Clients.showNotification("Maaf, ada kesalahan padding, hubungi developer!");
		}
	}
	
	@Command
	@NotifyChange({"dataPengguna","untoldPassword", "dataSkpd", "mm", "disableMenuConfiguration",
		"daftarPengguna"})
	public void save() {
		try {
			dataPengguna.setPassword(Encrypt.getEncrypted2(untoldPassword));
		} catch (InvalidKeyException e) {
			Clients.showNotification("Maaf, ada kesalahan Key enkripsi, \n" + 
					"PASSWORD TIDAK BERUBAH, hubungi developer!");
		} catch (NoSuchAlgorithmException e) {
			Clients.showNotification("Maaf, ada kesalahan algoritma enkripsi, \n" +
					"PASSWORD TIDAK BERUBAH, hubungi developer!");
		} catch (UnsupportedEncodingException e) {
			Clients.showNotification("Maaf, sistem peng-kode-an tidak didukung, \n" + 
					"PASSWORD TIDAK BERUBAH, hubungi developer!");
		} catch (IllegalBlockSizeException e) {
			Clients.showNotification("Maaf, ukuran blok enkripsi salah, \n" +
					"PASSWORD TIDAK BERUBAH, hubungi developer!");
		} catch (BadPaddingException e) {
			Clients.showNotification("Maaf, ada kesalahan padding, \n" +
					"PASSWORD TIDAK BERUBAH, hubungi developer!");
		} catch (NoSuchPaddingException e) {
			Clients.showNotification("Maaf, padding tidak ditemukan, \n" + 
					"PASSWORD TIDAK BERUBAH, hubungi developer!");
		} catch (InvalidAlgorithmParameterException e) {
			Clients.showNotification("Maaf, parameter algoritma enkripsi salah, \n" + 
					"PASSWORD TIDAK BERUBAH, hubungi developer!");
		}
		dataPengguna.setMenu(mm.getMenuConfiguration());
		um.saveOrUpdate(dataPengguna);
		Clients.showNotification("Data telah tersimpan");
		init();
	}
	
	
	// -- setter and getter
	
	public List<User> getDaftarPengguna() {
		return daftarPengguna;
	}
	
	public void setDaftarPengguna(List<User> daftarPengguna) {
		this.daftarPengguna = daftarPengguna;
	}
	
	public User getDataPengguna() {
		return dataPengguna;
	}
	
	public void setDataPengguna(User dataPengguna) {
		this.dataPengguna = dataPengguna;
	}
	
	public List<String> getDaftarSkpd() {
		return daftarSkpd;
	}
	
	public void setDaftarSkpd(List<String> daftar) {
		this.daftarSkpd = daftar;
	}
	
	public String getDataSkpd() {
		return dataSkpd;
	}
	
	public void setDataSkpd(String data) {
		this.dataSkpd = data;
	}
	
	public String getUntoldPassword() {
		return untoldPassword;
	}
	
	public void setUntoldPassword(String plainPassword) {
		this.untoldPassword = plainPassword;
	}
	
	public MenuManager getMm() {
		return mm;
	}
	
	public void setMm(MenuManager mm) {
		this.mm = mm;
	}
	
	public boolean getDisableMenuConfiguration() {
		return disableMenuConfiguration;
	}
	
	public void setDisableMenuConfiguration(boolean status) {
		this.disableMenuConfiguration = status;
	}

}
