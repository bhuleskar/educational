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
 * Created on Oct 12, 2013
 */
package Sort;

public class MergeSort {
     int [] A = { 2, 4, 1, 6, 8, 5, 3, 7 };
     int k=0;;

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        sort.mergeSort();
    }
    
    public void mergeSort(){

        System.out.println("Before recursion");
        for (int i = 0; i < A.length; i++) {
            System.out.print(" " + A[i]);
        }
        recurseSort(A);
        System.out.println("After recursion");
        for (int i = 0; i < A.length; i++) {
            System.out.print(" " + A[i]);
        }
    }
    
    public void recurseSort(int[] array) {
        if (array.length == 1) {
            return;
        }
        int length = array.length;
        int mid = length / 2;
        int[] left = new int[mid];
        int[] right = new int[mid];
        int i = 0;

        while (i < mid) {
            left[i] = array[i];
            i++;
        }
        int j = 0;
        while (i <length) {
            right[j] = array[i];
            i++;
            j++;
        }
        recurseSort(left);
        recurseSort(right);

        merge(array, left, right);
    }
    
    public  void merge(int[] array, int[] left, int right[]){
        
        int i=0;
        int j=0;
        int k=0;
        while(i<left.length && j< right.length){
            if(left[i] < right[j]){
                array[k] = left[i];
              i++;
              k++;
            } else{
                array[k] = right[j];
                j++;
                k++;
            }
        }
        while (i<left.length){
            array[k] = left[i];
            i++;
            k++; 
        }
        while (j<right.length){
            array[k] = right[j];
            j++;
            k++; 
        }
        
    }

}
