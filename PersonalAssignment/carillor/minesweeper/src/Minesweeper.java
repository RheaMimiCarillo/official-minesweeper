/* Minesweeper.java
 * TCSS 360
 * Summer 2025
 * Lecturer: Tom Capaul
 *
 * Author: Rhea Mimi Carillo
 *
 * This program accepts well-formed minesweeper fields and returns
 * the minefield's hints.
 *
 * todo: expand upon the problem statement
 *
 *
 * // todo: clean up and refine this pseudocode comment
 * pseudocode/strategy:
 * use some kind of data structure to keep track of the number of adjacent mines for each tile
 * that has at least 1 adjacent mine
 * first, we will get two integers from the input file (e.g. 4 6, which represents a 4 x 6 grid)
 * next, we'll create a 2D array and put the integer '0' into each square
 * after making the initial grid, we'll traverse the input, line-by-line, char-by-char
 * each occurrence of an '*' means
 *  to do that, we will traverse the input, assume each square is zero the
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Main class for the Minesweeper game.
 * Provides utility methods and entry points for the game logic.
 *
 * @author RheaMimiCarillo
 * @version Summer 2025
 */
public final class Minesweeper {

    /**
     * // todo: improve javadoc
     * Space delimiter.
     */
    private static final String SPACE = " ";

    /**
     * Symbol representing a mine in the minefield.
     */
    private static final String MINE_SYMBOL = "*";

    /**
     * Line separator used for formatting output.
     */
    private static final String LINE_SEPARATOR = System.lineSeparator();

    /**
     * Private constructor to prevent instantiation.
     *
     * @throws AssertionError if this constructor is called
     */
    private Minesweeper() {
        throw new AssertionError("Utility class; No instances");
    }

    /**
     * todo: move main method to the spot specified in the course style guide
     * todo: improve javadoc
     * Entry point for the Minesweeper game.
     *
     * @param theArgs command line arguments
     * @throws FileNotFoundException    if the input file is not found
     * @throws IllegalArgumentException if the input file is not well-formed
     */
    public static void main(final String[] theArgs) throws FileNotFoundException, IllegalArgumentException {

        Scanner input = null;
        PrintStream output = System.out; // prints to console by default

        try {
            switch (theArgs.length) {
                case 0: // no args means no files to read/write
                    input = new Scanner(System.in);
                    break;
                case 1: // one arg means we read an input file
                    input = new Scanner(new File(theArgs[0]));
                    break;
                case 2: // two args means we read the first arg and write to the second arg
                    // first argument is the input file
                    input = new Scanner(new File(theArgs[0]));

                    // second argument is the output file
                    File outputFile = new File(theArgs[1]);
                    output = new PrintStream(outputFile);
                    break;
                default: // too many args or unexpected error
                    throw new IllegalArgumentException("Too many arguments: expected 0, 1, or 2, "
                            + " but got " + theArgs.length + ".");
                    // todo: check proper convention to concatenate strings across multiple lines
            }

            if (output != System.out) { // if not printing to console
                System.setOut(output); // Redirect output to specified file
            }


            // run the game
            runMinesweeper(input);

        } catch (final FileNotFoundException fileException) {
            throw new FileNotFoundException("Could not find file: " + fileException.getMessage());
        } catch (final Exception e) { // for any unexpected exceptions
            System.err.println("An unexpected error occurred: " + e.getMessage());
        } finally { // after execution of the program is complete
            if (input != null) {
                input.close(); // free up resources used by input
            }
            if (output != System.out) {
                output.close(); // free up resources used by output
            }
        }
    }

