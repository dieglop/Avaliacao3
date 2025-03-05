package br.edu.ifba.inf011.model.provaIII.chainOfResponsability;

import br.edu.ifba.inf011.model.evento.Evento;

public abstract class AbstractRegraHandler implements RegraHandler {

    protected RegraHandler next;

    public AbstractRegraHandler(RegraHandler next) {
        this.next = next;
    }

    public AbstractRegraHandler(){
        this(null);
    }

    @Override
    public void processar(Evento e) {
        try {
            verificarRegra(e);
            String mensagem = formatarMensagem(e);
            adicionarAoCalendario(mensagem);
            enviarMensagem(mensagem);
        } catch (Exception ex) {
            if (next != null) next.processar(e);
        }

    }
    public abstract void verificarRegra(Evento e) throws Exception;

    public abstract String formatarMensagem(Evento e);
    public abstract void adicionarAoCalendario(String mensagemFormatada);
    
    public void enviarMensagem(String mensagemFormatada) {}


    public void setProximo(RegraHandler regra) {
        this.next = regra;
    }

    protected String formatarMensagemParaWhatsApp(Evento e) {
        return "[WhatsApp] " + e.getDescricao();
    }

    protected String formatarMensagemParaEmail(Evento e) {
        return "[Email] " + e.getDescricao();
    }

    protected void adicionandoEventoAoGoogleCalendar(String mensagem) {
        System.out.println("Evento adicionado ao Google Calendar: " + mensagem);
    }

    protected void enviandoMensagemEmail(String mensagem) {
        System.out.println("Email enviado: " + mensagem);
    }

    protected void enviandoMensagemWhatsApp(String mensagem) {
        System.out.println("WhatsApp enviado: " + mensagem);
    }

    protected void enviandoMensagemRedeSocial(String mensagem) {
        System.out.println("Rede Social enviado: " + mensagem);
    }

    
}
