package se.reky.janaina;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



import java.util.Scanner;

public class IOHandlerTest {

    private IOHandler createIOHandler(String dataForScanner) {
        Scanner scanner = new Scanner(dataForScanner);
        return new IOHandler(scanner);
    }

    @Test
    public void verifyIOHandlerScannerWorks() {
        IOHandler scannerForTest = createIOHandler("does this scanner work as expected?");
        String expectedOutput = "does this scanner work as expected?";

        assertEquals(expectedOutput, scannerForTest.nextLine());
    }

    @Test
    public void verifyIOHandlerHasNextIntFunction() {
        IOHandler ioHandler = createIOHandler("123");

        assertTrue(ioHandler.hasNextInt());
    }


}
