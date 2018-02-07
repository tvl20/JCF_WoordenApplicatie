package woordenapplicatie.logic;

public interface ILogic
{
    /**
     * Gets the total word count and the amount of different words
     * @param input The input that needs to be analyzed
     * @return An array of 2 integers, 0: Total amount of words, 1: Amount of different words
     */
    int[] getWordCount(String input);


}
