package lab.aikibo.manager;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
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
	
	public String getFormattedJnsRetribusiByKode(String kodeRetribusi) {
		Session session = HibernateUtil.currentSession();
		Criteria criteria = session.createCriteria(JenisRetribusi.class);
		criteria.add(Restrictions.eq("kdRetribusi", kodeRetribusi));
		List<JenisRetribusi> data = (List<JenisRetribusi>) criteria.list();
		if(data.isEmpty()) return null;
		return data.get(0).getKdRetribusi() + " - " + data.get(0).getNmRetribusi();
	}

}
