package list.exercicios;

/* Faça um programa que receba a temperatura média dos 6 primeiros meses do ano
*  e armazene-as em uma lista.
*  Após isto, calcule a média semestral das temperaturas e mostre todas as temperaturas
*  acima desta média, e em que mês elas ocorreram (mostrar o mês por extenso: 1 - Janeiro
*  2 - Fevereiro e etc). */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Exercicio01 {
    public static void main(String[] args) {
        // instanciando a lista
        List<Double> temperaturas = new ArrayList<>(){{
            add(25d); // jan
            add(28.6); // fev
            add(15d); // mar
            add(31.8); // abr
            add(35d); // mai
            add(23d); // jun
        }};

        // calculo da media semestral
        Double soma = 0d;
        Iterator<Double> iterator = temperaturas.iterator();
        while(iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }
        Double media = soma / temperaturas.size();

        // verificando as temperaturas que foram acima da media
        List<String> meses = new ArrayList<>(){{
            add("Janeiro");
            add("Fevereiro");
            add("Abril");
            add("Maio");
            add("Junho");
        }};

        System.out.println("Média = " + String.format("%.2f", media));
        for(int i = 0; i < temperaturas.size(); i++){
            if(temperaturas.get(i) > media){
                System.out.println(i + 1 + " - " + meses.get(i) + " -> " + String.format("%.2f", temperaturas.get(i)));
            }
        }
    }
}
