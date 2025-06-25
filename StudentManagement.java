package day2;

import java.util.ArrayList;
import java.util.Scanner;

class Student{
	int sid;
	String sname;
	double marks;
	
	Student(int id,String name,double marks){
		this.sid=id;
		this.sname=name;
		this.marks=marks;
	}
	
	@Override
	public String toString() {
		return "ID: "+sid+"|Name: "+sname+"|Marks: "+marks;
	}
}

public class StudentManagement {
	
	public static void addStudent() {
		System.out.println("Enter Student ID");
		int id = in.nextInt();
		in.nextLine();
		System.out.println("Enter Student Name");
		String name = in.nextLine();
		System.out.println("Enter Student Marks");
		double marks = in.nextDouble();
		
		Student student = new Student(id, name, marks);
		students.add(student);
		System.out.println("Student Added Successfully");
	}
	
	public static void viewStudent() {
		if(students.isEmpty()) {
			System.out.println("No Student Records Found");
			return;
		}
		
		System.out.println("Student List");
		for(Student s:students) {
			System.out.println(s);
		}
	}
	
	public static void updateStudent() {
		System.out.println("Enter Student ID to update");
		int id = in.nextInt();
		boolean found = false;
		for(Student s: students) {
			if(s.sid==id) {
				in.nextLine();
				System.out.println("Enter new name");
				s.sname=in.nextLine();
				System.out.println("Enter new marks");
				s.marks=in.nextDouble();
				found=true;
				System.out.println("Student updated successfully");
				break;
			}
		}
		if(!found) {
			System.out.println("Student with id "+id+" not found");
		}
	}
	
	public static void deleteStudent() {
		System.out.println("Enter Student ID to delete: ");
		int id = in.nextInt();
		boolean removed = students.removeIf(s->id==id);
		if(removed) {
			System.out.println("Student deleted successfully");
		}
		else {
			System.out.println("Student with ID "+id+" not found");
		}
	}

	static ArrayList<Student> students = new ArrayList<>();
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int choice;
		 do {
			 System.out.println("=====Student Management System=====");
			 System.out.println("1.Add Student");
			 System.out.println("2.View Student");
			 System.out.println("3.Update Student");
			 System.out.println("4.Delete Student");
			 System.out.println("5.Exit");
			 System.out.println("Choose An Option: ");
			 choice = in.nextInt();
			 in.nextLine();
			 switch(choice) {
			 case 1: addStudent();break;
			 case 2: viewStudent();break;
			 case 3: updateStudent();break;
			 case 4: deleteStudent();break;
			 case 5: System.out.println("Exiting.........Thank you");break;
			 default: System.out.println("Invalid Option Try Again.");
			 }
		 }while(choice!=5);
		 in.close();
	}
}
