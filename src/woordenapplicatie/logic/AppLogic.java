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
        TimeStamp calculatingTimeStamp = new TimeStamp();
        calculatingTimeStamp.setBegin();

        List<String> allWords = Arrays.asList(splitString(input));
        HashSet<String> differentWords = new HashSet<>(allWords);

        calculatingTimeStamp.setEnd();
        System.out.println("Time to complete calculating: " + calculatingTimeStamp.toString());


        TimeStamp stringFormattingTimeStamp = new TimeStamp();
        stringFormattingTimeStamp.setBegin();

        String output = "Totaal aantal woorden:         " + Integer.toString(allWords.size());
        output += "\nAaantal verschillende woorden: " + Integer.toString(differentWords.size());

        stringFormattingTimeStamp.setEnd();
        System.out.println("Time to complete String formatting: " + stringFormattingTimeStamp.toString());

        return output;
    }

    @Override
    public String getWordsSorted(String input)
    {
        TimeStamp calculatingTimeStamp = new TimeStamp();
        calculatingTimeStamp.setBegin();

        TreeSet<String> differentWords = new TreeSet<>(Arrays.asList(splitString(input)));

        calculatingTimeStamp.setEnd();
        System.out.println(calculatingTimeStamp.toString());


        TimeStamp stringFormattingTimeStamp = new TimeStamp();
        stringFormattingTimeStamp.setBegin();

        StringBuilder outputString = new StringBuilder();
        for (String word : differentWords.descendingSet())
        {
            outputString.append(word).append("\n");
        }

        stringFormattingTimeStamp.setEnd();
        System.out.println("Time to complete String formatting: " + stringFormattingTimeStamp.toString());

        return outputString.toString();
    }

    @Override
    public String getWordFrequency(String input)
    {
        TimeStamp calculatingTimeStamp = new TimeStamp();
        calculatingTimeStamp.setBegin();

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

        entries.sort(Comparator.comparing(Map.Entry::getValue));

        calculatingTimeStamp.setEnd();
        System.out.println(calculatingTimeStamp.toString());


        TimeStamp stringFormattingTimeStamp = new TimeStamp();
        stringFormattingTimeStamp.setBegin();

        // create the output String
        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, Integer> entry : entries)
        {
            output.append(entry.getKey()).append(": ");
            output.append(entry.getValue()).append("\n");
        }

        stringFormattingTimeStamp.setEnd();
        System.out.println("Time to complete String formatting: " + stringFormattingTimeStamp.toString());

        return output.toString();
    }

    @Override
    public String getWordConcordance(String input)
    {
        TimeStamp calculatingTimeStamp = new TimeStamp();
        calculatingTimeStamp.setBegin();

        HashMap<String, HashSet<Integer>> resultMap = new HashMap<>();
        int lineCount = 1;

        // Split the input by lines
        String[] lines = input.split("\n");

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
                if (resultMap.containsKey(word))
                {
                    HashSet<Integer> occurrences = resultMap.get(word);
                    occurrences.add(lineCount);

                    resultMap.replace(word, occurrences);
                }
                // If it is a new word, add it to the list
                else
                {
                    resultMap.put(word, new HashSet<Integer>(Collections.singletonList(lineCount)));
                }
            }
            lineCount++;
        }

        calculatingTimeStamp.setEnd();
        System.out.println(calculatingTimeStamp.toString());


        TimeStamp stringFormattingTimeStamp = new TimeStamp();
        stringFormattingTimeStamp.setBegin();

        Set<String> allWords = resultMap.keySet();
        StringBuilder outputString = new StringBuilder();
        for (String word : allWords)
        {
            outputString.append(word).append(" [");

            Set<Integer> lineOccurrences = resultMap.get(word);
            for (Integer lineNumber : lineOccurrences)
            {
                outputString.append(lineNumber).append(",");
            }

            // This is just to remove the ',' behind the last number
            outputString.deleteCharAt(outputString.length() -1);

            outputString.append("]\n");
        }

        stringFormattingTimeStamp.setEnd();
        System.out.println("Time to complete String formatting: " + stringFormattingTimeStamp.toString());

        return outputString.toString();
    }
}
