import java.util.Scanner;

public class Marks{
	
	public static void main(String[] arg){
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		int SubjectId;
		System.out.println("Enter the number of students");
		int numberOfStudents = sc.nextInt();
		
		if(numberOfStudents <= 0){
			System.out.println("Invalid Number of Students");
			return;
		}

		int[][] marks = new int[numberOfStudents][3];
		while(choice != 6){
			printMenu();
			choice = sc.nextInt();
			
			System.out.print("Enter the Student Id : ");
			int StudentId = sc.nextInt();
			if(StudentId > numberOfStudents){
				System.out.println("Invalid student Id");
				break;
			}

			switch(choice){
			case 1 : 
				AddMark(StudentId, marks);
				break;
			case 2 : 
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
				AverageStudent(StudentId, marks);
				break;
			case 5 : 
				Total(StudentId, marks);
				break;
			case 6 :
				System.out.println("Exiting...");
				break;
			default :
				System.out.println("Invalid Input");
			}
		}
	}

	static void printMenu(){
		System.out.println("===== Menu ====");
		System.out.println("1. Add student mark");
		System.out.println("2. Update student mark");
		System.out.println("3. Get the average for a subject");
		System.out.println("4. Get the average for a student");
		System.out.println("5. Get the total mark of student");
		System.out.println("6. Exit");
	}

	static void AddMark(int StudentId, int[][] marks){
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the marks of Mathematics: ");
		marks[StudentId - 1][0] = sc.nextInt();

		System.out.print("Enter the marks of Chemistry: ");
		marks[StudentId - 1][1] = sc.nextInt();

		System.out.print("Enter the marks of Physics: ");
		marks[StudentId - 1][2] = sc.nextInt();
	}
	
	static void UpdateMark(int StudentId, int SubjectId, int[][]marks){
		Scanner sc = new Scanner(System.in);

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
}