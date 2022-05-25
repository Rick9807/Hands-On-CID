package Hands8;

public class Data {
    double x[][] = {
            { 5.3, 3.7 },
            { 5.1, 3.8 },
            { 7.2, 3.0 },
            { 5.4, 3.4 },
            { 5.1, 3.3 },
            { 5.4, 3.9 },
            { 7.4, 2.8 },
            { 6.1, 2.8 },
            { 7.3, 2.9 },
            { 6.0, 2.7 },
            { 5.8, 2.8 },
            { 6.3, 2.3 },
            { 5.1, 2.5 },
            { 6.3, 2.5 },
            { 5.5, 2.4 }
    };

    String[] y = {
            "Setosa",
            "Setosa",
            "Virginica",
            "Setosa",
            "Setosa",
            "Setosa",
            "Virginica",
            "Verscicolor",
            "Virginica",
            "Verscicolor",
            "Virginica",
            "Verscicolor",
            "Verscicolor",
            "Verscicolor",
            "Verscicolor",
    };

    public double[][] getX() {
        return x;
    }

    public String[] getY() {
        return y;
    }

}