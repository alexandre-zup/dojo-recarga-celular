package br.com.zup.edu.dojo.recargacelular.recarga;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Pattern;

public class RecargaRequest {

    @JsonProperty
    @Pattern(regexp = "^[1-9]{2}9[7-9]{1}[0-9]{3}[0-9]{4}$")
    private String numeroCelular;
    @JsonProperty
    private Operadora operadora;
    @JsonProperty
    private Integer valor;


    public RecargaRequest(String numeroCelular, Operadora operadora, Integer valor) {
        this.numeroCelular = numeroCelular;
        this.operadora = operadora;
        this.valor = valor;
    }
}
