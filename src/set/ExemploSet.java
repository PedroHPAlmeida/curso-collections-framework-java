package set;

import java.util.*;

public class ExemploSet {
    public static void main(String[] args) {
        // formas de inicializar um set
        // Set notas = new HashSet(); // antes do java 5
        // HashSet<Double> notas = new HashSet<>();
        // Set<Double> notas = new HashSet<>();
        // Set<Double> notas = Set.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6); // instanciar com valores

        System.out.println("Crie um conjunto e adicione as notas:");
        Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas);

        // o que nao e possivel fazer com set
        // nao e possivel acessar os elementos por indice (set nao possui indexOf())
        // System.out.println("Exiba a posicao da nota 5.0: impossivel!");
        // System.out.println("Adicione na lista a nota 8.0 na posicao 4: impossivel!");
        // System.out.println("Substitua a nota 5.0 pela nota 6.8: impossivel!");
        // System.out.println("Exiba a terceira nota adicionada: immpossivel!");
        // System.out.println("Remova a nota na posicao 0: impossivel!");

        // verificar se um elemento esta no conjunto
        System.out.println("Verifique se a nota 5.0 esta no conjunto: " + notas.contains(5.0));

        // retornar o menor valor do conjunto
        System.out.println("Exiba a menor nota: " + Collections.min(notas));

        // retornar o maior valor do conjunto
        System.out.println("Exiba a maior nota: " + Collections.max(notas));

        // exibir a soma dos valores
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0.0;
        while(iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("Exiba a soma das notas: " + soma);
        System.out.println("Exiba a média das notas: " + soma / notas.size());

        // remover um elemento especifico do conjunto (pelo seu valor)
        System.out.println("Remova a nota 0: ");
        notas.remove(0d);
        System.out.println(notas.toString());

        // Remover elementos dada uma condicao
        System.out.println("Remova as notas menores que 7 e exiba a lista:");
        Iterator<Double> iterator1 = notas.iterator();
        notas.removeIf(n -> n < 7.0);
        System.out.println(notas);

        System.out.println("Exiba todas as notas na ordem em que foram informadas: ");
        Set<Double> notas2 = new LinkedHashSet<>(){{
            add(7d);
            add(8.5);
            add(9.3);
            add(9.3);
            add(5d);
            add(7d);
            add(0d);
            add(3.6);
        }};
        System.out.println(notas2);

        // exibir valores em ordem crescente (necessario usar TreeSet)
        System.out.println("Exiba todas as notas em ordem crescente: ");
        Set<Double> notas3 = new TreeSet<>(notas2); // TreeSet armazena os valores em ordem crescente automaticamente
        System.out.println(notas3);

        // Apagar todos os valores do conjunto
        System.out.println("Apague todas as notas:");
        notas.clear();

        // verificar se um conjunto esta vazio
        System.out.println("Confira se o conjunto está vazio: " + notas.isEmpty());
    }
}