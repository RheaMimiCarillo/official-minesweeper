import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class AIMinefield {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "minefield.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            boolean keepGoing = true;

            while (keepGoing) {
                System.out.print("Enter number of rows: ");
                int rows = scanner.nextInt();

                System.out.print("Enter number of columns: ");
                int cols = scanner.nextInt();

                System.out.print("Enter percentage of mines (0-100): ");
                int percentMines = scanner.nextInt();

                if (percentMines < 0 || percentMines > 100) {
                    System.out.println("Invalid percentage. Try again.");
                    continue;
                }

                // Write the rows and columns
                writer.println(rows + " " + cols);

                // Calculate the number of mines
                int totalCells = rows * cols;
                int numMines = (int) ((percentMines / 100.0) * totalCells);

                // Generate the minefield
                char[][] minefield = generateMinefield(rows, cols, numMines);

                // Write minefield to file
                for (char[] row : minefield) {
                    for (char cell : row) {
                        writer.print(cell);
                    }
                    writer.println();
                }

                System.out.print("Do you want to generate another minefield? (yes/no): ");
                scanner.nextLine(); // consume newline
                String answer = scanner.nextLine().trim().toLowerCase();

                if (!answer.equals("yes")) {
                    keepGoing = false;
                    writer.println("0 0"); // end marker
                    System.out.println("Minefields written to " + fileName);
                }
            }

        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        scanner.close();
    }

    private static char[][] generateMinefield(int rows, int cols, int numMines) {
        char[][] field = new char[rows][cols];

        // Fill with safe spots
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                field[i][j] = '.';
            }
        }

        // Place mines randomly
        Random rand = new Random();
        int placedMines = 0;

        while (placedMines < numMines) {
            int r = rand.nextInt(rows);
            int c = rand.nextInt(cols);

            if (field[r][c] != '*') {
                field[r][c] = '*';
                placedMines++;
            }
        }

        return field;
    }
}
