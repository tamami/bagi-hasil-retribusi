package lab.aikibo.manager;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.zkoss.zkplus.hibernate.HibernateUtil;

import lab.aikibo.entity.Realisasi;

public class RealisasiManager {
	
	public List<Realisasi> getDaftarRealisasi() {
		List<Realisasi> result = null;
		Session session = HibernateUtil.currentSession();
		try {
			session.beginTransaction();
			result = session.createQuery("from Realisasi").list();
			session.flush();
		} catch(HibernateException he) {
			he.printStackTrace();
			result = new LinkedList<Realisasi>();
		}
		return result;
	}
	
	public List<Realisasi> getDaftarRealisasiBySkpd(String kodeSkpd) {
		List<Realisasi> result = null;
		Session session = HibernateUtil.currentSession();
		
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Realisasi.class);
		criteria.add(Restrictions.eq("kodeSkpd", kodeSkpd));
		return criteria.list();
	}
	
	public Long getNewNumber(String kodeRetribusi, String thnRetribusi) {
		Long result = (long) 0;
		Session session = HibernateUtil.currentSession();
		
		session.beginTransaction();
		Query query = session.createQuery("select count(nomor) from Realisasi " +
				"where kodeRetribusi = :kodeRetribusi " +
				"  and year(tanggalRealisasi) = :thnRetribusi");
		query.setString("kodeRetribusi", kodeRetribusi);
		query.setInteger("thnRetribusi", Integer.valueOf(thnRetribusi));
		Iterator iterator = query.iterate();
		if (iterator.hasNext()) {
			result = new Long((long)iterator.next()) + 1;
		} else result = new Long(1);
		return result;
	}
	
	public void saveOrUpdate(Realisasi data) {
		Session session = HibernateUtil.currentSession();
		session.beginTransaction();
		session.saveOrUpdate(data);
		session.flush();
	}

}
