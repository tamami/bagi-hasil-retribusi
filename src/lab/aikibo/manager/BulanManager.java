package lab.aikibo.manager;

import java.util.LinkedList;
import java.util.List;

public class BulanManager {
	
	public List<String> getFormattedDaftarBulan() {
		List<String> result = new LinkedList<String>();
		result.add("01 - JANUARI");
		result.add("02 - FEBRUARI");
		result.add("03 - MARET");
		result.add("04 - APRIL");
		result.add("05 - MEI");
		result.add("06 - JUNI");
		result.add("07 - JULI");
		result.add("08 - AGUSTUS");
		result.add("09 - SEPTEMBER");
		result.add("10 - OKTOBER");
		result.add("11 - NOVEMBER");
		result.add("12 - DESEMBER");
		return result;
	}
	
	public String getFormattedBulanByName(String namaBulan) {
		switch(namaBulan) {
		case "JANUARI" : return "01 - JANUARI";
		case "FEBRUARI" : return "02 - FEBRUARI";
		case "MARET" : return "03 - MARET";
		case "APRIL" : return "04 - APRIL";
		case "MEI" : return "05 - MEI";
		case "JUNI" : return "06 - JUNI";
		case "JULI" : return "07 - JULI";
		case "AGUSTUS" : return "08 - AGUSTUS";
		case "SEPTEMBER" : return "09 - SEPTEMBER";
		case "OKTOBER" : return "10 - OKTOBER";
		case "NOVEMBER" : return "11 - NOVEMBER";
		case "DESEMBER" : return "12 - DESEMBER";
		default : return null;
		}
	}
	
	public Integer getIndexBulanByName(String namaBulan) {
		switch(namaBulan) {
		case "JANUARI" : return 0;
		case "FEBRUARI" : return 1;
		case "MARET" : return 2;
		case "APRIL" : return 3;
		case "MEI" : return 4;
		case "JUNI" : return 5;
		case "JULI" : return 6;
		case "AGUSTUS" : return 7;
		case "SEPTEMBER" : return 8;
		case "OKTOBER" : return 9;
		case "NOVEMBER" : return 10;
		case "DESEMBER" : return 11;
		default : return 0;
		}
	}
	
	public String getKodeBulanFromIndex(int index) {
		switch(index) {
		case 0: return "01";
		case 1: return "02";
		case 2: return "03";
		case 3: return "04";
		case 4: return "05";
		case 5: return "06";
		case 6: return "07";
		case 7: return "08";
		case 8: return "09";
		case 9: return "10";
		case 10: return "11";
		case 11: return "12";
		default : return null;
		}
	}

}
