package br.com.alexandrelfreitas.aulaspringboot.repository;

import br.com.alexandrelfreitas.aulaspringboot.entity.DadosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DadosRepository extends JpaRepository<DadosEntity, Integer> {
    //?1

    @Query("SELECT n FROM DadosEntity n WHERE n.nome = :nome")
    List<DadosEntity> listarDadosPorNome(
            @Param("nome") String nome
            //, String nome
    );

    List<DadosEntity> findByNome(String nome);

}
