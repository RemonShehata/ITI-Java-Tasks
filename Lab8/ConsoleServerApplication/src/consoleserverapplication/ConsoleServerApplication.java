/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleserverapplication;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author remon
 */
public class ConsoleServerApplication {

    /**
     * @param args the command line arguments
     */
    
    ServerSocket serverSoc;
    Socket soc;
    DataInputStream dis;
    PrintStream ps;
    public static void main(String[] args) {
        // TODO code application logic here
        new ConsoleServerApplication(); 
    }

    public ConsoleServerApplication() {
        try {
            serverSoc = new ServerSocket(5005);
            soc = serverSoc.accept();
            dis = new DataInputStream(soc.getInputStream());
            ps = new PrintStream(soc.getOutputStream());
            String msg = dis.readLine();
            System.out.println(msg);
            ps.println("data Recieved");
        } catch (IOException ex) {
            Logger.getLogger(ConsoleServerApplication.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                dis.close();
                soc.close();
                serverSoc.close();
            } catch (IOException ex) {
                Logger.getLogger(ConsoleServerApplication.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
}
