package lab.aikibo.manager;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.zkoss.zkplus.hibernate.HibernateUtil;

import lab.aikibo.entity.Potensi;

public class PotensiManager {
	
	public List<Potensi> getDaftarPotensi() throws HibernateException {
		List<Potensi> result = null;
		Session session = HibernateUtil.currentSession();
		try {
			session.beginTransaction();
			result = session.createQuery("from Potensi").list();
			session.flush();
		} catch(HibernateException he) {
			he.printStackTrace();
			result = new LinkedList<Potensi>();
		}
		return result;
	}
	
	public void saveOrUpdate(Potensi data) {
		Session session = HibernateUtil.currentSession();
		session.save(data);
		session.flush();
	}

}
