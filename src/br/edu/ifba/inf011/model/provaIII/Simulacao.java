package br.edu.ifba.inf011.model.provaIII;

import java.time.LocalDateTime;
import java.util.Collection;

import br.edu.ifba.inf011.model.Geolocalizacao;
import br.edu.ifba.inf011.model.evento.Evento;
import br.edu.ifba.inf011.model.evento.Lembrete;
import br.edu.ifba.inf011.model.fm.Aplicacao;
import br.edu.ifba.inf011.model.provaIII.chainOfResponsability.RegraAltaPrioridade;
import br.edu.ifba.inf011.model.provaIII.chainOfResponsability.RegraBaixaPrioridade;
import br.edu.ifba.inf011.model.provaIII.chainOfResponsability.RegraMediaPrioridade;
import br.edu.ifba.inf011.model.provaIII.chainOfResponsability.RegraHandler;

public class Simulacao {
  public static void main(String[] args) throws Exception {

      Aplicacao app = new Aplicacao();
      app.run();
      
      RegraHandler regrasHandler =  new RegraAltaPrioridade(
                                      new RegraMediaPrioridade(
                                        new RegraBaixaPrioridade()));

      Notificador notificador = new Notificador(regrasHandler);

      Collection<Evento> eventosHoje = app.today();

      notificador.notificar(new Lembrete("evento personalizado criado agora", LocalDateTime.now(), LocalDateTime.now().plusHours(2l), 10, Geolocalizacao.here()));
      /*for (Evento evento : eventosHoje) {
        notificador.notificar(evento);
      }*/
  }
}