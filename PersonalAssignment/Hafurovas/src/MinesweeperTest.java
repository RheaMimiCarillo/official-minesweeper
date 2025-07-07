import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
class MinesweeperTest {

    @Test
    void test0() {
        String field = "0 0"; // Changed from "0" to "0 0"

        InputStream input = System.in;
        PrintStream originalOutput = System.out;

        try {
            System.setIn(new ByteArrayInputStream(field.getBytes()));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            System.setOut(new PrintStream(output));

            Minesweeper.main(new String[]{});

            System.setIn(input);
            System.setOut(originalOutput);

            String myOutput = output.toString().replace("\r\n", "\n").trim();
            String expectedOutPut = "Field #1:";

            assertAll("Testing for no rows and no columns!",
                    () -> assertEquals(expectedOutPut, myOutput,
                            "Your minefield generator failed to generate a minefield"
                                    + " with no rows and no columns!")
            );
        } finally {
            System.setIn(input);
            System.setOut(originalOutput);
        }
    }
}