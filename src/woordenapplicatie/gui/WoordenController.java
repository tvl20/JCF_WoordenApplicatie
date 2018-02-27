package woordenapplicatie.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import woordenapplicatie.logic.AppLogic;
import woordenapplicatie.logic.ILogic;

/**
 * FXML Controller class
 *
 * @author frankcoenen
 */
public class WoordenController implements Initializable
{
    private ILogic logic = new AppLogic();

    private static final String DEFAULT_TEXT = "Een, twee, drie, vier\n" +
            "Hoedje van, hoedje van\n" +
            "Een, twee, drie, vier\n" +
            "Hoedje van papier\n" +
            "\n" +
            "Heb je dan geen hoedje meer\n" +
            "Maak er één van bordpapier\n" +
            "Eén, twee, drie, vier\n" +
            "Hoedje van papier\n" +
            "\n" +
            "Een, twee, drie, vier\n" +
            "Hoedje van, hoedje van\n" +
            "Een, twee, drie, vier\n" +
            "Hoedje van papier\n" +
            "\n" +
            "En als het hoedje dan niet past\n" +
            "Zetten we 't in de glazenkas\n" +
            "Een, twee, drie, vier\n" +
            "Hoedje van papier";

    @FXML
    private Button btAantal;
    @FXML
    private TextArea taInput;
    @FXML
    private Button btSorteer;
    @FXML
    private Button btFrequentie;
    @FXML
    private Button btConcordantie;
    @FXML
    private TextArea taOutput;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        taInput.setText(DEFAULT_TEXT);
    }

    @FXML
    private void aantalAction(ActionEvent event)
    {
        Integer[] wordCount = logic.getWordCount(taInput.getText());
        String output = "Totaal aantal woorden:         " + wordCount[0];
        output += "\nAaantal verschillende woorden: " + wordCount[1];
        taOutput.setText(output);
    }

    @FXML
    private void sorteerAction(ActionEvent event)
    {
        TreeSet<String> differentWords = logic.getWordsSorted(taInput.getText());
        StringBuilder output = new StringBuilder();
        // O(Log(n)) for each item in the list:
        // O(n * Log(n))
        for (String word : differentWords.descendingSet())
        {
            output.append(word).append("\n");
        }

        taOutput.setText(output.toString());
    }

    @FXML
    private void frequentieAction(ActionEvent event)
    {
        List<Map.Entry<String, Integer>> entries = logic.getWordFrequency(taInput.getText());

        // create the output String
        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, Integer> entry : entries)
        {
            output.append(entry.getKey()).append(": ");
            output.append(entry.getValue()).append("\n");
        }

        taOutput.setText(output.toString());
    }

    @FXML
    private void concordatieAction(ActionEvent event)
    {
        HashMap<String, HashSet<Integer>> resultMap = logic.getWordConcordance(taInput.getText());

        Set<String> allWords = resultMap.keySet();
        StringBuilder output = new StringBuilder();
        for (String word : allWords)
        {
            output.append(word).append(" [");

            Set<Integer> lineOccurrences = resultMap.get(word);
            for (Integer lineNumber : lineOccurrences)
            {
                output.append(lineNumber).append(",");
            }

            // This is just to remove the ',' behind the last number
            output.deleteCharAt(output.length() - 1);

            output.append("]\n");
        }


        taOutput.setText(output.toString());
    }

}
