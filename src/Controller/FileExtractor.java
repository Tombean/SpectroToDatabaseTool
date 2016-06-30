package Controller;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import Model.LensTest;

public class FileExtractor extends JFrame {

	private boolean modified;
	private long lastModifiedDate;
	private long currentDate;
	private String fileText;
	private String[][] fileTextParsed;
	private File file;
	private String fileInputExtension;
	private String fileOutputExtension;
	private String pathInput;
	private String pathOutput;
	private String pathForSaving = "C:\\Users\\tsr\\workspace\\SpectroLocal\\save.txt";
	FileInputStream fis;
    FileOutputStream fos;
    Scanner reader;
	
	/**
	 * Initialize a FileExtractor object.
	 * @param newFile :  boolean : true will open the fileExtractorDialog to pick a new default file. False will load the default file to process.
	 */
	public FileExtractor(boolean newFile){
		
		if(newFile){
			fileExtractorDialog();
		}else{
			loadDefaultFile();			
		}
		
	}
	
	public FileExtractor(String pathInput, String pathOutput){
		
		
		this.pathInput = pathInput;
		this.pathOutput = pathOutput;
		this.fileInputExtension = getFileExtension(this.pathInput);
		this.fileOutputExtension = getFileExtension(this.pathOutput);
		this.file = new File(this.pathInput);
		
	   }
	
	/**
	 * Opens a Pop-up windows allowing to browse through directories and files to pick a file to use.
	 * Approving a new file will set this file as new default file to open and process.
	 * Canceling this windows will make the user process the default file. 	 
	 */
	public void fileExtractorDialog(){
		
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if(returnVal == JFileChooser.CANCEL_OPTION) {
			loadDefaultFile();
			
		}else if(returnVal == JFileChooser.APPROVE_OPTION) {
			try {
			
				File file = fc.getCurrentDirectory();
				this.pathInput = fc.getSelectedFile().getPath();
				saveNewDefaultFile();
			    this.reader = new Scanner(fc.getSelectedFile());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		
	}
	
	/**
	 * Loads the default file to open a retrieve data from. This file's path is saved in a second file. It is accessed by opening the file with pathForSaving as it's path and reading the path of the default file in it.
	 */
	public void loadDefaultFile(){
		try {
			this.reader = new Scanner(new File(this.pathForSaving));
			this.pathInput = this.reader.nextLine();
			
			this.reader = new Scanner(new File(this.pathInput));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets a new default file to open. The path to this file is saved in a second file that has pathForSaving for an absolute path.
	 * @throws IOException
	 */
	public void saveNewDefaultFile() throws IOException{
		
			FileWriter fw = new FileWriter(this.pathForSaving);
		 	fw.write(this.pathInput);
		 	System.out.println("Path of new default file : "+this.pathInput);
			fw.close();
		
	}
	
	/**
	 * copies the input file into a second file that will be used as a saving / logging file to keep track of every extracted data.
	 */
	public void copyFile(){
		try {
			 fis = new FileInputStream(new File(this.pathInput));
	         fos = new FileOutputStream(new File(this.pathOutput));
	         
	
	         byte[] buf = new byte[8];
	         int n = 0;
	         while ((n = fis.read(buf)) >= 0) {
	            // Copying the content of our input file into the end of our output ( save/history ) file
	        	fileText += buf;
	            fos.write(buf);
	            buf = new byte[8];
	
	         }
	
	      } catch (FileNotFoundException e) {
	         // if no file exists in pathInput
	         e.printStackTrace();
	      } catch (IOException e) {
	         // if reading or writing fails
	         e.printStackTrace();
	      } finally {
	         // closing fis and fos
	         try {
	            if (fis != null)
	               fis.close();
	         } catch (IOException e) {
	            e.printStackTrace();
	         }
	
	         try {
	            if (fos != null)
	               fos.close();
	         } catch (IOException e) {
	            e.printStackTrace();
	         }
	      }
	}
      
	/**
	 * reads and display the content of the file that is accessed with the pathInput path.
	 */
	public void readFile(){
		int count = 0;
		String delims = "[ ]+"; 
		this.fileTextParsed = new String[100][100];
		while(this.reader.hasNext()){
			
			
			String line =  this.reader.nextLine();
			//System.out.println("Line n°"+count+" : "+line);
			this.fileTextParsed[count] = stringParser(line, delims);
			count++;
		}
		for(int j = 0; j < this.fileTextParsed[0].length; j++){
			for(int i = 0; i<count; i++){
				if(fileTextParsed[i][j] != null){
					System.out.print(this.fileTextParsed[i][j]+"\t ");
				}
				else{
					System.out.print("\t ");
				}
			}
			System.out.println("\n-----------------------------------");
		}
		
	}
	
	/** 
	 * Parses a string according to a given delimiter
	 * @param line : the String that will be split into words according to the delimiter param
	 * @param delims : delimiter for the parsing method : if delimiter is "[ ]+" then line = "Hello world" will become  tokens[] = {"Hello","world"}
	 * @return tokens :  array of String containing parsed words
	 */
	
	public String[] stringParser(String line, String delims){

		String[] tokens = line.split(delims);
		return tokens;
		
	}
	
	/** 
	 * Gets the extension of a file
	 * @param name : name or path of the file
	 * @return String : extension of the file. Example : ".pdf", ".dat", etc
	 */
	private String getFileExtension(String name) {
	    try {
	        return name.substring(name.lastIndexOf(".") + 1);
	    } catch (Exception e) {
	        return "";
	    }
	}
	
	/**
	 * Creates a LensTest Object fitting the data extracted from the file
	 * @return lens : a LensTest object with all the data in the file
	 */
	public LensTest createLensTest(){
		
		int index = 0;
		LensTest lens = new LensTest();
		while ( fileTextParsed[index] != null ){
			
			String value =  fileTextParsed[(index+1)][0];
			String valueType = "int";
			for (int i = 0; i<value.length(); i++){
				if(value.charAt(i) == ',' || value.charAt(i) == '.' ){
					valueType = "double";
				}
			}
			
		}
		return lens;
	}

}

