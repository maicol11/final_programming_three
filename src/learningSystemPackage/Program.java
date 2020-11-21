package learningSystemPackage;

public class Program {

	public static void main(String[] args) {
		
		Companie c1 = new Companie(1, "companie 1");
		
		LessonBinarySearchTree bst = new LessonBinarySearchTree();
		
		User u1 = new User(1, "user 1", false);
		User u2 = new User(2, "user 2", true);
		User u3 = new User(3, "user 3", true);
		User u4 = new User(4, "user 4", false);
		
		c1.addUser(u1);	
		
		Course course1 = new Course(1, "BIM", 423.4f);
		
		course1.listUsers.add(u2);
		course1.listUsers.add(u3);
		course1.listUsers.add(u4);
		
		Course course2 = new Course(2, "LEAN", 241.4f);
		
		Course course3 = new Course(3, "PRUEBA 3", 231.3f);
		
		Lesson s1 = new Lesson(1, "lesson 1");
		
		//course1.addLesson(s1);
		
		Comment comment1 = new Comment(1, "comment 1");
		Comment comment2 = new Comment(2, "comment 2");
		Comment comment3 = new Comment(3, "comment 3");
		Comment comment4 = new Comment(4, "comment 4");
		
		s1.addComment(comment1);
		s1.addComment(comment2);
		s1.addComment(comment3);
		s1.addComment(comment4);
		
		Lesson s2 = new Lesson(3, "lesson 2");
		
		s2.addComment(comment4);
		
		//course2.addLesson(s2);
		
		Lesson s3 = new Lesson(2, "lesson 3");
		

		bst.addLesson(s1);
		bst.addLesson(s2);
		bst.addLesson(s3);		
		//bst.printTree();
		course1.lessonsTree = bst;
		
		LessonBinarySearchTree bst2 = new LessonBinarySearchTree();
		
		bst2.addLesson(s2);
		
		LessonBinarySearchTree bst3 = new LessonBinarySearchTree();
		
		course2.lessonsTree = bst2;
		
		course3.lessonsTree = bst3;
		
		c1.addCourse(course2);
		c1.addCourse(course1);
		c1.addCourse(course3);
		
		c1.recorrerCursos();
		
		Suscription suscription1 = new Suscription(1, 423.15f, false, 12.45f, u4);
		c1.stackSuscriptions.push(suscription1);
		
		c1.getPremiumUsers();
		
		c1.commonCourse();

	}
}
