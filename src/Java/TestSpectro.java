package Java;
import java.io.IOException;
import java.util.Scanner;

import Controller.FileExtractor;
import View.SpectroPanel;

public class TestSpectro {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		SpectroPanel panel = new SpectroPanel();
		Scanner sc = panel.getScanner();
		while(sc.hasNext()){
			System.out.println(sc.next());
		}
		*/
		SpectroPanel panel = new SpectroPanel();
		/*System.out.println("Continue using the same input file as before ? y/n ");
		Scanner sc = new Scanner(System.in);
		char newFileToRead = sc.nextLine().charAt(0);
		boolean newFile = (newFileToRead == 'y') ? false : true;
		FileExtractor extract = new FileExtractor(newFile);
		extract.readFile();
		/*
		Scanner sc = new Scanner(System.in);
		 
		System.out.println("Enter input file's path please  :   ");
		String inputPath = sc.nextLine();
		System.out.println("Enter output file's path please  :   ");
		String outputPath = sc.nextLine();
		sc.close();
		FileExtractor f = new FileExtractor(inputPath, outputPath );
		f.copyFile();
		f.readFile();
		f.stringParser();
		*/
	
	}

}
