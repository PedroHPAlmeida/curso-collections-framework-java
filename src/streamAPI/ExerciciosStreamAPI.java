package streamAPI;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExerciciosStreamAPI {
    public static void main(String[] args) {
        List<String> numerosAleatorios = new ArrayList<>(List.of("1", "0", "4", "1", "2", "3", "9", "9", "6", "5", "0"));

        //System.out.println("Imprima todos os elementos dessa lista de String:");
        //numerosAleatorios.forEach(s -> System.out.print(s + " ")); // printar uma colecao inteira usando 1 linha
        //numerosAleatorios.forEach(System.out :: println);

        /*System.out.println("Pegue os 5 primeiros números e coloque dentro de um Set:");
        Set<String> collectSet = numerosAleatorios.stream()
                .limit(5) // seleciona o numero de elementos passado como argumento
                .collect(Collectors.toSet()); // coleta os valores selecionados e transforma em um Set
        collectSet.forEach(n -> System.out.print(n + " "));*/

        /*System.out.println("Transforme esta lista de String em uma lista de números inteiros");
        List<Integer> integerStream = numerosAleatorios.stream()
                .map(Integer::parseInt).toList(); // convertendo uma lista para Integer e guardando em outra lista
        integerStream.forEach(n -> System.out.print(n.getClass().getSimpleName() + " "));*/ // verificando se a lista foi convertida para Integer

        /*System.out.println("Pegue os números pares e maiores que 2 e coloque em uma lista:");
        List<Integer> paresMaioresQue2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(n -> n % 2 == 0 && n > 2) // retornar elementos dada uma condicao
                .toList();
        paresMaioresQue2.forEach(n -> System.out.print(n + " "));*/

        /*System.out.println("Mostre a média dos números: ");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt) // retorna um Strem de inteiros
                .average() // retorna a média
                .ifPresent(System.out::println); // a média sera printada somente se existir (pesquisar por OptionalDouble)*/

        /*List<Integer> numerosAleatorios1 = new ArrayList<>(List.of(1, 0, 4, 1, 2, 3, 9, 9, 6, 5));
        System.out.println("Remova os valores ímpares:");
        numerosAleatorios1.removeIf(n -> n % 2 == 1);
        System.out.println(numerosAleatorios1);*/

        // exercicios
        System.out.println("Ignore os 3 primeiros elementos da lista e imprima o restante:");
        numerosAleatorios.stream()
                .skip(3) // ingnora os x primeiros valores
                .forEach(System.out::println);

        System.out.println("Retirando os números repetidos da lista quantos números ficam? ");
        System.out.println(numerosAleatorios.stream().distinct().count()); // 1º forma
        System.out.println(numerosAleatorios.stream().collect(Collectors.toSet()).size()); // 2º forma

        System.out.println("Mostre o menor valor da lista:");
        numerosAleatorios.stream().mapToInt(Integer::parseInt).min().ifPresent(System.out::println);

        System.out.println("Mostre o maior valor da lista:");
        numerosAleatorios.stream().mapToInt(Integer::parseInt).max().ifPresent(System.out::println);

        System.out.println("Pegue apenas os números ímpares e some:");
        System.out.println(numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 1)
                .sum());

        System.out.println("Mostre a lista na ordem numérica:");
        List<Integer> numerosOrdemNatural = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .sorted(Comparator.naturalOrder())
                .toList();
        System.out.println(numerosOrdemNatural);

        System.out.println("Agrupe os valores ímpares múltiplos de 3 ou de 5:");
        List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream().map(Integer::parseInt).toList();

        Map<Boolean, List<Integer>> numerosMultiplos3e5 = numerosAleatoriosInteger.stream()
                .collect(Collectors.groupingBy(n -> (n % 3 == 0 || n % 5 == 0)));
        System.out.println(numerosMultiplos3e5);
    }
}
