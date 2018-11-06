package tesgNGTestCases;

import org.testng.annotations.Test;

public class DependsOn {
	
	
	@Test()
	public void method1() {
		
		
		
	}
	
	@Test(dependsOnMethods="method1")
	public void method2() {
		
		System.out.println("Executing Method 2 Group");
		
	}

}
