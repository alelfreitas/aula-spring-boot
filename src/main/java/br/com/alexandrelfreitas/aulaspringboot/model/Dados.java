package br.com.alexandrelfreitas.aulaspringboot.model;

import lombok.*;

@ToString
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@RequiredArgsConstructor
public class Dados {

    @NonNull String id;
    String nome;
}
