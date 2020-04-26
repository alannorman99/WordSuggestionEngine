package wordengine;

import java.io.IOException;

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

    System.out.println(reader.fileWords.size());

  }
}
