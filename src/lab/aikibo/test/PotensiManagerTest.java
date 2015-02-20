package lab.aikibo.test;

import java.util.List;

import org.hibernate.HibernateException;

import lab.aikibo.entity.Potensi;
import lab.aikibo.manager.PotensiManager;

public class PotensiManagerTest {
	
	public static void main(String args[]) {
		System.out.println("Init");
		PotensiManager pm = new PotensiManager();
		System.out.println("Get list data");
		try {
			List<Potensi> lp = pm.getDaftarPotensi();
			System.out.println("Berapa isinya : " + lp.size());
			System.out.println("Kode Retribusi : " + lp.get(0).getKdRetribusi());
		} catch(HibernateException he) {
			System.out.println("Error Hibernate");
		}
	}

}
