package com.oct.project.testcases;

import java.util.ArrayList;

public class DemoClass {
	
	
	public static void main(String[] args) {
		
		int number[] = {56,78,12,54,67};
		
		System.out.println(number[0]);
		
		
		int[] intArray = new int[]{ 1,2,3,4,5,6,7,8,9,10 }; 
		
		int []secintArray = new int[20];
		
		secintArray[0] = 43;
		secintArray[1] = 45;
		secintArray[2] = 47;
		
		String[] data = {"test","demo"}; 
	
		
		/* Array lists are created with an initial size.
		 * When this size is exceeded, 
		 * the collection is automatically enlarged. 
		 * When objects are removed, the array may be shrunk.
		 * 
		 *  Class Contains Methods
		 */
		
		ArrayList<String> obj = new ArrayList<String>();
		
		// will retrieve size of an arrray
		System.out.println(obj.size());
		
		obj.add("Test1");
		obj.add("Test2");
		obj.add(0, "Suresh");
		
		System.out.println(obj.size());
		
		System.out.println(obj.get(1));
		
		
		obj.remove(2);
		
		System.out.println(obj);
				
	}
	
	

}
