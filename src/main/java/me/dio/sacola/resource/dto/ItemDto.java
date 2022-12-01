package me.dio.sacola.resource.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@AllArgsConstructor //Anotação que substitui todos os construtores responsável pelos atributos/agumentos//
@NoArgsConstructor //Construtor sem argumento, necessário por estar trabalhando com hibernate//
@Builder //Responsável pelo Sacola Builder//
@Data //Responsável pelos Get/Set//
@Embeddable //Significa que ela não vai ser uma tabela no BD//

public class ItemDto {
    private Long produtoid;
    private int quantidade;
    private Long sacolaId;
}
