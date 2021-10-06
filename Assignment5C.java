import java.util.Scanner;

public class Assignment5C {
	private static int width, height, x, y, length, option = 0;
  
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		System.out.println("[FYE Level Map Creator]");
		System.out.print("Enter a level map width: ");
		width = sc.nextInt();

		System.out.print("Enter a level map height: ");
		height = sc.nextInt();

		char[][] map = new char[height][width + 1];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (j < map[i].length - 1) {
					map[i][j] = '*';
				} else {
					map[i][j] = '\n';
				}

				System.out.print(map[i][j]);
			}
		}

		do {
			System.out.println("\nOptions");
			System.out.println("1. Clear Level");
			System.out.println("2. Add Platform");
			System.out.println("3. Add Items");
			System.out.println("4. Quit");

			do {
				System.out.print("Enter a choice: ");
				option = sc.nextInt();
			} while (option < 1 || option > 4);

			if (option == 1) {
				System.out.println("\n[Clear Level]");

				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map[i].length; j++) {
						if (j < map[i].length - 1) {
							map[i][j] = '*';
						} else {
							map[i][j] = '\n';
						}

						System.out.print(map[i][j]);
					}
				}
			} else if (option == 2) {
				int x, y, length = 0;

				System.out.println("\n[Add Platform]");

				System.out.print("Enter X Coordinate: ");
				x = sc.nextInt();
				System.out.print("Enter Y Coordinate: ");
				y = sc.nextInt();

				if ((x > (width - 1) || y > (height - 1)) || (x < 0 || y < 0)) {
					System.out.println("This is not a valid location!");
				} else {
					do {
						System.out.print("Enter Length: ");
						length = sc.nextInt();
					} while (length < 1);

					if (x + length - 1 > width) {
						System.out.println("This platform won't fit in the level!");
					} else {
						for (int i = x; i < x + length; i++) {
							map[y][i] = '=';
						}
					}
				}

				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map[i].length; j++) {
						System.out.print(map[i][j]);
					}
				}
			} else if (option == 3) {
				int x, y;

				System.out.println("\n[Add Item]");
				
				System.out.print("Enter X Coordinate: ");
				x = sc.nextInt();

				System.out.print("Enter Y Coordinate: ");
				y = sc.nextInt();

				if ((x > (width - 1) || y > (height - 1)) || (x < 0 || y < 0)) {
					System.out.println("This is not a valid location!");
				} else {
					for (int i = x; i < x + 1; i++) {
						map[y][i] = '0';
					}
				}

				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map[i].length; j++) {
						System.out.print(map[i][j]);
					}
				}
			} else if (option == 4) {
				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map[i].length; j++) {
						System.out.print(map[i][j]);
					}
				}

				System.out.println("\nGoodbye!");
			}
		} while (option != 4);
	}
}