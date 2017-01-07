package com.david.javase.tutorial.essential.exception;

/**
 * Feature form Java 7 try - with resource
 * And the suppress the second exception
 * And recover the suppressed exception
 * @author david
 * @link http://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
 * @link http://www.theserverside.com/tutorial/OCPJP-OCAJP-Java-7-Suppressed-Exceptions-Try-With-Resources
 *
 */
public class TryWithResources {
	
	public static void main(String[] args){
		
		try(OpenDoor door = new OpenDoor()){
			door.swing();
		} catch (Exception e) {
			System.out.println("Is there a draft? "+e.getClass());
			int suppressedCount = e.getSuppressed().length;
			for (int i=0; i<suppressedCount; i++){
				System.out.println("Suppressed: "+e.getSuppressed()[i]);
			}
		} finally {
			System.out.println("I'm putting a sweater on.");
		}
		
	}

}

class OpenException extends Exception {}
class SwingException extends Exception {}
class CloseException extends Exception {}

class OpenDoor implements AutoCloseable {

	public OpenDoor() throws Exception {
		System.out.println("The door is open.");
	}
	
	public void swing() throws Exception {
		System.out.println("The door is becoming unhinged.");
		throw new SwingException();
	}
	@Override
	public void close() throws Exception {
		System.out.println("The door is closed.");
		throw new CloseException();
	}
	
}
