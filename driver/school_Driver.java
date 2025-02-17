package driver;
import java.sql.SQLException;
import java.util.Scanner;

import service.class_School_service;
public class school_Driver {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int choice=0;
		class_School_service s1 = new class_School_service();
		int n=0;
		do {
			System.out.println("Welcome School Mangement");
			System.out.println("Enter 1 to save Student");
			System.out.println("Enter 2 to update the Student");
			System.out.println("Enter 3 to delete the student");
			System.out.println("Enter 4 to fetch the student");
			System.out.println("Enter 5 to exit the application ");
			System.out.println("Enter your choice");
			choice=s.nextInt();
			switch(choice) {
			case 1:
				n=s1.save();
				if(n!=0)
					System.out.println("saved");
				break;
			case 2:
				n=s1.update();
				if(n!=0)
					System.out.println("Updated");
				else
					System.out.println("enter wrong detail check");
				break;
			case 3:
				n=s1.delete();
				if(n!=0)
					System.out.println("delete");
				break;
			case 4:
				s1.fetch();
				break;
			case 5:
				System.out.println("close the application");
				break;
			default:{
				System.out.println("your enter wrong choice");
				break;
			}
		}
		}while(choice!=5);
	}
}
