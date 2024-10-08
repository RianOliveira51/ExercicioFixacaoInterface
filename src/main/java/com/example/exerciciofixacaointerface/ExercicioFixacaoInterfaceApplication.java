package com.example.exerciciofixacaointerface;

import com.example.exerciciofixacaointerface.entities.Contrato;
import com.example.exerciciofixacaointerface.entities.Installment;
import com.example.exerciciofixacaointerface.services.ContractService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/*Uma empresa deseja automatizar o processamento de seus contratos. O processamento de uim contrato
* consiste em gerar as parcelas a serem pagas para aquele contrato, com base no número de meses desejado.
* A empresa utiliza um serviço de pagamento online oara realizar o pagamento das parcelas. Os serviços de
* pagamento online tipicamente cobram um juro mensal, bem como uma taxa por pagamento. Por enquanto,
* o serviço contratado pela emrpesa é o do Paypal, que aplica juros simples de 1% a cada parcela, mais
* uma taxa de pagamento de 2%.
* Fazer um programa para ler os dados de um contrato(número do contrato, data do contrato, e valor total
* do contra). Em seguida, o programa deve ler o número de meses para parcelamento do contrato). Em seguida,
* o programa deve ler o número de meses para parcelamento do contrato, e dái gerar os registros de parcelas
* a serem apgas (data e valor), sendo a primeira parcela a ser paga um mês após a data do contrato, a
* segunda parcela dois meses após o contrato e assim por diante. MOstrar os dados das parcelas na tela*/
@SpringBootApplication
public class ExercicioFixacaoInterfaceApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre os dados do contrato");

        System.out.print("Numero: ");
        int number = sc.nextInt();

        sc.nextLine();

        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.next(),fmt);

        System.out.print("Valor do contrato: ");
        double totalValue = sc.nextDouble();

        Contrato contrato = new Contrato(number, date, totalValue);

        System.out.print("Entre com o numero de parcelas: ");
        int n = sc.nextInt();
        System.out.println(contrato);

        ContractService contractService = new ContractService(null);

        contractService.processContract(contrato,n);

        System.out.println("Parcelas:");
        for (Installment installment : contrato.getInstallments()){
            System.out.println(installment);
        }

        sc.close();
    }

}
