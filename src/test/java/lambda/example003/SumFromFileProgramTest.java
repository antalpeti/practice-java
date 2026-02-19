package lambda.example003;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * Unit tests for SumFromFileProgram
 */
class SumFromFileProgramTest {

    @TempDir
    Path tempDir;

    private Path testFile;

    @BeforeEach
    void setUp() {
        testFile = tempDir.resolve("test_numbers.txt");
    }

    @Test
    void sumIntegersFromFile_withTwoNumbersOnOneLine() throws IOException {
        Files.writeString(testFile, "10 20");

        int result = SumFromFileProgramHelper.sumIntegersFromFile(testFile.toString());

        assertEquals(30, result);
    }

    @Test
    void sumIntegersFromFile_withTwoNumbersOnSeparateLines() throws IOException {
        Files.writeString(testFile, "15\n25");

        int result = SumFromFileProgramHelper.sumIntegersFromFile(testFile.toString());

        assertEquals(40, result);
    }

    @Test
    void sumIntegersFromFile_withTabSeparator() throws IOException {
        Files.writeString(testFile, "30\t40");

        int result = SumFromFileProgramHelper.sumIntegersFromFile(testFile.toString());

        assertEquals(70, result);
    }

    @Test
    void sumIntegersFromFile_withNegativeNumbers() throws IOException {
        Files.writeString(testFile, "-50 30");

        int result = SumFromFileProgramHelper.sumIntegersFromFile(testFile.toString());

        assertEquals(-20, result);
    }

    @Test
    void sumIntegersFromFile_withBothNegativeNumbers() throws IOException {
        Files.writeString(testFile, "-10 -20");

        int result = SumFromFileProgramHelper.sumIntegersFromFile(testFile.toString());

        assertEquals(-30, result);
    }

    @Test
    void sumIntegersFromFile_withZero() throws IOException {
        Files.writeString(testFile, "0 50");

        int result = SumFromFileProgramHelper.sumIntegersFromFile(testFile.toString());

        assertEquals(50, result);
    }

    @Test
    void sumIntegersFromFile_withBothZero() throws IOException {
        Files.writeString(testFile, "0 0");

        int result = SumFromFileProgramHelper.sumIntegersFromFile(testFile.toString());

        assertEquals(0, result);
    }

    @Test
    void sumIntegersFromFile_withLargeNumbers() throws IOException {
        Files.writeString(testFile, "1000000 2000000");

        int result = SumFromFileProgramHelper.sumIntegersFromFile(testFile.toString());

        assertEquals(3000000, result);
    }

    @Test
    void sumIntegersFromFile_ignoresExtraNumbers() throws IOException {
        Files.writeString(testFile, "10 20 30 40");

        int result = SumFromFileProgramHelper.sumIntegersFromFile(testFile.toString());

        assertEquals(30, result); // Only first two numbers
    }

    @Test
    void sumIntegersFromFile_withMultipleSpaces() throws IOException {
        Files.writeString(testFile, "10    20");

        int result = SumFromFileProgramHelper.sumIntegersFromFile(testFile.toString());

        assertEquals(30, result);
    }

    @Test
    void sumIntegersFromFile_withLeadingAndTrailingSpaces() throws IOException {
        Files.writeString(testFile, "  10 20  ");

        int result = SumFromFileProgramHelper.sumIntegersFromFile(testFile.toString());

        assertEquals(30, result);
    }

    @Test
    void sumIntegersFromFile_throwsExceptionWhenFileNotFound() {
        IOException exception = assertThrows(IOException.class, () -> {
            SumFromFileProgramHelper.sumIntegersFromFile("nonexistent_file.txt");
        });

        assertTrue(exception.getMessage().contains("File not found"));
    }

    @Test
    void sumIntegersFromFile_throwsExceptionWhenOnlyOneNumber() throws IOException {
        Files.writeString(testFile, "10");

        assertThrows(IllegalArgumentException.class, () -> {
            SumFromFileProgramHelper.sumIntegersFromFile(testFile.toString());
        });
    }

