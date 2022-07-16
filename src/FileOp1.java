package mypackage;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class FileOp1 {

	public static void fileDisplay(String dirPath) {
		File folder = new File(dirPath);
		if(folder.isDirectory())
		{
			File[] fileList = folder.listFiles();

			Arrays.sort(fileList);

			System.out.println("\nTotal number of items present in the directory: " + fileList.length );

			FileFilter fileFilter = new FileFilter()
			{
				public boolean accept(File file) {
					return !file.isDirectory();
				}
			};

			fileList = folder.listFiles(fileFilter);

			// Sort files by name
			Arrays.sort(fileList, new Comparator()
			{
				public int compare(Object f1, Object f2) {
					return ((File) f1).getName().compareTo(((File) f2).getName());
				}
			});

			//Prints the files in file name ascending order
			for(File file:fileList)
			{
				System.out.println(file.getName());
			}

		}   
	}

	///creation
	public static void createFile(String dirPath, String filename) {
		File folder = new File(dirPath);
		if(folder.isDirectory())
		{
			File file = new File(dirPath+"\\"+filename);
			try {
				boolean value = file.createNewFile();
				if (value) {
					System.out.println("\""+filename+"\" is created.");
				}
				else {
					System.out.println("Error: a file with the specified name already exists.");
				}
			}
			catch(Exception e) {
				e.getStackTrace();
			}
		}
	}
	//Deletion
	public static void deleteFile(String dirPath, String filename) {
		try 
		{ 
			File f = new File(dirPath+"\\"+filename); 
			if(f.delete()) 
			{ 
				System.out.println("The file \""+f.getName() + "\" is deleted from the directory."); 
			} 
			else 
			{ 
				System.out.println("Error: File not found!"); 
			} 
		}
		catch(Exception e) 
		{ 
			e.printStackTrace(); 
		} 
	}
	//Search
	public static void searchFile(String dirPath, String fileName) {
		File directory = new File (dirPath+"\\"+"").getAbsoluteFile();
		String[] flist = directory.list();
		int flag = 0;
		if (flist == null) {
			System.out.println("The directory in empty.");
		}
		else {
		 // Linear search in the array
			for (int i = 0; i < flist.length; i++) {
				String filename = flist[i];
				if (filename.equalsIgnoreCase(fileName)) {
					System.out.println("\""+filename + "\" is present in the directory.");
					flag = 1;
				}
			}
		}
		if (flag == 0) {
			System.out.println("Sorry, no files found with name \""+fileName+"\" in the given directory.");
		}
	}
}