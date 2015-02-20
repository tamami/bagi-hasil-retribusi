package lab.aikibo.services;

import org.hibernate.Session;

import lab.aikibo.util.BoneCPDS;
import lab.aikibo.util.ConnectorUtil;

public class Koneksi {
	
	private static ConnectorUtil cu;
	private static BoneCPDS bone;
	
	public static void init() {
		cu = new ConnectorUtil();
		bone = new BoneCPDS();
	}
	
	public static Session getSession() {
		return cu.getSF().openSession(bone.getBoneCPConn());
	}
	
	public static void closeConnection() {
		bone.shutdownBoneCP();
	}

}
