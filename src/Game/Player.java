package Game;

import javax.swing.*;
import java.awt.*;

public class Player {
    int[][] field = new int[15][15];

    private int x;
    private int y;
    private int w;
    private int h;
    private int countPass = 0;

    private String imgW = "image/white.png";
    private String imgB = "image/black.png";
    private String turnB = "Ход Черных";;
    private String turnW = "Ход Белых";;

    int turnWorB = 0; //переменная, определяющая порядок ходов, при четном значении - Ход Черных, иначе - Белых

    public static boolean click = false;
    public static boolean firstTurn = false;


    public Player() {
        x = 105;
        y = 60;
        h = 396;
        w = 100;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getW() { //не юзаю, убрать при финальной проверки!!!!!!!!
        return w;
    }
    public int getH() {
        return h;
    }

    public void drawCircle(Graphics2D g, int  x, int y) {
        g.setColor(Color.BLACK);
        g.fillOval(x,y,35,35);
    }

    public void fieldDraw(Graphics2D g, int[][] field) {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (field[i][j] == 1) {
                    g.drawImage(new ImageIcon(imgB).getImage(), i * 53 + 73, j * 53 + 20, null); //ставим картинку черной шашки в указаную позицию
                } else if (field[i][j] == 2) {
                    g.drawImage(new ImageIcon(imgW).getImage(), i * 53 + 73, j * 53 + 20, null);
                }
            }
        }

        if (turnWorB % 2 == 0) {
            inscriptions(g, turnWorB, turnB, 0);
        } else {
            inscriptions(g, turnWorB, turnW, 0);
        }
    }

    public void inscriptions(Graphics2D g, int turnWorB, String str, int d) {
        Font font = new Font("Arial", Font.TRUETYPE_FONT, 40); //задаём шрифт, указав при этом тип и размер
        g.setFont(font); //устанавливаем шрифт

        long length = (int) g.getFontMetrics().getStringBounds(str, g).getWidth(); //длина надписи
        //помещаем надпись в центр текстуры кнопки
        if (turnWorB % 2 == 0) {
            g.setColor(Color.BLACK);
        } else {
            g.setColor(Color.WHITE);
        }
        g.drawString(str, ((x + 900) + w / 2) - (length / 3), ((h / 3 + d))); //помещаем надпись в центр текстуры кнопки
    }

    public void turnPlayer(Graphics2D g, int x, int y, int n, int m) {

        if (turnWorB % 2 == 0) {
            if (field[n][m] == 0) {
                field[n][m] = 1;
                g.drawImage(new ImageIcon(imgB).getImage(), x, y, null);
                turnWorB++;
            }
        } else {
            if (field[n][m] == 0) {
                field[n][m] = 2;
                g.drawImage(new ImageIcon(imgW).getImage(), x, y, null);
                turnWorB++;
            }
        }
    }

    public void pass(Graphics2D g) {
        if (turnWorB > 1) {
            turnWorB++;
            System.out.println("PASS BILL");
            Player.click = false;
        }
    }

    private boolean checkLines(int s,int block, int blockX, int blockY) {
        boolean rightDio = true;
        boolean leftDio = true;
        for (int i = 0; i < blockX + block; i++) {
            boolean hor = true;
            boolean ver = true;
            for (int j = 0; j < blockY + block; j++) {
                rightDio &= (field[i][i] == s);
                leftDio &= (field[i][i] == s);
                hor &= (field[i][j] == s);
                ver &= (field[j][i] == s);
            }
            if (hor || ver) return true;
        }
        
        if (leftDio || rightDio) return true;
        return false;
    }
    
    public boolean win(int s) {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                if (checkLines(s,5,i,j)) return true;
            }
        }
        return false;
    }
}
