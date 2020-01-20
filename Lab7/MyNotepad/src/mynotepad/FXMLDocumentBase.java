package mynotepad;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;

public class FXMLDocumentBase extends BorderPane {

    protected final MenuBar mnuBar;
    protected final Menu mnuFile;
    protected final MenuItem mnuItemNew;
    protected final MenuItem mnuItemOpen;
    protected final MenuItem mnuItemSave;
    protected final MenuItem mnuItemClose;
    protected final Menu mnuEdit;
    protected final MenuItem mnuItemCut;
    protected final MenuItem mnuItemCopy;
    protected final MenuItem mnuItemPaste;
    protected final MenuItem mnuItemDelete;
    protected final MenuItem mnuItemSelectAll;
    protected final Menu mnuHelp;
    protected final MenuItem mnuItemAbout;
    protected final TextArea textBody;

    public FXMLDocumentBase() {

        mnuBar = new MenuBar();
        mnuFile = new Menu();
        mnuItemNew = new MenuItem();
        mnuItemOpen = new MenuItem();
        mnuItemSave = new MenuItem();
        mnuItemClose = new MenuItem();
        mnuEdit = new Menu();
        mnuItemCut = new MenuItem();
        mnuItemCopy = new MenuItem();
        mnuItemPaste = new MenuItem();
        mnuItemDelete = new MenuItem();
        mnuItemSelectAll = new MenuItem();
        mnuHelp = new Menu();
        mnuItemAbout = new MenuItem();
        textBody = new TextArea();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(mnuBar, javafx.geometry.Pos.CENTER);

        mnuFile.setMnemonicParsing(false);
        mnuFile.setText("File");

        mnuItemNew.setMnemonicParsing(false);
        mnuItemNew.setText("New");
        mnuItemNew.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_ANY));

        mnuItemOpen.setMnemonicParsing(false);
        mnuItemOpen.setText("Open");
        mnuItemOpen.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_ANY));

        mnuItemSave.setMnemonicParsing(false);
        mnuItemSave.setText("Save");
        mnuItemSave.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_ANY));

        mnuItemClose.setMnemonicParsing(false);
        mnuItemClose.setText("Close");

        mnuEdit.setMnemonicParsing(false);
        mnuEdit.setText("Edit");

        mnuItemCut.setMnemonicParsing(false);
        mnuItemCut.setText("Cut");

        mnuItemCopy.setMnemonicParsing(false);
        mnuItemCopy.setText("Copy");

        mnuItemPaste.setMnemonicParsing(false);
        mnuItemPaste.setText("Paste");

        mnuItemDelete.setMnemonicParsing(false);
        mnuItemDelete.setText("Delete");

        mnuItemSelectAll.setMnemonicParsing(false);
        mnuItemSelectAll.setText("Select All");
        mnuItemSelectAll.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_ANY));

        mnuHelp.setMnemonicParsing(false);
        mnuHelp.setText("Help");

        mnuItemAbout.setMnemonicParsing(false);
        mnuItemAbout.setText("About");
        setTop(mnuBar);

        BorderPane.setAlignment(textBody, javafx.geometry.Pos.CENTER);
        textBody.setPrefHeight(200.0);
        textBody.setPrefWidth(200.0);
        setCenter(textBody);

        mnuFile.getItems().add(mnuItemNew);
        mnuFile.getItems().add(mnuItemOpen);
        mnuFile.getItems().add(mnuItemSave);
        mnuFile.getItems().add(mnuItemClose);
        mnuBar.getMenus().add(mnuFile);
        mnuEdit.getItems().add(mnuItemCut);
        mnuEdit.getItems().add(mnuItemCopy);
        mnuEdit.getItems().add(mnuItemPaste);
        mnuEdit.getItems().add(mnuItemDelete);
        mnuEdit.getItems().add(mnuItemSelectAll);
        mnuBar.getMenus().add(mnuEdit);
        mnuHelp.getItems().add(mnuItemAbout);
        mnuBar.getMenus().add(mnuHelp);

        mnuItemNew.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textBody.clear();
            }
        });

        mnuItemSelectAll.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textBody.selectAll();
            }
        });

        mnuItemClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });

        mnuItemCut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textBody.cut();
            }
        });

        mnuItemCopy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textBody.copy();
            }
        });

        mnuItemPaste.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textBody.paste();
            }
        });

        mnuItemDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textBody.deleteText(textBody.getSelection());
            }
        });

        mnuItemAbout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Alert alert = new Alert(AlertType.INFORMATION, "Designed by Remon");
               //alert.setContentText("Programmed by Remon!");
               
               alert.showAndWait();

            }
        });

    }
}
