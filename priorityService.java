import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
class Student {
	private int token;
	private String fname;
	private double cgpa;
	public Student(int token, String fname, double cgpa) {
		this.token = token;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getToken() {
		return token;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}

}
class priorityService {
	public static void main(String[] args) {
		System.out.println("Enter Input in the Format: \nNumber of Inputs\nEvent-ENTER Name Cgpa Token\nor SERVED:\n ");
		Scanner scan = new Scanner(System.in);
		int totalEvents = scan.nextInt();
		PriorityQueue<Student> pQ = new PriorityQueue<Student>(
				new Comparator<Student>() {
					public int compare(Student student1, Student student2) {
						if (student1.getCgpa() != student2.getCgpa()){
							if(student1.getCgpa() > student2.getCgpa())
								return -1;
							else
								return 1;
						}else {
							if (  ( student1.getFname().compareTo(student2.getFname()) ) != 0){
								return student1.getFname().compareTo(student2.getFname());
						}else
								return student1.getToken() - student2.getToken();
						}
					}
				}
		);
		for (int i = 0; i < totalEvents; i++) {
			String event = scan.next();            
            if (event.equals("ENTER")) {
                String name = scan.next();
                double cgpa = scan.nextDouble();
                int token = scan.nextInt();
                
                Student student = new Student(token, name, cgpa);
                
                pQ.add(student);
            } else if (event.equals("SERVED")) {
            	pQ.poll();
            }
		}
		if ( pQ.isEmpty() ) {
			System.out.println("EMPTY");
		} else {
			for (;;) {
				Student stu = pQ.poll();
				try {
					System.out.println("\n");
					System.out.println(stu.getFname());
				} catch (NullPointerException  e) {
					break;
				}
			}
		}
	}
}