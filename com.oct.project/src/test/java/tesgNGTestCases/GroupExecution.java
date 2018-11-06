package tesgNGTestCases;

import org.testng.annotations.Test;

public class GroupExecution {
	
	@Test(groups = {"Smoke","Regression"})
	public void method1() {
		
		System.out.println("Executing Method 1 is belongs Smoke and Regression Group");
		
	}
	
	@Test(groups= {"Funatioal"})
	public void method2() {
		
		System.out.println("Executing Method 2 Group");
		
	}
	
	@Test(groups= {"Smoke"})
	public void method3() {
		
		System.out.println("Executing Method 3 is a Smoke Group");
		
	}
	
	@Test(groups= {"Regression"})
	public void method4() {
		
		System.out.println("Executing Method 4 Group");
		
	}
	
	@Test(groups= {"Regression"})
	public void method5() {
		
		System.out.println("Executing Method 5 Group");
		
	}
	
	@Test(groups= {"Functional"})
	public void method6() {
		
		System.out.println("Executing Method 6 Group");
	}
	

}
