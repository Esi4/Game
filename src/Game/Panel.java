package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Panel extends JPanel implements ActionListener {

    public static int high = Toolkit.getDefaultToolkit().getScreenSize().height; //высота панели
    public static int width = Toolkit.getDefaultToolkit().getScreenSize().width; //ширина панели

    public static int mouseX; //координаты панели
    public static int mouseY;

    public static enum states{menus, play}
    public static states state = states.menus; //изначальная перменная(play)

    private BufferedImage image; //ссылка на объект класса
    private Graphics2D g;

    Timer timer = new Timer(30, this); //задается интервал обновления игровых событий

    Fon fon = new Fon();
    Menus menus = new Menus();
    Player player = new Player();

    public Panel() {
        super();
        setFocusable(true);
        requestFocus();
        timer.start(); //старт таймера
        image = new BufferedImage(width, high, BufferedImage.TYPE_INT_BGR); //объект буффера для картинок
        g = (Graphics2D) image.getGraphics();

        addMouseListener (new Mouse());
        addMouseMotionListener (new Mouse());
        addKeyListener(new Mouse());
    }

    @Override
    public void actionPerformed(ActionEvent e) {  //игровые события
        if (state.equals(states.play)) {
            fon.draw(g);
            for (int n = 0; n < 795; n = n + 53 ) {
                for (int m = 0; m < 795; m = m + 53 ) {
                    if ((Panel.mouseX <= player.getX() + n + 15) && (Panel.mouseY <= player.getY() + m + 15) && (Panel.mouseX >= player.getX() + n - 15) && (Panel.mouseY >= player.getY() + m - 15)) {
                        player.drawCircle(g,player.getX() + n - 22, player.getY() + m - 26); //рисуется кружок при наведении на позицию, куда можно поставить "шашку"
                        if (Player.click) {
                            player.turnPlayer(g, player.getX() + n - 30, player.getY() + m - 34 , n/53, m/53);
                        }
                    }
                    player.fieldDraw(g, player.field);
                    if (player.turnWorB > 1) {
                        player.inscriptions(g, player.turnWorB, "PASS", 600);
                    }
                    if (Panel.mouseX > 1000 && Panel.mouseX < 1100 && Panel.mouseY > 700 && Panel.mouseY < 727) {
                        if (Player.click) {
                            player.pass(g);
                        }
                    }
                }
            }
            gameDraw();
        }
        if (state.equals(states.menus)) {
            fon.draw(g);
            menus.draw(g);
            int f = Panel.mouseX;
            int v = Panel.mouseY;
            if (Panel.mouseX > (menus.getX() + 640) && Panel.mouseX < (menus.getX() + 640) + menus.getW() &&
                    Panel.mouseY > (menus.getY() + 200) * 0 && Panel.mouseY < (menus.getY() + 200) * 0 + menus.getH()) {
                menus.list[0] = "Старт";

                if(Menus.click) { //клик ЛКМ для начала игры
                    state = states.play;
                    Menus.click = false;
                }
            } else {
                menus.list[0] = String.valueOf("Начать игру");
            }
            gameDraw();
        }
        if (Panel.mouseX > (menus.getX() + 640) && Panel.mouseX < (menus.getX() + 640) + menus.getW() &&
                Panel.mouseY > (menus.getY() + 200) * 2 && Panel.mouseY < (menus.getY() + 200) * 2 + menus.getH()) {
            if(Menus.click) {
                System.exit(0);
            }
        }
    }

    public void gameRender() {
         fon.draw(g);
    }

    private void gameDraw() {
        Graphics g2 = this.getGraphics();
        g2.drawImage(image, 0,0, null);
        g2.dispose();

        Point location = MouseInfo.getPointerInfo().getLocation();
        double x = location.getX();
        double y = location.getY();

        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
}
