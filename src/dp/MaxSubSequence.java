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
 * Created on Oct 4, 2013
 */
package dp;

public class MaxSubSequence {

        
        public static void main(String[] args) {
         int [] A = { -2, 11, -4, 13, -5, 2 };
         int [] B = {-15, 29, -36, 3, -22, 11, 19, -5};
         maxContiguousSum(A);
         maxContiguousSum(B);
        }
         
        public static void maxContiguousSum(int [] A) {
         int len = A.length;
         int maxSum = 0;
         int runningSum = A[0];
         int j = 0;
         int start=0, finish=0;
          
         for (int i=1; i<len; i++) {
          if (runningSum > 0) {
           runningSum += A[i];
          } else {
           runningSum = A[i];
           j = i;
          }
          if (runningSum > maxSum) {
           maxSum = runningSum;
           start = j;
           finish = i;
          }
         }
         System.out.println("Max Sum: " + maxSum);
         System.out.println("Indices: i=" + start + ": j=" + finish);
        }
}
