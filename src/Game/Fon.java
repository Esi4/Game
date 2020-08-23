package Game;


import javax.swing.*;
import java.awt.*;

public class Fon {

    Image imgMenus = new ImageIcon ("image/fon.jpg").getImage(); //загрузка картинки
    Image imgPlay = new ImageIcon ("image/play.png").getImage(); //загрузка картинки

    public void draw(Graphics2D g) { //прорисовка в графикс2дэ

        if (Panel.state.equals(Panel.states.menus)) {
            g.drawImage(imgMenus,0,0, null);
        }
        if (Panel.state.equals(Panel.states.play)) {
            g.drawImage(imgPlay,0,0, null);
        }
    }
}
