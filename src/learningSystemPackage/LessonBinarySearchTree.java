package learningSystemPackage;


public class LessonBinarySearchTree {
	LessonNode root;
	
	public void addLesson(Lesson lesson) {	
		if(root == null) {
			root = new LessonNode(lesson);
			return;
		}
		addChild(root, lesson);
	}
	
	private void addChild(LessonNode root, Lesson lesson) {
		if(root == null) {
			return;
		}
		
		if(uniqueId(root, lesson.id) == false) {
			System.out.println(lesson.name + " (" + lesson.id + ") is duplicated, so "+ lesson.name +" couldn't be added to the system again.");
			return;
		}
		
		if(lesson.id > root.lesson.id) {
			if(root.right == null) {
				root.right = new LessonNode(lesson);
			}
			else {
				addChild(root.right, lesson);
			}
		}else {
			if(root.left == null) {
				root.left = new LessonNode(lesson);
			}
			else {
				addChild(root.left, lesson);
			}
		}		
	}
	
	public void printTree() {
		System.out.println("root: " + root.lesson.name);
		search(root);
	}
	
	private void search(LessonNode node) {
		
		if(node == null) {
			return;
		}
		
		if(node.left != null) {
			System.out.println("Left: " + node.left.lesson.name);
			search(node.left);
		}
		
		if(node.right != null) {
			System.out.println("Right: " + node.right.lesson.name);
			search(node.right);
		}
	}
	
	private boolean uniqueId(LessonNode node, int id) {
		if(node == null) {
			return true;
		}
		if(id == node.lesson.id) {
			return false;
		}
		if(id > node.lesson.id) {
			return uniqueId(node.right, id);
		}else {
			return uniqueId(node.left, id);
		}
	}
	
	public int getTotalComments() {
		int totalComments = totalComments(root);
		if(root != null) {
			totalComments += root.lesson.comments.size();
		}
		return totalComments;
	}
	
	private int totalComments(LessonNode node) {
		if(node == null) {
			return 0;
		}		
		int right = 0;
		if(node.right != null) {
			right =  totalComments(node.right);
			right += node.right.lesson.comments.size();
		}
		int left = 0;
		if(node.left != null) {
			left =  totalComments(node.left);
			left += node.left.lesson.comments.size();
		}
		int totalComments = right + left;
		return totalComments;
		
	}
	
	public int getTotalLessons() {
		int totalLessons= size(root);
		if(root != null) {
			totalLessons=+1;
		}
		return totalLessons;
	}
	
	private int size(LessonNode node) {
		if(node == null) {
			return 0;
		}		
		int right = 0;
		if(node.right != null) {
			right =  size(node.right);
			right += 1;
		}
		
		int left = 0;
		if(node.left != null) {
			left =  size(node.left);
			left += 1;
		}
		int totalPatients = right + left;
		return totalPatients;
	}
	
	

}
