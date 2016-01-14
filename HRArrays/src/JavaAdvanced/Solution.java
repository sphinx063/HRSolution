package JavaAdvanced;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;

import jdk.nashorn.internal.runtime.FindProperty;
//import static java.lang.System.in;

public class Solution {

	public static void main(String[] args) {
		for(int i =0;i<1;i++){
			System.out.println("Hi");
		}
		String s = "cbacdcbc";
		Solution p = new Solution();
		//p.duplicated("cbacdcbc");
		//System.out.println(k);
		int[] arr = {5,2,6,1};
		int[] count = new int[arr.length];
		for(int i=0;i<count.length;i++){
			count[i] = 0;
		}
		for(int i=0;i<arr.length;i++){
			//System.out.println(arr[i]);
			if(i==arr.length-1){
				break;
			}
				
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[i]){
					count[i] = count[i]+1;
				}
			}
		}
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0;i<count.length;i++){
			System.out.println(count[i]);
			list.add(count[i]);
		}
		int[] a = {1,2,3,4,5,4};
		int k = findDuplicate(a);
		System.out.println("        "+k);
	}

public void duplicated(String s){
	Map<Character,Integer> map = new LinkedHashMap<Character,Integer>();
	for(int i =0;i<s.length();i++){
		if(map.containsKey(s.charAt(i))){
			map.put(s.charAt(i),map.get(s.charAt(i))+1);
		}
		else{
			map.put(s.charAt(i),1);
		}
	}
	
	Set<Character> keys =map.keySet();
	String result = "";
	char minChar='\0';
	for(Character c : keys){
		if(minChar<c)
			minChar = c;
		result = result+c;
	}
	
	ArrayList<String> list = new ArrayList<String>();
	list = permutation(result);
	int i = 0;
	for(i =0;i<list.size();i++){
		System.out.println(list.get(i));
	}
	System.out.println(i);
	
}
public static ArrayList<String> permutation(String s) {
    // The result
    ArrayList<String> res = new ArrayList<String>();
    // If input string's length is 1, return {s}
    if (s.length() == 1) {
        res.add(s);
    } else if (s.length() > 1) {
        int lastIndex = s.length() - 1;
        // Find out the last character
        String last = s.substring(lastIndex);
        // Rest of the string
        String rest = s.substring(0, lastIndex);
        // Perform permutation on the rest string and
        // merge with the last character
        res = merge(permutation(rest), last);
    }
    return res;
}
public static ArrayList<String> merge(ArrayList<String> list, String c) {
    ArrayList<String> res = new ArrayList<String>();
    // Loop through all the string in the list
    for (String s : list) {
        // For each string, insert the last character to all possible postions
        // and add them to the new list
        for (int i = 0; i <= s.length(); ++i) {
            String ps = new StringBuffer(s).insert(i, c).toString();
            res.add(ps);
        }
    }
    return res;
}
    public static int findDuplicate(int[] nums) {
    		int A =0;
    		int B=0;
    		int C = 0;
        for(int i=0;i<nums.length;i++){
        	A+=nums[i];
        	B+=(nums[i]*nums[i]);
        }
        for(int i =0;i<nums.length-1;i++){
        	C+=(i+1);
        }
        int result = A-C;
        int P=((nums.length)*(nums.length+1))/2;
        int Q=((nums.length)*(nums.length+1)*(2*nums.length+1))/6;
        int x=P-A;
        int y=(Q-B)/A;
        //int result = (y-x)/2;
        return result;
        
    }

}
