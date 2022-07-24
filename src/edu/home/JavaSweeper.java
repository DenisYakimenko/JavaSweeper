package edu.home;

import javax.swing.*;

public class JavaSweeper extends JFrame {
    public static void main(String[] args) {
        new JavaSweeper().setVisible(true);

    }

    //конструктор закрытия программы
    public JavaSweeper (){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sweeper");
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);//запрет на изменение размера формы
        setSize(320,345);
    }
}
