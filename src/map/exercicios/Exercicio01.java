package map.exercicios;

/*Dada a população estimada de alguns estados do NE brasileiro, faça:
* Estado = PE - População = 9.616.621
* Estado = AL - População = 3.351.543
* Estado = CE - População = 9.187.103
* Estado = RN - População = 3.534.265
*
* Crie um dicionário e relacione os estados e suas populações;
* Substitua a população do estado do RN por 3.534.165;
* Confira se o estado PB está no dicionário, caso não adicione: PB -
4.039.277;
* Exiba todos os estados e suas populações na ordem que foi
informado;
* Exiba os estados e suas populações em ordem alfabética;
* Exiba o estado com o menor população e sua quantidade;
* Exiba o estado com a maior população e sua quantidade;
* Exiba a soma da população desses estados;
* Exiba a média da população deste dicionário de estados;
* Remova os estados com a população menor que 4.000.000;
* Apague o dicionário de estados;
* Confira se o dicionário está vazio.
* Exiba a população PE;*/

import java.util.*;

public class Exercicio01 {
    public static void main(String[] args) {
        // instanciando dicionario de estados e populacoes
        Map<String, Integer> estados = new HashMap<>(){{
            put("PE", 9616621);
            put("Al", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        System.out.println("Estados e suas populações:");
        imprimirDicionario(estados);

        // substituindo populacao do RN
        System.out.println("\nSubstitua a população do estado do RN por 3.534.165:");
        estados.put("RN", 3534165);
        imprimirDicionario(estados);

        // adicionando novo estado ao dicionario
        System.out.println("\nConfira se o estado PB está no dicionário, caso não adicione: PB - 4.039.277:");
        estados.put("PB", 4039277);
        imprimirDicionario(estados);

        // exibir a populacao de um estado
        System.out.println("\nExiba a população PE:");
        System.out.println("PE - " + estados.get("PE"));

        // exibir estados na ordem de insercao
        System.out.println("\nExiba todos os estados e suas populações na ordem que foi informado:");
        Map<String, Integer> estadosOrdemInsercao = new LinkedHashMap<>(){{
            put("PE", 9616621);
            put("Al", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        imprimirDicionario(estadosOrdemInsercao);

        // classificar por estado
        System.out.println("\nExiba os estados e suas populações em ordem alfabética:");
        Map<String, Integer> estadosOrdemAlpha = new TreeMap<>(estados);
        imprimirDicionario(estadosOrdemAlpha);

        // exibir o estado com a menor populacao
        System.out.println("\nExiba o estado com o menor população e sua quantidade:");
        Integer menorPopu = Collections.min(estados.values());
        for(Map.Entry<String, Integer> estado : estados.entrySet()){
            if(estado.getValue().equals(menorPopu)){
                System.out.println(estado.getKey() + " -> " + estado.getValue());
            }
        }

        // exibir o estado com a maior populacao
        System.out.println("\nExiba o estado com o maior população e sua quantidade:");
        Integer maiorPopu = Collections.max(estados.values());
        for(Map.Entry<String, Integer> estado: estados.entrySet()){
            if(estado.getValue().equals(maiorPopu)){
                System.out.println(estado.getKey() + " -> " + estado.getValue());
            }
        }

        // somar a populacao de todos os estados do dicionario
        Integer soma = 0;
        for(Map.Entry<String, Integer> estado: estados.entrySet()){
            soma += estado.getValue();
        }
        System.out.println("\nExiba a soma da população desses estados: " + soma);

        // media das populacoes
        System.out.println("\nExiba a média da população deste dicionário de estados: " + (soma / estados.size()));

        // remover estados com uma condicao
        System.out.println("\nRemova os estados com a população menor que 4.000.000:");
        estados.values().removeIf(populacao -> populacao < 4000000);
        imprimirDicionario(estados);

        // apagar o dicionario
        estados.clear();

        // verificar se o dicionario esta vazio
        System.out.println("\nConfira se o dicionário está vazio: " + estados.isEmpty());
    }

    public static void imprimirDicionario(Map<String, Integer> dicionario){
        for(Map.Entry<String, Integer> elemento : dicionario.entrySet()){
            System.out.println(elemento.getKey() + " -> " + elemento.getValue());
        }
    }
}
