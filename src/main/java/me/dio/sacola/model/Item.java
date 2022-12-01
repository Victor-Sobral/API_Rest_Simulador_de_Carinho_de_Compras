package me.dio.sacola.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor //Anotação que substitui todos os construtores responsável pelos atributos/agumentos//
@NoArgsConstructor //Construtor sem argumento, necessário por estar trabalhando com hibernate//
@Builder //Responsável pelo Sacola Builder//
@Data //Responsável pelos Get/Set//
@Entity //indica que essa clase vai trabalhar com o BD//
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})



public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne //significa que um item só pode ter um produto//
    private Produto produto;
    private int quantidade;
    @ManyToOne //significa que uma sacola pode ter vários produtos//
    @JsonIgnore
    private Sacola sacola;

}
