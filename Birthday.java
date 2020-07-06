package _solution;

import javax.swing.*;
import java.util.*;
import java.text.DecimalFormat;

public class Birthday {

	public static void main(String[] args) {
		System.out.println("BIRTHDAY GIFTS");    // console title
		
		// variables to store information from the user
		String childsName;
		String chose = "no";
		double total = 0;
		
		// objects 
		Toy toy = new Toy();
		Random random = new Random();
		DecimalFormat dollar = new DecimalFormat("#,##0.00");
		
		// message box starts here
		JOptionPane.showMessageDialog(null,"Welcome to the Toy Company \nto choose gifts young children");
		
		// loop that allows the customer to add more toys
		do {
			childsName = JOptionPane.showInputDialog("Enter the name of the child");
			toy.setAge(Integer.parseInt(JOptionPane.showInputDialog("how old is the child?")));
			// validation loop to insure if the customer aware the toy is age-appropriate
			do {
				toy.setToy(JOptionPane.showInputDialog("Choose a toy: plushie, blocks, book"));
				toy.setCost(toy.getToy());
				if (!toy.ageOK()) chose = JOptionPane.showInputDialog("The toy is not appropriate for a child of " + toy.getAge() + 
																	  "\n.Do you want to cancel?yes or no");
				else chose = "no";
			} while((Character.toString(chose.charAt(0))).equalsIgnoreCase("y"));
			
			// additional options
			boolean ballon = false;
			boolean card = false;
			String choseCard = JOptionPane.showInputDialog("Do you want a card with the gift?yes or no");
			if((Character.toString(choseCard.charAt(0))).equalsIgnoreCase("y")) {total += toy.CARD; card = true;} 
			
			String choseBallon = JOptionPane.showInputDialog("Do you want a ballon with the gift?yes or no");
			if((Character.toString(choseBallon.charAt(0))).equalsIgnoreCase("y")) { total += toy.BALLOON; ballon = true;}
			
			// individual order details
			System.out.println("\nThe gift for " + childsName + toy.toString()); 
			if(card)  System.out.println("Card   :$" + dollar.format(toy.CARD));
			if(ballon)System.out.println("Ballon :$" + dollar.format(toy.BALLOON));
			System.out.println("Order Number: " + random.nextInt(99999));
			total += toy.getCost();
			
			chose = JOptionPane.showInputDialog("Do you want another toy?yes or no");
		} while((Character.toString(chose.charAt(0))).equalsIgnoreCase("y"));
		
		// total overall cost
		System.out.println("\nTotal Cost  :$" + dollar.format(total));
		// program author
		System.out.println("\nprogrammer: Emmanuel Abebe");
	}
}
