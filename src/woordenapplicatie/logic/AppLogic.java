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
        return null;
    }
}
