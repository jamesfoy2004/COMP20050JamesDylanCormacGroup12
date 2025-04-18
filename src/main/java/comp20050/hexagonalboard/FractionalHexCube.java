package comp20050.hexagonalboard;

import java.util.List;

class FractionalHexCube
{
    public FractionalHexCube(double q, double r, double s)
    {
        this.q = q;
        this.r = r;
        this.s = s;
        if (Math.round(q + r + s) != 0)
            throw new IllegalArgumentException("q + r + s must be 0");
    }

    public final double q;
    public final double r;
    public final double s;

    public HexCube hexRound(List<HexCube> hexcubes) {

        int qi = (int) (Math.round(q));
        int ri = (int) (Math.round(r));
        int si = (int) (Math.round(s));
        double q_diff = Math.abs(qi - q);
        double r_diff = Math.abs(ri - r);
        double s_diff = Math.abs(si - s);
        if (q_diff > r_diff && q_diff > s_diff) {
            qi = -ri - si;
        } else if (r_diff > s_diff) {
            ri = -qi - si;
        } else {
            si = -qi - ri;
        }

        for (HexCube cube : hexcubes) {
            if (cube.q == qi && cube.r == ri && cube.s == si) {
                return cube;
            }
        }

        throw new IllegalArgumentException("No HexCube found for coordinates (" + qi + ", " + ri + ", " + si + ")");
    }

}