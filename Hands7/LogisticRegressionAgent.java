package Hands7;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class LogisticRegressionAgent extends Agent {
    Data data = new Data();
    GradienteDesc gradiente = new GradienteDesc();

    protected void setup() {
        System.out.println("Agent " + getLocalName() + " started.");
        addBehaviour(new MyGenericBehaviour());
    }

    private class MyGenericBehaviour extends Behaviour {
        int i = 0;
        double w [] = gradiente.getW();


        public void action() {
            System.out.println("Vuelta: " + i);
            System.out.println("W-0:  " + w[0]);
            System.out.println("W-1:  " + w[1]);
            System.out.println("W-2:  " + w[2]);
            gradiente.calculateW();
            i++;
        }

        public boolean done() {
            if( gradiente.checkW() ){
                return true;
            }
            else {
                return false;
            }
        }

        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        }
    } // END of inner class ...Behaviour
}
