package br.edu.ifba.inf011.model.provaIII.chainOfResponsability;

import java.time.LocalDate;

import br.edu.ifba.inf011.model.evento.Evento;

public class RegraAltaPrioridade extends AbstractRegraHandler {

  public RegraAltaPrioridade(RegraHandler next) {
    super(next);
  }

  public RegraAltaPrioridade() {
    super();
  }

  @Override
  public void verificarRegra(Evento e) throws Exception {
    if (e.getPrioridade() == 10 && e.iniciaEm(LocalDate.now())) {
      return;
    }
    throw new Exception();
  }

  @Override
  public String formatarMensagem(Evento e) {
    return formatarMensagemParaWhatsApp(e);
  }

  @Override
  public void adicionarAoCalendario(String mensagemFormatada) {
    adicionandoEventoAoGoogleCalendar(mensagemFormatada);
  }

  @Override
  public void enviarMensagem(String mensagemFormatada) {
    enviandoMensagemEmail(mensagemFormatada);
    enviandoMensagemWhatsApp(mensagemFormatada);
  }
}
