package wordengine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class FileReader {

  private String filePath;

  static List<String> fileWords;
  static ArrayList<String> words = new ArrayList<>();

  /**
   * Constructor requires file path and reads all words into a list.
   *
   * @param filePath string version of path
   * @throws IOException handles empty strings
   */
  FileReader(String filePath) throws IOException {

    //gets the path from the string parameter
    Path readPath = Paths.get(filePath);

    // Read all lines (except empty) into a String Stream for later processing
    Stream<String> fileLines = Files.lines(readPath)
        .filter(line -> !line.isEmpty());
    // Then amend our earlier example by adding a split & flatMapping our Arrays
    fileWords = fileLines
        .map(String::toLowerCase)
        .map(line -> line.split("\\s+"))
        .flatMap(Arrays::stream)
        .collect(Collectors.toList());

    // fileWords.forEach(System.out::println);
  }

  public void minimalWords(List<String> fileWords) {
    for (String word : fileWords) {
      if (words.contains(word)) {
        continue;
      }
      words.add(word);
    }
    words.forEach(System.out::println);

  }

}
