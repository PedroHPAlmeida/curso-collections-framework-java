package list;

import java.util.*;

public class ExemploList {
    public static void main(String[] args) {
        // Formas de instanciar um List
        List<Double> notas1 = new ArrayList<>();
        List<Double> notas2 = new ArrayList<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6)); // esse metodo nao permite adicionar nem remover elmentos
        List<Double> notas3 = List.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6); // esse metodo torna a lista imutavel

        // Exemplo
        System.out.println("Crie uma lista e adicione as sete notas:");
        List<Double> notas = new ArrayList<>();
        notas.add(7d);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5d);
        notas.add(7d);
        notas.add(0d);
        notas.add(3.6);
        System.out.println(notas.toString());

        // Exibir a posicao de um item dentro da lista
        System.out.println("Exibir a posição da nota 5.0: " + notas.indexOf(5d));

        // Adicionar valor em uma posicao especifica
        System.out.println("Adicione na lista a nota 8.0 nna posição 4:");
        notas.add(4, 8d);
        System.out.println(notas);

        // Substituir um elemento especifico
        System.out.println("Substitui a nota 5.0 pela nota 6.0:");
        notas.set(notas.indexOf(5d), 6d);
        System.out.println(notas);

        // Verificar se um determinado elemento esta na lista
        System.out.println("Conferir se a nota 5.0 está na lista: " + notas.contains(5d));

        // Imprimir valores na ordem em que foram inseridos
        System.out.println("Exiba todas as notas na ordem em que foram informados: ");
        //for(Double nota : notas) System.out.println(nota);

        // Retornar o elemento de determinado indice
        System.out.println("Exiba a terceira nota adicionada: " + notas.get(2));

        // Retornar o menor valor de uma colecao
        System.out.println("Exiba a menor nota: " + Collections.min(notas));// Retornar o menor valor de uma colecao

        // Retornar o maior valor de uma colecao
        System.out.println("Exiba a menor nota: " + Collections.max(notas));

        // Somar todos os valores de uma colecao
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        while(iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("Exiba a soma dos valores: " + soma);
        System.out.println("Exiba a média das notas: " + (soma / notas.size()));

        // Remover um elemento especifico
        System.out.println("Remova a nota 0:");
        notas.remove(0d); // remove pelo valor do objeto
        //notas.remove(0); // remove pelo indice
        System.out.println(notas);

        // Remover elementos dada uma condicao
        System.out.println("Remova as notas menores que 7 e exiba a lista:");
        notas.removeIf(next -> next < 7);
        System.out.println(notas);

        // Apagar todos os elementos da lista
        System.out.println("Apagar todos os elementos da lista:");
        notas.clear();
        System.out.println(notas);

        // Veirificar se uma lista esta vazia
        System.out.println("Confira se a lista esta vazia: " + notas.isEmpty());
    }
}
