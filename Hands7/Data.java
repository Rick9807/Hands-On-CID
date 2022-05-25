package Hands7;

public class Data {
    double x[][] = {
            { 1, 1, 1 },
            { 1, 4, 2 },
            { 1, 2, 4 }
    };

    // double x[][] = {
    //         { 780, 4, 3 },
    //         { 750, 3.9, 4 },
    //         { 690, 3.3, 3},
    //         { 710, 3.7, 5},
    //         { 680, 3.9, 4},
    //         { 730, 3.7, 6},
    //         { 690, 2.3, 1},
    //         { 720, 3.3, 4},
    //         { 740, 3.3, 5}
    // };
    
    double y[] = { 0, 1, 1 };

    // double y[] = { 1, 1, 0, 1, 0, 1, 0, 1, 1};

    public double[][] getX() {
        return x;
    }

    public double[] getY() {
        return y;
    }
}
