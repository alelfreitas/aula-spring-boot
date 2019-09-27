package br.com.alexandrelfreitas.aulaspringboot.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class DadosCustomProducer {
    @Autowired
    private DadosCustomBinder dadosCustomBinder;

    public boolean sendMessage(String dados){
        Message<String> message = MessageBuilder.withPayload(dados).build();
        return dadosCustomBinder.sendMessage().send(message);
    }
}
