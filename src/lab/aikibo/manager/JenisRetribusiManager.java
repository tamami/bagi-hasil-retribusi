package lab.aikibo.manager;

import java.util.List;

import org.hibernate.Session;
import org.zkoss.zkplus.hibernate.HibernateUtil;

import lab.aikibo.entity.JenisRetribusi;

public class JenisRetribusiManager {
	
	public void saveOrUpdate(JenisRetribusi jr) {
		Session session = HibernateUtil.currentSession();
		session.saveOrUpdate(jr);
		session.flush();
	}
	
	public List<JenisRetribusi> getListJenisRetribusi() {
		Session session = HibernateUtil.currentSession();
		return session.createQuery("from JenisRetribusi order by kdRetribusi").list();
	}

}
