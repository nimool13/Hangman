package ns222tv_assign2;
import java.util.Scanner;
import java.util.Random;

public class GameEntity {
	String[] Fruits = { "eggplant", "apple", "orange" };
	String[] Animals = { "Lion", "Cat", "snake" };
	String[] Countries = { "Brazil", "Canada", "Japan" };
	Player Player;
	int SelectedCategory;
	
	public GameEntity(int selectedCategory, Player player)
	{
		Player = player;
		SelectedCategory = selectedCategory;
	}
	
 	public void StartGame() {
		String[] guesses;

		switch (SelectedCategory) {
		case 1:
			guesses = Animals;
			break;
		case 2:
			guesses = Countries;
			break;
		case 3:
			guesses = Fruits;
			break;
		default:
			return;
		}
		
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		boolean wordIsGuessed = false;
		boolean weArePlaying = true;
		int finalNumGuess=6;
		while (weArePlaying) {
			
			char[] randomWordToGuess = guesses[random.nextInt(guesses.length)].toCharArray();
			int amountOfGuesses = randomWordToGuess.length;
			char[] playerGuess = new char[amountOfGuesses];
			for (int i = 0; i < playerGuess.length; i++) {
				playerGuess[i] = '_';
			}

			int tries = 1;
			while (!wordIsGuessed && tries < finalNumGuess ) {
				System.out.print("current guesses : ");
				printArray(playerGuess);
				System.out.println("you have " + (finalNumGuess - tries) + " tries left");
				System.out.println("Enter a single character : ");
				String line = sc.nextLine();
				if(line == null || line.length() == 0)
				{
					System.err.println("input is invalid");
					continue;
				}
					
                char input = line.charAt(0);
				
             
                
				tries++;
				if (input == '-') {
					weArePlaying = false;
					wordIsGuessed = true;
				} else {
					for (int i = 0; i < randomWordToGuess.length; i++) {
						if (Character.toLowerCase(randomWordToGuess[i])  == Character.toLowerCase(input)) {
							playerGuess[i] = Character.toLowerCase(input);
						}

					}
				}

				if (isTheWordGuessed(playerGuess)) {
					wordIsGuessed = true;
					weArePlaying = false;
					System.out.println("Winner winner chicken dinner , Congratulations you won !");
					break;
				}
			}
			
			if (!wordIsGuessed)
			{
					System.out.println("you ran out of guesses ,you lost !!!");
					break;
			}
			
		}
	}

	public static void printArray(char[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static boolean isTheWordGuessed(char[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == '_')
				return false;
		}
		return true;
	}
}


