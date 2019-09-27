package br.com.alexandrelfreitas.aulaspringboot.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface DadosCustomBinder {

    @Output("canal-mensagem")
    public MessageChannel sendMessage();

}
