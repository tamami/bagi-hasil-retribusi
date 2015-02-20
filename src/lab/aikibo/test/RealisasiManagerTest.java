package lab.aikibo.test;

import java.util.Date;
import java.util.List;

import lab.aikibo.entity.Realisasi;
import lab.aikibo.manager.RealisasiManager;

public class RealisasiManagerTest {
	
	public static void main(String args[]) {
		RealisasiManager rm = new RealisasiManager();
		List<Realisasi> daftar = rm.getDaftarRealisasiBySkpd("01");
		System.out.println("Jumlah data : " + daftar.size());
		System.out.println("Nomor berikut : " + rm.getNewNumber("02", "2015"));
		Date tanggal = new Date();
		System.out.println("Tahun : " + (tanggal.getYear() + 1900));
	}

}
