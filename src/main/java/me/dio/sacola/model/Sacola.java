package me.dio.sacola.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.sacola.enumeration.FormaPagamento;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor //Anotação que substitui todos os construtores responsável pelos atributos/agumentos//
@NoArgsConstructor //Construtor sem argumento, necessário por estar trabalhando com hibernate//
@Builder //Responsável pelo Sacola Builder//
@Data //Responsável pelos Get/Set//
@Entity //indica que essa clase vai trabalhar com o BD//
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Sacola {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne (fetch = FetchType.LAZY, optional = false) //relacionamento de entidades no BD//
    @JsonIgnore
    private Cliente cliente;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> itens;
    private double valorTotal;

    @Enumerated
    private FormaPagamento FormaPagamento;
    private boolean fechada;


}
