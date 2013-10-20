
package inward; 

public class Test { 

            public static void main(String args[]){

                  int[][] arr={
                              {1,2,3,4},
                              };

                  int colmin=0;

                  int colmax=arr[0].length-1;

                  int rowmin=0;

                int rowmax=arr.length-1;

                  while(colmin<=colmax && rowmin <=rowmax)

                  {

                        for(int i=colmin;i<=colmax;i++)

                          System.out.println(arr[rowmin][i]);

                        for(int i=rowmin;i<=rowmax;i++)

                               System.out.println(arr[i][colmax]);

                        for(int i=--colmax;i>=colmin;i--)

                               System.out.println(arr[rowmax][i]);

                        for(int i=--rowmax;i>rowmin;i--)

                               System.out.println(arr[i][colmin]);

//                        colmin++;
//
//                        rowmax--;
//
//                        rowmin++;
//
//                        colmax--;

                  } 

            } 

}