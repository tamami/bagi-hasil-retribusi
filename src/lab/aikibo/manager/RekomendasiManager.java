package lab.aikibo.manager;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.zkoss.zkplus.hibernate.HibernateUtil;

import lab.aikibo.entity.Rekomendasi;
import lab.aikibo.util.ConnectorUtil;

public class RekomendasiManager {
	
	public List<Rekomendasi> getDaftarRekomendasi() {
		Session session = HibernateUtil.currentSession();
		//session.beginTransaction();
		List<Rekomendasi> data = (List<Rekomendasi>) session.createQuery("from Rekomendasi").list();
		System.out.println(data.size());
		Rekomendasi r = data.get(0);
		//System.out.print(r.getNamaKecamatan() + " | ");
		//System.out.print(r.getNamaKelurahan() + " | ");
		//System.out.print(r.getRealParkir() + " | ");
		//System.out.print(r.getRealOr());
		System.out.println();
		return data;
	}
	
	public List<Rekomendasi> getDaftarByParam(String bulan, String tahun) {
		Session session = HibernateUtil.currentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Rekomendasi.class);
		criteria.add(Restrictions.eq("bulan", bulan));
		criteria.add(Restrictions.eq("tahun", tahun));
		return (List<Rekomendasi>) criteria.list();
	}
	
	public List<Rekomendasi> getDaftarRekomNonWeb() {
		ConnectorUtil cu = new ConnectorUtil();
		SessionFactory sf = cu.getSF();
		Session session = sf.openSession();
		List<Rekomendasi> data = (List<Rekomendasi>) session.createQuery("from Rekomendasi").list();
		System.out.println(data.size());
		for(int i=0; i<data.size(); i++) {
			Rekomendasi r = data.get(i);
			if(r != null)
				System.out.print(r.getBulan() + " : ");
				System.out.println(r.getNamaKecamatan() + " : " + r.getNamaKelurahan());
		}
		return data;
	}

}
