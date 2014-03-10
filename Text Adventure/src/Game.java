/**
 * Map.java
 * @author Alex Dunn
 * B00636250
 * Mar 9, 2014
 * Dalhousie University
 * Faculty of Computer Science
 */


import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		printMessage("Hello There Dunn");
		
		
		
	}
	
	public static void printMessage(String n){
		
		for (int i = 0; i < n.length(); i++){
			System.out.print(n.substring(i, i+1));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}
