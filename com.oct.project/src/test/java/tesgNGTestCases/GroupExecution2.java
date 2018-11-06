package tesgNGTestCases;

import org.testng.annotations.Test;

public class GroupExecution2 {
	
	@Test(groups = {"Smoke"})
	public void method7() {
		
		System.out.println("Executing Method 7 is a Smoke Group");
		
	}
	
	@Test(groups= {"Funatioal"})
	public void method2() {
		
		System.out.println("Executing Method 2 Group");
		
	}
	
	@Test(groups= {"Smoke"})
	public void method9() {
		
		System.out.println("Executing Method 9 is a Smoke Group");
		
	}
	
	@Test(groups= {"Regression"})
	public void method10() {
		
		System.out.println("Executing Method 10 Group");
		
	}
	
	@Test(groups= {"Regression"})
	public void method11() {
		
		System.out.println("Executing Method 11 Group");
		
	}
	
	@Test(groups= {"Functional"})
	public void method6() {
		
		System.out.println("Executing Method 6 Group");
	}
	

}
