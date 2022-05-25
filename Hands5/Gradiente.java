package Hands5;

import java.math.BigDecimal;

import Hands5.Data;

public class Gradiente {
    double b0;
    double b1;
    double alfa;
    double length;
    Data data;
    double y[];
    double x[];
    double optimalError;

    public Gradiente() {
        data = new Data();
        b0 = 0;
        b1 = 0;
        alfa = 0.00051;
        y = data.getY();
        x = data.getX();
        optimalError = 0.0001;
        length = x.length;
    }


    public void calculateB() {
        double b0_gradient;
        double b1_gradient;
        
        for (int i = 0; i < 400000; i++) {
            b0_gradient = 0;
            b1_gradient = 0;
            int j = 0;

            for (j = 0; j < length; j++) {
                b0_gradient -= (2 / length) * (y[j] - (b0 + b1 * x[j]));
                b1_gradient -= (2 / length) * (y[j] - (b0 + b1 * x[j])) * x[j];
            }

            b0 = b0 - (alfa * b0_gradient);
            b1 = b1 - (alfa * b1_gradient);

            if (Math.max(Math.abs(alfa * b0_gradient), Math.abs(alfa * b1_gradient)) < optimalError){
                break;
            }

        }
        System.out.println("B0 =  " + b0);
        System.out.println("B1 =  " + b1);

    }


}
