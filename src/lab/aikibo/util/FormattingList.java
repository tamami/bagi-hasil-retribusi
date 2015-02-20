package lab.aikibo.util;

import java.util.LinkedList;
import java.util.List;

import lab.aikibo.entity.JenisRetribusi;
import lab.aikibo.entity.Kecamatan;
import lab.aikibo.entity.Kelurahan;
import lab.aikibo.entity.Skpd;

public class FormattingList {
	
	public static String getFormattedSkpd(Skpd data) {
		return data.getKodeSkpd() + " - " + data.getNamaSkpd();
	}
	
	public static List<String> getFormattedSkpd(List<Skpd> list) {
		List<String> resultList = new LinkedList<String>();
		if(list == null) 
			return null;
		for(int i=0; i < list.size(); i++) {
			Skpd tempData = new Skpd();
			tempData = list.get(i);
			resultList.add(tempData.getKodeSkpd() + " - " + tempData.getNamaSkpd());
		}
		return resultList;
	}
	
	public static String getFormattedKecamatan(Kecamatan data) {
		return data.getKdKecamatan() + "-" + data.getNmKecamatan();
	}
	
	public static List<String> getFormattedKecamatan(List<Kecamatan> list) {
		List<String> resultList = new LinkedList<String>();
		if(list == null) 
			return null;
		for(int i=0; i < list.size(); i++) {
			Kecamatan tempData = new Kecamatan();
			tempData = list.get(i);
			resultList.add(tempData.getKdKecamatan() + " - " + tempData.getNmKecamatan());
		}
		return resultList;
	}
	
	public static String getFormattedRetribusi(JenisRetribusi jr) {
		return jr.getKdRetribusi() + " - " + jr.getNmRetribusi();
	}
	
	public static List<String> getFormattedRetribusi(List<JenisRetribusi> list) {
		List<String> resultList = new LinkedList<String>();
		if(list == null) return null;
		for(int i=0; i < list.size(); i++) {
			JenisRetribusi jr = new JenisRetribusi();
			jr = list.get(i);
			resultList.add(getFormattedRetribusi(jr));
		}
		return resultList;
	}
	
	public static String getKodeRetribusi(String formattedRetribusi) {
		return formattedRetribusi.substring(0,2);
	}
	
	public static String getFormattedKelurahan(Kelurahan data) {
		return data.getKdKelurahan() + " - " + data.getNmKelurahan();
	}
	
	public static List<String> getFormattedKelurahan(List<Kelurahan> listData) {
		List<String> resultList = new LinkedList<String>();
		if(listData == null) return null;
		for(int i=0; i < listData.size(); i++) {
			Kelurahan data = new Kelurahan();
			data = listData.get(i);
			resultList.add(getFormattedKelurahan(data));
		}
		return resultList;
	}
	
	public static String getUpperCase(String data) {
		return data.toUpperCase();
	}
	
}
