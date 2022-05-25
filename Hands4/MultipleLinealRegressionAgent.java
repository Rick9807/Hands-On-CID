package Hands4;

import javax.swing.JOptionPane;

import handsOn.Hands4.Data;
import handsOn.Hands4.Matrix;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class MultipleLinealRegressionAgent extends Agent {
    Data data = new Data();
    Matrix matrix = new Matrix();

    protected void setup() {
        System.out.println("Agente " + getLocalName() + " iniciado.");
        addBehaviour(new GenericBehaviour());
    }

    private class GenericBehaviour extends Behaviour {

        public void action() {
            double x[][] = data.getX();
            double y[] = data.getY();
            double xT[][] = matrix.transpose(x);
            double xTx[][] = matrix.productMatrix(xT, x);
            double xTy[] = matrix.productMatrixVector(xT, y);
            double xTxInv[][] = matrix.getXTxInv(matrix.productMatrix(xT, x));
            double result[] = matrix.getB();

            System.out.println("Holiwis  Action   " + getLocalName());
            System.out.print("\n \n \n");

            System.out.print("Matriz X\n");
            for (int a = 0; a < x.length; a++) {
                System.out.print("\n");
                for (int b = 0; b < x[a].length; b++) {
                    System.out.print(x[a][b] + "\t");
                }
            }
            System.out.print("\n \n \n");

            System.out.print("Matriz Y\n");
            for (int a = 0; a < x.length; a++) {
                System.out.print(y[a] + "\n");
            }
            System.out.print("\n \n \n");

            System.out.print("Matriz Transpuesta de X\n");
            for (int a = 0; a < xT.length; a++) {
                System.out.print("\n");
                for (int b = 0; b < xT[0].length; b++) {
                    System.out.print(xT[a][b] + "\t");
                }
            }
            System.out.print("\n \n \n");

            System.out.print("Producto de XT * X");
            for (int a = 0; a < x[0].length; a++) {
                System.out.print("\n");
                for (int b = 0; b < xT.length; b++) {
                    System.out.print(xTx[a][b] + "\t");
                }
            }
            System.out.print("\n \n \n");

            System.out.print("Prudcto de XT * Y");
            for (int a = 0; a < x[0].length; a++) {
                System.out.print("\n");
                System.out.print(xTy[a] + "\t");
            }
            System.out.print("\n \n \n");

            for (int a = 0; a < xTxInv.length; a++) {
                System.out.print("\n");
                for (int b = 0; b < xTxInv.length; b++) {
                    System.out.print(xTxInv[a][b] + "\t");
                }
            }
            System.out.print("\n \n \n");

            System.out.print(xTxInv.length);
            System.out.print(xTy.length);
            for (int a = 0; a < xTxInv[0].length; a++) {
                System.out.print("\n");
                System.out.print(result[a] + "\t");
            }
            System.out.print("\n \n \n");
        }

        public boolean done() {
            return true;
        }

        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        }
    }
}