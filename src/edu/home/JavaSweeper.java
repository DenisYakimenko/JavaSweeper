package edu.home;

import javax.swing.*;
import java.awt.*;

public class JavaSweeper extends JFrame {

   private JPanel panel;
    public static void main(String[] args) {
        new JavaSweeper();

    }

    //конструктор закрытия программы
    private JavaSweeper (){

        initPanel();
        initFrame();
    }



    private void initPanel() {
        panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(getImage("bomb"),0,0,this);
                g.drawImage(getImage("num1"),50,0,this);
            }
        };
        panel.setPreferredSize(new Dimension(500,300));
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

    //метод ппоказывающий картинку
    private Image getImage(String name){
     ImageIcon icon = new ImageIcon("res/img/"+name+".png");
     return icon.getImage();
    }
}
