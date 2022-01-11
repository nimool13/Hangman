package ns222tv_assign2;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Player {
	private String Name;
	private int Age;
	private String Gender;

	public Player() {
		getPlayerInfo();
	}

	public void setName(String name) {
		this.Name = name;
	}

	public void setAge(int age) {
		this.Age = age;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getName() {
		return Name;
	}

	public int getAge() {
		return Age;
	}

	public String getGender() {
		return Gender;
	}

	public void getPlayerInfo() {

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter a minimum 4 characters long nickname with at least one letter \n");

		// this checks if nickname contains at least one letter
		Pattern pattern = Pattern.compile(".*[a-zA-Z]+.*");
		String nickName;
		while (true) {

			nickName = scanner.nextLine();
			Matcher matcher = pattern.matcher(nickName);

			if (nickName.trim().length() < 4 || !matcher.matches()) {
				System.err.println(
						"Nickname is invalid. Please enter a nick name with minimum 4 characters containing at least one letter.");
				continue;
			} else {
				setName(nickName);
				break;
			}
		}

		System.out.println("Please enter your gender (F or M) \n");
		String gender;
		while (true) {

			gender = scanner.nextLine();
			if (gender.trim().length() > 1 || (!gender.trim().toLowerCase().equalsIgnoreCase("m")
					&& !gender.trim().toLowerCase().equalsIgnoreCase("f"))) {
				System.err.println("Gender is invalid. Please enter M for male and F for female.");
				continue;
			} else {
				setGender(gender);
				break;
			}
		}

		int age;
		System.out.println("Please enter your age\n");
		while (true) {
			while (!scanner.hasNextInt()) {
				System.err.println("Tinput is invalid. Please enter a valid age between 5 and 100");
				scanner.next();
			}
			age = scanner.nextInt();
			if (age < 5 || age > 100) {
				System.err.println("Input is invalid. Please enter a valid age between 5 and 100");
				continue;
			} else {
				setAge(age);
				break;
			}
		}
	}
}
