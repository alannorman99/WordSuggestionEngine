package wordengine;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class AffinityAnalysis {

  AffinityAnalysis(BiGram biGram) {

    //reference to the words list and variable for list size
    int numberOfFeatures = FileReader.words.size();
    ArrayList<String> features = FileReader.words;

    //list of all the words
    List<String> fullWordSet = FileReader.fileWords;

    //Maps to store amount of items as full results and amount of repeats as valid
    Map<String, Integer> fullResults = new HashMap<>();
    Map<HashSet<String>, Integer> validResults = new HashMap<>();

    //Loop through the bigram to get the amount a word is used and the amount a pair is repeated
    for (HashSet<String> feature : biGram.bgrams.keySet()) {
      //System.out.println(featureSet);
      for (String word : fullWordSet) {

        for (int premise = 0; premise < numberOfFeatures; premise++) {
          fullResults.put(features.get(premise),
              fullResults.getOrDefault(features.get(premise), 0) + 1);

          for (int conclusion = 0; conclusion < numberOfFeatures; conclusion++) {
            if (conclusion == premise) {
              continue;
            }

            if (feature.contains(word)) {
              validResults
                  .put(new HashSet<String>(
                          Arrays.asList(features.get(premise), features.get(premise))),
                      validResults.getOrDefault(
                          new HashSet<String>(
                              Arrays.asList(features.get(premise), features.get(conclusion))),
                          0)
                          + 1);
            }
          }
        }
      }
    }
    //Calculate and print out the confidences and support
    for (HashSet<String> featureSet : validResults.keySet()) {
      List<String> featureList = featureSet.stream().collect(Collectors.toList());

      //first how many times was there an item with another item (confidence)
      //then how many times was there an item at all (support)
      double confidence =
          (double) fullResults.get(featureList.get(0)) / validResults.get(featureSet);
      double support = (double) validResults.get(featureSet) / numberOfFeatures;

      System.out.printf("We show a confidence of %f that a person who "
              + "bought %s will also buy %s%n and a support of %f that "
              + "a person will buy these items together at all.%n", confidence,
          featureList.get(0), featureList.get(1), support);
    }
  }

}



