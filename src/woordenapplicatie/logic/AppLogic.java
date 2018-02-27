package woordenapplicatie.logic;

import java.util.*;

public class AppLogic implements ILogic
{

    private String[] splitString(String original)
    {
        return original.toLowerCase().split("[,\n ]+");
    }

    @Override
    public Integer[] getWordCount(String input) // O(n^2)
    {
        // O(n) for each item in the list:
        // O(n^2)
        List<String> allWords = Arrays.asList(splitString(input));
        HashSet<String> differentWords = new HashSet<>(allWords);

        Integer[] output = {allWords.size(), differentWords.size()};

        return output;
    }

    @Override
    public TreeSet<String> getWordsSorted(String input) // O(2 * (n * Log(n)))
    {
        // O(Log(n)) for each item in the list:
        // O(n * Log(n))
        TreeSet<String> differentWords = new TreeSet<>(Arrays.asList(splitString(input)));

        return differentWords;
    }

    @Override
    public List<Map.Entry<String, Integer>> getWordFrequency(String input) // 2n^2
    {
        String[] allWords = splitString(input);

        HashMap<String, Integer> wordFrequency = new HashMap<>();

        // insert the words into the map/dictionary
        // for n loop
        // so 2n^2
        for (String word : allWords)
        {
            // if it already exists add 1 to the value
            // else just add the word to the map/dictionary as a new word
            if (wordFrequency.containsKey(word))
            {
                // O(n) + O(n) = O(2n)
                wordFrequency.replace(word, wordFrequency.get(word) + 1);
            }
            else
            {
                // O(n)
                wordFrequency.put(word, 1);
            }
        }

        // sort the map/dictionary by value
        // O(2n)
        List<Map.Entry<String, Integer>> entries = new LinkedList<>(wordFrequency.entrySet());

        entries.sort(Comparator.comparing(Map.Entry::getValue));

        return entries;
    }

    @Override
    public HashMap<String, HashSet<Integer>> getWordConcordance(String input)
    {
        HashMap<String, HashSet<Integer>> resultMap = new HashMap<>();
        int lineCount = 1;

        // Split the input by lines
        String[] lines = input.split("\n");

        // One big for n loop
        // 3n^2
        for (String line : lines)
        {
            // Split every line by words
            String[] words = splitString(line);

            for (String word : words)
            {
                // If the only "word" in the sentence is a space (or the line is empty) just continue to the next word
                if (word.equals("") || word.equals(" "))
                {
                    continue;
                }

                // If it has been added previously, add an row number to the list
                // Either O(3n)
                if (resultMap.containsKey(word))
                {
                    // O(n)
                    HashSet<Integer> occurrences = resultMap.get(word);
                    // O(n)
                    occurrences.add(lineCount);

                    // O(n)
                    resultMap.replace(word, occurrences);
                }
                // If it is a new word, add it to the list
                else
                {
                    // O(n)
                    resultMap.put(word, new HashSet<Integer>(Collections.singletonList(lineCount)));
                }
            }
            lineCount++;
        }

        return resultMap;
    }
}
