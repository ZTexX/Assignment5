import java.util.Scanner;

public class Assignment5C {
  static class Map {
    int width;
    int height;
    char[][] map;

    public Map(int width, int height) {
      this.width = width;
      this.height = height;
      map = new char[height][width + 1];

      for (int i = 0; i < map.length; i++) {
        for (int j = 0; j < map[i].length; j++) {
          if (j < map[i].length - 1) {
            map[i][j] = '*';
          } else {
            map[i][j] = '\n';
          }
        }
      }
    }

    public void printMap() {
      for (int i = 0; i < map.length; i++) {
        for (int j = 0; j < map[i].length; j++) {
          System.out.print(map[i][j]);
        }
      }
    }

    public void clearLevel() {
      for (int i = 0; i < map.length; i++) {
        for (int j = 0; j < map[i].length; j++) {
          if (j < map[i].length - 1) {
            map[i][j] = '*';
          } else {
            map[i][j] = '\n';
          }
        }
      }
    }

    public void addPlatform(int x, int y, int length) {
      for (int i = x; i < x + length; i++) {
        map[y][i] = '=';
      }
    }

    public void addItem(int x, int y) {
      for (int i = x; i < x + 1; i++) {
        map[y][i] = '0';
      }
    }

    public boolean isValid(int x,int y) {
      if ((x > width - 1 || y > height - 1) || (x < 0 || y < 0)) {
        return false;
      }

      return true;
    }

    public boolean fitsPlatform(int x, int length) {
      if (x + length > width) {
        return false;
      }

      return true;
    }
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int option = 0, width, height;

    System.out.println("[FYE Level Map Creator]");
    System.out.print("Enter a level map width: ");
    width = sc.nextInt();

    System.out.print("Enter a level map height: ");
    height = sc.nextInt();

    Map map = new Map(width, height);

    map.printMap();

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

        map.clearLevel();
        map.printMap();
      } else if (option == 2) {
        int x, y, length = 0;

        System.out.println("\n[Add Platform]");

        System.out.print("Enter X Coordinate: ");
        x = sc.nextInt();

        System.out.print("Enter Y Coordinate: ");
        y = sc.nextInt();

        if (!map.isValid(x, y)) {
          System.out.println("This is not a valid location!");
        } else {
          do {
            System.out.print("Enter Length: ");
            length = sc.nextInt();
          } while (length < 1);

          if (!map.fitsPlatform(x, length)) {
            System.out.println("This platform won't fit in the level!");
          } else {
            map.addPlatform(x, y, length);
          }
        }

        map.printMap();
      } else if (option == 3) {
        int x, y;

        System.out.println("\n[Add Item]");

        System.out.print("Enter X Coordinate: ");
        x = sc.nextInt();

        System.out.print("Enter Y Coordinate: ");
        y = sc.nextInt();

        if (!map.isValid(x, y)) {
          System.out.println("This is not a valid location!");
        } else {
          map.addItem(x, y);
        }

        map.printMap();
      } else if (option == 4) {
        System.out.println();
        map.printMap();

        System.out.println("\nGoodbye!");
      }
    } while (option != 4);

    sc.close();
  }
}