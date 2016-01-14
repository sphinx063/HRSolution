package Q2;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int[][] A = new int[6][6];
        Scanner s = new Scanner(System.in);
        for(int i = 0;i<6;i++){
            s.useDelimiter("\\s");
            for(int j=0;j<6;j++){
                A[i][j] = s.nextInt();
            }
            s.nextLine();
        }
        
        for(int i =0;i<6;i++){
            for(int j=0;j<6;j++){
                System.out.print(A[i][j]+" ");
            }
            System.out.print("\n");
        }
        int sum=0;
        int startRow,startColumn;
        for(int i=0;i<6;i++){
            if((i+2)>5)
                break;
            for(int j=0;j<6;j++){
                if((j+2)>5)
                    break;
                if( (A[i][j]+A[i][j+1]+A[i][j+2]+A[i+1][j+1]+A[i+2][j]+A[i+2][j+1]+A[i+2][j+2])>sum)
                    sum = (A[i][j]+A[i][j+1]+A[i][j+2]+A[i+1][j+1]+A[i+2][j]+A[i+2][j+1]+A[i+2][j+2]);
            }
        }
        System.out.print(sum);
    }
}