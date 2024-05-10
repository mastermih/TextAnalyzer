package textanalyzer;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Comparator;

public class TextAnalyzer {

    public static void main(String[] args) {
        System.out.println("Text Analyzer App");
        CommandParser commandParser = new CommandParser();
        String filePath = "";
        int top = 0;
        int phraseSize = 0;

        // Parse command line arguments
        for (String arg : args) {
            if (arg.startsWith("-file=")) {
                filePath = arg.substring(6);
            } else if (arg.startsWith("-top=")) {
               top = commandParser.parseTopParameter(arg);
            } else if (arg.startsWith("-phraseSize=")) {
                phraseSize = commandParser.parsePhraseSize(arg);
            }
        }

        // Validate argument
        try {
            if (filePath.isEmpty() || top <= 0 || phraseSize <= 0) {
                System.out.println("Invalid arguments provided.");
                return;
            }
        } catch (NumberFormatException n) {
            System.out.println("Please enter a number for '-top' or '-phraseSize'.");
            return;
        }

        int wordCount = 0;
        int sentenceCount = 0;
        Map<String, Integer> phraseMap = new HashMap<>();

        // Read file and perform text analysis
        try (Scanner scanner = new Scanner(new FileReader(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Count words and sentences
                wordCount += countWords(line);
                sentenceCount += countSentences(line);

                // Split the line into words
                String[] words = line.split("\\s+");
                for (int i = 0; i <= words.length - phraseSize; i++) {
                    StringBuilder phraseBuilder = new StringBuilder();
                    for (int j = 0; j < phraseSize; j++) {
                        phraseBuilder.append(words[i + j]).append(" ");
                    }
                    String phrase = phraseBuilder.toString().trim();
                    phraseMap.put(phrase, phraseMap.getOrDefault(phrase, 0) + 1);
                }
            }

            // Display the number of words and sentences
            System.out.println("+---------------------+-----+");
            System.out.println("| Number of words:    | " + wordCount + " |");
            System.out.println("+---------------------+-----+");
            System.out.println("| Number of sentences:|  " + sentenceCount + " |");
            System.out.println("+---------------------+-----+");

            System.out.println();
            System.out.println("+---------------------+-----+");

            System.out.println("| Phrases             |Count|");
            System.out.println("+---------------------+-----+");
            phraseMap.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(top)
                    .forEach(entry -> System.out.printf("| %-20s |  %-1d |\n", entry.getKey(), entry.getValue())); // Unfortunately I did not manage to complete the formatting in the right way

            System.out.println("+---------------------+-----+");
            System.out.println("Text analysis completed successfully.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        System.out.println("App is closed.");
    }

    // Method to count sentences in a line
    public static int countSentences(String line) {
        // Assume a sentence ends with a period, question mark, or exclamation mark
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '.' || c == '?' || c == '!') {
                count++;
            }
        }
        return count;
    }

    // Method to count words in a line
    public static int countWords(String line) {
        String[] words = line.split("\\s+");
        return words.length;
    }
}
