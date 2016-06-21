package epam.view;

public class View {
	public static final String MAIN_MENU = "Select action:\n1.Get bouquet cost\n" +
							"2.Sort by freshness\n3.Get flowers by stem length\n" +
							"4.Print bouquet consist\n5.Stop working";
	public static final String WRONG_MENU_ITEM = "Choose menu item!\n";
	public static final String WRONG_INT = "Length must be positive";
	public static final String WRONG_INPUT_DATA = "Enter correct value";
	public static final String ENTER_RANGE = "Enter length range(FROM, TO) in mm:";

	public void printMessage(String message) {
		System.out.println(message);
	}
}