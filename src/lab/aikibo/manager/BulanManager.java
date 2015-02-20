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

}
