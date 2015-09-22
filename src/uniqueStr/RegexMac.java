package uniqueStr;

import java.util.regex.Pattern;

public class RegexMac {

	public static void main(String[] args) {
		String str = "00:23:8a:cf:b8:50_Port2049-00:23:8a:cf:b8:50_Port-1-2-3";

		removeDuplicates(str);
	}

	static void removeDuplicates(String str) {
		Pattern p  = Pattern.compile("^([0-9A-Fa-f]{2}[:-]){5}[0-9A-Fa-f]{2}$");
		
	}

}
