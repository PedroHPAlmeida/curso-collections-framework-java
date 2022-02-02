package streamAPI;

import java.util.*;
import java.util.function.Function;

/*Dadas as seguintes informações de id e contato, crie um dicionário e
ordene este dicionário exibindo (Nome id - Nome contato);
id = 1 - Contato = nome: Samuel, numero: 111;
id = 4 - Contato = nome: Camila, numero: 222;
id = 3 - Contato = nome: Jonas, numero: 555;
*/
public class RefatoracaoOrdenacaoMap {

    public static void main(String[] args) {
        System.out.println("--\tOrdem aleatória\t--");
        Map<Integer, Contato> agenda = new HashMap<>() {{
            put(1, new Contato("Samuel", 1111));
            put(4, new Contato("Camila", 2222));
            put(3, new Contato("Jonas", 5555));
        }};
        System.out.println(agenda);
        imprimirDicionario(agenda);

        System.out.println("\n--\tOrdem Inserção\t--");
        Map<Integer, Contato> agendaOrdemInsercao = new LinkedHashMap<>() {{
            put(1, new Contato("Samuel", 5555));
            put(4, new Contato("Camila", 1111));
            put(3, new Contato("Jonas", 2222));
        }};
        System.out.println(agendaOrdemInsercao);
        imprimirDicionario(agendaOrdemInsercao);

        System.out.println("\n--\tOrdem id\t--");
        Map<Integer, Contato> agendaOrdemId = new TreeMap<>(agenda);
        System.out.println(agendaOrdemId);
        imprimirDicionario(agendaOrdemId);

        /*System.out.println("\n--\tOrdem número telefone\t--");
        //precisamos organizar os valores. Logo:
        Set<Map.Entry<Integer, Contato>> agendaOrdemNumeroTel = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() { // usando classe anonima
            @Override
            public int compare(Map.Entry<Integer, Contato> contato1, Map.Entry<Integer, Contato> contato2) {
                return Integer.compare(contato1.getValue().getNumero(), contato2.getValue().getNumero());
            }
        });
        agendaOrdemNumeroTel.addAll(agenda.entrySet());
        imprimirDicionario(agendaOrdemNumeroTel);*/

        /*System.out.println("\n--\tOrdem número telefone\t--"); // usando interface funcional
        Set<Map.Entry<Integer, Contato>> agendaOrdemNumeroTel = new TreeSet<>(Comparator.comparing(new Function<Map.Entry<Integer, Contato>, Integer>() {
            @Override
            public Integer apply(Map.Entry<Integer, Contato> contato) {
                return contato.getValue().getNumero();
            }
        }));
        agendaOrdemNumeroTel.addAll(agenda.entrySet());
        imprimirDicionario(agendaOrdemNumeroTel);*/

        System.out.println("\n--\tOrdem número telefone\t--"); // usando lambda
        Set<Map.Entry<Integer, Contato>> agendaOrdemNumeroTel = new TreeSet<>(Comparator.comparing(contato -> contato.getValue().getNumero()));
        agendaOrdemNumeroTel.addAll(agenda.entrySet());
        imprimirDicionario(agendaOrdemNumeroTel);

        System.out.println("\n--\tOrdem nome do contato\t--");
        Set<Map.Entry<Integer, Contato>> agendaOrdemNomeContato = new TreeSet<>(Comparator.comparing(contato -> contato.getValue().getNome()));
        agendaOrdemNomeContato.addAll(agenda.entrySet());
        imprimirDicionario(agendaOrdemNomeContato);
    }

    public static void imprimirDicionario(Map<Integer, Contato> agenda){
        for (Map.Entry<Integer, Contato> entry: agenda.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }
    }

    public static void imprimirDicionario(Set<Map.Entry<Integer, Contato>> agenda){
        for (Map.Entry<Integer, Contato> contato: agenda) {
            System.out.println(contato.getValue().getNumero() + " - " + contato.getValue().getNome());
        }
    }
}