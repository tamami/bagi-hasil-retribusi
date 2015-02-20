package lab.aikibo.manager;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.zkoss.zkplus.hibernate.HibernateUtil;

import lab.aikibo.entity.Skpd;
import lab.aikibo.util.FormattingList;

public class SkpdManager {
	
	public List<String> getDaftarSkpd() {
		Session session = HibernateUtil.currentSession();
		List<Skpd> list = session.createQuery("from Skpd").list();
		return FormattingList.getFormattedSkpd(list);
	}
	
	public List<Skpd> getNaturalSkpd() {
		Session session = HibernateUtil.currentSession();
		return session.createQuery("from Skpd").list();
	}
	
	public String getFormattedSkpdByKode(String kode) {
		String result;
		List<Skpd> list;
		
		Session session = HibernateUtil.currentSession();
		Criteria criteria = session.createCriteria(Skpd.class);
		criteria.add(Restrictions.eq("kodeSkpd", kode));
		list = criteria.list();
		if(list != null) {
			result = FormattingList.getFormattedSkpd((Skpd) list.get(0));
		} else result = null;
		
		return result;
	}
	
	public void saveOrUpdate(Skpd skpd) {
		Session session = HibernateUtil.currentSession();
		session.saveOrUpdate(skpd);
		session.flush();
	}

}
