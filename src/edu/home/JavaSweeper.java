package edu.home;

import javax.swing.*;
import java.awt.*;



public class JavaSweeper extends JFrame {

    private final int COLS =9;
    private final int ROWS = 9;
    private final int IMAGE_SIZE = 50;//обозначили константой размер картинки
    private JPanel panel;
    public static void main(String[] args) {
        new JavaSweeper();

    }

    //конструктор закрытия программы
    private JavaSweeper (){

        Ranges.setSize(new Coord(COLS, ROWS));
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
                {

                  //  g.drawImage((Image) Box.BOMB.image,
                    g.drawImage((Image) Box.values()[(coord.x+coord.y) % Box.values().length].image,
                            coord.x*IMAGE_SIZE, coord.y*IMAGE_SIZE, this);//ordinal координата текущего объекта

                }
            }
        };
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
        pack();//заставляет сработать panel.setPreferredSize (new Dimension(500,300))
        setLocationRelativeTo(null);
        setIconImage(getImage("icon"));
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
