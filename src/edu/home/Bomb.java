package edu.home;

import java.util.Random;

class Bomb
{
    private Matrix bombMap;
    private int totalBombs;

    Bomb(int totalBombs)
    {
        this.totalBombs = totalBombs;
    }

    void start()
    {
        bombMap = new Matrix(Box.ZERO);
        placeBomb();
    }

    Box get (Coord coord) //узнаем что находится в клектке
    {
        return bombMap.get(coord);
    }

    private void placeBomb()
    {
        Coord coord = Ranges.getRandomCoord();
        bombMap.set(coord,Box.BOMB);
    }
}
