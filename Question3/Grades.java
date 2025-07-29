package Question3;

import java.util.Scanner;

public class Grades{
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] arg){
		int choice = 0;
		int SubjectId, StudentId;
		System.out.println("Enter the number of students");
		int numberOfStudents = sc.nextInt();
		
		if(numberOfStudents <= 0){
			System.out.println("Invalid Number of Students");
			return;
		}

		int[][] marks = new int[numberOfStudents][3];

		System.out.println(marks[0][0]);
		while(choice != 7){
			printMenu();
			choice = sc.nextInt();

			switch(choice){
			case 1 : 
				System.out.print("Enter the Student Id : ");
				StudentId = sc.nextInt();
				AddMark(StudentId, marks);
				break;
			case 2 :
				System.out.print("Enter the Student Id : ");
				StudentId = sc.nextInt();
				System.out.print("Enter the Subject Id : ");
				SubjectId = sc.nextInt();
				if(SubjectId  > 3){
					System.out.println("Invalid subject Id");
					break;
				}
				UpdateMark(StudentId,SubjectId, marks);
				break;
			case 3 : 
				System.out.print("Enter the Subject Id : ");
				SubjectId = sc.nextInt();
				if(SubjectId  > 3){
					System.out.println("Invalid subject Id");
					break;
				}
				
				AverageSubject(SubjectId, marks, numberOfStudents);
				break;
			case 4 : 
				System.out.print("Enter the Student Id : ");
				StudentId = sc.nextInt();
				AverageStudent(StudentId, marks);
				break;
			case 5 : 
				System.out.print("Enter the Student Id : ");
				StudentId = sc.nextInt();
				Total(StudentId, marks);
				break;
			case 6 :
				PrintGrades(marks, numberOfStudents);
				break;
			case 7 :
				System.out.println("Exiting...");
				break;
			default :
				System.out.println("Invalid Input");
			}
		}
		sc.close();
	}

	static void printMenu(){
		System.out.println("===== Menu ====");
		System.out.println("1. Add student mark");
		System.out.println("2. Update student mark");
		System.out.println("3. Get the average for a subject");
		System.out.println("4. Get the average for a student");
		System.out.println("5. Get the total mark of student");
		System.out.println("6. Print Grades");
		System.out.println("7. Exit");
	}

	static void AddMark(int StudentId, int[][] marks){
		System.out.print("Enter the marks of Mathematics: ");
		marks[StudentId - 1][0] = sc.nextInt();

		System.out.print("Enter the marks of Chemistry: ");
		marks[StudentId - 1][1] = sc.nextInt();

		System.out.print("Enter the marks of Physics: ");
		marks[StudentId - 1][2] = sc.nextInt();
	}
	
	static void UpdateMark(int StudentId, int SubjectId, int[][]marks){
		System.out.print("Enter the new mark: ");
		marks[StudentId - 1][SubjectId - 1] = sc.nextInt();
	}	

	static void AverageSubject(int SubjectId, int[][] marks, int numberOfStudents ){
		int sum = 0;
		for(int i=0; i<numberOfStudents ; i++){
			sum += marks[i][SubjectId - 1];
		}
		System.out.println("Average marks for the " + SubjectId + " is " + sum/numberOfStudents );
	}

	static void AverageStudent(int StudentId, int[][] marks){
		int sum = 0;
		for(int i=0; i<3; i++){
			sum += marks[StudentId - 1][i];
		}
		System.out.println("Average marks of the " + StudentId + " is " + sum/3);
	}

	static void Total(int StudentId, int[][] marks){
		int sum = 0;
		for(int i=0; i<3; i++){
			sum += marks[StudentId - 1][i];
		}
		System.out.println("Total marks of the " + StudentId + " is " + sum);
	}

	static void PrintGrades(int[][] marks, int numberOfStudents){
		System.out.println("+------------+---------------+---------------+---------------+");
        System.out.println("| Student ID | Mathematics   | Chemistry     | Physics       |");
        System.out.println("+------------+---------------+---------------+---------------+");
        
        for(int i=0; i<numberOfStudents; i++){
            System.out.printf("| %-10d | %-13s | %-13s | %-13s |\n", 
                i+1,
				getGrade(marks[i][0]),
				getGrade(marks[i][1]),
				getGrade(marks[i][2]));
        }
        System.out.println("+------------+---------------+---------------+---------------+");
	}

	static String getGrade(int mark){
		if (mark >= 90){
			return "A";
		}else if (mark >= 80){
			return "B";
		}else if (mark >= 70){
			return "C";
		}else if (mark >= 60){
			return "D";
		}else{
			return "Fail";
		}
	}
}