package com.parkinglot.app;

import java.util.Arrays;

public class FindNonRepeatingNo {
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,3,4,5,1};		
		
		for(int i=0; i< arr.length; i++) {
			
			int temp = arr[i];
			temp = temp-1;
			
			if(arr[temp] >= 0) {
				arr[temp] = -arr[i]; 
			}else {
				arr[temp] = Math.abs(arr[i]);
			}			
		}		
		
		Arrays.stream(arr).filter(i -> i< 0).forEach(System.out::println);
		
		
	}

}
