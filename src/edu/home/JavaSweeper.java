package edu.home;

import javax.swing.*;
import java.awt.*;

public class JavaSweeper extends JFrame {

    JPanel panel;
    public static void main(String[] args) {
        new JavaSweeper();

    }

    //конструктор закрытия программы
    public JavaSweeper (){

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(500,300));
        add(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sweeper");
        setVisible(true);
        setResizable(false);//запрет на изменение размера формы
        pack();//заставляет сработать panel.setPreferredSize (new Dimension(500,300))
        setLocationRelativeTo(null);
    }
}
