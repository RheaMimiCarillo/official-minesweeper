import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class MineSweeperTest {


    /**
     * Test for Mine Location Corners.
     */
    @Test
    void testMineLocationCorners() {

        String field = "3 3\n*.*\n...\n*.*\n0 0\n";

        InputStream input = System.in;
        PrintStream originalOutput = System.out;
        try {

            System.setIn(new ByteArrayInputStream(field.getBytes()));

            ByteArrayOutputStream output = new ByteArrayOutputStream();

            System.setOut(new PrintStream(output));

            OfficialMinesweeper.main(new String[]{});


            System.setIn(input);
            System.setOut(originalOutput);


            String myOutput = output.toString().replace("\r\n", "\n").trim();

            String expectedOutPut = "Field #1:\n*2*\n242\n*2*\n".trim();


            assertAll("Testing minefield corners.",
                    () -> assertEquals(expectedOutPut, myOutput,
                            "The minefield was not generated correctly.")

            );
        } finally {
            System.setIn(input);
            System.setOut(originalOutput);
        }
    }
    @Test
    void testMinesOnlyAtEdges() {

        String field = "3 3\n***\n*.*\n***\n0 0\n";

        InputStream input = System.in;
        PrintStream originalOutput = System.out;
        try {

            System.setIn(new ByteArrayInputStream(field.getBytes()));

            ByteArrayOutputStream output = new ByteArrayOutputStream();

            System.setOut(new PrintStream(output));

            OfficialMinesweeper.main(new String[]{});


            System.setIn(input);
            System.setOut(originalOutput);


            String myOutput = output.toString().replace("\r\n", "\n").trim();

            String expectedOutPut = "Field #1:\n***\n*8*\n***\n".trim();


            assertAll("Testing minefield edges.",
                    () -> assertEquals(expectedOutPut, myOutput,
                            "Mines only at edges wasn't generated correctly")

            );
        } finally {
            System.setIn(input);
            System.setOut(originalOutput);
        }
    }

    @Test
    void testSingleAndMultipleFieldsMine() {
        // four fields: 1 mine, 1 mine, 1 safe, 1 safe all concatenate
        String input =
                "1 1\n*\n" +      // field #1
                        "1 1\n*\n" +      // field #2
                        "1 1\n.\n" +      // field #3
                        "1 1\n.\n" +      // field #4
                        "0 0\n";

        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            System.setOut(new PrintStream(output));

            OfficialMinesweeper.main(new String[]{});

            System.setIn(originalIn);
            System.setOut(originalOut);

            String myOutput = output.toString().replace("\r\n", "\n").trim();
            String expectedOutput = (
                    "Field #1:\n*\n\n" +
                            "Field #2:\n*\n\n" +
                            "Field #3:\n0\n\n" +
                            "Field #4:\n0"
            ).trim();

            assertAll("Testing 4 consecutive 1x1 minefields",
                    () -> assertEquals(expectedOutput, myOutput,
                            "Your minefield generator did not properly generate 4 consecutive minefields.")
            );
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }
    @Test
    void testMinesAlongOneColumn() {
        String field = "4 3\n*..\n*..\n*..\n*..\n0 0\n";

        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        try {
            System.setIn(new ByteArrayInputStream(field.getBytes()));

            ByteArrayOutputStream output = new ByteArrayOutputStream();

            System.setOut(new PrintStream(output));

            OfficialMinesweeper.main(new String[]{});


            System.setIn(originalIn);
            System.setOut(originalOut);

            String actualOutput = output.toString().replace("\r\n", "\n").trim();

            String expectedOutput = "Field #1:\n*20\n*30\n*30\n*20\n".trim();
            assertAll("Testing 1 column of bombs in a minefield",
                    () -> assertEquals(expectedOutput, actualOutput,
                            "Mines along one column were not generated correctly")

            );
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    @Test
    void testMinesAllAlongOneRow() {
        String field = "3 4\n****\n....\n....\n0 0\n";

        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        try {
            System.setIn(new ByteArrayInputStream(field.getBytes()));

            ByteArrayOutputStream output = new ByteArrayOutputStream();

            System.setOut(new PrintStream(output));

            OfficialMinesweeper.main(new String[]{});

            System.setIn(originalIn);
            System.setOut(originalOut);

            String actualOutput = output.toString().replace("\r\n", "\n").trim();

            String expectedOutput = "Field #1:\n****\n2332\n0000\n".trim();
            assertAll("Testing 1 row of bombs in a minefield",
                    () -> assertEquals(expectedOutput, actualOutput,
                            "Mines along one row were not generated correctly")

            );
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    @Test
    void testMinesAlongOneRow() {
        String field = " 1 10\n*.*.*.*.*.\n0 0\n";

        InputStream input = System.in;
        PrintStream originalOutput = System.out;
        try {

            System.setIn(new ByteArrayInputStream(field.getBytes()));

            ByteArrayOutputStream output = new ByteArrayOutputStream();

            System.setOut(new PrintStream(output));

            OfficialMinesweeper.main(new String[]{});


            System.setIn(input);
            System.setOut(originalOutput);


            String myOutput = output.toString().replace("\r\n", "\n").trim();

            String expectedOutPut = "Field #1:\n*2*2*2*2*1\n".trim();

            assertAll("Testing for only a single row minefield",
                    () -> assertEquals(expectedOutPut, myOutput,
                            "Your minefield generator crashed trying to generate " +
                                    "a single row minefield.")

            );

        } finally {
            System.setIn(input);
            System.setOut(originalOutput);
        }
    }


    @Test
    void testCorrectDimensions() {
        String field = "4 5\n.....\n.....\n.....\n.....\n0 0\n";

        InputStream input = System.in;
        PrintStream originalOutput = System.out;
        try {

            System.setIn(new ByteArrayInputStream(field.getBytes()));

            ByteArrayOutputStream output = new ByteArrayOutputStream();

            System.setOut(new PrintStream(output));

            OfficialMinesweeper.main(new String[]{});


            System.setIn(input);
            System.setOut(originalOutput);


            String myOutput = output.toString().replace("\r\n", "\n").trim();

            String expectedOutPut = "Field #1:\n00000\n00000\n00000\n00000\n".trim();

            assertAll("Testing that correct dimensions are being output",
                    () -> assertEquals(expectedOutPut, myOutput,
                            "The dimensions weren't handled correctly")

            );

        } finally {
            System.setIn(input);
            System.setOut(originalOutput);
        }

    }

    @Test
    void testAllMines() {
        String field = "2 2\n**\n**\n0 0\n";

        InputStream input = System.in;
        PrintStream originalOutput = System.out;
        try {

            System.setIn(new ByteArrayInputStream(field.getBytes()));

            ByteArrayOutputStream output = new ByteArrayOutputStream();

            System.setOut(new PrintStream(output));

            OfficialMinesweeper.main(new String[]{});


            System.setIn(input);
            System.setOut(originalOutput);


            String myOutput = output.toString().replace("\r\n", "\n").trim();

            String expectedOutPut = "Field #1:\n**\n**".trim();

            assertAll("Testing for all mines",
                    () -> assertEquals(expectedOutPut, myOutput,
                            "All mines field was not generated correctly")

            );

        } finally {
            System.setIn(input);
            System.setOut(originalOutput);
        }

    }
    @Test
    void testNoMines() {
        String field = "3 3\n...\n...\n...\n0 0\n";

        InputStream input = System.in;
        PrintStream originalOutput = System.out;
        try {

            System.setIn(new ByteArrayInputStream(field.getBytes()));

            ByteArrayOutputStream output = new ByteArrayOutputStream();

            System.setOut(new PrintStream(output));

            OfficialMinesweeper.main(new String[]{});


            System.setIn(input);
            System.setOut(originalOutput);


            String myOutput = output.toString().replace("\r\n", "\n").trim();

            String expectedOutPut = "Field #1:\n000\n000\n000".trim();

            assertAll("Testing for no mines",
                    () -> assertEquals(expectedOutPut, myOutput,
                            "No mines field was not generated correctly")

            );

        } finally {
            System.setIn(input);
            System.setOut(originalOutput);
        }

    }
    @Test
    void testSparseMines() {
        String field = "4 4\n*...\n....\n....\n...*\n0 0\n";
        InputStream input = System.in;
        PrintStream originalOutput = System.out;
        try {

            System.setIn(new ByteArrayInputStream(field.getBytes()));

            ByteArrayOutputStream output = new ByteArrayOutputStream();

            System.setOut(new PrintStream(output));

            OfficialMinesweeper.main(new String[]{});


            System.setIn(input);
            System.setOut(originalOutput);


            String myOutput = output.toString().replace("\r\n", "\n").trim();

            String expectedOutPut = "Field #1:\n*100\n1100\n0011\n001*".trim();

            assertAll("Testing for sparsely laid out mines",
                    () -> assertEquals(expectedOutPut, myOutput,
                            "Sparse mines field was not generated correctly")

            );

        } finally {
            System.setIn(input);
            System.setOut(originalOutput);
        }
    }
    @Test
    void testLargeField() {
        String field = "10 10\n*.........\n..........\n..........\n..........\n..........\n." +
                ".........\n..........\n..........\n..........\n.........*\n0 0\n";
        InputStream input = System.in;
        PrintStream originalOutput = System.out;
        try {

            System.setIn(new ByteArrayInputStream(field.getBytes()));

            ByteArrayOutputStream output = new ByteArrayOutputStream();

            System.setOut(new PrintStream(output));

            OfficialMinesweeper.main(new String[]{});


            System.setIn(input);
            System.setOut(originalOutput);


            String myOutput = output.toString().replace("\r\n", "\n").trim();

            String expectedOutPut =
                    ("Field #1:\n*100000000\n1100000000\n0000000000\n0000000000\n0000000000" +
                            "\n0000000000\n0000000000\n0000000000\n0000000011\n000000001*").trim();

            assertAll("Testing for a large field of mines",
                    () -> assertEquals(expectedOutPut, myOutput,
                            "Large mine field was not generated correctly")

            );

        } finally {
            System.setIn(input);
            System.setOut(originalOutput);
        }
    }

    @Test
    void testLargeField100x100AllSafeSpaces() {
        StringBuilder fieldBuilder = new StringBuilder();
        fieldBuilder.append("100 100\n");

        // Add 100 rows of 100 dots each
        for (int row = 0; row < 100; row++) {
            for (int col = 0; col < 100; col++) {
                fieldBuilder.append(".");
            }
            fieldBuilder.append("\n");
        }
        fieldBuilder.append("0 0\n");

        String field = fieldBuilder.toString();
        InputStream input = System.in;
        PrintStream originalOutput = System.out;
        try {
            System.setIn(new ByteArrayInputStream(field.getBytes()));

            ByteArrayOutputStream output = new ByteArrayOutputStream();

            System.setOut(new PrintStream(output));

            OfficialMinesweeper.main(new String[]{});


            System.setIn(input);
            System.setOut(originalOutput);


            String myOutput = output.toString().replace("\r\n", "\n").trim();

            StringBuilder expectedBuilder = new StringBuilder();
            expectedBuilder.append("Field #1:");
            for (int row = 0; row < 100; row++) {
                expectedBuilder.append("\n");
                for (int col = 0;  col < 100; col++) {
                    expectedBuilder.append("0");
                }
            }
            String expectedOutput = expectedBuilder.toString().replace("\r\n", "\n").trim();
            assertAll("Testing for a field of 100x100 safe spaces",
                    () -> assertEquals(expectedOutput, myOutput,
                            "Large 100x100 field with all safe spaces was not generated " +
                                    "correctly")

            );

        } finally {
            System.setIn(input);
            System.setOut(originalOutput);
        }
    }
    @Test
    void testLargeField100x100AllMineSpaces() {
        StringBuilder fieldBuilder = new StringBuilder();
        fieldBuilder.append("100 100\n");

        // Add 100 rows of 100 dots each
        for (int row = 0; row < 100; row++) {
            for (int col = 0; col < 100; col++) {
                fieldBuilder.append("*");
            }
            fieldBuilder.append("\n");
        }
        fieldBuilder.append("0 0\n");

        String field = fieldBuilder.toString();
        InputStream input = System.in;
        PrintStream originalOutput = System.out;
        try {
            System.setIn(new ByteArrayInputStream(field.getBytes()));

            ByteArrayOutputStream output = new ByteArrayOutputStream();

            System.setOut(new PrintStream(output));

            OfficialMinesweeper.main(new String[]{});


            System.setIn(input);
            System.setOut(originalOutput);


            String myOutput = output.toString().replace("\r\n", "\n").trim();

            StringBuilder expectedBuilder = new StringBuilder();
            expectedBuilder.append("Field #1:");
            for (int row = 0; row < 100; row++) {
                expectedBuilder.append("\n");
                for (int col = 0;  col < 100; col++) {
                    expectedBuilder.append("*");
                }
            }
            String expectedOutput = expectedBuilder.toString().replace("\r\n", "\n").trim();
            assertAll("Testing for a field of 100x100 mine spaces",
                    () -> assertEquals(expectedOutput, myOutput,
                            "Large 100x100 field with all mine spaces was not generated " +
                                    "correctly")

            );

        } finally {
            System.setIn(input);
            System.setOut(originalOutput);
        }
    }

}

