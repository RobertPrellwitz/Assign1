package Assignment1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextTable {

	private String header;
	private TableRow [] table = new TableRow[100] ;
	private int counter = 0;


	public void loadTableFromFile(String fileName) throws IOException  {
		Scanner loadFile = new Scanner (new FileReader(fileName));
		String input ;
		header = loadFile.nextLine();
		while (loadFile.hasNext()){
			input = loadFile.nextLine();
			String[] array = input.split("\t", 3);
			table[counter]= new TableRow(array[0],array[1],array[2]);
			counter++;
		}
		loadFile.close();
	}

	public void saveTableToFile(String fileName) throws FileNotFoundException {
	PrintWriter fileOutput = new PrintWriter(fileName);
	String number, name, score;
	TableRow array ;

	for (int i =0; i < counter; i++){
		String test = table[i].toString();
		 array = table[i];;
		 number = array.getNumber();
		 name = array.getName();
		score = array.getScore();
		fileOutput.println("------------------------------------------------\nRecord number: "+ i);
		fileOutput.println("Number: " + number + "\n" +"Name: " + name + "\n" +"Score: " + score );
	}

	fileOutput.close();
	}

	public void addRow(String int1, String nameToAddtoTable, String item3){
		table[counter]= new TableRow(int1,nameToAddtoTable,item3);
			counter++;
	}

	public void removeRow(int numberToRemoveFromTable){
		TableRow array;
		int temp = -1;
		int number;
		for (int i = 0; i < counter; i++){
			array = table[i];
			number = Integer.parseInt(array.getNumber());
			if (number == numberToRemoveFromTable){
				temp = i;
			}
		}
		if (temp != -1){
		for (int j = temp; j < counter; j++ ){
			table[j] = table[j+1];
		}
	}
	counter--;
	}

	public String findRow(String findword){
	    String row = "";
	    return row;
    }

}
