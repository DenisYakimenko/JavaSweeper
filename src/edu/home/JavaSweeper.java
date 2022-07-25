package edu.home;

import javax.swing.*;
import java.awt.*;


public class JavaSweeper extends JFrame {

    private final int COLS =15;
    private final int ROWS = 1;
    private final int IMAGE_SIZE = 50;//обозначили константой размер картинки
    private JPanel panel;
    public static void main(String[] args) {
        new JavaSweeper();

    }

    //конструктор закрытия программы
    private JavaSweeper (){

        setImages();
        initPanel();
        initFrame();
    }



    private void initPanel() {
        panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for(Box box: Box.values())// values перебирает все enum

                g.drawImage(box.image,
                        box.ordinal()*IMAGE_SIZE,0,this);//ordinal координата текущего объекта

            }
        };
        panel.setPreferredSize(new Dimension(
                COLS*IMAGE_SIZE,
                ROWS*IMAGE_SIZE));
        add(panel);
    }

    private void initFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sweeper");
        setVisible(true);
        setResizable(false);//запрет на изменение размера формы
        pack();//заставляет сработать panel.setPreferredSize (new Dimension(500,300))
        setLocationRelativeTo(null);
    }

    private void setImages(){
        for(Box box:Box.values()) //к каждому боксу присвоили картинку
            box.image = getImage(box.name().toLowerCase());
    }

    //метод ппоказывающий картинку
    private Image getImage(String name){
     ImageIcon icon = new ImageIcon("res/img/"+name+".png");
     return icon.getImage();
    }
}
