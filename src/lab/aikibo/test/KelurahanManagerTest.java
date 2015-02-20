package lab.aikibo.test;

import lab.aikibo.manager.KelurahanManager;

public class KelurahanManagerTest {
	
	public static void main(String args[]) {
		KelurahanManager km = new KelurahanManager();
		System.out.println(km.getListKelurahan().get(0));
	}

}
