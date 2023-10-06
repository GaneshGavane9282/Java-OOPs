package com.tyss.has_a_relationship.foodrestaurant.entity;

public class MenuCard {
	
	private SouthIndian[] sIndians = {new SouthIndian("Panner Tikka", 240), 
									 new SouthIndian("Kaju Panner", 180),
									 new SouthIndian("Pulav", 210),
									 new SouthIndian("Panner Masala", 170)};
	
	private NorthIndian[] nIndians = {new NorthIndian("Dosa", 80),
									  new NorthIndian("Idali", 60),
									  new NorthIndian("Upama", 40),
									  new NorthIndian("Biryani", 240)};
	
	
	
	public void northIndian() {
		int i = 1;
		for (NorthIndian northIndian : nIndians) {
			System.out.print(i++ + " : ");
			northIndian.display();
		}
	}
	
	public void southIndian() {
		int i = 1;
		for (SouthIndian southIndian : sIndians) {
			System.out.print(i++ + " : ");
			southIndian.display();
		}
	}

	public SouthIndian[] getsIndians() {
		return sIndians;
	}

	public NorthIndian[] getnIndians() {
		return nIndians;
	}
}
