package Game;

import java.awt.event.*;

public class Mouse implements MouseListener, MouseMotionListener, KeyListener{

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) { //если нажата лкм
            if(Panel.state == Panel.states.menus) { //в меню
                Menus.click = true; //нажатие лкм в меню
            }
            if(Panel.state == Panel.states.play) { //в игре
                Player.click = true; //нажатие лкм в игре
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) { //если отжата лкм
            if(Panel.state == Panel.states.menus) { //в меню
                Menus.click = false; //отжатие лкм в меню
            }
            if(Panel.state == Panel.states.play) { //в игре
                Player.click = false; //отжатие лкм в игре
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Panel.mouseX = e.getX(); //получаем коор-ту х и у при перемещнии мышки
        Panel.mouseY = e.getY();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_ESCAPE) {
            if(Panel.state == Panel.states.play) {
                Panel.state = Panel.states.menus; //если нажать escape, то происходит возврат в меню игры
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
