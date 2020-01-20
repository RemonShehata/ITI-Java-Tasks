/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

import java.sql.Connection;
import java.sql.Driver;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.derby.jdbc.ClientDriver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.derby.jdbc.Driver42;

/**
 *
 * @author remon
 */
public class PhoneBook extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = new FXMLDocumentBase();
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
