package Hands2;

import handsOn.Hands2.SLR;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class SimpleLinealRegressionAgent extends Agent {
    protected void setup() {
        System.out.println("Agente " + getLocalName() + " iniciado.");
        addBehaviour(new GenericBehaviour());
    }

    private class GenericBehaviour extends Behaviour {
        Object[] args = getArguments();
        SLR slr = new SLR();
        float X = Float.parseFloat(args[0].toString());
        float b0 = slr.getB0();
        float b1 = slr.getB1();
        float rel = slr.predict(X);

        public void action() {
            System.out.println("B0 = " + b0 + "\nB1 = " + b1);
            System.out.println("F(x) = y = " + rel);
            System.out.println(slr.displayFormula());
            System.out.println("F(" + args[0] + ") = " + rel);
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