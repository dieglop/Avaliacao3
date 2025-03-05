package br.edu.ifba.inf011.model.provaIII.chainOfResponsability;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import br.edu.ifba.inf011.model.evento.Evento;

public class RegraBaixaPrioridade extends AbstractRegraHandler {

  public RegraBaixaPrioridade(RegraHandler next) {
    super(next);
  }

  public RegraBaixaPrioridade() {
    super();
  }

  @Override
  public void verificarRegra(Evento e) throws Exception {
    if (e.getPrioridade() >= 1 && e.getPrioridade() < 5
        && e.iniciaEntre(LocalDateTime.now().minus(2, ChronoUnit.DAYS), LocalDateTime.now())){
      return;
    }
    throw new Exception();
  }

  @Override
  public String formatarMensagem(Evento e) {
    return formatarMensagemParaEmail(e);
   }

  @Override
  public void adicionarAoCalendario(String mensagemFormatada) {
    adicionandoEventoAoGoogleCalendar(mensagemFormatada);
  }

  @Override
  public void enviarMensagem(String mensagemFormatada) {}

}