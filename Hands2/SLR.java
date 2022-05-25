package handsOn.Hands2;

public class SLR {
    float B0;
    float B1;
    Data data = new Data();
    DataMath dataMath = new DataMath();

    public float getB0() {
        B0 = ((data.getX().length * dataMath.getSumXY()) - (dataMath.getSumX() * dataMath.getSumY()))
                /
                ((data.getX().length * dataMath.getSumXpow2()) - (dataMath.getSumX() * dataMath.getSumX()));
        return B0;
    }

    public float getB1() {
        B1 = dataMath.getSumYprom() - (B0 * dataMath.getSumXprom());
        return B1;
    }

    public float predict(float x) {
        float yHat = B1 + (B0 * x);
        return yHat;
    }

    public String displayFormula() {
        return ("y(with hat) = " + B1 + " + (" + B0 + " * xi)");
    }
}
