import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class MapImpl {

	public static void main(String[] args){
//	HashMap map = new HashMap();
//	map.put("test","abc");
//	map.put("test1","abcs");
//	map.put("test3","abcs");
//	map.get("test3");
//	map.get("test");
//	map.get("test2");
//	
//	LinkedList l = new LinkedList();
//	l.size();
//	l.get(5);
//	ArrayList lst = new ArrayList();
//	lst.get(5);
	    
	    String string = "2013 Sep 16 15:24:54.226332 -0700";
	    String dbStr = "2013-09-19 23:05:58.0";

	    try {
	        SimpleDateFormat sf = new SimpleDateFormat("hh:mm:ss.S z EEE MMM dd yyyy");
         //  Date dt =  sf.parse(showClock);
	        TimeZone tz = sf.getTimeZone();
	        SimpleDateFormat showClockDateFormat = new SimpleDateFormat("hh:mm:ss.S z EEE MMM dd yyyy");


            Date date1 = new SimpleDateFormat("yyyy MMM dd hh:mm:ss.S Z").parse(string);
            Date date2 =  new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S").parse(dbStr);
           // Date date3 =  new SimpleDateFormat("hh:mm:ss.S z EEE MMM dd yyyy").parse(showClock);

            if(date1.after(date2)){
                 
            }else{
                    
            }
            System.out.println(date2);
            System.out.println(date1);   
            //System.out.println(date3);
            //System.out.println(tz);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}
