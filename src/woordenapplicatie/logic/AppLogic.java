package woordenapplicatie.logic;

import java.util.*;

public class AppLogic implements ILogic
{

    private String[] splitString(String original)
    {
        return original.toLowerCase().split("[,\n ]+");
    }

    @Override
    public String getWordCount(String input)
    {
        List<String> allWords = Arrays.asList(splitString(input));
        String output = "Totaal aantal woorden:         " + Integer.toString(allWords.size());

        HashSet<String> differentWords = new HashSet<>(allWords);
        output += "\nAaantal verschillende woorden: " + Integer.toString(differentWords.size());

        return output;
    }

    @Override
    public String getWordsSorted(String input)
    {
        TreeSet<String> differentWords = new TreeSet<>(Arrays.asList(splitString(input)));

        StringBuilder outputString = new StringBuilder();
        for (String word : differentWords.descendingSet())
        {
            outputString.append(word).append("\n");
        }

        return outputString.toString();
    }

    @Override
    public String getWordFrequency(String input)
    {
        String[] allWords = splitString(input);

        HashMap<String, Integer> wordFrequency = new HashMap<>();
        // insert the words into the map/dictionary
        for (String word : allWords)
        {
            // if it already exists add 1 to the value
            // else just add the word to the map/dictionary as a new word
            if (wordFrequency.containsKey(word))
            {
                wordFrequency.replace(word, wordFrequency.get(word)+1);
            }
            else
            {
                wordFrequency.put(word, 1);
            }
        }

        // sort the map/dictionary by value
        List<Map.Entry<String, Integer>> entries = new LinkedList<>(wordFrequency.entrySet());

        // this line can be changed to Comparator.comparing() but this is more readable for me
        entries.sort((o1, o2) -> o1.getValue().compareTo(o2.getValue()));


        // create the output String
        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, Integer> entry : entries)
        {
            output.append(entry.getKey()).append(": ");
            output.append(entry.getValue()).append("\n");
        }

        return output.toString();
    }
}
