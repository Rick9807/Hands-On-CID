package handsOn.Hands4;

import java.util.Arrays;

public class Matrix {
    double x[][];
    double y[];
    double xT[][];
    double xTx[][];
    double xTy[];
    double xTxInv[][];

    Data data = new Data();

    public Matrix() {
        x = data.getX();
        y = data.getY();
    }

    public double[][] transpose(double m[][]) {
        xT = new double[x[0].length][x.length];

        for (int a = 0; a < m.length; a++) {
            for (int b = 0; b < m[a].length; b++) {
                xT[b][a] = x[a][b];
            }
        }

        return xT;
    }

    public double[][] productMatrix(double m1[][], double m2[][]) {
        xTx = new double[m2[0].length][m1.length];
        double sum = 0;

        if (m2[0].length == m1.length) {
            for (int a = 0; a < m2[0].length; a++) {
                for (int i = 0; i < m1.length; i++) {
                    sum = 0;
                    for (int j = 0; j < m1[0].length; j++) {
                        sum += m1[i][j] * m2[j][a];
                    }
                    xTx[a][i] = sum;
                }
            }
        }
        return xTx;
    }

    public double[] productMatrixVector(double m[][], double v[]) {
        xTy = new double[xT.length];
        double sum = 0;

        for (int a = 0; a < m.length; a++) {
            sum = 0;
            for (int j = 0; j < v.length; j++) {
                sum += m[a][j] * v[j];
            }
            xTy[a] = sum;
        }
        return xTy;
    }

