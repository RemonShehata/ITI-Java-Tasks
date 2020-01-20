/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleclientapplication;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author remon
 */
public class ConsoleClientApplication {

    Socket soc;
    DataInputStream dis;
    PrintStream ps;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new ConsoleClientApplication();
    }

    public ConsoleClientApplication() {
        try {
            soc = new Socket("127.0.0.1", 5005);
            dis = new DataInputStream(soc.getInputStream());
            ps = new PrintStream(soc.getOutputStream());
            ps.println("Test Test!");
            String replayMessage = dis.readLine();
            System.out.println(replayMessage);
        } catch (IOException ex) {
            Logger.getLogger(ConsoleClientApplication.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                dis.close();
                soc.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

}
