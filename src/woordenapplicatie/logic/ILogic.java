package woordenapplicatie.logic;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public interface ILogic
{
    String getWordCount(String input);

    String getWordsSorted(String input);

    String getWordFrequency(String input);

    String getWordConcordance(String input);
}