    public double[][] getXTxInv(double m[][]) {
        double auxM[][] = new double[3][3];
        double M[][] = new double[3][3];
        double inv[][] = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
        double auxInv[][] = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
        double x;
        int cont = 0;

        for (int a = 0; a < m.length; a++) {
            for (int b = 0; b < m[a].length; b++) {
                auxM[a][b] = m[a][b];
            }
        }
        for (int a = 0; a < m.length; a++) {
            for (int b = 0; b < m[a].length; b++) {
                M[a][b] = m[a][b];
            }
        }

        for (int i = 0; i < m.length; i++) {
            System.out.println("\n\nVuelta de I   =" + i);

            cont = 0;
            System.out.println("aver  =" + M[i][i]);
            for (int j = 0; j < auxM.length; j++) {

                if ((j + i) < auxM.length) {
                    x = M[i][j + i];
                    System.out.println("\nX  =" + x + "    Valor de j = " + j);
                    if (j == 0) {
                        for (cont = 0; cont < 6; cont++) {
                            if (cont < 3) {
                                auxM[i][cont] = auxM[i][cont] / x;
                                System.out.println("M[" + i + "][" + cont + "]  =" + auxM[i][cont]);
                            } else {
                                auxInv[i][cont - 3] = auxInv[i][cont - 3] / x;
                                System.out.println("Inv[" + i + "][" + (cont - 3) + "]  =" + auxInv[i][cont - 3]);
                            }
                        }
                    } else {
                        System.out.println("INVERSA P2 ");
                        for (cont = 0; cont < 6; cont++) {
                            if (cont < 3) {
                                for (int a = 0; a < auxM.length; a++) {
                                    System.out.print("\n");
                                    for (int b = 0; b < auxM.length; b++) {
                                        System.out.print(auxM[a][b] + "\t");
                                    }
                                }

                                System.out.println("\nauxM[" + i + "][" + i + "]  =" + auxM[i][i]);
                                System.out.println("auxM[" + (j + i) + "][" + cont + "]  =" + auxM[j + i][cont]);
                                System.out.println("X =" + x);
                                System.out.println("auxM[" + j + "][" + cont + "]  =" + auxM[j][cont]);

                                auxM[j + i][cont] = (auxM[i][i] * M[j + i][cont]) - (x * auxM[i][cont]);
                                System.out.println("M[" + (j + i) + "][" + cont + "]  =" + auxM[j + i][cont]);

                            } else {
                                System.out.println("\nauxM[" + i + "][" + i + "]  =" + auxM[i][i]);
                                System.out.println(
                                        "auxInv[" + (j + i) + "][" + (cont - 3) + "]  =" + auxInv[j + i][cont - 3]);
                                System.out.println("X =" + x);
                                System.out.println("Inv[" + i + "][" + (cont - 3) + "]  =" + auxInv[i][cont - 3]);
                                auxInv[j + i][cont - 3] = (auxM[i][i] * auxInv[j + i][cont - 3])
                                        - (x * auxInv[i][cont - 3]);
                                System.out
                                        .println("Inv[" + (j + i) + "][" + (cont - 3) + "]  ="
                                                + auxInv[j + i][cont - 3]);
                            }
                        }
                    }
                }

            }
            cont++;
            for (int a = 0; a < m.length; a++) {
                for (int b = 0; b < m[a].length; b++) {
                    M[a][b] = auxM[a][b];
                }
            }
            for (int a = 0; a < m.length; a++) {
                for (int b = 0; b < m[a].length; b++) {
                    inv[a][b] = auxInv[a][b];
                }
            }
        }

        // La vuelta de regreso
        for (int i = m.length - 1; i > 0; i--) {
            System.out.println("\n\n\n\n\n\n\nVuelta de I   =" + i);

            cont = 0;
            System.out.println("aver  =" + M[i][i]);
            for (int j = m.length - 1; j >= 0; j--) {

                if ((j - 1) >= 0) {
                    x = M[j - 1][i];
                    if (x != 1) {
                        System.out.println("\nX  =" + x + "    Valor de j = " + j);

                        System.out.println("INVERSA P2 ");
                        for (cont = (m.length * 2) - 1; cont >= 0; cont--) {
                            if (cont < 3) {
                                for (int a = 0; a < auxM.length; a++) {
                                    System.out.print("\n");
                                    for (int b = 0; b < auxM.length; b++) {
                                        System.out.print(auxM[a][b] + "\t");
                                    }
                                }
                                System.out.println("\nauxM[" + i + "][" + i + "]  =" + auxM[i][i]);
                                System.out.println("auxM[" + (j - 1) + "][" + cont + "]  =" + M[j - 1][cont]);
                                System.out.println("X =" + x);
                                System.out.println("auxM[" + i + "][" + cont + "]  =" + auxM[i][cont]);

                                auxM[j - 1][cont] = (auxM[i][i] * M[j - 1][cont]) - (x * auxM[i][cont]);
                                System.out.println("\nM[" + (j - 1) + "][" + cont + "]  =" + auxM[j - 1][cont]);
                            } else {
                                for (int a = 0; a < auxM.length; a++) {
                                    System.out.print("\n");
                                    for (int b = 0; b < auxM.length; b++) {
                                        System.out.print(auxInv[a][b] + "\t");
                                    }
                                }

                                System.out.println("\nESTOOO\nauxM[" + i + "][" + i + "]  =" + auxM[i][i]);
                                System.out.println(
                                        "Inv[" + (j - 1) + "][" + (cont - 3) + "]  =" + inv[j - 1][cont - 3]);
                                System.out.println("X =" + x);
                                System.out.println("Inv[" + i + "][" + (cont - 3) + "]  =" + inv[i][cont - 3]);

                                auxInv[j - 1][cont - 3] = (auxM[i][i] * auxInv[j - 1][cont - 3])
                                        - (x * auxInv[i][cont - 3]);
                                System.out.println(
                                        "\nauxInv[" + (j - 1) + "][" + (cont - 3) + "]  =" + auxInv[j - 1][cont - 3]);

                            }
                        }
                    }
                }
            }
            cont++;
            for (int a = 0; a < m.length; a++) {
                for (int b = 0; b < m[a].length; b++) {
                    M[a][b] = auxM[a][b];
                }
            }
            for (int a = 0; a < m.length; a++) {
                for (int b = 0; b < m[a].length; b++) {
                    inv[a][b] = auxInv[a][b];
                }
            }
            // inv = auxInv;
        }

        xTxInv = auxInv;
        return auxInv;
    }

    public double[] getB() {
        double result[] = new double[3];
        double sum = 0;

        for (int i = 0; i < xTxInv.length; i++) {
            sum = 0;
            for (int j = 0; j < xTy.length; j++) {
                sum += xTxInv[i][j] * xTy[j];
            }
            result[i] = sum;
        }

        return result;
    }
}