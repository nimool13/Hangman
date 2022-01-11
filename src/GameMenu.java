package ns222tv_assign2;

import java.util.Scanner;


public class GameMenu {

	public static void main(String[] args) {
		System.out.println("welcome to the Hangman game");
		int option = getOption();
		Player player = new Player();
		while (true) {
			int category = getCategory();
			GameEntity hangmanGame = new GameEntity(category, player);
			hangmanGame.StartGame();
			restartGame();
		}
	}

	public static void restartGame() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Do you want to play another game ? (yes /no)");
		String anotherGame = scanner.nextLine();
		if (anotherGame.toLowerCase().equals("no")) {
			System.out.println("Are you sure you want to quit ?");
			anotherGame = scanner.nextLine();
			if (anotherGame.toLowerCase().equals("yes")) {
				System.out.println("Game over");
				System.exit(0);
			}
		}
	}

	
	public static int getOption() {
		Scanner scanner = new Scanner(System.in);
		int option;
		while (true) {
			System.out.println("Please select an option. Enter 1 to play game or 0 to exit game \n");

			while (!scanner.hasNextInt()) {
				System.err.println("Invalid input. Please enter a valid option.");
				scanner.next();
			}
			option = scanner.nextInt();
			if (option != 0 && option != 1) {
				System.err.println("Invalid input. Please enter a valid option.");
				continue;
			} else if (option == 0) {
				System.out.println("Bye, bye!");
				System.exit(0);
			} else
				break;
		}

		return option;
	}

	public static int getCategory() {
		int category;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please select a category\n1 --> Animals \n2 --> Countries \n3 --> Fruits");
		while (true) {
			while (!scanner.hasNextInt()) {
				System.err.println("Invalid input. Please enter a valid integer.");
				scanner.next();
			}
			category = scanner.nextInt();
			if (category < 1 || category > 3) {
				System.err.println("Invalid category. Please enter a valid category.");
				System.out.println("\n1 --> Animals \n2 --> Countries \n3 --> Fruits");
				continue;
			}

			else
				break;
		}
		return category;
	}
}
