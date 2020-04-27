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

public class AffinityAnalysis {

  public AffinityAnalysis(BiGram biGram) {

    int numberOfFeatures = FileReader.words.size();
    ArrayList<String> features = FileReader.words;

    //Map<String, Integer> fullResults = new HashMap<>();
    Map<HashSet<String>, Integer> validResults = new HashMap<>();

    for (HashSet<String> featureSet : biGram.bgrams.keySet()) {
      //System.out.println(featureSet);
    }


  /*//Calculate and print out the confidences and support
      for(HashSet<String> featureSet : validResults.keySet()) {
    List<String> featureList = featureSet.stream().collect(Collectors.toList());

    //first how many times was there an item with another item (confidence)
    //then how many times was there an item at all (support)
    //double confidence = (double) fullResults.get(featureList.get(0)) / validResults.get(featureSet);
    double support = (double) validResults.get(featureSet) / totalTransactions;

    System.out.printf("We show a confidence of %f that a person who " +
            "bought %s will also buy %s%n      and a support of %f that " + "a person will buy these items together at all.%n"
        , featureList.get(0), featureList.get(1), support);
  }*/

  }

}
