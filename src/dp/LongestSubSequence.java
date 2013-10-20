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
 * Created on Aug 6, 2013
 */
package dp;

public class LongestSubSequence {
    public static void main (String[] args){
int[] seq = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};

System.out.println(increasingSubsequence(seq));
    }
//    public static int increasingSubsequence(int[]seq){
//        int[]L=new int[seq.length];
//        L[0]=1;
//        for(int i=1;i<L.length;i++){
//          int maxn=0;
//          for(int j=0;j<i;j++){
//            if(seq[j]<seq[i]&&L[j]>maxn){
//              maxn=L[j];
//            }
//          }
//          L[i]=maxn+1;
//        }
//        int maxi=0;
//        for(int i=0;i<L.length;i++){
//          if(L[i]>maxi){
//            maxi=L[i];
//          }
//        }
//        return(maxi);
//      }
    
    public static int increasingSubsequence(int[]seq){
        /*
         * This helps us check already found length of earlier dp[]... so considering 14 i.e seq[7] ...we know 14>0, 14>8 14 >4
         * but at 14>4 we have calculated that at 4 dp[] value length is 2 so we dont update dp[7].
         */ 
        int[] dp = new int[seq.length];
        dp[0] = 1;
        for( int i = 1; i < seq.length; i++ ) {
           dp[i] = 1;
           for( int j = 0; j < i; j++ ) {
              if( seq[i] > seq[j] ) {
                 if( dp[i] < dp[j]+1 ) {
                    dp[i] = dp[j]+1;
                 }
              }
           }
        }
        int max=0;
        for(int i=0;i<dp.length;i++){
            if (max<dp[i]){
                max=dp[i];
            }
        }
        return max;
    }
}
