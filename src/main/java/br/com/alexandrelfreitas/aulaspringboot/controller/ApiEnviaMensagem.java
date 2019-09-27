package br.com.alexandrelfreitas.aulaspringboot.controller;

import br.com.alexandrelfreitas.aulaspringboot.producer.DadosCustomProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/mensagem")
public class ApiEnviaMensagem {

    private final Logger logger = LoggerFactory.getLogger(ApiEnviaMensagem.class.getSimpleName());


    @Autowired
    private DadosCustomProducer dadosCustomProducer;

    @GetMapping("/{mensagem}")
    @ResponseBody
    public Boolean enviarMensagem(@PathVariable String mensagem) {
        logger.info("enviando mensagem: {}", mensagem);
        return dadosCustomProducer.sendMessage(mensagem);
    }

}
