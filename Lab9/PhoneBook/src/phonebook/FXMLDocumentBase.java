package phonebook;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class FXMLDocumentBase extends AnchorPane {

    protected final Label nameLabel;
    protected final Label phoneLabel;
    protected final TextField nameTextField;
    protected final TextField phoneTextField;
    protected final Button newButton;
    protected final Button updateButton;
    protected final Button deleteButton;
    protected final Button firstButton;
    protected final Button previousButton;
    protected final Button nextButton;
    protected final Button lastButton;

    boolean newPressed = false;
    boolean updatePressed = false;
    String old = null;

    public FXMLDocumentBase() {

        nameLabel = new Label();
        phoneLabel = new Label();
        nameTextField = new TextField();
        phoneTextField = new TextField();
        newButton = new Button();
        updateButton = new Button();
        deleteButton = new Button();
        firstButton = new Button();
        previousButton = new Button();
        nextButton = new Button();
        lastButton = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        nameLabel.setLayoutX(56.0);
        nameLabel.setLayoutY(56.0);
        nameLabel.setText("Name");
        nameLabel.setFont(new Font(18.0));

        phoneLabel.setLayoutX(56.0);
        phoneLabel.setLayoutY(111.0);
        phoneLabel.setText("Phone");
        phoneLabel.setFont(new Font(18.0));

        nameTextField.setLayoutX(238.0);
        nameTextField.setLayoutY(54.0);
        nameTextField.setPrefHeight(31.0);
        nameTextField.setPrefWidth(257.0);

        phoneTextField.setLayoutX(238.0);
        phoneTextField.setLayoutY(109.0);
        phoneTextField.setPrefHeight(31.0);
        phoneTextField.setPrefWidth(257.0);

        newButton.setLayoutX(69.0);
        newButton.setLayoutY(240.0);
        newButton.setMnemonicParsing(false);
        newButton.setPrefHeight(31.0);
        newButton.setPrefWidth(63.0);
        newButton.setText("New");

        updateButton.setLayoutX(160.0);
        updateButton.setLayoutY(240.0);
        updateButton.setMnemonicParsing(false);
        updateButton.setPrefHeight(31.0);
        updateButton.setPrefWidth(76.0);
        updateButton.setText("Update");

        deleteButton.setLayoutX(269.0);
        deleteButton.setLayoutY(240.0);
        deleteButton.setMnemonicParsing(false);
        deleteButton.setPrefHeight(31.0);
        deleteButton.setPrefWidth(76.0);
        deleteButton.setText("Delete");

        firstButton.setLayoutX(69.0);
        firstButton.setLayoutY(315.0);
        firstButton.setMnemonicParsing(false);
        firstButton.setPrefHeight(31.0);
        firstButton.setPrefWidth(63.0);
        firstButton.setText("First");

        previousButton.setLayoutX(167.0);
        previousButton.setLayoutY(315.0);
        previousButton.setMnemonicParsing(false);
        previousButton.setText("Previous");

        nextButton.setLayoutX(277.0);
        nextButton.setLayoutY(315.0);
        nextButton.setMnemonicParsing(false);
        nextButton.setPrefHeight(31.0);
        nextButton.setPrefWidth(76.0);
        nextButton.setText("Next");

        lastButton.setLayoutX(385.0);
        lastButton.setLayoutY(315.0);
        lastButton.setMnemonicParsing(false);
        lastButton.setPrefHeight(31.0);
        lastButton.setPrefWidth(76.0);
        lastButton.setText("Last");

        getChildren().add(nameLabel);
        getChildren().add(phoneLabel);
        getChildren().add(nameTextField);
        getChildren().add(phoneTextField);
        getChildren().add(newButton);
        getChildren().add(updateButton);
        getChildren().add(deleteButton);
        getChildren().add(firstButton);
        getChildren().add(previousButton);
        getChildren().add(nextButton);
        getChildren().add(lastButton);

        nameTextField.setEditable(false);
        phoneTextField.setEditable(false);
        nameTextField.setDisable(true);
        phoneTextField.setDisable(true);

        try {
            if (DatabaseUtils.rs == null || DatabaseUtils.rs.isClosed()) {
                DatabaseUtils.getResults("select * from contact");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            DatabaseUtils.rs.first();
            nameTextField.setText(DatabaseUtils.rs.getString(1));
            phoneTextField.setText(DatabaseUtils.rs.getString(2));
            System.out.println(DatabaseUtils.rs.getString(1));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
        }

        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseUtils.deleteField(phoneTextField.getText());
                DatabaseUtils.closeResources();

            }
        });

        updateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (updatePressed) {
                    newButton.setDisable(false);
                    deleteButton.setDisable(false);
                    firstButton.setDisable(false);
                    nextButton.setDisable(false);
                    lastButton.setDisable(false);
                    previousButton.setDisable(false);

                    updateButton.setText("Update");
                    nameTextField.setEditable(false);
                    phoneTextField.setEditable(false);
                    nameTextField.setDisable(true);
                    phoneTextField.setDisable(true);
                    updatePressed = false;
                    if (!(old.trim().isEmpty())) {
                        DatabaseUtils.updateField(nameTextField.getText(), phoneTextField.getText(), old);
                        DatabaseUtils.closeResources();
                    }

                } else {

                    nameTextField.setEditable(true);
                    phoneTextField.setEditable(true);
                    nameTextField.setDisable(false);
                    phoneTextField.setDisable(false);

                    updateButton.setDisable(false);
                    newButton.setDisable(true);
                    deleteButton.setDisable(true);
                    firstButton.setDisable(true);
                    nextButton.setDisable(true);
                    lastButton.setDisable(true);
                    previousButton.setDisable(true);
                    updateButton.setText("Save");
                    updatePressed = true;

                    old = phoneTextField.getText();
                }
            }
        });

        newButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (newPressed) {
                    updateButton.setDisable(false);
                    deleteButton.setDisable(false);
                    firstButton.setDisable(false);
                    nextButton.setDisable(false);
                    lastButton.setDisable(false);
                    previousButton.setDisable(false);

                    newButton.setText("New");
                    nameTextField.setEditable(false);
                    phoneTextField.setEditable(false);
                    nameTextField.setDisable(true);
                    phoneTextField.setDisable(true);
                    newPressed = false;
                    if (!(nameTextField.getText().trim().isEmpty() && phoneTextField.getText().trim().isEmpty())) {
                        DatabaseUtils.addField(nameTextField.getText(), phoneTextField.getText());

                        DatabaseUtils.closeResources();
                    }

                } else {

                    nameTextField.setText("");
                    phoneTextField.setText("");
                    nameTextField.setEditable(true);
                    phoneTextField.setEditable(true);
                    nameTextField.setDisable(false);
                    phoneTextField.setDisable(false);

                    updateButton.setDisable(true);
                    deleteButton.setDisable(true);
                    firstButton.setDisable(true);
                    nextButton.setDisable(true);
                    lastButton.setDisable(true);
                    previousButton.setDisable(true);
                    newButton.setText("Save");
                    newPressed = true;
                }

            }
        });

        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    if (DatabaseUtils.rs == null || DatabaseUtils.rs.isClosed()) {
                        DatabaseUtils.getResults("select * from contact");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    if (DatabaseUtils.rs.next()) {

                        nameTextField.setText(DatabaseUtils.rs.getString(1));
                        phoneTextField.setText(DatabaseUtils.rs.getString(2));

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        firstButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    if (DatabaseUtils.rs == null || DatabaseUtils.rs.isClosed()) {
                        DatabaseUtils.getResults("select * from contact");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    DatabaseUtils.rs.first();
                    nameTextField.setText(DatabaseUtils.rs.getString(1));
                    phoneTextField.setText(DatabaseUtils.rs.getString(2));

                } catch (SQLException ex) {
                    Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        previousButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    if (DatabaseUtils.rs == null || DatabaseUtils.rs.isClosed()) {
                        DatabaseUtils.getResults("select * from contact");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    if (DatabaseUtils.rs.previous()) {
                        nameTextField.setText(DatabaseUtils.rs.getString(1));
                        phoneTextField.setText(DatabaseUtils.rs.getString(2));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        lastButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    if (DatabaseUtils.rs == null || DatabaseUtils.rs.isClosed()) {
                        DatabaseUtils.getResults("select * from contact");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    DatabaseUtils.rs.last();
                    nameTextField.setText(DatabaseUtils.rs.getString(1));
                    phoneTextField.setText(DatabaseUtils.rs.getString(2));

                } catch (SQLException ex) {
                    Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }
}
