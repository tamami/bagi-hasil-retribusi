package lab.aikibo.manager;

import java.util.List;

import lab.aikibo.entity.Kelurahan;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.zkoss.zkplus.hibernate.HibernateUtil;

public class KelurahanManager {
	
	public List<String[]> getDaftarKelurahan() {
		Session session = HibernateUtil.currentSession();
		return (List<String[]>) session.createQuery("select kec.kdKecamatan, kec.nmKecamatan, " + 
				"  kel.kdKelurahan, kel.nmKelurahan " +
				"from Kecamatan kec, Kelurahan kel " +
				"where kec.kdKecamatan = kel.kdKecamatan " +
				"order by kec.kdKecamatan, kel.kdKelurahan").list();
	}
	
	public void saveOrUpdate(Kelurahan kelurahan) {
		Session session = HibernateUtil.currentSession();
		session.saveOrUpdate(kelurahan);
		session.flush();
	}
	
	public List<Object[]> getListKelurahan() {
		List<Object[]> data;
		Session session = HibernateUtil.currentSession();
		session.beginTransaction();
		data = (List<Object[]>) session.createQuery("from Kelurahan").list();
		session.flush();
		return data;
	}
	
	public List<Kelurahan> getListKelurahanByKecamatan(String kodeKecamatan) {
		Session session = HibernateUtil.currentSession();
		Criteria criteria = session.createCriteria(Kelurahan.class);
		criteria.add(Restrictions.eq("kdKecamatan", kodeKecamatan));
		return criteria.list();
	}
	
	public String getFormattedKelurahanByKode(String kodeKecamatan, String kodeKelurahan) {
		Session session = HibernateUtil.currentSession();
		Criteria criteria = session.createCriteria(Kelurahan.class);
		criteria.add(Restrictions.eq("kdKecamatan", kodeKecamatan));
		criteria.add(Restrictions.eq("kdKelurahan", kodeKelurahan));
		List<Kelurahan> data = (List<Kelurahan>) criteria.list();
		if(data.isEmpty()) return null;
		return data.get(0).getKdKelurahan() + " - " + data.get(0).getNmKelurahan();
	}

}
