package lab.aikibo.manager;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.zkoss.zkplus.hibernate.HibernateUtil;

import lab.aikibo.entity.Kecamatan;

public class KecamatanManager {
	
	public void saveOrUpdate(Kecamatan kecamatan) {
		Session session = HibernateUtil.currentSession();
		session.saveOrUpdate(kecamatan);
		session.flush();
	}
	
	public List<Kecamatan> getListKecamatan() {
		Session session = HibernateUtil.currentSession();
		return (List<Kecamatan>) session.createQuery("from Kecamatan order by kdKecamatan").list();
	}
	
	public List<String> getFormattedKecamatan() {
		List<String> result = null;
		List<Kecamatan> data = getListKecamatan();
		if(!data.isEmpty()) result = new LinkedList<String>(); 
		for(int i=0;i<data.size();i++) {
		  result.add(data.get(i).getKdKecamatan() + " - " + data.get(i).getNmKecamatan());
		}
		return result;
	}

}
