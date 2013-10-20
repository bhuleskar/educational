/*-
 * This computer program is the confidential information and proprietary trade
 * secret of Cisco Systems, Inc. Possessions and use of this program must
 * conform strictly to the license agreement between the user and Cisco Systems,
 * Inc., and receipt or possession does not convey any rights to divulge,
 * reproduce, or allow others to use this program without specific written
 * authorization of Cisco Systems, Inc.
 * 
 * Copyright 2011-2013 Cisco Systems, Inc. All rights reserved.
 * 
 * Created on Sep 30, 2013
 */
package dp;

class StringDecode{
    public static void main(String[] args){
        AllPossibleChars("","1123");
    }
    
    public static void AllPossibleChars(String prefix,String str){
        if(str.length()==0){
            System.out.println(prefix);
            return;
        }
        char c = (char)(Integer.parseInt(str.substring(0,1))+96);
        AllPossibleChars(prefix+c, str.substring(1));
        if(str.length()>=2)
            if(Integer.parseInt(str.substring(0,2))<=26){
                c = (char)(Integer.parseInt(str.substring(0,2))+96);
                AllPossibleChars(prefix+c, str.substring(2));
            }
    }
}