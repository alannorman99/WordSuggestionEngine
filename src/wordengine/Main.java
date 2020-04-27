package wordengine;

import java.io.IOException;
import java.util.Scanner;

public class Main {

  /**
   * Main class for the program.
   *
   * @param args args for startup
   * @throws IOException handles string input exceptions
   */
  public static void main(String[] args) throws IOException {
    String path = "D:\\Java Programs\\Code Examples\\WordSuggestionEngine"
        + "\\src\\wordengine\\messages.txt";
    FileReader reader = new FileReader(path);

    System.out.println(FileReader.fileWords.size());

    reader.minimalWords(FileReader.fileWords);

    BiGram biGram = new BiGram(FileReader.fileWords);

    Scanner scanner = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Enter Message");

    String userName = scanner.nextLine();  // Read user input
    System.out.println("Message is: " + userName);  // Output user input

    AffinityAnalysis affinityAnalysis = new AffinityAnalysis(biGram);


  }
}
