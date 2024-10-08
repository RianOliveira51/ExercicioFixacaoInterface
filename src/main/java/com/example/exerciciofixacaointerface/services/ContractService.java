package com.example.exerciciofixacaointerface.services;

import com.example.exerciciofixacaointerface.entities.Contrato;
import com.example.exerciciofixacaointerface.entities.Installment;

import java.time.LocalDate;

public class ContractService {
    //declarando dependencia
    private OnlinePaymentService onlinePaymentService;

    //Assegurando que vamos instanciar o ContratcService, já informando o onlinePaymentService.
    public ContractService(OnlinePaymentService onlinePaymentService){
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contrato contrato, int months){
        contrato.getInstallments().add(new Installment(LocalDate.of(2018,7,25),206.04));
        contrato.getInstallments().add(new Installment(LocalDate.of(2018,8,25),208.08));
    }

}
