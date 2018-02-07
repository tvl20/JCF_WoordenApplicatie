package woordenapplicatie.logic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AppLogic implements ILogic
{

    private String[] splitString(String original)
    {
        original.toLowerCase();
        return original.split("[,\n ]+");
    }

    @Override
    public int[] getWordCount(String input)
    {
        List<String> allWords = Arrays.asList(splitString(input));

        int[] result = new int[2];
        result[0] = allWords.size();

        HashSet<String> differentWords = new HashSet<>(allWords);
        result[1] = differentWords.size();

        return result;
    }
}
