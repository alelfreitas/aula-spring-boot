package br.com.alexandrelfreitas.aulaspringboot.controller;

import br.com.alexandrelfreitas.aulaspringboot.model.Dados;
import br.com.alexandrelfreitas.aulaspringboot.entity.DadosEntity;
import br.com.alexandrelfreitas.aulaspringboot.repository.DadosRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ApiRestTemplate {

    private final Logger logger = LoggerFactory.getLogger(ApiRestTemplate.class.getSimpleName());

    @Autowired
    private DadosRepository dadosRepository;

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
        //Save serve como update também, tomar cuidado com envio de ID
        DadosEntity dadosEntity = new DadosEntity();
                //dados.getId(),
        dadosEntity.setNome(dados.getNome());
        dadosRepository.save(dadosEntity);
    }

    @GetMapping("/dados/all")
    @ResponseBody
    public List<DadosEntity> getAllDados() {
        return dadosRepository.findAll();
    }

    @GetMapping("/dados/{id}")
    @ResponseBody
    public Optional<DadosEntity> getDadosById(@PathVariable Integer id) {
        return dadosRepository.findById(id);
    }

    @GetMapping("/dados/porNome/{nome}")
    @ResponseBody
    public List<DadosEntity> getDadosPorNome(@PathVariable String nome) {
        logger.info("Busca por nome {} usando query", nome);
        return dadosRepository.listarDadosPorNome(nome);
    }

    @GetMapping("/dados/byNome/{nome}")
    @ResponseBody
    public List<DadosEntity> getDadosByNome(@PathVariable String nome) {
        logger.info("Busca por nome {} usando jpa", nome);
        return dadosRepository.findByNome(nome);
    }
}
