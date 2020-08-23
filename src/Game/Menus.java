package Game;

import javax.swing.*;
import java.awt.*;

public class Menus {

    private int n; //количество кнопок
    private Color color; //цвет шрифта дял надписи кнопок
    private double x; //коор-ты x кнопки
    private double y; //коор-ты у кнопки
    private double w; //ширина кнопки
    private double h; //высота кнопки

    public static boolean click = false; //клик мышкой в меню

    private String img; //путь к картинке кнопки

    String[] list = new String[3]; //список из 3-х эл-ов типа строка - название кнопки

    public Menus() {
        x = 100; //задаём коор-ты
        y = 0;
        w = 396; // задаём высоту и ширину
        h = 100;
        n = 3;
        color = Color.BLACK; //задаём цвет шрифта(черный)
        img = "image/but1.png"; //указывает путь к "текстуре" кнопки

        list[0] = "Начать игру"; //задаем каждой ячейки листа(кнопке) название
        list[1] = "Информация об игре";
        list[2] = "Выход";
    }
    //создаем гетеры//
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getW() {
        return w;
}
    public double getH() {
        return h;
    }

    public void update() {

    }

    //отрисуем страницу меню//
    public void draw(Graphics2D g) {

        for (int i = 0; i < n; i++) {
            g.drawImage(new ImageIcon(img).getImage(), (int) (x + 640), (int) (y + 200) * i, null); //отрисовываем кнопки по коор-там

            g.setColor(color); //задаем цвет объекту color
            Font font = new Font("Arial", Font.TRUETYPE_FONT, 40); //задаём шрифт, указав при этом тип и размер
            g.setFont(font); //устанавливаем шрифт

            long length = (int) g.getFontMetrics().getStringBounds(list[i], g).getWidth(); //длина надписи
            g.drawString(list[i], (int) ((x + 640) + w / 2) - (length / 3), (int) ((y + 200) * i + (h / 3) * 2)); //помещаем надпись в центр текстуры кнопки
        }
    }
}
