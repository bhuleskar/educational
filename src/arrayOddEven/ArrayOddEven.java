package arrayOddEven;

import java.util.ArrayList;
import java.util.List;

public class ArrayOddEven {
	public static void main(String[] args) {
		int[] a = { 1, 3, 2, 4, 5, 6, 7, 8 };
		int[] newarr = new int[8];
		
		List<Integer> odd = new ArrayList<Integer>();
		int i = 0;
		for (; i < a.length - 1;) {
			if (a[i] % 2 == 0) {
				newarr[i] = a[i];
			} else {
				odd.add(a[i]);
			}
		}
		
		for(;i<odd.size();i++){
			a[i]=odd.get(i);
		}
		

//		int i = 0;
//		for (int k : a)
//			if (k % 2 == 0) {
//				a[i] = k;
//				i++;
//			} else {
//				odd.add(k);
//			}
//
//		for (int k : odd) {
//			a[i] = k;
//			i++;
//		}

	}
}
