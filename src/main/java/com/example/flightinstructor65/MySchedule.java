package com.example.flightinstructor65;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MySchedule {
    @javafx.fxml.FXML
    private TableColumn flightTimeCo;
    @javafx.fxml.FXML
    private TableColumn flightDateCo;
    @javafx.fxml.FXML
    private TableColumn trainingLocationCo;
    @javafx.fxml.FXML
    private TableView scheduleTableView;
    @javafx.fxml.FXML
    private TableColumn instructorNameCo;
    @javafx.fxml.FXML
    private TableColumn traininglocationCo;
    @javafx.fxml.FXML
    private TableColumn sessionTypeCo;

    @javafx.fxml.FXML
    public void refreshOnClick(ActionEvent actionEvent) {
    }
}
