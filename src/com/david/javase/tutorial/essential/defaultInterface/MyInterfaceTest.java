package com.david.javase.tutorial.essential.defaultInterface;

/**
 * The following show it has static method and default method on JDK 8
 * 
 * @author david
 * @link http://www.journaldev.com/2752/java-8-interface-changes-static-method-default-method
 * @link https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html
 * 
 * <li>One of the major reason for introducing default methods in interfaces is to enhance the Collections API in Java 8 to support lambda expressions.
 * <li>we can’t have default methods that are overriding Object class methods.
 * 
 *
 * if MyInterfaceTest implements both interfaces it must override the interface on the class. It is compile error.
 */
public class MyInterfaceTest implements Interface1, Interface2 {

	
	/**
	 * remark the following method to see the result. 
	 */
	@Override
	public void doSomething() {
		System.out.println("MyInterfaceTest doSomething");
		Interface1.print("inside doSomething method");
	}
	
	//@Override cannot override static method
	public void print(String message){
		System.out.println("MyInterafeceTest override print");
	}

	public static void main(String[] args){
		MyInterfaceTest test = new MyInterfaceTest();
		test.doSomething();
		test.print("Main");
		Interface1.print("Main Ended");
	}
	
}

/**
 * Please note all implementions inside the method would check the caller class if it has override in subclass for all default method.
 * Otherwise if the method is static. It would not check the subclass override method and use the static method directly.
 * 
 * @author david
 *
 */
interface Interface1 {
	
	static void print(String message){
		System.out.println("Interface1 static print method "+message);
	}
	
	default void doSomething(){
		System.out.println("I do something from interface1");
	}
}

interface Interface2 {
	static void print(String message){
		System.out.println("Interface1 static print method "+message);
	}
	
	default void doSomething(){
		System.out.println("I do something from interface2");
	}
}