    @Test
    void sumIntegersFromFile_throwsExceptionWhenEmpty() throws IOException {
        Files.writeString(testFile, "");

        assertThrows(IllegalArgumentException.class, () -> {
            SumFromFileProgramHelper.sumIntegersFromFile(testFile.toString());
        });
    }

    @Test
    void sumIntegersFromFile_throwsExceptionWhenInvalidNumber() throws IOException {
        Files.writeString(testFile, "10 abc");

        assertThrows(IllegalArgumentException.class, () -> {
            SumFromFileProgramHelper.sumIntegersFromFile(testFile.toString());
        });
    }

    @Test
    void sumIntegersFromFile_throwsExceptionWhenOnlyText() throws IOException {
        Files.writeString(testFile, "not numbers");

        assertThrows(IllegalArgumentException.class, () -> {
            SumFromFileProgramHelper.sumIntegersFromFile(testFile.toString());
        });
    }

    @Test
    void sumIntegersFromFileStream_worksCorrectly() throws IOException {
        Files.writeString(testFile, "25 75");

        int result = SumFromFileProgramHelper.sumIntegersFromFileStream(testFile.toString());

        assertEquals(100, result);
    }

    @Test
    void sumIntegersFromFileStream_withMultipleLines() throws IOException {
        Files.writeString(testFile, "10\n20\n30");

        int result = SumFromFileProgramHelper.sumIntegersFromFileStream(testFile.toString());

        assertEquals(30, result); // Only first two
    }

    @Test
    void sumIntegersFromFileStream_throwsExceptionWhenInvalid() throws IOException {
        Files.writeString(testFile, "invalid data");

        assertThrows(IllegalArgumentException.class, () -> {
            SumFromFileProgramHelper.sumIntegersFromFileStream(testFile.toString());
        });
    }

    @Test
    void sumMultiplePairsFromFile_withTwoPairs() throws IOException {
        Files.writeString(testFile, "10 20 30 40");

        int[] results = SumFromFileProgramHelper.sumMultiplePairsFromFile(testFile.toString());

        assertArrayEquals(new int[]{30, 70}, results);
    }

    @Test
    void sumMultiplePairsFromFile_withThreePairs() throws IOException {
        Files.writeString(testFile, "5 10\n20 30\n100 200");

        int[] results = SumFromFileProgramHelper.sumMultiplePairsFromFile(testFile.toString());

        assertArrayEquals(new int[]{15, 50, 300}, results);
    }

    @Test
    void sumMultiplePairsFromFile_withOnePair() throws IOException {
        Files.writeString(testFile, "50 50");

        int[] results = SumFromFileProgramHelper.sumMultiplePairsFromFile(testFile.toString());

        assertArrayEquals(new int[]{100}, results);
    }

    @Test
    void sumMultiplePairsFromFile_ignoresOddNumber() throws IOException {
        Files.writeString(testFile, "10 20 30");

        int[] results = SumFromFileProgramHelper.sumMultiplePairsFromFile(testFile.toString());

        assertArrayEquals(new int[]{30}, results); // Only complete pairs
    }

    @Test
    void sumMultiplePairsFromFile_withNegativeNumbers() throws IOException {
        Files.writeString(testFile, "-5 10 -20 -30");

        int[] results = SumFromFileProgramHelper.sumMultiplePairsFromFile(testFile.toString());

        assertArrayEquals(new int[]{5, -50}, results);
    }

    @Test
    void sumMultiplePairsFromFile_emptyArrayWhenNoNumbers() throws IOException {
        Files.writeString(testFile, "");

        int[] results = SumFromFileProgramHelper.sumMultiplePairsFromFile(testFile.toString());

        assertEquals(0, results.length);
    }

    @Test
    void sumIntegersFromFile_withNumbersInDifferentFormats() throws IOException {
        Files.writeString(testFile, "  10  \n  20  ");

        int result = SumFromFileProgramHelper.sumIntegersFromFile(testFile.toString());

        assertEquals(30, result);
    }

    @Test
    void sumIntegersFromFile_withMixedSeparators() throws IOException {
        Files.writeString(testFile, "10\t\n20");

        int result = SumFromFileProgramHelper.sumIntegersFromFile(testFile.toString());

        assertEquals(30, result);
    }
}

