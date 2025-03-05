package br.edu.ifba.inf011.model.provaIII.chainOfResponsability;

import java.time.LocalDate;

import br.edu.ifba.inf011.model.evento.Evento;

public class RegraMediaPrioridade extends AbstractRegraHandler {

  public RegraMediaPrioridade(RegraHandler next) {
    super(next);
  }

  public RegraMediaPrioridade() {
    super();
  }

  @Override
  public void verificarRegra(Evento e) throws Exception {
    if (e.getPrioridade() >= 5 && e.iniciaEm(LocalDate.now())){
      return;
    }
    throw new Exception();
  }

  @Override
  public String formatarMensagem(Evento e) {
    return formatarMensagemParaEmail(e);
  }

  @Override
  public void enviarMensagem(String mensagemFormatada) {
    enviandoMensagemEmail(mensagemFormatada);
  }

  @Override
  public void adicionarAoCalendario(String mensagemFormatada) {
    adicionandoEventoAoGoogleCalendar(mensagemFormatada);
  }
}