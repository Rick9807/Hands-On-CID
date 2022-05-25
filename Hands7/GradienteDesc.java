package Hands7;

import java.math.BigDecimal;

public class GradienteDesc {
    Data data = new Data();
    double alfa;
    double w[] = new double[9];
    double wAux[]= new double[9];
    double x[][];
    double y[];
    int length;

    public GradienteDesc() {
        length = data.getY().length;
        for (int i = 0; i < length; i++) {
            w[i] = 0;
        }
        alfa = 0.1;
        x = data.getX();
        y = data.getY();
        System.arraycopy(w, 0, wAux, 0, w.length);
    }

    public double[] getW() {
        return w;
    }

    public void calculateW() {
        //double wAux[] = new double[3];
        System.arraycopy(w, 0, wAux, 0, w.length);
        for (int j = 0; j < length; j++) {
            double aux = sumFxiyixij(j);
            //System.out.println("Calculate W" + j);
            //System.out.println("W vieja:  " + wAux[j]);
            //System.out.println("alfa:   " + alfa);
            //System.out.println("Sumatoria:   " + aux);
            wAux[j] = wAux[j] - (alfa * (aux));
            //System.out.println("Resultado:   " + wAux[j]);
        }
        System.arraycopy(wAux, 0, w, 0, wAux.length);
    }

    public double sumFxiyixij(int j) {
        double result = 0;
        double aux = sigmoidFunction(j);
        for (int i = 0; i < data.getX()[0].length; i++) {
            
            //System.out.println("Sum Fcdkjhjhd   " + i);
            //System.out.println("f(xi)   " + y[i]);
            //System.out.println("yi   " + aux);
            //System.out.println("xij   " + x[i][j]);
            result += (aux - y[i]) * x[j][i];
            //System.out.println(result);
        }
        return result;
    }

    public double calculateY(int j) {
        double y = 0;
        for (int i = 0; i < data.getX()[0].length ; i++) {
            //System.out.println("W:   " + w[i]);
            //System.out.println("x[j][i]:   " + x[j][i]);
            y += w[j] * x[j][i];
        }
        //System.out.println("Y:   " + y);
        return y;
    }

    // 1 / (1 + e^-z)
    public double sigmoidFunction(int j) {
        double z = calculateY(j);
        //System.out.println("Sigmoid Function!!!!!!   " + z);
        double result = 1 / (1 + Math.pow(Math.E, -z));
        return result;
    }

    public double odds(int j) {
        double z = calculateY(j);
        //System.out.println("Sigmoid Function!!!!!!   " + z);
        double result = Math.pow(Math.E, -z) / (1 + Math.pow(Math.E, -z));
        return result;
    }

    public int oneOrZero(double value) {
        if (value <= 0.5) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean checkW(){
        double aux;
        double aux2;
        for(int i = 0; i < length; i++) {
            aux = odds(i);
            aux2 = oneOrZero(aux);
            if(aux2 != y[i]){
                return false;
            }
        }
        return true;
    }

}
