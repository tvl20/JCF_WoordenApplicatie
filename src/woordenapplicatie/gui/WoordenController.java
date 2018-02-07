package woordenapplicatie.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

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
        taOutput.setText(logic.getWordCount(taInput.getText()));
    }

    @FXML
    private void sorteerAction(ActionEvent event)
    {
        taOutput.setText(logic.getWordsSorted(taInput.getText()));
    }

    @FXML
    private void frequentieAction(ActionEvent event)
    {
        taOutput.setText(logic.getWordFrequency(taInput.getText()));
    }

    @FXML
    private void concordatieAction(ActionEvent event)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
