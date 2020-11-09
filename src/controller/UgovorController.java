/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.Ugovor;

/**
 *
 * @author ivana
 */
public class UgovorController {

    @FXML
    private TextField iip_polje;
    @FXML
    private TextField adr_polje;

    @FXML
    private ToggleGroup trajanjeRbg;

    private RadioButton selected;

    @FXML
    private TableView<Ugovor> tableView;

    @FXML
    private ComboBox brzinaCombo;
    ObservableList<String> brzine = FXCollections.observableArrayList("2 Mbit", "5 Mbit", "10 Mbit", "20 Mbit", "50 Mbit", "100 Mbit");

    @FXML
    private ComboBox protokCombo;
    ObservableList<String> protoci = FXCollections.observableArrayList("1 GB", "5 GB", "10 GB", "100 GB", "FLAT");

    @FXML
    private CheckBox potvrda;

    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;

    ObservableList<Ugovor> ugovori;
    Ugovor ugovor;

    int brojeviUgovora[] = {7584297, 5534531};

    @FXML
    public void initialize() {

        System.out.println("Initialize poceo");

        System.out.println("Initialize gotov");
        brzinaCombo.getItems().addAll(brzine);
        protokCombo.getItems().addAll(protoci);
        tableView.setItems(getUgovori());

        System.out.println("Ugovori gotovi");

    }

    public ObservableList<Ugovor> getUgovori() {

        ugovori = FXCollections.observableArrayList();
        ugovori.add(new Ugovor(7584297, "Ivana Pavlovic", "Deset avijaticara 5", "12 meseci", "10", "FLAT"));
        ugovori.add(new Ugovor(5534531, "Nikola Pavlovic", "Deset avijaticara 5", "24 meseca", "50", "FLAT"));

        return ugovori;
    }

    @FXML
    protected void addUgovor(ActionEvent event) {
        if (validnostFormulara1()) {

            if (validnostFormulara2()) {
                if (potvrda.isSelected()) {

                    selected = (RadioButton) trajanjeRbg.getSelectedToggle();

                    Integer jedinstvenBroj = randomUniqueNumber();
                    ugovori = tableView.getItems();
                    ugovori.add(new Ugovor(jedinstvenBroj, iip_polje.getText(), adr_polje.getText(), selected.getText(), (String) brzinaCombo.getValue(), (String) protokCombo.getValue()));

                    resetPolja();

                } else {

                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Obavestenje!");
                    alert.setHeaderText("NEPRAVILNO POPUNJEN FORMULAR");
                    alert.setContentText("Potvrdite da se slazete sa Ugovornim obavezama");
                    alert.showAndWait();
                }
            }
        }
    }

    @FXML
    protected void deleteUgovor() {
        ugovori = tableView.getItems();
        int index = tableView.selectionModelProperty().getValue().getSelectedIndex();
        ugovori.remove(index);
        tableView.setItems(ugovori);
    }

    public Integer randomUniqueNumber() {

        Random id = new Random();
        int number = 0;
        boolean unique = false;

        while (unique != true) {
            number = id.nextInt(9000000) + 1000000;
            int i = 0;
            for (int no : brojeviUgovora) {

                if (no == number) {
                    i++;
                }
            }
            if (i == 0) {
                unique = true;
            }
        }
        return number;
    }

    public void resetPolja() {
        iip_polje.setText("");
        adr_polje.setText("");
        potvrda.setSelected(false);
        brzinaCombo.getSelectionModel().clearSelection();
        protokCombo.getSelectionModel().clearSelection();
        trajanjeRbg.getSelectedToggle().setSelected(false);
    }

    public Boolean validnostFormulara1() {

        if (("".equals(iip_polje.getText())) || ("".equals(adr_polje.getText())) || ((RadioButton) trajanjeRbg.getSelectedToggle() == null)) {

            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Obavestenje!");
            alert.setHeaderText("NEPRAVILNO POPUNJEN FORMULAR");
            alert.setContentText("Popunite pravilno polja za unos podataka korisnika!");

            alert.showAndWait();
            return false;

        }

        return true;

    }

    public Boolean validnostFormulara2() throws NullPointerException {
        System.out.println("validnostFormulara2 pocinje");

        if ((protokCombo.getSelectionModel().getSelectedIndex() == -1) || (brzinaCombo.getSelectionModel().getSelectedIndex() == -1)) {
            System.out.println("validnostFormulara2");
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Obavestenje!");
            alert.setHeaderText("NEPRAVILNO POPUNJEN FORMULAR");
            alert.setContentText("Unesite vrednosti parametara protoka!");

            alert.showAndWait();
            return false;
        } else {
        }

        return true;
    }
}
