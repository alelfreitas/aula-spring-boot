package br.com.alexandrelfreitas.aulaspringboot.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;

//Usando binding padrao do spring cloud
@EnableBinding(Source.class)
public class DadosProducer {

    private final Logger logger = LoggerFactory.getLogger(DadosProducer.class.getSimpleName());

    //@InboundChannelAdapter(Source.OUTPUT)
    public String sendMessage() {
        String mensagemPadrao = "Olá! Sou o spring stream";
        logger.info("Enviando mensagem: {}", mensagemPadrao);
        return mensagemPadrao;
    }

}
