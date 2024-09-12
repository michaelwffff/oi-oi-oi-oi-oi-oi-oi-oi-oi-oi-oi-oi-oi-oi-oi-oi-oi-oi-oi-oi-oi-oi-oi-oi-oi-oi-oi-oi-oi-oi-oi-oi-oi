package com.codedotorg;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
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
        // Create a TextField for pet name input
        TextField petNameField = new TextField();
        petNameField.setPromptText("Enter pet name");

        // Create a ComboBox for pet type selection
        ComboBox<String> petTypeComboBox = new ComboBox<>();
        petTypeComboBox.getItems().addAll("Dog", "Cat", "Bird", "Fish");
        petTypeComboBox.setPromptText("Select pet type");

        // Create a Button to submit the selections
        Button submitButton = new Button("Submit");

        // Add event handler to the Button
        submitButton.setOnAction(event -> {
            String name = petNameField.getText();
            String type = petTypeComboBox.getValue();

            if (name != null && !name.isEmpty() && type != null) {
                setPetName(name);
                setPetType(type);
            }
        });

        // Create a VBox layout and add all components
        VBox layout = new VBox(10); // 10 is the spacing between elements
        layout.getChildren().addAll(
            new Label("Pet Name:"), petNameField,
            new Label("Pet Type:"), petTypeComboBox,
            submitButton
        );

        return layout;
    }

    /**
     * Creates a submit button that, when clicked, creates a new MainScene object with
     * the given pet name and type, and displays it.
     *
     * @return the submit button
     */
    public Button createSubmitButton() {
        Button submitButton = new Button("Submit");
    
        submitButton.setOnAction(event -> {
            if (petName != null && !petName.isEmpty() && petType != null && !petType.isEmpty()) {
                MainScene mainScene = new MainScene(getWindow(), getWidth(), getHeight(), petName, petType);
                mainScene.showMainScene();
            } else {
                // Handle the case where petName or petType is not set
                System.out.println("Please enter a pet name and select a pet type.");
            }
        });
    
        return submitButton;
    }
}