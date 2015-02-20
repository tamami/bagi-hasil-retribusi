package lab.aikibo.services;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UserCredential implements Serializable {

	private static final long serialVersionUID = -7540801911300047190L;
	String nama;
	String nip;
	String kodeSkpd;
	Set<String> roles = new HashSet<String>();
	
	public UserCredential(String nama, String nip, String kodeSkpd) {
		this.nama = nama;
		this.nip = nip;
		this.kodeSkpd = kodeSkpd;
		roles.add("users");
	}
	
	public UserCredential() {
		this.nama = "anonymous";
		this.nip = "anonymous";
		roles.add("anonymous");
	}
	
	public boolean isAnonymous() {
		return "anonymous".equals(nama);
	}
	
	public boolean hasRole(String role) {
		return roles.contains(role);
	}
	
	public void addRole(String role) {
		roles.add(role);
	}
	
	
	// --- setter and getter
	
	public String getNama() {
		return this.nama;
	}
	
	public void setNama(String nama) {
		this.nama = nama;
	}
	
	public String getNip() {
		return nip;
	}
	
	public void setNip(String nip) {
		this.nip = nip;
	}
	
	public String getKodeSkpd() {
		return kodeSkpd;
	}
	
	public void setKodeSkpd(String kodeSkpd) {
		this.kodeSkpd = kodeSkpd;
	}

}
