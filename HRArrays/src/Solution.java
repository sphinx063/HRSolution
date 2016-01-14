import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        
    	Scanner s = new Scanner(System.in);
    	int N = s.nextInt();
    	//System.out.println("\n");
    	s.nextLine();
    	if(N<=1000){
    	int[] A = new int[N];
    	int temp;
    	s.useDelimiter("\\s");
    	for(int i =0; i<N; i++){
    		temp = s.nextInt();
    		if(temp<=10000 || temp>=1){
    			A[i] = temp;
    		}
    	}
    	
    	int temp1;
    	for(int i=0;i<N/2;i++){
    		temp1 = A[i];
    		A[i]=A[N-i-1];
    		A[N-i-1] = temp1;
    	}
    	for(int i =0;i<N;i++){
    		System.out.print(A[i]+" ");
    	}
    	}
    	/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}
