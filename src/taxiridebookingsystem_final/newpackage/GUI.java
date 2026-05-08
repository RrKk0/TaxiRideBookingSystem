package taxiridebookingsystem_final.newpackage;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {

    private TextArea outputArea = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setStyle("-fx-background-color: lightblue;");

        Label titleLabel = new Label("Taxi Ride Booking System");
        Label customerLabel = new Label("Customer Name:");
        Label pickupLabel = new Label("Pickup Location:");
        Label destinationLabel = new Label("Destination:");
        Label fareLabel = new Label("Fare:");

        TextField customerField = new TextField();
        TextField pickupField = new TextField();
        TextField destinationField = new TextField();
        TextField fareField = new TextField();

        Button addButton = new Button("Add");
        Button showButton = new Button("Show");

        outputArea.setEditable(false);
        outputArea.setPrefHeight(160);

        grid.add(titleLabel, 0, 0, 2, 1);
        grid.add(customerLabel, 0, 1);
        grid.add(customerField, 1, 1);
        grid.add(pickupLabel, 0, 2);
        grid.add(pickupField, 1, 2);
        grid.add(destinationLabel, 0, 3);
        grid.add(destinationField, 1, 3);
        grid.add(fareLabel, 0, 4);
        grid.add(fareField, 1, 4);
        grid.add(addButton, 0, 5);
        grid.add(showButton, 1, 5);
        grid.add(outputArea, 0, 6, 2, 1);

        addButton.setOnAction(e -> {
            try {
                String customerName = customerField.getText();
                String pickup = pickupField.getText();
                String destination = destinationField.getText();
                double fare = Double.parseDouble(fareField.getText());

                if (customerName.trim().length() == 0 || pickup.trim().length() == 0
                        || destination.trim().length() == 0 || fare <= 0) {
                    outputArea.setText("Please enter valid booking information.");
                } else {
                    outputArea.setText("Booking added.\n"
                            + "Customer: " + customerName + "\n"
                            + "Pickup: " + pickup + "\n"
                            + "Destination: " + destination + "\n"
                            + "Fare: " + fare);
                }
            } catch (Exception ex) {
                outputArea.setText("Error: Please enter a valid fare.");
            }
        });

        showButton.setOnAction(e -> {
            outputArea.setText("Enter booking information, then click Add.\n"
                    + "------------------\n"
                    + "This simple GUI is connected to the taxi booking project package.");
        });

        Scene scene = new Scene(grid, 420, 360);
        primaryStage.setTitle("Taxi Ride Booking System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
