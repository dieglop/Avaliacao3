package br.edu.ifba.inf011.model.provaIII.chainOfResponsability;

import br.edu.ifba.inf011.model.evento.Evento;

public interface RegraHandler {
  public void setProximo(RegraHandler regra);
  public void verificarRegra(Evento e) throws Exception;
  public void processar(Evento e);
}
