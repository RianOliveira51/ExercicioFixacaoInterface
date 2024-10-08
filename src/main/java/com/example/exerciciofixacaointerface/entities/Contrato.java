package com.example.exerciciofixacaointerface.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrato {
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private Integer numero;
    private LocalDate data;
    private double valor;

    private List<Installment> installments = new ArrayList<>();
    public Contrato(){

    }

    public Contrato(Integer numero, LocalDate data, double valor){
        this.numero = numero;
        this.data = data;
        this.valor = valor;

    }

    public Integer getNumero(){
        return numero;
    }

    public LocalDate getData(){
        return data;
    }

    public void setData(LocalDate date){
        this.data = data;
    }

    public double getValor(){
        return valor;
    }

    public void setValor(double valor){
        this.valor = valor;
    }



    public List<Installment> getInstallments(){
        return installments;
    }

    //não tem set de list, pois não tem "trocar lista"


    public String toString(){
        return "Numero contrato: " + numero + ", Data: " + data + ", Valor: " + valor;
    }
}
