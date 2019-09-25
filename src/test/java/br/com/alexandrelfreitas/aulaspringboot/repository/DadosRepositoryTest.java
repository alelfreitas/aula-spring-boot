package br.com.alexandrelfreitas.aulaspringboot.repository;

import br.com.alexandrelfreitas.aulaspringboot.entity.DadosEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DadosRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DadosRepository dadosRepository;

    @Test
    public void whereFindByName_thenReturnDado() {
        // prepara o dados
        DadosEntity dados = new DadosEntity();
        dados.setNome("teste");
        entityManager.persist(dados);
        entityManager.flush();

        //busca
        List<DadosEntity> encontrado = dadosRepository.findByNome(dados.getNome());

        //valida
        assertEquals(dados, encontrado.get(0));

    }

}
