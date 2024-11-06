package com.backend.testing;

public class A {

	/*
	public static void given() {
		System.out.println("execute given method");
	}
	
	public static void when() {
		System.out.println("execute when method");
	}
	
	public static void then() {
		System.out.println("execute then method");
	}
	*/
	
	public static A a() {
		System.out.println("execute method a");
		return new A();
		//static methods can also return same class object and other class object also
	}
	
	public static A b() {
		System.out.println("execute method b");
		return new A();
	}
	
	public static B c() {
		System.out.println("execute method c");
		return new B();
	}
}
