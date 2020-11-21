package learningSystemPackage;

import java.util.ArrayList;
import java.util.Stack;

public class Lesson {
	int id;
	String name;
	ArrayList<User> listUsers;
	Stack<Comment> comments;
	
	Lesson(int idValue, String nameValue) {
		id = idValue;
		name = nameValue;
		listUsers = new ArrayList<User>();
		comments  = new Stack<Comment>();
	}
	
	public void addComment(Comment c) {
		comments.push(c);
	}
	
	public void recorrerStack() {
		while(comments.isEmpty()==false) {
			Comment comment = comments.pop();
			System.out.println("Comentario: " + comment.description);	
		}
	}
}
