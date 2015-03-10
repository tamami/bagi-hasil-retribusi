package lab.aikibo.manager;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import lab.aikibo.entity.Rekomendasi;
import lab.aikibo.util.ConnectorUtil;

public class RekomendasiManager {
	
	public List<Rekomendasi> getDaftarRekomendasi() {
		// mode non-web
		ConnectorUtil cu = new ConnectorUtil();
		SessionFactory sf = cu.getSF();
		Session session = sf.openSession();
		List<Rekomendasi> data = (List<Rekomendasi>) session.createQuery("from Rekomendasi").list();
		return data;
	}

}
