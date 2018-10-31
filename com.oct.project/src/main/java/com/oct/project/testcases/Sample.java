package com.oct.project.testcases;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sample implements Demo {
	
	String n = "rt";

	public void add() {
		
		System.out.println("addition");
		
	}

	public void sub() {
		
		System.out.println("s");
		
	}

	public void div() {
		System.out.println("div");		
	}
	
	
	public static void main(String[] args) {
		
		Demo sample = new Sample();
		
		WebDriver driver = new ChromeDriver();
		
			
		driver = new FirefoxDriver();
	
		
		
		sample.add();
		
		sample.sub();
	}

	
}
