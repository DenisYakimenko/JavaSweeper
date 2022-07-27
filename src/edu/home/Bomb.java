package edu.home;

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
        bombMap.set(new Coord(4,4),Box.BOMB);
    }
}
