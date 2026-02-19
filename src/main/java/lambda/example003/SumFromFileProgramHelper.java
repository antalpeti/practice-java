package lambda.example003;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.IntBinaryOperator;
import java.util.stream.Stream;

public class SumFromFileProgramHelper {

  /**
   * Lambda expression for summing two integers
   */
  private static final IntBinaryOperator SUM_OPERATION = (a, b) -> a + b;

  /**
   * Reads multiple pairs of integers from a file and sums each pair using lambda
   *
   * @param filePath the path to the file
   * @return array of sums
   * @throws IOException if file cannot be read
   */
  public static int[] sumMultiplePairsFromFile(String filePath) throws IOException {
    try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
      int[] numbers = lines
          .flatMap(line -> Stream.of(line.split("\\s+")))
          .filter(s -> !s.isEmpty())
          .mapToInt(Integer::parseInt)
          .toArray();

      int pairs = numbers.length / 2;
      int[] results = new int[pairs];

      for (int i = 0; i < pairs; i++) {
        // Apply lambda to each pair
        results[i] = SUM_OPERATION.applyAsInt(numbers[i * 2], numbers[i * 2 + 1]);
      }

      return results;
    }
  }

  /**
   * Reads two integers from a file and returns their sum using a lambda expression.
   *
   * @param filePath the path to the file containing two integers
   * @return the sum of the two integers
   * @throws IOException if file cannot be read
   * @throws IllegalArgumentException if file doesn't contain exactly two integers
   */
  public static int sumIntegersFromFile(String filePath) throws IOException {
      Path path = Paths.get(filePath);

      if (!Files.exists(path)) {
          throw new IOException("File not found: " + filePath);
      }

      try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
          String content = reader.lines()
              .reduce("", (a, b) -> a + " " + b)
              .trim();

          String[] numbers = content.split("\\s+");

          if (numbers.length < 2) {
              throw new IllegalArgumentException("File must contain at least two integers");
          }

          try {
              int num1 = Integer.parseInt(numbers[0]);
              int num2 = Integer.parseInt(numbers[1]);

              // Apply lambda expression to sum the two integers
              return SUM_OPERATION.applyAsInt(num1, num2);
          } catch (NumberFormatException e) {
              throw new IllegalArgumentException("File must contain valid integers", e);
          }
      }
  }

  /**
   * Alternative method using Stream API with lambda
   */
  public static int sumIntegersFromFileStream(String filePath) throws IOException {
      try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
          int[] numbers = lines
              .flatMap(line -> Stream.of(line.split("\\s+")))
              .filter(s -> !s.isEmpty())
              .limit(2)
              .mapToInt(Integer::parseInt)
              .toArray();

          if (numbers.length < 2) {
              throw new IllegalArgumentException("File must contain at least two integers");
          }

          // Apply lambda expression to sum
          return SUM_OPERATION.applyAsInt(numbers[0], numbers[1]);
      } catch (NumberFormatException e) {
          throw new IllegalArgumentException("File must contain valid integers", e);
      }
  }

  /**
   * Creates sample files for demonstration
   */
  static void createSampleFiles() throws IOException {
      // Create target directory if it doesn't exist
      Files.createDirectories(Paths.get("target"));

      // File 1: Two numbers on one line
      Files.writeString(Paths.get("target/numbers1.txt"), "10 20");

      // File 2: Two numbers on separate lines
      Files.writeString(Paths.get("target/numbers2.txt"), "15\n25");

      // File 3: Multiple pairs
      Files.writeString(Paths.get("target/numbers3.txt"), "5 10\n20 30\n100 200");

      // File 4: Negative numbers
      Files.writeString(Paths.get("target/numbers4.txt"), "-50 30");
  }
}
