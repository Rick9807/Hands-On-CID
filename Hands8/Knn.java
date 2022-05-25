package Hands8;

import java.util.Arrays;

import javax.swing.JOptionPane;

import Hands8.Data;

public class Knn {
    Data data;
    double distances[][];
    double x[][];
    String y[];
    // double a[] = { 4.2, 2.7 };
    // Bandera que nos permite seguir ciclando en caso de empate, siempre y cuando k
    // sea menor a y.length.
    boolean banderaAux;

    public Knn() {
        data = new Data();
        x = data.getX();
        y = data.getY();
        distances = new double[data.getY().length][2];
        banderaAux = true;
    }

    // Calcular todas las distancia en base a la dupla recibida.
    public void calculateDistances(double dupla[]) {
        double aux;

        for (int i = 0; i < y.length; i++) {
            // aux = 0;
            aux = Math.sqrt(Math.pow((dupla[0] - x[i][0]), 2) + Math.pow((dupla[1] - x[i][1]), 2));
            distances[i][0] = i;
            distances[i][1] = aux;
        }
        rank();
    }

    // Regresa una matriz. La primera columna son los Id's originales de Y,
    // mientras que la segunda, la distancia. La matriz esta ordenada
    // de menor a mayor, según las medidas.
    public void rank() {
        double tmp[][] = new double[distances.length][2];

        // Metodo burbuja
        for (int i = 0; i < y.length; i++) {
            for (int j = 0; j < y.length - 1; j++) {
                if (distances[j][1] > distances[j + 1][1]) {
                    tmp[j][0] = distances[j + 1][0];
                    tmp[j][1] = distances[j + 1][1];

                    distances[j + 1][0] = distances[j][0];
                    distances[j + 1][1] = distances[j][1];

                    distances[j][0] = tmp[j][0];
                    distances[j][1] = tmp[j][1];
                }
            }
        }
    }

    // Función que posiciona la dupla en su ubicación correcta.
    public void selectHigher(int k) {
        String types[] = setTypes();
        // Conteo de cuantas veces se repite cada tipo.
        int count[] = new int[types.length];
        int indiceFinal = 0;

        if (k == 1) {
            System.out.println("La dupla pertenece a:   " + y[(int) distances[0][0]]);
            // for(int j = 0; j < y.length; j++){
            // System.out.println(y[j]);
            // }
        } else {
            for (int i = 0; i < k; i++) {
                // Si k == 1, entonces la a distancia más cercana será la real.
                for (int j = 0; j < types.length; j++) {
                    if (y[(int) distances[i][0]] == types[j]) {
                        count[j]++;
                    }
                }
            }

            System.out.println("_____________________________________________________________________");

            for (int i = 0; i < count.length; i++) {
                System.out.println(types[i] + "  " + count[i]);
            }

            // Si k > 1, se hace un conteo de los tipos, a ver cual es el mayor.

            for (int i = 0; i < count.length - 1; i++) {
                if (count[i] < count[i + 1]) {
                    indiceFinal = i + 1;
                }
            }

            if (isDraw(count, indiceFinal) && banderaAux) {
                if (k + 1 > y.length) {
                    JOptionPane.showMessageDialog(null,
                            "La K excedio el tamaño de las duplas, no se puede continuar y el resultado no será satisfactorio.");
                    banderaAux = false;
                } else {
                    k++;
                    JOptionPane.showMessageDialog(null,
                            "Se encontró un empate, se le sumo +1 a tu k para obtener mejores resultados.");
                }
                selectHigher(k);
            } else {
                System.out.println("La dupla pertenece a:   " + types[indiceFinal]);
                // System.out.println(indiceFinal);
            }

        }

    }

    public boolean isDraw(int count[], int iFinal) {
        for (int i = 0; i < count.length; i++) {
            if (count[iFinal] == count[i] && iFinal != i) {
                return true;
            }
        }
        return false;
    }

    // Se eliminan datos repetidos de Y, pero en una copia.
    public String[] setTypes() {
        // double types[][] = new double[y.length][2];
        String aux[] = new String[15];
        String[] result = new String[3];

        System.arraycopy(y, 0, aux, 0, y.length);

        Arrays.sort(aux);

        int j = 0;
        for (int i = 0; i < y.length - 1; i++) {
            if (aux[i] != aux[i + 1]) {
                result[j++] = aux[i];
            }
            result[j] = aux[i + 1];
        }

        // for(int i = 0; i < result.length; i++){
        // System.out.println(result[i]);
        // }

        // for(int i = 0; i < y.length; i++){
        // types[i][0] = y[i];
        // types[i][1] = 0;
        // }

        return result;
    }

    public double[][] getDistances() {
        return distances;
    }
}
