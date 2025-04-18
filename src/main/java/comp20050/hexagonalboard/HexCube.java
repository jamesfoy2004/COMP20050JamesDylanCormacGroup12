package comp20050.hexagonalboard;

import java.util.ArrayList;

class HexCube
{

    public static final int UNCOLOURED = 0;
    public static final int BLUE = 1;
    public static final int RED = 2;

    public HexCube(int q, int r, int s, int colour)
    {
        this.q = q;
        this.r = r;
        this.s = s;
        if (q + r + s != 0)
            throw new IllegalArgumentException("q + r + s must be 0");
        if (colour != UNCOLOURED && colour != BLUE && colour != RED)
            throw new IllegalArgumentException("Invalid color value");
        this.colour = colour;
    }

    public final int q;
    public final int r;
    public final int s;
    private int colour;

    public int getColour(){
        return colour;
    }

    public void setColour(int colour){
        if (colour != UNCOLOURED && colour != BLUE && colour != RED)
            throw new IllegalArgumentException("Invalid color value");
        this.colour = colour;
    }

    public HexCube add(HexCube b)
    {
        return new HexCube(q + b.q, r + b.r, s + b.s, this.colour);
    }

    public HexCube subtract(HexCube b)
    {
        return new HexCube(q - b.q, r - b.r, s - b.s, this.colour);
    }

    static public ArrayList<HexCube> directions = new ArrayList<HexCube>(){{add(new HexCube(1, 0, -1, UNCOLOURED)); add(new HexCube(1, -1, 0, UNCOLOURED)); add(new HexCube(0, -1, 1, UNCOLOURED)); add(new HexCube(-1, 0, 1,UNCOLOURED)); add(new HexCube(-1, 1, 0,UNCOLOURED)); add(new HexCube(0, 1, -1,UNCOLOURED));}};

    static public HexCube direction(int direction)
    {
        return HexCube.directions.get(direction);
    }

    public HexCube neighbor(int direction)
    {
        return add(HexCube.direction(direction));
    }

    public int length()
    {
        return (int)((Math.abs(q) + Math.abs(r) + Math.abs(s)) / 2);
    }

    public int distance(HexCube b)
    {
        return subtract(b).length();
    }
}

