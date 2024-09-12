package com.codedotorg;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PetSelectionScene extends PetApp {

    /** The name of the pet provided by the user */
    private String petName;

    /** The type of pet chosen by the user */
    private String petType;

    /**
     * This class represents a scene for selecting a pet. It extends the Scene class and
     * provides a constructor for initializing the pet name and type.
     */
    public PetSelectionScene(Stage window, int width, int height) {
        super(window, width, height);

        petName = "";
        petType = "";
    }

    /**
     * This method starts the application by creating a VBox layout for pet selection
     * and setting it as the scene to be displayed.
     */
    public void startApp() {
        VBox petSelectionLayout = createPetSelectionLayout();
        setAndShowScene(petSelectionLayout);
    }

    /**
     * Sets petName to the name entered by the user
     */
    public void setPetName(String name) {

        this.petName = name;

    }

    /**
     * Sets petType to the type of pet chosen by the user
     */
    public void setPetType(String type) {

        this.petType = type;

    }

    /**
     * Creates the main layout for the PetSelection scene
     * 
     * @return the VBox layout for the PetSelection scene
     */
    public VBox createPetSelectionLayout() {
        // Create a dropdown for pet type selection
        ComboBox<String> petTypeDropdown = new ComboBox<>();
        petTypeDropdown.getItems().addAll("Dog", "Cat");

        // Create a text field for pet name input
        TextField petNameField = new TextField();

        // Create labels
        Label petTypeLabel = new Label("Select Pet Type:");
        Label petNameLabel = new Label("Enter Pet Name:");

        // Use the existing method to create the submit button
        Button submitButton = createSubmitButton();

        // Add all elements to the layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(petTypeLabel, petTypeDropdown, petNameLabel, petNameField, submitButton);

        return layout;
    }

    /**
     * Creates a submit button that, when clicked, creates a new MainScene object with
     * the given pet name and type, and displays it.
     *
     * @return the submit button
     */
    public Button createSubmitButton() {
        Button tempButton = new Button("Submit");

        tempButton.setOnAction(event -> {
            MainScene mainScene = new MainScene(getWindow(), getWidth(), getHeight(), petName, petType);
            mainScene.showMainScene();
            getWindow().close(); // Close the current scene
        });

        return tempButton;
    }

}