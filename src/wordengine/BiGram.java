package wordengine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class BiGram {

  private Map<Set<String>, Integer> bgrams = new HashMap<>();

  BiGram(List<String> fileWords) {

    for (int i = 1; i < fileWords.size(); i++) {
      bgrams.merge(new HashSet<>(Arrays.asList(
          fileWords.get(i - 1),
          fileWords.get(i))),
          1, Integer::sum);
      // We just combined the shuffle & reduce in the same step
    }

    bgrams.forEach((key, value) -> System.out.println(key + ", " + value));
  }

}
