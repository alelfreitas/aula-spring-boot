package br.com.alexandrelfreitas.aulaspringboot.controller;

import br.com.alexandrelfreitas.aulaspringboot.model.Dados;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RestController
public class ApiRestTemplate {

    private final Logger logger = LoggerFactory.getLogger(ApiRestTemplate.class.getSimpleName());

    @GetMapping("/teste")
    @ResponseBody
    public String resposta() {
        return "Funcionou";
    }

    @GetMapping("/texto/{texto}")
    @ResponseBody
    public String mostraTexto(@PathVariable String texto){
        return texto;
    }

    @PostMapping("/dados")
    @ResponseBody
    public void mostraDados(@RequestBody Dados dados){
        logger.info("Id: {}, nome: {}" , dados.getId(), dados.getNome());
    }
}
