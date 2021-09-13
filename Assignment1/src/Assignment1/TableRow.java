package Assignment1;

public class TableRow {

	private String [] tableRow = new String [3] ;
	// private String num;
	// private String name;
	// private String score;

	TableRow(String number, String name, String score){
		tableRow[0] = number;
		tableRow[1] = name;
		tableRow[2] = score;
	}
	TableRow(){
		tableRow[0]="";
		tableRow[1]="";
		tableRow[2]="";
	}
	public String getNumber (){
		String number = tableRow[0];
		return number;
	}

	public String getName(){
		String  name = tableRow[1];
		return name;
	}

	public String getScore(){
		String score = tableRow[2];
		return score;
	}
}
