import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SortFileContents {
    public static void main(String[] args) {
        String originalFileName = "numbers.txt";
        String sortedFileName = "sorted_numbers.txt";

        // Create and write to the original file
        try (FileWriter writer = new FileWriter(originalFileName)) {
            writer.write("5\n");
            writer.write("3\n");
            writer.write("8\n");
            writer.write("1\n");
            writer.write("7\n");
            writer.write("2\n");
            writer.write("4\n");
            System.out.println("Numbers written to " + originalFileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
            return;
        }

        // Read numbers from the file and sort them
        ArrayList<Integer> numbers = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(originalFileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    numbers.add(Integer.parseInt(line));
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
            return;
        }

        // Sort the numbers
        Collections.sort(numbers);

        // Write the sorted numbers to the new file
        try (FileWriter writer = new FileWriter(sortedFileName)) {
            for (int number : numbers) {
                writer.write(number + "\n");
            }
            System.out.println("Sorted numbers written to " + sortedFileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the sorted file: " + e.getMessage());
        }
    }
}
