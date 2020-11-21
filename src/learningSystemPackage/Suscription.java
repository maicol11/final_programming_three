package learningSystemPackage;

public class Suscription {
	int id;
	float price;
	boolean premium;
	float disccount;
	User user;
	
	Suscription(int idValue, float priceValue, boolean premiumValue, float discountValue, User userValue) {
		id 				= idValue;
		price 			= priceValue;
		premium 		= premiumValue;
		disccount 		= discountValue;
		user			= userValue;
		calculateDisccount();
	}
	
	protected void calculateDisccount() {
		if(user.premium == true) {
			price = 0;
		}else {
			price = price - disccount;
		}
	}
	
}
