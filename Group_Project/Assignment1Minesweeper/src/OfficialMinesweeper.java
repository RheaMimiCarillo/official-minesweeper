/**
 * Minesweeper Game Implementation - Salima Hafurova's solution
 *
 * @author salimahafurova
 * @version Summer 2025
 */

import java.util.Scanner;

public class OfficialMinesweeper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // keep track of which field number we are processing
        int fieldNum = 1;

        while (true) {
            // Read the first line to get the dimensions of the field
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if (row == 0 && col == 0) {
                break; // End of input (stops loop if both 0)
            }

            // Create 2D array to store field.
            char[][] field = new char[row][col];
            for (int i = 0; i < row; i++) {
                // Reads each row of field as string & converts to char array
                field[i] = scanner.next().toCharArray();
            }

            System.out.println("Field #" + fieldNum + ":");
            String[] result = processField(field);
            for (String line : result) {
                System.out.println(line);
            }
            fieldNum++;
            System.out.println();
        }
        scanner.close();
    }

    public static String[] processField(char[][] field) {
        int row = field.length;
        int col = field[0].length;
        String[] result = new String[row];

        // Process each cell in the field
        for (int i = 0; i < row; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < col; j++) {
                // If the cell is a mine, print '*'
                if (field[i][j] == '*') {
                    sb.append('*');

                } else { // if not a mine, count adjacent mine
                    int count = 0;
                    // Check all 8 adjacent cells
                    // rowOffset is checking how much you move from current cell and column to check neighbors
                    for (int rowOffset = -1; rowOffset <= 1; rowOffset++) {
                        for (int colOffset = -1; colOffset <= 1; colOffset++) {
                            // Skip the cell itself because you don't want to count it
                            if (rowOffset == 0 && colOffset == 0) {
                                continue; // Skip the cell itself
                            }
                            // Calculate the new row and column indices
                            int newRow = i + rowOffset;
                            int newCol = j + colOffset;
                            // Check if the new indices are within bounds
                            if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col) {
                                // If the adjacent cell is a mine, increment the count
                                if (field[newRow][newCol] == '*') {
                                    count++;
                                }
                            }
                        }
                    }
                    // Print the count of adjacent mines
                    sb.append(count);
                }
            }
            result[i] = sb.toString();
        }
        return result;
    }

}