package Assignment1;

public class TableRow {

	private String [] tableRow = new String [3] ;
	

	 TableRow(String number, String name, String score){
		tableRow[0] = number;
		tableRow[1] = name;
		tableRow[2] = score;
	}
	protected String getNumber (){
		String number = tableRow[0];
		return number;
	}

	protected String getName(){
		String  name = tableRow[1];
		return name;
	}

	protected String getScore(){
		String score = tableRow[2];
		return score;
	}

	protected  String getData(int i){
		String element = tableRow[i];
		return element;
	}
}
