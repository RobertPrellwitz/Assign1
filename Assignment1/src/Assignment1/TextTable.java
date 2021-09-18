package Assignment1;

import java.io.*;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class TextTable {

	private String header;
	private static TableRow [] table = new TableRow[100] ;
	private static int counter = 0;


	public void loadTableFromFile(String fileName) throws IOException  {
		
		Scanner loadFile = null; loadFile = new Scanner(new FileReader(fileName));
		String input ;
		try{
		header = loadFile.nextLine();
			while (loadFile.hasNext())
			{
				input = loadFile.nextLine();
				boolean isEmpty = (input == null || input.trim().isEmpty());

				if(!isEmpty)
				{
					String[] array = input.split("\t", 3);
					table[counter] = new TableRow(array[0], array[1], array[2]);
					counter++;
				}
			}
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null,exp + "\nThe file does not conform to the required data stucture:");
		}
		loadFile.close();
	}

	public void saveTableToFile(String fileName) throws FileNotFoundException {
	
	PrintWriter fileOutput = new PrintWriter(fileName);

	String number, name, score;
	TableRow array ;
	fileOutput.println(header);
	fileOutput.println("------------------------------------------------");

	for (int i =0; i < counter; i++)
	{
		//String test = table[i].toString();
		 array = table[i];;
		 number = array.getData(0);
		 name = array.getData(1);
		score = array.getData(2);
		fileOutput.println("------------------------------------------------\nRecord number: "+ (i+1));
		fileOutput.println("Number: " + number + "\n" +"Name: " + name + "\n" +"Score: " + score );
	}

	fileOutput.close();
	}

	public void addRow(String int1, String nameToAddtoTable, String item3)
	{
		table[counter]= new TableRow(int1,nameToAddtoTable,item3);
			counter++;
	}

	public void removeRow(int numberToRemoveFromTable)
	{
		TableRow array;
		int temp = -1;
		int range = counter;
		int number;
		for (int i = 1; i < range; i++){
			array = table[i];
			number = Integer.parseInt(array.getNumber());
			if (number == numberToRemoveFromTable){
				temp = i;
				break;
			}
		}
		if (temp != -1)
		{
		for (int j = temp; j < range; j++ )
			{
			table[j] = table[j+1];
			}
		counter--;
		}
	}

	public String findRow(String findword)
	{
	    String row = "";
	    TableRow array;
    	for(int i = 1; i < counter; i++){
    		array = table[i];
    		String check =  array.getName();
    		if (check.equals(findword)){
    			row = "Number: " + array.getNumber() + " Name: " + check + " Score: " + array.getScore();
    			break;
    		}
    		else{continue;}
    	}

	    return row;
    }

    static public String displayData(){
    	String display=String.format("\n%-30s%-30s%-30s","Number","Name","Data");
		TableRow array;
    	for(int i = 0; i < counter; i++){
    		array = table[i];
			display = display + (String.format("\n%-30s%-30s%-30s" , array.getNumber(), array.getName(), array.getScore()));
    	}
    	return display;
    }

}
