package Hands5;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class GradienteAgent extends Agent {
  Data data = new Data();
  Gradiente gradiente = new Gradiente();

  protected void setup() {
    System.out.println("Agent " + getLocalName() + " started.");
    addBehaviour(new MyGenericBehaviour());
  }

  private class MyGenericBehaviour extends Behaviour {

    public void action() {
      gradiente.calculateB();
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
