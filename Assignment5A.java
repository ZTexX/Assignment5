import java.util.Scanner;
import java.lang.Math;

public class Assignment5A {
  public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int highestNum, howLong;

		System.out.print("What's the highest number you want to generate?: ");
		highestNum = sc.nextInt();

		System.out.print("How long of a number sequence do you want to generate?: ");
		howLong = sc.nextInt();
		sc.close();

		System.out.println("Okay, we'll generate " + howLong + " number(s) ranging from 1 to " + highestNum + "!");

		int[] numbers = new int[howLong];
		int[][] frequencies = new int[highestNum][2];

		for (int i = 0; i < howLong; i++) {
			numbers[i] = (int)(Math.random() * highestNum) + 1;
		}

		for (int i = 0; i < highestNum; i++) {
			frequencies[i][0] = i + 1;
			frequencies[i][1] = 0;
		}

		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < highestNum; j++) {
				if (frequencies[j][0] == numbers[i]) {
					frequencies[j][1] += 1;
				}
			}
		}

		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + ", ");
		}

		System.out.println("\nFrequencies:");

		for (int i = 0; i < highestNum; i++) {
			System.out.println(frequencies[i][0] + " occurs " + String.format("%.2f", (double)((double)frequencies[i][1] / howLong * 100)) + "% of the time");
		}
  }
}