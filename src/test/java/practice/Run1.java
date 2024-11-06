package practice;

import org.testng.annotations.Test;

import static com.backend.testing.A.*;

public class Run1 {
	
	@Test
	public void sampleTest() {

		/*
		given();
		when();
		then();
		
		//you can access all the static methods available in class A without using class name because you have
		//already done static import.
		//This functionality is available only in JDK 1.5 above version
		 */
		
		//No need to create an object because of static import that is a1.a().b().c().d(); is not required.
		//I can access the methods directly without using class name as i am doing static import

		a().b().c().d();


	}
}
