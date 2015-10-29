import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class MapImpl {

	public static void main(String[] args){
	HashMap map = new HashMap();
	map.put(new MapImpl(),"abc");
	map.put("test1","abcs");
	map.put(new MapImpl(),"abcs");
	map.get(new MapImpl());
	map.get("test");
	map.get("test2");
	
	HashSet<String> set = new HashSet<String>();
	set.add("test");
	set.add("test124");
	Iterator<String> itr = set.iterator();
	while(itr.hasNext()){
	    System.out.println("Element --> " + itr.next());
	}
	
	List lst = new ArrayList();
	lst.add("a");
	lst.add("b");
	lst.add("c");
	lst.remove(0);
	lst.get(1);
	
	List linklst = new LinkedList();
	linklst.add(1);
	linklst.add(1);
	linklst.get(1);
	linklst.remove(1);
	
	String a = "123test124";
	
	int ans =indexOfTest(a.toCharArray(), 0, a.length(), "teweqwe".toCharArray(), 0, 2, 0);

	
//	LinkedList l = new LinkedList();
//	l.size();
//	l.get(5);
//	ArrayList lst = new ArrayList();
//	lst.get(5);
	    
//	    String string = "2013 Sep 16 15:24:54.226332 -0700";
//	    String dbStr = "2013-09-19 23:05:58.0";
//
//	    try {
//	        SimpleDateFormat sf = new SimpleDateFormat("hh:mm:ss.S z EEE MMM dd yyyy");
//         //  Date dt =  sf.parse(showClock);
//	        TimeZone tz = sf.getTimeZone();
//	        SimpleDateFormat showClockDateFormat = new SimpleDateFormat("hh:mm:ss.S z EEE MMM dd yyyy");
//
//
//            Date date1 = new SimpleDateFormat("yyyy MMM dd hh:mm:ss.S Z").parse(string);
//            Date date2 =  new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S").parse(dbStr);
//           // Date date3 =  new SimpleDateFormat("hh:mm:ss.S z EEE MMM dd yyyy").parse(showClock);
//
//            if(date1.after(date2)){
//                 
//            }else{
//                    
//            }
//            System.out.println(date2);
//            System.out.println(date1);   
//            //System.out.println(date3);
//            //System.out.println(tz);
//        } catch (ParseException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
	}
	
	  public int hashCode() {
	    int result = 10;
	    return result;
	  }
	  public boolean equals(Object obj) {
	      //null instanceof Object will always return false
	      if (!(obj instanceof MapImpl))
	        return false;
	      if (obj == this)
	        return true;
	      return false;
	    }
	  
	    static int indexOfTest(char[] source, int sourceOffset, int sourceCount,
	            char[] target, int targetOffset, int targetCount,
	            int fromIndex) {
	if (fromIndex >= sourceCount) {
	 return (targetCount == 0 ? sourceCount : -1);
	}
	if (fromIndex < 0) {
	 fromIndex = 0;
	}
	if (targetCount == 0) {
	return fromIndex;
	}

	char first  = target[targetOffset];
	int max = sourceOffset + (sourceCount - targetCount);

	for (int i = sourceOffset + fromIndex; i <= max; i++) {
	 /* Look for first character. */
	 if (source[i] != first) {
	     while (++i <= max && source[i] != first);
	 }

	 /* Found first character, now look at the rest of v2 */
	 if (i <= max) {
	     int j = i + 1;
	     int end = j + targetCount - 1;
	     for (int k = targetOffset + 1; j < end && source[j] ==
	              target[k]; j++, k++);

	     if (j == end) {
	         /* Found whole string. */
	         return i - sourceOffset;
	     }
	 }
	}
	return -1;
	}
	  
}
