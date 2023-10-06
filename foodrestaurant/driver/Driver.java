package com.tyss.has_a_relationship.foodrestaurant.driver;

import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {
		menu();
		
		FoodDriver driver = new FoodDriver();
		
		Scanner scanner = new Scanner(System.in);
		
		boolean flag = true;
		
		while (flag) {
			
			driver.chooseFood();
			
			boolean temp = driver.orderFood();
			
			if (temp) {
				
				System.out.println("1. Make Payment\n"
						       + "2. Cancel Order\n");
				System.out.print("Choose Option : ");
				int option = scanner.nextInt();
				
				if (option == 1) {
					driver.payment();
				} else {
					driver.cancelOrder();
				}
				System.out.println("\nDo you want order again");
				System.out.print("Press Y or N : ");
				char ch = scanner.next().charAt(0);
				System.out.println();
				
				if (ch == 'n') {
					flag = false;
				} 
			}
			scanner.close();
		}
	}
	
	public static void menu() {
		System.out.print("====== WelCome ======\n"
					   + "= Hotel PriyDarshni =\n\n");
		
	}
}
