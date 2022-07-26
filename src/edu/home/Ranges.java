package edu.home;

public class Ranges //класс задающий размеры поля
{
    private static Coord size;
    public static void setSize(Coord _size){
        size = _size;
    }

    public static Coord getSize(){
        return  size;

    }
}
