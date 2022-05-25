package Hands8;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class KnnAgent extends Agent {
    Data data = new Data();
    Knn knn = new Knn();
    double dupla[] = new double[2];

    protected void setup() {
        System.out.println("Agent " + getLocalName() + " started.");
        addBehaviour(new MyGenericBehaviour());
    }

    private class MyGenericBehaviour extends Behaviour {
        public void action() {
            int k = Integer.parseInt(JOptionPane.showInputDialog("Escribe la k:  "));
            dupla[0] = Double.parseDouble(JOptionPane.showInputDialog("Escribe x1:  "));
            dupla[1] = Double.parseDouble(JOptionPane.showInputDialog("Escribe x2:  "));

            System.out.println("K = " + k);

            if (k <= data.getY().length && k > 0) {
                knn.calculateDistances(dupla);
                double aux[][] = knn.getDistances();
                for (int i = 0; i < data.getY().length; i++) {
                    System.out.println(aux[i][0] + "   " + aux[i][1]);
                }
                knn.selectHigher(k);
                // knn.setTypes();
            } else {
                JOptionPane.showMessageDialog(null, "La k no debe ser mayor al número de duplas!");
            }

        }

        public boolean done() {
            return true;
        }

        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        }
    } // END of inner class ...Behaviour
}
