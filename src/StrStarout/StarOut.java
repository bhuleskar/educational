package StrStarout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarOut {
	public static void main(String[] args){
		starOut("");
	}
	
	public static String starOut(String str) {
		 str="sm*****eilll****yy";
		 Pattern p = Pattern.compile("([a-z]\\*+[a-z])");
		 Matcher m = p.matcher(str);
		 while(m.find()){
			 String a =m.group(1);
			 str=str.replace(a, "");
		 }
		 System.out.println("Final Str ==" + str);
		 return str;
		}

}
