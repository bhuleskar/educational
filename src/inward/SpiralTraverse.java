package inward;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class to Implement an iterator for a 2-dimensional array type data structure
 * that moves in an clockwise inward spiral
 * 
 * 
 * Algo: I used an approach such that the outer spiral is printed first followed
 * by the inner spiral and so on till the end of elements
 * 
 */
//i.e: Say a matrix is like the following:

//1  2  3  4 
//5  6  7  8
//9 10 11 12
//13 14 15 16
//17 18 19 20

/**
 * The algorithm first prints the outer square i.e 1,2,3,4 then the right most
 * column excluding the already printed element 8,12,16,20 and then the bottom
 * row from right to left excluding the already printed element 19,18,17 and
 * then to the top leaving the element already printed i.e till 17,13,9,5
 * 
 * This is continued till we are exhausted of all the elements in the array. 
 * The algorithm visits all the elements in the matrix giving it O(nm).
 */

public class SpiralTraverse {

	public static void main(String args[]) {
		/**
		 * A sample Array.
		 */
		// int[][] matarr={
		// {1,2,3,4},
		// {5,6,7,8},
		// {9,10,11,12},
		// {13,14,15,16},
		// {17,18,19,20}};

		// Can use Scanner too but I chose to use BufferedReader.
		//Scanner scanner = new Scanner(System.in);
		// Scan All the elements from the command line.
		//NOTE: Enter needs to be pressed after each element is inputed.
		InputStreamReader istream = new InputStreamReader(System.in) ;
        BufferedReader br = new BufferedReader(istream) ;

		// Number of Rows and Cols for the array.
		int rows = 0;
		int cols = 0;

		System.out.println("Enter the rows and press enter\n");

		// Get the Input for number of rows from the user.
		try {
			try {
				rows = Integer.parseInt(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (NumberFormatException e) {
			System.out.println("Rows should be an integer value.");
			System.exit(0);
		}
		System.out.println("Enter the cols and press enter \n");
		// Get the Input for number of rows from the user.
		try {
			try {
				cols = Integer.parseInt(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (NumberFormatException e) {
			System.out.println("cols should be an integer value.");
			System.exit(0);
		}

		// Initialize the 2D array.
		// Initially uses int array but it failed for alphabets. So considered
		// using a String array.
		String[][] matarr = new String[rows][cols];

		// Get the input from the user and populate the 2D array.
		if (rows > 0 && cols > 0) {
			for (int i = 0; i < rows; i++)
				for (int j = 0; j < cols; j++) {
					try {
						try {
							System.out.println("Enter the element:"+i+j +" and press enter");
							matarr[i][j] = br.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (NumberFormatException e) {
						e.printStackTrace();
					}
				}
		} else {
			System.out.println("Rows and Cols should be greater than 0");
			System.exit(0);
		}

		// First element in the matrix.
		int colmin = 0;
		// Num of columns.
		int colmax = cols - 1;
		// First element in the matrix.
		int rowmin = 0;
		// Num of rows.
		int rowmax = rows - 1;
		System.out.println("Output \n");
		if (cols == 1) {
			for (int i = 0; i <= rowmax; i++) {
				System.out.print(matarr[i][0] + " ");
			}
		} else if (rows == 1) {
			for (int i = 0; i <= colmax; i++) {
				System.out.print(matarr[0][i] + " ");
			}
		} else {

			// While the condition is true.
			while (colmin <= colmax && rowmin <= rowmax) {
				// Prints the first row in the corresponding matrix set.
				for (int i = colmin; i <= colmax; i++) {
					System.out.print(matarr[rowmin][i] + " ");
				}
				// Prints the last column in the corresponding matrix set.
				for (int i = rowmin + 1; i <= rowmax; i++) {
					System.out.print(matarr[i][colmax]+ " ");
				}
				// Prints the last row in the corresponding matrix set.
				for (int i = colmax - 1; i >= colmin && rowmax != rowmin ; i--) {
						System.out.print(matarr[rowmax][i]+ " ");
				}
				// Prints the first column in the corresponding matrix set.
				for (int i = rowmax - 1; i > rowmin; i--) {
					System.out.print(matarr[i][colmin]+ " ");
				}
				// Increment and decrement the colmin,rowmax,rowmin.colmax so
				// that
				// the next spiral is taken into consideration.
				colmin++;
				rowmax--;
				rowmin++;
				colmax--;
			}
		}
	}
}


/*
 * TEST CASES
 * 
TEST CASE1 : Test with integer values.-- Pass

Enter the rows and press enter
2
Enter the cols and press enter 
3
Enter the element:00 and press enter
1
Enter the element:01 and press enter
2
Enter the element:02 and press enter
3
Enter the element:10 and press enter
4
Enter the element:11 and press enter
5
Enter the element:12 and press enter
6
Output 

1 2 3 6 5 4 

TEST CASE2:-- Fails 
Reason: Rows should be greater than 0.

Enter the rows and press enter
0
Enter the cols and press enter 

1
Rows and Cols should be greater than 0


TEST CASE3 -- Fails 
Reason: Rows should be an integer value.
Enter the rows and press enter
a
Rows should be an integer value.


TEST CASE4:Test with Strings. -- Pass

Enter the rows and press enter
2
Enter the cols and press enter 
2
Enter the element:00 and press enter
this
Enter the element:01 and press enter
is
Enter the element:10 and press enter
a
Enter the element:11 and press enter
test
Output 

this is test a 


TEST CASE5 :When row and col is 1-- Pass
Enter the rows and press enter
1
Enter the cols and press enter 
1
Enter the element:00 and press enter
1
Output 
1

TEST CASE6 -- When rows is 1 and cols >1 --Pass
Enter the rows and press enter
1
Enter the cols and press enter 

3
Enter the element:00 and press enter
1
Enter the element:01 and press enter
2
Enter the element:02 and press enter
3
Output 

1 2 3 

TEST CASE7-- When cols is 1 and rows >1 --Pass
Enter the rows and press enter
5
Enter the cols and press enter 
1
Enter the element:00 and press enter
1
Enter the element:10 and press enter
2
Enter the element:20 and press enter
3
Enter the element:30 and press enter
4
Enter the element:40 and press enter
5
Output 

1 2 3 4 5 


TEST CASE8 -- When rows and cols are characters --Pass
Enter the rows and press enter
6
Enter the cols and press enter 
2
Enter the element:00 and press enter
a
Enter the element:01 and press enter
b
Enter the element:10 and press enter
c
Enter the element:11 and press enter
d
Enter the element:20 and press enter
e
Enter the element:21 and press enter
f
Enter the element:30 and press enter
g
Enter the element:31 and press enter
h
Enter the element:40 and press enter
i
Enter the element:41 and press enter
j
Enter the element:50 and press enter
k
Enter the element:51 and press enter
l
Output 

a b d f h j l k i g e c 
*/
