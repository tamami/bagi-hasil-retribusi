package lab.aikibo.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectorUtil {
	
	private Configuration config;
	private SessionFactory sf;
	
	public ConnectorUtil() {
		init();
	}
	
	private void init() {
		config = new Configuration();
		sf = config.configure().buildSessionFactory();
	}
	
	public SessionFactory getSF() {
		return sf;
	}
	
	public Configuration getConfig() {
		return config;
	}

}
