package learningSystemPackage;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.PriorityQueue;
import java.util.Stack;

public class Companie {
	int id;
	String name;
	ArrayList<User> listUsers;
	PriorityQueue<Course> courses;
	Stack<Suscription> stackSuscriptions;
	
	Companie(int idValue, String nameValue) {
		id = idValue;
		name = nameValue;
		listUsers = new ArrayList<User>();
		courses = new PriorityQueue<Course>();
		stackSuscriptions = new Stack<Suscription>();
		
	}
	
	public void recorrerUsuarios() {
		for(User user : listUsers) {
			System.out.println("Usuario: " + user.name);
		}
	}
	
	public void recorrerCursos() {
		for(Course course : courses) {
			System.out.println("Curso: " + course.name + " Ganancias: " + course.calculateProfits() + " Lecciones: "+ course.lessonsTree.getTotalLessons() +" Interacciones: " + course.getLessonInteractions(course.lessonsTree));
			;
		}
	}
	
	public void addUser(User u) {
		listUsers.add(u);
	}
	
	public void addCourse(Course c) {
		courses.add(c);
	}
	
	public void getCoursesProfitsAverage() {
		float totalProfits = 0;
		for(Course course : courses) {
			totalProfits += course.calculateProfits();
		}
		
		float average = totalProfits / courses.size();
		System.out.println("Promedio de ganancias: " + average);
	}
	
	public void getPremiumUsers() {
		while(stackSuscriptions.isEmpty()==false) {
			Suscription suscription = stackSuscriptions.pop();
			System.out.println("Precio: " + suscription.price);	
		}
	}
	
	public void commonCourse() {
		Hashtable<Course, Integer> hashCommonCourse = new Hashtable<Course, Integer>();	
		for(Course course : courses) {
			for(User user : course.listUsers) {
				int count = 1;
				if(hashCommonCourse.containsKey(course)) {
					count = hashCommonCourse.get(course);
					count ++;
				}
				hashCommonCourse.put(course, count);
			}
		}
		
		int mayor = 0;
		Course commonCourse = null;
		
		Enumeration<Course> enumeration = hashCommonCourse.keys();
		
		while(enumeration.hasMoreElements()) {
			Course key = enumeration.nextElement();
			if(hashCommonCourse.get(key) > mayor) {
				mayor = hashCommonCourse.get(key);
				commonCourse = key;
			}
		}
		
		System.out.println("El curso más comun es: " + commonCourse.name);
		
	}
	
}
