package br.edu.ifba.inf011.model.provaIII;

import br.edu.ifba.inf011.model.evento.Evento;
import br.edu.ifba.inf011.model.provaIII.chainOfResponsability.RegraHandler;

public class Notificador {

  private RegraHandler regra;

  public Notificador(RegraHandler regra) {
    this.regra = regra;
  }

  public void notificar(Evento e) {
    regra.processar(e);
  }

}