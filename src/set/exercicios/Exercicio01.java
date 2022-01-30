package set.exercicios;

/* Crie um conjunto contendo as cores do arco-íris e:
* Exiba todas as cores uma abaixo da outra
* A quantidade de cores que o arco-íris tem
* Exiba as cores em ordem alfabética
* Exiba as cores na ordem inversa da que foi informada
* Exiba todas as cores que começam com a letra ”v”
* Remova todas as cores que não começam com a letra “v”
* Limpe o conjunto
* Confira se o conjunto está vazio
*/

import java.util.*;

public class Exercicio01 {
    public static void main(String[] args) {
        // instanciando lista de cores
        Set<String> cores = new HashSet<>(Arrays.asList("vermelha", "laranja", "amarela", "verde", "azul", "azul-escuro", "violeta"));
        Set<String> coresOrdenadas = new TreeSet<>(cores);

        // exibir as cores
        System.out.print("A. Cores: ");
        for(String cor : cores) System.out.print(cor + " ");

        // exibir cores em ordem alfabetica
        System.out.print("\n\nB. Cores em ordem alfabética: ");
        for(String cor : coresOrdenadas) System.out.print(cor + " ");

        // exibir numero de cores
        System.out.print("\n\nC. O arco-íris possui " + cores.size() + " cores");

        // exibir cores na ordem inversa da que foi informada
        List<String> coresOrdenadasInversamente = new ArrayList<>(cores);
        coresOrdenadasInversamente.sort(Collections.reverseOrder());
        System.out.print("\n\nD. Cores em ordem inversa da que foram informadas: ");
        for(String cor : coresOrdenadasInversamente) System.out.print(cor + " ");

        // exibir cores na ordem inversa da que foi informada
        System.out.print("\n\nE. Exiba todas as cores que começam com a letra 'v': ");
        for(String cor : cores){
            if(cor.charAt(0) == 'v') System.out.print(cor + " ");
        }

        // remover as cores que nao comecao com a letra 'v'
        System.out.print("\n\nF. Remover as cores que não começam com a letra 'v': ");
        cores.removeIf(c -> c.charAt(0) != 'v');
        for(String cor : cores) System.out.print(cor + " ");

        // limpar o conjunto e conferir se ele esta vazio
        cores.clear();
        System.out.print("\n\nG. Limpando o conjunto... Está vazio? " + cores.isEmpty());
    }
}
