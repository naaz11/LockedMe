package mypackage;
import java.util.Scanner;

public class FileScreen {
	public static void MenuDisplay() {
		System.out.println("\n\nWhat would you like to do? Please select an option:");
		System.out.println("1. Display the list files in the directory \n"
				+"2. Add a file to the directory \n"
				+"3. Delete a file from directory \n"
				+"4. Search a file in the directory \n"
				+"5. Exit the application \n");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("WELCOME TO LOCKERS DEN");
		System.out.println("\nMalika E Naz is happy to help!!!");
		System.out.println("\nYou can browse, add, delete or searc files is a folder using this application.");
		System.out.println("\nPlease enter the path of a directory you want to work with");
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		String dirPath = sc.nextLine();
		do {
				FileScreen.MenuDisplay();
				int x=sc.nextInt();
				switch (x) {
				case 1: FileOp1.fileDisplay(dirPath);
						break;
				
				case 2: System.out.println("Enter a file name: ");
						Scanner sc1= new Scanner(System.in);
						String filename= sc1.nextLine();
					    FileOp1.createFile(dirPath, filename);
						break;
						
				case 3: System.out.println("Enter the name of the file to be deleted: ");
						Scanner sc2= new Scanner(System.in);
						String filename1= sc2.nextLine();
						FileOp1.deleteFile(dirPath, filename1);
						break;
						
				case 4: System.out.println("Enter search string:");
						Scanner sc3= new Scanner(System.in);
						String filename2= sc3.nextLine();
						FileOp1.searchFile(dirPath, filename2);
						break;
				
				case 5: System.out.println("Good Bye!");
				  		running = false;
				  		sc.close();
				  		System.exit(0);
				  		System.out.flush();
				  		break;
				  		
				 default:
					 System.out.println("Invalid option");
					
				
				}
				
				
		}while(running==true);
		
	}

}
