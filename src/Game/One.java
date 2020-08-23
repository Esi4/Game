package Game;

import javax.swing.*;
import java.awt.*;

public class One {
    public static void main(String[] args) {

        JFrame startFrame = new JFrame("Renju");
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startFrame.setLocation(0,0);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        startFrame.setSize(1440,899);
        startFrame.setContentPane(new Panel());
        startFrame.setVisible(true);
    }
}
