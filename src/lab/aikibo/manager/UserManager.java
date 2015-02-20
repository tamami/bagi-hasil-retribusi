package lab.aikibo.manager;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import lab.aikibo.entity.User;
import lab.aikibo.services.Koneksi;
import lab.aikibo.util.BoneCPDS;
import lab.aikibo.util.ConnectorUtil;
import lab.aikibo.util.Encrypt;
import lab.aikibo.util.FormattingList;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zkplus.hibernate.HibernateUtil;

@SuppressWarnings("deprecation")
public class UserManager {
	
	public UserManager() {
		init();
	}
	
	public void init() {
		//Koneksi.init();
	}
	
	public boolean isAnyUser(String username) {
		Session session = HibernateUtil.currentSession();
		String sql = "select login from User where login = :username";
		try {
			Query query = session.createQuery(sql);
			query.setString("username", username);
			Iterator iterator = query.iterate();
			while(iterator.hasNext()) {
				String user = (String) iterator.next();
				if(user.equalsIgnoreCase(username)) {					
					return true;
				}
			}
			return false;
		} catch(Exception e) {
			Clients.showNotification("Ada kesalahan sistem, hubungi Admin.");
			return false;
		}
	}
	
	public String getPassword(String username) {
		String password;
		if(isAnyUser(username)) {
			Session session = HibernateUtil.currentSession();
			String sql = "select password from User where login = :username";
			Query query = session.createQuery(sql);
			query.setString("username", username);
			Iterator iterator = query.iterate();
			password = (String) iterator.next();
			return password;
		} else {
			return null;
		}
	}
	
	public String getNip(String username) {
		String nip;
		if(isAnyUser(username)) {
			Session session = HibernateUtil.currentSession();
			String sql = "select nip from User where login = :username";
			Query query = session.createQuery(sql);
			query.setString("username", username);
			Iterator iterator = query.iterate();
			nip = (String) iterator.next();
			return nip;
		} else {
			return null;
		}
	}
	
	public String getNama(String username) {
		String nama;
		if(isAnyUser(username)) {
			Session session = HibernateUtil.currentSession();
			String sql = "select nama from User where login = :username";
			Query query = session.createQuery(sql);
			query.setString("username", username);
			Iterator iterator = query.iterate();
			nama = (String) iterator.next();
			return nama;
		} else {
			return null;
		}
	}
	
	public String getMenu(String username) {
		String menu;
		if(isAnyUser(username)) {
			Session session = HibernateUtil.currentSession();
			String sql = "select menu from User where login = :username";
			Query query = session.createQuery(sql);
			query.setString("username", username);
			Iterator iterator = query.iterate();
			menu = (String) iterator.next();
			return menu;
		} else {
			return null;
		}
	}
	
	public String getKodeSkpd(String username) {
		String result;
		if(isAnyUser(username)) {
			Session session = HibernateUtil.currentSession();
			String sql = "select kodeSkpd from User where login = :username";
			session.beginTransaction();
			Query query = session.createQuery(sql);
			query.setString("username", username);
			Iterator iterator = query.iterate();
			result = (String) iterator.next();
			return result;
		} else {
			return null;
		}
	}
	
	public List<User> getListUser() {
		List<User> list;
		Session session = HibernateUtil.currentSession();
		list = session.createQuery("from User").list();
		return list;
	}
	
	public User getUserByNip(String nip) {
		List<User> daftarData;
		Session session = HibernateUtil.currentSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("nip", nip));
		daftarData = criteria.list();
		if(daftarData != null) {
			return daftarData.get(0);
		} else {
			return null;
		}
	}
	
	public String getDecryptedPasswordByNip(String nip) throws InvalidKeyException, 
			NoSuchAlgorithmException, UnsupportedEncodingException, NoSuchPaddingException, 
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		String result;
		List<User> tempData;
		Session session = HibernateUtil.currentSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("nip", nip));
		tempData = criteria.list();
		if(tempData != null) {
			result = Encrypt.getDecrypted2(((User) tempData.get(0)).getPassword());
		} else result = null;
		
		return result;
	}
	
	public void saveOrUpdate(User user) {
		Session session = HibernateUtil.currentSession();
		session.saveOrUpdate(user);
	}
	
}
