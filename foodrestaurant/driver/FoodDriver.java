package com.tyss.has_a_relationship.foodrestaurant.driver;

import java.util.Scanner;

import com.tyss.has_a_relationship.foodrestaurant.entity.MenuCard;

public class FoodDriver {
	
	private MenuCard menuCard = new MenuCard();
	
	private Scanner scanner = new Scanner(System.in);
	
	int food;
	int order;
	
	public void chooseFood() {
		
		System.out.print("1. South Indian Food \n"
				         + "2. North Indian Food \n\n"
				         + "Enter the Food : ");
		food = scanner.nextInt();
		System.out.println();
		
		if (food == 1) {
			menuCard.southIndian();
		} else {
			menuCard.northIndian();
		}
	}
	
	
	public boolean orderFood() {
		System.out.print("\nOrder : ");
		order = scanner.nextInt();
		
		if (food == 1) {
			System.out.println("\n" + menuCard.getsIndians()[order-1].getDish()  + " order is placed..\n") ;
		} else if (food == 2){
			System.out.println("\n" + menuCard.getnIndians()[order-1].getDish()  + " order is placed..\n") ;
		} else {
			System.out.println("\nInvalid Option");
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unused")
	public void payment() {
		System.out.println("\n1. Card Pay\n"
					   + "2. Cash");
		System.out.print("Choose Payment Option : ");
		int option = scanner.nextInt();
		
		if (option == 1) {
			System.out.println("\nPrice : " + menuCard.getsIndians()[order-1].getPrice());
			System.out.print("Please Swipe Your Card\n"
					       + "Enter Your 4 Digit Card Pin : ");
			int pin = scanner.nextInt();
			System.out.println("\nPayment is Successfully completed By Online");
			
		} else {
			System.out.println("\nPrice : " + menuCard.getsIndians()[order-1].getPrice());
			System.out.println("Payment is Successfully completed By Cash");
		}
	}
	
	public boolean cancelOrder() {
		System.out.println("Your " + menuCard.getsIndians()[order-1].getDish() + " Order is Canceled");
		return false;
	}
}	