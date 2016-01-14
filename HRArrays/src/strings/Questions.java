package strings;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

public class Questions {
	public String pangram(String s){
		boolean[] alphabet =  new boolean[26];
		for(int i =0;i<alphabet.length;i++){
			alphabet[i] = false;
		}
		StringBuilder builder =new StringBuilder(s.replaceAll("\\s",""));
		System.out.println(builder.toString());
		if(builder.length()<26)
			return "not pangram";
		else{
			for(int i =0;i<builder.length();i++){
				if(builder.charAt(i)-97<0){
					alphabet[builder.charAt(i)-65] = true;
				}
				else{
					alphabet[builder.charAt(i)-97] = true;
				}
			}
		}
		boolean isPangram = true;
		for(int i =0;i<alphabet.length;i++){
			if(!alphabet[i]){
				isPangram = false;
				break;
			}
		}
		if(isPangram)
			return "pangram";
		else
			return "not pangram";
		
	}
	public void funnyString(){
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		String[] strs = new String[T];
		int n =0;
		while(n<T){
			strs[n] = scanner.next();
			n++;
		}
		//String input = scanner.nextLine();
		for(int j =0;j<strs.length;j++){
		String s = strs[j];
		StringBuilder r = new StringBuilder(s);
		r.reverse();
		int p = 0;
		int q= 0;
		boolean isFunny = true;
		for(int i=1;i<s.length();i++){
			p = Math.abs(s.charAt(i)-s.charAt(i-1));
			q = Math.abs(r.charAt(i)-r.charAt(i-1));
			if(p!=q){
				isFunny = false;
				break;
			}
		}
		if(isFunny)
			System.out.println("Funny");
		else
			System.out.println("Not Funny");
		}
		scanner.close();
	}
	public static void StairCase(int n)
	{
		 for(int i=0;i<n;i++){
             for(int j=0;j<n-i-1;j++){
                 System.out.print(" ");
             } 
          for(int k= 0;k<i+1;k++){
        	  System.out.print("#");
          }
          if(i!=n-1){
          System.out.println();
          }
      }
	}
	public static int TrailingZeros(int N){
	
		int count=0;
		for(int i=5;N/i>=1;i=i*5){
			count+=N/i;
		}
		return count;
		
	}
	public static int countDuplicates(int[] numbers){
		int count=0;
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<numbers.length;i++){
			if(map.containsKey(numbers[i])){
				map.put(numbers[i],map.get(numbers[i])+1);
			}
			else{
				map.put(numbers[i],1);
			}
		}
		Iterator<Integer> keyIt = map.keySet().iterator();
		while(keyIt.hasNext()){
			if(map.get(keyIt.next())>=2){
				count++;
			}
		}
		return count;
	}
	public static int countDifferenceK(){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		long[] inputArray = new long[N];
		for(int i=0;i<N;i++){
			inputArray[i]= sc.nextLong();
		}

		sc.close();
		int count = 0;
		Arrays.sort(inputArray);
		for(int i=0;i<N;i++){
			System.out.print(inputArray[i]+" ");
		}
		
		for(int i = 0;i<inputArray.length-1;i++){
			if((Arrays.binarySearch(inputArray,i+1,N,inputArray[i]+K))>0){
				count++;
			}
		}
		
		return count;
		
	}
	/*public static int numberOfTopics(){
		
		Scanner in =new Scanner(System.in);
		int N = in.nextInt();  
		int M=in.nextInt();
		long []input=new long[N];
		for(int i=0;i<M;i++){
		int firstIndex=in.nextInt();
		int secondIndex=in.nextInt();
		long K=in.nextLong();
		input[firstIndex]+=K;
		if((secondIndex+1)<=N) 
			input[secondIndex+1]-=K;
		}
		in.close();
		long max = 0;
        long x = 0;
    for(int i=1;i<=N;i++)
    {
       x=x+input[i];
       if(max<x) 
           max=x;

     }
		System.out.println(max); 
		
	}*/
	static LinkedList<Integer> queue = new LinkedList<Integer>();
	public static int friendCircle(String[] friends){
		String[] tempFriendArray = friends.clone();
        int friendCircleCount=0;
        for (int j=0;j<tempFriendArray.length;j++){
            if (tempFriendArray[j].contains("Y") ){
                friendCircleCount++;
                tempFriendArray[j] = processRow(tempFriendArray[j]);
                while (!queue.isEmpty()){
                    int head = queue.poll();
                    tempFriendArray[head] = processRow(tempFriendArray[head]);
                }
            }
        }
        return  friendCircleCount;
	}
	static String processRow(String row){
        Integer indexOfY;
        while((indexOfY=row.indexOf('Y')) != -1){
            queue.addLast(indexOfY);
            row = row.replaceFirst("Y","N");
        }
        return row;
    }
	static int equilibrium(int[] A){
		long sumRight=0;
		long sumLeft = 0;
		int equilibrium = -1;
		for(int i = 0;i<A.length;i++){
			sumRight+=A[i];
		}
		for(int i = 0;i<A.length;i++){
			long tempRight = sumRight-A[i];
			if(sumLeft == tempRight){
				equilibrium = i;
				break;
			}
			else{
				sumLeft+=A[i];
				sumRight = tempRight;
			}
		}
		return equilibrium;
	}
	 public static int frog(int X, int[] A,int D) {
	       /* int steps = X;
	        boolean[] bitmap = new boolean[steps+1];
	        for(int i = 0; i < A.length; i++){
	            if(!bitmap[A[i]]){
	                bitmap[A[i]] = true;
	                steps--;
	            }
	            if(steps == 0) return i;
	        }
	        return -1;*/
		 int[] positions = new int[X];
		 for(int i=0;i<X;i++)
			 positions[i] = 0;
		 	int currentPosition = 0;
		// b = Array.new(x) { 0 }
		// int leaves_sum = 0;
		 for(int i=0;i<A.length;i++){
			 if(positions[A[i]] == 0){
				 positions[A[i]]=1;
				 //leaves_sum+=1;
			 if(currentPosition<A[i] && currentPosition+D>=A[i]){
				 currentPosition=A[i];
				 if(X-currentPosition<=D){
					 return i;
				 }
					 
			 }
			}
			 //if(leaves_sum == X)
				// return i;
		 }
		 return -1;
		 /* a.each_with_index do |e, i|
		    begin
		      if b[e-1] == 0
		        b[e-1] = 1
		        leaves_sum += 1
		      end

		      if leaves_sum == x
		        return i
		      end
		    rescue
		      # for index out of range
		    end
		  end

		  return -1
*/
		 
	    }
	 int frogDynamic(int[] A, int X, int D){
		 for(int i=A.length-1;i>=0;i--){
			if(X-A[i]<D);
		 }
		 int F = 0;
		 int[] b = new int[X];
		 for(int i = 0;i<X;i++){
			 if(b[A[i]] == 0){
				 b[A[i]] = 1;
				 
			 }
		 }
		 return 0;
	 }
	 static  BigInteger fibonacci(){
		 Scanner s = new Scanner(System.in);
		 long A = s.nextLong();
		 long B = s.nextLong();
		 long N = s.nextLong();
		 s.close();
		 BigInteger T1 = BigInteger.valueOf(A);
		 BigInteger T2 = BigInteger.valueOf(B);
		 BigInteger T = BigInteger.ZERO;
		 for(int i=0;i<N-2;i++){
			 T = (T2.multiply(T2)).add(T1);
			 T1 = T2;
			 T2 = T;
		 }
		 return T;
	 }
	 static int[][] maximumSubarray(){
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		int[][] results = new int[T][2];
		
		for(int i = 0;i<T;i++){
			s.nextLine();
			int N = s.nextInt();
			int[] A = new int[N];
			s.nextLine();
			for(int j = 0;j<N;j++){
				A[j] = s.nextInt();
			}
			int maxSum = A[0];
			//System.out.println("$$$$$$$$$$  "+Integer.MIN_VALUE);
			int currentSum = A[0];
			int startIndex = -1;
			int endIndex = -1;
			int currentIndex = -1;
			int maxStart = -1;
			int maxEnd = -1;
			//System.out.println(maximumSum);
			//results[i] = maximumSum;
			for(int k =1;k<A.length;k++){
				if(currentSum+A[k]<A[k]){
					//System.out.println("k=  "+k);
					if(k>0 && A[k]<0 && A[k-1]<0 && A[k]<A[k-1])
						continue;
						currentSum = A[k];
						startIndex = k;
						endIndex = k;
					
				}
				else{
					currentSum +=A[k];
					endIndex = k;
				}
				if(currentSum>maxSum){
					maxSum = currentSum;
					maxStart = startIndex;
					maxEnd = endIndex;
				}
			}
			results[i][0] = maxSum;
			maxSum = 0;
			startIndex = -1;
			endIndex = -1;
			boolean isFirstPositive =  false;
			for(int k = 0;k<A.length;k++){
				if(A[k]>0 && !isFirstPositive){
					isFirstPositive =  true;
					startIndex = k;
				}
				if(A[k]>0){
					maxSum += A[k];
					endIndex = k;
				}
					
			}
			if(!isFirstPositive){
				maxSum = A[0];
				startIndex = 0;
				endIndex = 0;
				for(int k = 1;k<A.length;k++){
					if(maxSum<A[k]){
						maxSum = A[k];
						startIndex=k;
						endIndex = k;
					}
				}
			}
			//System.out.println(maxStart+" "+ maxEnd);
			results[i][1] = maxSum;
				//System.out.println(A[k]);
			
		}
		s.close();
		return results;
	 }
	 static int coinChange(){
		 Scanner s  = new Scanner(System.in);
		 int N  = s.nextInt();
		 int M  = s.nextInt();
		 int[] coins = new int[M];
		 s.nextLine();
		 for(int  i = 0;i<M;i++){
			 coins[i] = s.nextInt();
		 }
		 int[][] solutions = new int[coins.length+1][N+1];
		 for(int i = 0;i<=coins.length;i++)
			 solutions[i][0] = 1;
		 for(int i = 1;i<=N;i++)
			 solutions[0][i] = 0;

		for(int i = 1;i<=coins.length;i++){
			for(int currentSum = 1;currentSum<=N;currentSum++){
				if((currentSum-coins[i-1])>=0){
					solutions[i][currentSum] = solutions[i][currentSum-coins[i-1]]+solutions[i-1][currentSum];
				}
				else{
					solutions[i][currentSum] = solutions[i-1][currentSum];
				}
			}
		}
		return solutions[coins.length][N];
	 }
	 public static void insertIntoSorted(int[] ar) {
	        // Fill up this function
		 int unsorted = ar[ar.length-1];
		 boolean elementFound  = false;
	        for(int i = ar.length-2;i>=-1;i--){
	        	if(i!=-1){
	        	if(ar[i]>unsorted){
	        			ar[i+1] = ar[i];
	        	}
	        	else{
	        		ar[i+1] = unsorted;
	        		elementFound = true;
	        		
	        	}
	        	}
	        	else{
	        		ar[i+1] = unsorted;
	        		elementFound = true;
	        	}
	        	for(int j=0;j<ar.length;j++){
    				System.out.print(ar[j]+" ");
    			}
    			System.out.println();
    			if(elementFound)
    				break;
	        	
	        }
	    }
	 public static int alternatingCharacters(){
		 Scanner s  = new Scanner(System.in);
		 int T = s.nextInt();
		 String tests[] = new String[T];
		 s.nextLine();
		 for(int  i =0;i<T;i++){
			 tests[i] = s.nextLine();
		 }
		 int[] results = new int[T];
		 for(int i = 0;i<tests.length;i++)
		 {
			 String p = tests[i];
			 int deleteCount = 0;
			 for(int j =0;j<p.length()-1;j++){
				 if(p.charAt(j) == p.charAt(j+1)){
					deleteCount++;
				 }
				 
			 }
			 results[i] = deleteCount;
		 }
		 for(int  i =0;i<T;i++){
			 System.out.println(results[i]);
		 }
		 
		 return 0;
	 }
	 public static int[] maxTopics(){
		 Scanner s  = new Scanner(System.in);
		 int N  = s.nextInt();
		 int M  = s.nextInt();
		 boolean[][] knowMatrix = new boolean[N][M];
		 s.nextLine();
		 for(int  i =0;i<N;i++){
			 String str = s.nextLine();
			 for(int j = 0;j<M;j++){
				 	if(str.charAt(j) == '1')
					 knowMatrix[i][j] = true;
				 	else
				 		knowMatrix[i][j] = false; 
			 }
		 }
		 int max = 0;
		 int noOfTeams = 0;
		 for(int  i =0;i<N-1;i++){
			 
			 for(int j = i+1;j<N;j++){
				 int currentTopics = 0;
				 for(int k = 0 ;k<M;k++){
					 if(knowMatrix[i][k]|knowMatrix[j][k])
						 currentTopics++;
					 
				 }
				 if(currentTopics == max)
					 noOfTeams++;
				 if(currentTopics>max){
					 max = currentTopics;
					 noOfTeams =1;
				 }
			 }
		 }
		 int[] results = new int[2];
		 results[0] = max;
		 results[1] = noOfTeams;
		 return results;
		 
	 }
	/* public static void dArray(){
		 Scanner s  = new Scanner(System.in);
		 int N  = s.nextInt();
		 int Q  = s.nextInt();
		 Vector<Integer>[] sequences = new Vector<Integer>[Q];
		 int lastans = 0;
		 s.nextLine();
		 int[][] opArray= new int[Q][3];
		 for(int  i =0;i<Q;i++){
			 opArray[i][0]=s.nextInt();
			 opArray[i][1]  = s.nextInt();
			 opArray[i][2] = s.nextInt();
			 s.nextLine();
		 }
		 s.close();
		 for(int  i =0;i<Q;i++){
			 int op = opArray[i][0];
			 int x  = opArray[i][1];
			 int y = opArray[i][2];
			 switch(op){
			 case 1:
				 int seqId = ((x^lastans)%N);
				// int lastIndex = sequences[seqId].length;
				// sequences[seqId][lastIndex] = y;
				 break;
			 
		 	 case 2:
			 	int seqId2 = ((x^lastans)%N);
			 	int size = sequences[seqId2].length;
			 	if(size!=0){
			 		int index = y%size;
			 		System.out.println(sequences[seqId2][index]);
			 		lastans = sequences[seqId2][index];
			 	}
			 	break;
		 }
		 }
	 }*/
	    
	 public static void sparseArrays(){
		 Scanner s  = new Scanner(System.in);
		 int N  = s.nextInt();
		 String[] stringList =  new String[N];
		 s.nextLine();
		 for(int i = 0;i<N;i++){
			 stringList[i] = s.nextLine();
		 }
		 //s.nextLine();
		 int Q  = s.nextInt();
		 String[] test = new String[Q];
		 s.nextLine();
		 for(int i = 0;i<Q;i++){
			 test[i] = s.nextLine();
		 }
		 s.close();
/*		 for(int i = 0;i<N;i++){
			 System.out.println(stringList[i]);
		 }
		 for(int i = 0;i<Q;i++){
			 System.out.println(test[i]);
		 }*/
		 int[] results = new int[Q];
		 for(int i = 0;i<Q;i++){
			 int count = 0;
			 for(int j = 0;j<N;j++){
				 if(test[i].equals(stringList[j])){
					 count++;
				 }
			 }
			 results[i] = count;
		 }
		 for(int i = 0;i<Q;i++){
			 System.out.println(results[i]);
		 }
	 }
}
