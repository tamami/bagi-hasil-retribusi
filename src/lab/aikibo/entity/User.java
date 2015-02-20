package lab.aikibo.entity;

public class User {
	
	private String nip;
	private String nama;
	private String login;
	private String password;
	private String menu;
	private String kodeSkpd;
	
	public User() {}
	
	public User(String nip, String nama, String login, String password, 
			String menu, String kodeSkpd) {
		this.nip = nip;
		this.nama = nama;
		this.login = login;
		this.password = password;
		this.menu = menu;
		this.kodeSkpd = kodeSkpd;
	}
	
	
	// -- setter and getter
	
	public String getNip() {
		return nip;
	}
	
	public void setNip(String nip) {
		this.nip = nip;
	}
	
	public String getNama() {
		return nama;
	}
	
	public void setNama(String nama) {
		this.nama = nama;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMenu() {
		return menu;
	}
	
	public void setMenu(String menu) {
		this.menu = menu;
	}
	
	public String getKodeSkpd() {
		return kodeSkpd;
	}
	
	public void setKodeSkpd(String kodeSkpd) {
		this.kodeSkpd = kodeSkpd;
	}

}
