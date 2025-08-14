package com.example.group65_ms3version1_flighttrainingacademy_2221902_2321051_1810611_2220678;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                HelloApplication.class.getResource(
                        "/com/example/group65_ms3version1_flighttrainingacademy_2221902_2321051_1810611_2220678/TrainingRecordsOfficer/TRODashboard"
                )
        );
        Scene scene = new Scene(fxmlLoader.load(), 600, 400); // adjust size as needed
        stage.setTitle("Finance and Enrollment Officer Dashboard");
        stage.setScene(scene);
        stage.show();
    }}