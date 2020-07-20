package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.util.ArrayList;

public class Controller {
    public TextField lengthInput;
    public TextField widthInput;
    public Label numOfPanelsLabel;
    public Label numOfHSLabel;
    public Label numOfVSLabel;
    public Label totalNumOfPanelsLabel;
    public Label totalNumOfVSLabel;
    public Label totalNumOfHSLabel;
    public ListView listView;
    int standLength;
    int standWidth;
    int numOfPanels;
    int numOfVS;
    int numOfHS;
    int totalNumOfPanels;
    int totalNumOfVS;
    int totalNumOfHS;
    ArrayList<String> stands = new ArrayList<String>();

    public void calculateBtnPressed(ActionEvent actionEvent) {
        String standLengthString = lengthInput.getText();
        String standWidthString = widthInput.getText();
        standLength = Integer.parseInt(standLengthString);
        standWidth = Integer.parseInt(standWidthString);

        stands.add(standLength + " x " + standWidth);

        numOfPanels = standLength + (standWidth * 2);
        numOfVS = numOfPanels + 1;
        numOfHS = numOfPanels * 2;

        totalNumOfPanels += numOfPanels;
        totalNumOfVS += numOfVS;
        totalNumOfHS += numOfHS;

        // Stand i = new Stand(standLength, standWidth);
        // System.out.println(stand1.length + " " + stand1.width);

        numOfPanelsLabel.setText("Number of Panels: " + numOfPanels);
        numOfVSLabel.setText("Number of Vertical Supports: " + numOfVS);
        numOfHSLabel.setText("Number of Horizontal Supports: " + numOfHS);

        totalNumOfPanelsLabel.setText("Total number of Panels: " + totalNumOfPanels);
        totalNumOfVSLabel.setText("Total number of Vertical Supports: " + totalNumOfVS);
        totalNumOfHSLabel.setText("Total number of Horizontal Supports: " + totalNumOfHS);

        lengthInput.setText("");
        widthInput.setText("");

        ObservableList<String> items = FXCollections.observableArrayList(stands);
        listView.setItems(items);
    }

    public void clearOptionPressed(ActionEvent actionEvent) {
        numOfPanels = 0;
        numOfHS = 0;
        numOfVS = 0;
        totalNumOfPanels = 0;
        totalNumOfHS = 0;
        totalNumOfVS = 0;
        stands.clear();
        listView.getItems().clear();

        lengthInput.setText("");
        widthInput.setText("");
        numOfPanelsLabel.setText("Number of Panels: ");
        numOfVSLabel.setText("Number of Vertical Supports: ");
        numOfHSLabel.setText("Number of Horizontal Supports: ");
        totalNumOfPanelsLabel.setText("Total number of Panels: ");
        totalNumOfVSLabel.setText("Total number of Vertical Supports: ");
        totalNumOfHSLabel.setText("Total number of Horizontal Supports: ");
    }

    public void deleteBtnPressed(ActionEvent actionEvent) {
        int selectedItem = listView.getSelectionModel().getSelectedIndex();
        String selectedStand = stands.get(selectedItem);

        String selectedStandLengthStr = selectedStand.substring(0, selectedStand.length() - 4);
        String selectedStandWidthStr = selectedStand.substring(4);
        int selectedStandLength = Integer.parseInt(selectedStandLengthStr);
        int selectedStandWidth = Integer.parseInt(selectedStandWidthStr);

        int numOfPanelsToRemove = selectedStandLength + (selectedStandWidth * 2);
        int numOfVSToRemove = numOfPanelsToRemove + 1;
        int numOfHSToRemove = numOfPanelsToRemove * 2;

        totalNumOfPanels -= numOfPanelsToRemove;
        totalNumOfVS -= numOfVSToRemove;
        totalNumOfHS -= numOfHSToRemove;

        stands.remove(selectedItem);
        System.out.println(stands);
        ObservableList<String> items = FXCollections.observableArrayList(stands);
        listView.setItems(items);

        totalNumOfPanelsLabel.setText("Total number of Panels: " + totalNumOfPanels);
        totalNumOfVSLabel.setText("Total number of Vertical Supports: " + totalNumOfVS);
        totalNumOfHSLabel.setText("Total number of Horizontal Supports: " + totalNumOfHS);
        numOfPanelsLabel.setText("Number of Panels: ");
        numOfVSLabel.setText("Number of Vertical Supports: ");
        numOfHSLabel.setText("Number of Horizontal Supports: ");
    }
}