    /**
     * // todo: improve javadoc
     * // todo: reduce cyclomatic complexity
     * Runs the Minesweeper game logic.
     *
     * @param theInput The input file to read.
     */
    private static void runMinesweeper(final Scanner theInput) {

        // count the number of minefields
        int fieldCount = 0;

        // loop condition
        boolean again = true; // todo: find more appropriate variable name
        while (again && theInput.hasNextLine()) {
            final String line = theInput.nextLine();
            fieldCount++;

            // header line of each field is the total # of rows and columns
            // trim leading and trailing whitespace and split by SPACE delimiter
            final String[] totalRowsAndColumns = line.trim().split(SPACE);

            final int totalRows = Integer.parseInt(totalRowsAndColumns[0]); // first token is the # of rows
            final int totalColumns = Integer.parseInt(totalRowsAndColumns[1]); // second token is the # of columns

            // if any of the values are 0 or less, stop looping (e.g. "0 0")
            if (totalRows < 1 || totalColumns < 1) {
                again = false;
            } else {
                final String[][] currentMinefield = new String[totalRows][totalColumns]; // todo: see if this needs to be final or not
                // initialize the minefield by filling each element with "0"
                for (int i = 0; i < totalRows; i++) {
                    Arrays.fill(currentMinefield[i], "0");
                }

                // traverse the input file
                for (int row = 0; row < totalRows; row++) {
                    final String[] minefieldRow = theInput.nextLine().trim().split("");
                    for (int column = 0; column < totalColumns; column++) {
                        // when a mine is found in the current line of the input file
                        if (minefieldRow[column].equals(MINE_SYMBOL)) {
                            currentMinefield[row][column] = MINE_SYMBOL; // denote a mine with "*"

                            // increment all adjacent spaces by one
                            countAdjacentMines(currentMinefield, row, column, totalRows, totalColumns);
                        }
                    }
                }

                // output ("Field #" + fieldCount + ":") on its own line
                System.out.println("Field #" + fieldCount + ":");

                // then output the current minefield, row-by-row
                for (final String[] minefieldRow : currentMinefield) {
                    for (final String hint : minefieldRow) {
                        // output each element of the current row
                        System.out.print(hint);
                    }
                    System.out.print(LINE_SEPARATOR);
                }

                // after the last row of the current field, output a blank line between minefields
                System.out.print(LINE_SEPARATOR);
            }
        }
    }

    /**
     * // todo: improve javadoc and make all javadoc match
     * Increments all adjacent elements by one,
     *
     * @param theMinefield    the 2D array that stores the adjacent mine counts
     * @param theRow          current row number
     * @param theColumn       current column number
     * @param theTotalRows    total rows in the 2D array
     * @param theTotalColumns total columns in the 2D aray
     */
    private static void countAdjacentMines(final String[][] theMinefield, final int theRow, final int theColumn, final int theTotalRows, final int theTotalColumns) {
        // if the current element is an asterisk, then increment each surrounding non-mine element
        // adjacent squares are cardinal direction and diagonals (8 directions)
        // do not increment squares that are out of bounds of the current field

        // calculate offset to +/- 1 row or column
        for (int i = -1; i <= 1; i++) { // loop over adjacent rows
            for (int j = -1; j <= 1; j++) { // loop over adjacent columns
                if (i != 0 || j != 0) { // only process adjacent elements; do not process self
                    // calculate the row index of the adjacent square in the 2D array
                    final int adjacentRow = theRow + i;
                    // calculate the column index of the adjacent square in the 2D array
                    final int adjacentColumn = theColumn + j;
                    // check if the adjacent square is within the bounds of the field
                    if (adjacentRow >= 0 && adjacentRow < theTotalRows
                            && adjacentColumn >= 0 && adjacentColumn < theTotalColumns) {
                        // if inbounds, increment adjacent square at that index in the 2D array
                        // parse entry to integer, increment, then back to String
                        // but only increment if the entry is an integer
                        if (isInteger(theMinefield[adjacentRow][adjacentColumn])) {
                            theMinefield[adjacentRow][adjacentColumn] = Integer.toString(
                                    Integer.parseInt(theMinefield[adjacentRow][adjacentColumn]) + 1);
                        }
                    }
                }
            }
        }
    }

    /**
     * // todo: improve javadoc
     * // todo: is there a better way to do this?
     * Determines whether an input String can be parsed as an Integer.
     *
     * @param theString the String to be checked
     * @return true is the String can be read as an Integer, false otherwise
     */
    private static boolean isInteger(final String theString) {
        if (theString == null) {
            return false;
        }
        try {
            Integer.parseInt(theString);
            return true;
        } catch (final NumberFormatException e) {
            return false;
        }
    }
}
