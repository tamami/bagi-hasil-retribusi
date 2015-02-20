package lab.aikibo.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.cfg.Configuration;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

public class BoneCPDS {
	
	private BoneCP connectionPool;
	private Connection connection;
	
	public Connection getBoneCPConn() {
		connectionPool = null;
		connection = null;
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		try {
			// setup the connection pool
			BoneCPConfig config = new BoneCPConfig();
			Configuration hibernateConfig = new ConnectorUtil().getConfig();
			config.setJdbcUrl(hibernateConfig.getProperty("connection.url"));
			config.setUsername(hibernateConfig.getProperty("connection.username"));
			config.setPassword(hibernateConfig.getProperty("connection.password"));
			config.setMinConnectionsPerPartition(5);
			config.setMaxConnectionsPerPartition(10);
			config.setPartitionCount(1);
			connectionPool = new BoneCP(config);
			connection = connectionPool.getConnection();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public void shutdownBoneCP() {
		connectionPool.shutdown();
	}

}
