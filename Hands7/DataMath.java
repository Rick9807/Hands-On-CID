package Hands7;

public class DataMath {
    double x[][];
    double y[];
    Data data = new Data();
    int length;
    //GradienteDesc gradiente = new GradienteDesc();

    public DataMath () {
        x = data.getX();
        y = data.getY();
        length = data.getY().length;
    }


    // wj = wj - alfa*          SUM( f(xi) - yi ) xij
   
}
