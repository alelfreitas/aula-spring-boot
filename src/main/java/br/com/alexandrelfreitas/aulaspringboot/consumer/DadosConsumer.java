package br.com.alexandrelfreitas.aulaspringboot.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class DadosConsumer {

    final private Logger logger = LoggerFactory.getLogger(DadosConsumer.class.getSimpleName());

    @StreamListener(Sink.INPUT)
    public void readMessage(String message) {
        System.out.println("Nova mensagem: " + message);
    }
}
