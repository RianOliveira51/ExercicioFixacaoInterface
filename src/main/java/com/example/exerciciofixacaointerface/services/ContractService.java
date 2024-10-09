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

    //gerando parcelas
    public void processContract(Contrato contrato, int months){

        double basicQuota = contrato.getValor() / months;

        for( int i=1; i <= months; i++){
            //plusMonths - adicionando meses
            LocalDate duedate = contrato.getData().plusMonths(i);

            //juros
            double interest = onlinePaymentService.interest(basicQuota, i);
            //taxas
            double fee = onlinePaymentService.paymentFee(basicQuota + interest);
            //valor total da parcela
            double quota = basicQuota + interest + fee;

            //instanciado parcela
            contrato.getInstallments().add(new Installment(duedate,quota));
        }
    }

}
