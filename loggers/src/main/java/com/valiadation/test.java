package com.valiadation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class test {
	public static void main(String[] args) {
		Integer[] aar1= {1,2,3,4,5};
		Integer[] arr2= {3,4,5,6};
		
		Set<Integer> set1= new HashSet<>(Arrays.asList(aar1));
		Set<Integer> set2= new HashSet<>(Arrays.asList(arr2));
		
		set1.retainAll(set2);
		
		System.out.println("intersection " +set1);
		
		
	}

}
