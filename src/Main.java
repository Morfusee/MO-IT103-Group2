import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

import GUI.LoginPage;
import GUI.admin.FullEmployeeDetailsPage;

public class Main {

    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> new LoginPage());
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }
}
