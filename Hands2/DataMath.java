package handsOn.Hands2;

public class DataMath {
    float x[];
    float y[];
    float sumX = 0;
    float sumY = 0;
    float sumXY = 0;
    float sumXpow2 = 0;
    Data data = new Data();

    public DataMath() {
        x = data.getX();
        y = data.getY();

        for (int i = 0; i < x.length; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXpow2 += x[i] * x[i];
            sumXY += x[i] * y[i];
        }
    }

    public float getSumX() {
        return sumX;
    }

    public float getSumY() {
        return sumY;
    }

    public float getSumXY() {
        return sumXY;
    }

    public float getSumXpow2() {
        return sumXpow2;
    }

    public float getSumXprom() {
        float sumXprom = sumX / x.length;
        return sumXprom;
    }

    public float getSumYprom() {
        float sumYprom = sumY / y.length;
        return sumYprom;
    }
}
