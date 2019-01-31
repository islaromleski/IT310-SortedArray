package sa;

public class MainController {
	public static void main(String[] args) {
		ADT aADT = new ADT();
		ConsoleView aView = new ConsoleView();
		
		aADT.insertData(1);
		aADT.insertData(3);
		aADT.insertData(5);
		aADT.insertData(4);
		
		aView.print(aADT.findIndex(4) + "\n");

		aView.print(aADT.outputMinMax());

		aADT.deleteByIndex(2);
		aView.print(aADT.outputMinMax());

		aADT.deleteByNumber(3);
		aView.print(aADT.outputMinMax());
	}
}