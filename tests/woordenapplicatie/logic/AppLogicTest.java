package woordenapplicatie.logic;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static org.junit.Assert.*;

public class AppLogicTest
{
    private ILogic testLogic;

    private String string10k;
    private String string1m;

    @Before
    public void setUp() throws Exception
    {
        testLogic = new AppLogic();
        string10k = generateString(10000);
        string1m = generateString(1000000);
    }

    @Test
    public void getWordCount() throws Exception
    {
        System.out.println("Word count test");

        System.out.println("10k");
        long start10k = System.currentTimeMillis();
        testLogic.getWordCount(string10k);
        visualise(10000, start10k);

        System.out.println("1m");
        long start1m = System.currentTimeMillis();
        testLogic.getWordCount(string1m);
        visualise(1000000, start1m);

        System.out.println("----------------------------");
    }

    @Test
    public void getWordsSorted() throws Exception
    {
        System.out.println("Word sort test");

        System.out.println("10k");
        long start10k = System.currentTimeMillis();
        testLogic.getWordsSorted(string10k);
        visualise(10000, start10k);

        System.out.println("1m");
        long start1m = System.currentTimeMillis();
        testLogic.getWordsSorted(string1m);
        visualise(1000000, start1m);

        System.out.println("----------------------------");
    }

    @Test
    public void getWordFrequency() throws Exception
    {
        System.out.println("Word frequency test");

        System.out.println("10k");
        long start10k = System.currentTimeMillis();
        testLogic.getWordFrequency(string10k);
        visualise(10000, start10k);

        System.out.println("1m");
        long start1m = System.currentTimeMillis();
        testLogic.getWordFrequency(string1m);
        visualise(1000000, start1m);

        System.out.println("----------------------------");
    }

    @Test
    public void getWordConcordance() throws Exception
    {
        System.out.println("Word concordance test");

        System.out.println("10k");
        long start10k = System.currentTimeMillis();
        testLogic.getWordConcordance(string10k);
        visualise(10000, start10k);

        System.out.println("1m");
        long start1m = System.currentTimeMillis();
        testLogic.getWordConcordance(string1m);
        visualise(1000000, start1m);

        System.out.println("----------------------------");
    }

    private String generateString(int numberOfWords)
    {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numberOfWords; i++)
        {
            String name = " " + rnd.nextInt();
            if ((i % 5) == 0)
            {
                sb.append("\n");
            }
            sb.append(name + "");
        }

        return sb.toString();
    }

    private void visualise(int grootte, long start)
    {
        long end = System.currentTimeMillis();
        long nb_miliseconds = (end - start);

        System.out.println("n = " + grootte);
        System.out.println("time = " + nb_miliseconds + "ms");

        SimpleDateFormat sdf = new SimpleDateFormat("KK:mm:ss,SSS");
        Date resultdate = new Date(nb_miliseconds);

        System.out.println("Human readable: " + sdf.format(resultdate));
    }
}