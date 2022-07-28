package edu.home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//3.01.01

public class JavaSweeper extends JFrame {

    private Game game;
    private JPanel panel;
    private final int COLS =9;
    private final int ROWS = 9;
    private final int BOMBS = 10;
    private final int IMAGE_SIZE = 50;//обозначили константой размер картинки
    public static void main(String[] args) {
        new JavaSweeper();

    }

    //конструктор закрытия программы
    private JavaSweeper (){

        game = new Game(COLS,ROWS,BOMBS);
        game.start();
        setImages();
        initPanel();
        initFrame();
    }



    private void initPanel() {
        panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Coord coord:Ranges.getAllCoords())

                  //  g.drawImage((Image) Box.BOMB.image,
                    g.drawImage((Image) game.getBox(coord).image,
                            coord.x*IMAGE_SIZE, coord.y*IMAGE_SIZE, this);//ordinal координата текущего объекта

            }
        };
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX()/IMAGE_SIZE;
                int y = e.getY()/IMAGE_SIZE;
                Coord coord = new Coord(x,y);
                if (e.getButton()== MouseEvent.BUTTON1)//смотрит координаты мышки
                    game.pressLeftButton (coord);// срабатывает нажатие кнопки и открывает клетку
                if (e.getButton()== MouseEvent.BUTTON3)
                    game.pressRightButton (coord);
                if (e.getButton()== MouseEvent.BUTTON2)
                    game.start();
                panel.repaint();
            }
        });
        panel.setPreferredSize(new Dimension(
                Ranges.getSize().x *IMAGE_SIZE,
                Ranges.getSize().y *IMAGE_SIZE));
        add(panel);
    }

    private void initFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sweeper");
        setVisible(true);
        setResizable(false);//запрет на изменение размера формы
        setIconImage(getImage("icon"));
        pack();//заставляет сработать panel.setPreferredSize (new Dimension(500,300))
        setLocationRelativeTo(null);
    }

    private void setImages(){
        for(Box box:Box.values()) //к каждому боксу присвоили картинку
            box.image = getImage(box.name().toLowerCase());
    }

    //метод ппоказывающий картинку
    private Image getImage(String name){
      //  String filename = "img/"+name+".png"; //пометили папку res/img как корень ресурсов
        ImageIcon icon = new ImageIcon("res/img/"+name+".png");
        return icon.getImage();
    }
}
