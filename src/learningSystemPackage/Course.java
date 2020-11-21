package learningSystemPackage;

import java.util.ArrayList;

public class Course implements Comparable<Course>{
	int id;
	String name;
	float price;
	ArrayList<User> listUsers;
	LessonBinarySearchTree lessonsTree; 
	Course(int idValue, String nameValue, float priceValue) {
		id 			= idValue;
		name 		= nameValue;
		price 		= priceValue;
		listUsers 	= new ArrayList<User>();
		lessonsTree = new LessonBinarySearchTree();
	}
	
	public int getLessonInteractions(LessonBinarySearchTree lessons) {

		int commentsQuantity = lessons.getTotalComments();
		return commentsQuantity;
	}
	
	public float calculateProfits() {
		return price * listUsers.size();
	}

	@Override
	public int compareTo(Course c) {
		return getLessonInteractions(c.lessonsTree) - getLessonInteractions(this.lessonsTree);
	}
	
	
}
