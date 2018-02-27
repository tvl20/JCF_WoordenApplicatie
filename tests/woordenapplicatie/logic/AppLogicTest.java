package woordenapplicatie.logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class AppLogicTest
{
    private ILogic testLogic;

    @Before
    public void setUp() throws Exception
    {
        testLogic = new AppLogic();
    }

    @Test
    public void getWordCount() throws Exception
    {
        String countString = "Dit is een test string, for a test thing";
        Integer[] counts = testLogic.getWordCount(countString);

        Assert.assertTrue("Total word count doesn't match", 9 == counts[0]);
        Assert.assertTrue("Total unique word count doesn't match", 8 == counts[1]);
    }

    @Test
    public void getWordsSorted() throws Exception
    {
        String sortedString = "c b d a";
        TreeSet<String> sortedSet = testLogic.getWordsSorted(sortedString);

        Assert.assertTrue(sortedSet.pollFirst().equals("a"));
        Assert.assertTrue(sortedSet.pollFirst().equals("b"));
        Assert.assertTrue(sortedSet.pollFirst().equals("c"));
        Assert.assertTrue(sortedSet.pollFirst().equals("d"));
    }

    @Test
    public void getWordFrequency() throws Exception
    {
        String frequencyString = "three two three one two three";
        List<Map.Entry<String, Integer>> entries = testLogic.getWordFrequency(frequencyString);

        for (Map.Entry<String, Integer> entry : entries)
        {
            switch(entry.getKey())
            {
                case "one":
                    Assert.assertTrue(entry.getValue() == 1);
                    break;
                case "two":
                    Assert.assertTrue(entry.getValue() == 2);
                    break;
                case "three":
                    Assert.assertTrue(entry.getValue() == 3);
                    break;
                default:
                    Assert.fail();
            }
        }
    }

    @Test
    public void getWordConcordance() throws Exception
    {
        String concordanceString = "three two \n" +
                                " three one two three";

        HashMap<String, HashSet<Integer>> concordance = testLogic.getWordConcordance(concordanceString);

        for (Map.Entry<String, HashSet<Integer>> entry : concordance.entrySet())
        {
            HashSet<Integer> occurances = entry.getValue();
            switch (entry.getKey())
            {
                case "one":
                    Assert.assertTrue("too many occurances in concordance", occurances.size() == 1);
                    Assert.assertTrue("set doesn't contain the right numbers", occurances.contains(2));
                    break;
                case "two":
                    Assert.assertTrue("too many occurances in concordance", occurances.size() == 2);
                    Assert.assertTrue("set doesn't contain the right numbers", occurances.contains(1));
                    Assert.assertTrue("set doesn't contain the right numbers", occurances.contains(2));
                    break;
                case "three":
                    Assert.assertTrue("too many occurances in concordance", occurances.size() == 2);
                    Assert.assertTrue("set doesn't contain the right numbers", occurances.contains(1));
                    Assert.assertTrue("set doesn't contain the right numbers", occurances.contains(2));
                    break;
                default:
                    Assert.fail();
            }
        }
    }
}