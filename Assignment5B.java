import java.util.Scanner;

public class Assignment5B {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int howMany;
		String userPlay, botPlay;
		String[] botPlays = {
				"ROCK",
				"PAPER",
				"SCISSORS",
		};

		System.out.print("How many games do you want to play?: ");
		howMany = sc.nextInt();

		String[] rounds = new String[howMany];

		for (int i = 0; i < howMany; i++) {
			System.out.print("Round " + (i + 1) + ": What do you want to throw?: ");
			userPlay = sc.next();
			
			while (!userPlay.equalsIgnoreCase("rock") && !userPlay.equalsIgnoreCase("paper") && !userPlay.equalsIgnoreCase("scissors")) {
				System.out.print("Please enter 'Rock', 'Paper', or 'Scissors': ");
				userPlay = sc.next();
			}

			botPlay = botPlays[(int)(Math.random() * 3)];
			
			System.out.println("Computer threw " + botPlay + "!");

			rounds[i] = userPlay.equalsIgnoreCase("rock") && botPlay.equals("ROCK") ? "Tied on " : userPlay.equalsIgnoreCase("paper") && botPlay.equals("PAPER") ? "Tied on " : userPlay.equalsIgnoreCase("scissors") && botPlay.equals("SCISSORS") ? "Tied on " : userPlay.equalsIgnoreCase("rock") && botPlay.equals("SCISSORS") ? "Player won " : userPlay.equalsIgnoreCase("paper") && botPlay.equals("ROCK") ? "Player won " : userPlay.equalsIgnoreCase("scissors") && botPlay.equals("PAPER") ? "Player won " : userPlay.equalsIgnoreCase("rock") && botPlay.equals("PAPER") ? "Computer won " : userPlay.equalsIgnoreCase("paper") && botPlay.equals("SCISSORS") ? "Computer won " : userPlay.equalsIgnoreCase("scissors") && botPlay.equals("ROCK") ? "Computer won " : "";
		}

    sc.close();

		System.out.println("Game Over...");
		System.out.println("\nHere's the recap:");
		
		for (int i = 0; i < rounds.length; i++) {
			System.out.println(rounds[i] + "Round " + (i + 1));
		}
	}
}