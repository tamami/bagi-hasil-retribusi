package lab.aikibo.test;

import java.util.List;

import lab.aikibo.entity.Rekomendasi;
import lab.aikibo.manager.RekomendasiManager;

public class RekomendasiManagerTest {
	
	public static void main(String args[]) {
		RekomendasiManager rm = new RekomendasiManager();
		List<Rekomendasi> data = rm.getDaftarRekomNonWeb();
		if(!data.isEmpty()) {
			System.out.println(data.size());
		}
	}

}
