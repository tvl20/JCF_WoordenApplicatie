package woordenapplicatie.logic;

import java.util.*;

public interface ILogic
{
    Integer[] getWordCount(String input);

    TreeSet<String> getWordsSorted(String input);

    List<Map.Entry<String, Integer>> getWordFrequency(String input);

    HashMap<String, HashSet<Integer>> getWordConcordance(String input);
}
