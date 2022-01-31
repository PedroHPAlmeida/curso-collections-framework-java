package map;

/* Dado os modelos dos carros e seus respectivos consumos na estrada, faça:
* modelo = gol - consumo = 14,4km/l
* modelo = uno - consumo = 15,6km/l
* modelo = mobi - consumo = 16,1km/l
* modelo = hb20 - consumo = 14,5km/l
* modelo = kwid - consumo = 15,6km/l*/

import java.util.*;

public class ExemploMap {
    public static void main(String[] args) {
        // formas de instanciar um Map
        // Map carrosPopulares = new HashMap(); // antes do java 5
        // Map<String, Double> carrosPopulares = new HashMap<>();
        // HashMap<String, Double> carrosPopulares = new HashMap<>();
        // Map<String, Double> carrosPopulares = Map.of("gol", 14.4, "uno", 15.6, "mobi", 16.1, "hb20", 14.5, "kwid", 15.6);

        System.out.println("Crie um dicionário que relacione os modelos e seus respectivos consumos:");
        Map<String, Double> carrosPopulares = new HashMap<>(){{
            put("gol", 14.4); // adiciona valores ao dicionario
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares.toString());

        // HashMap nao permite chaves duplicadas, entao para substituir um valor basta passar a mesma chave para o metodo put
        System.out.println("Substitua o consumo do gol por 15.2 km/l:");
        carrosPopulares.put("gol", 15.2);
        System.out.println(carrosPopulares);

        // verificar se uma chave esta no dicionario
        System.out.println("Confira se o modelo tucson está no dicionário: " + carrosPopulares.containsKey("tucson"));

        // retornar o valor pela chave
        System.out.println("Exiba o consumo do uno: " + carrosPopulares.get("uno") + " km/l");

        // System.out.println("Exiba o terceiro modelo adicionado: impossivel!");

        // retornar as chaves contidas no dicionario
        Set<String> modelos = carrosPopulares.keySet();
        System.out.println("Exiba os modelos: " + modelos);

        // retornar os valores contidos no dicionario
        Collection<Double> consumos = carrosPopulares.values();
        System.out.println("Exiba os consumos dos carros: " + consumos);

        // retornar o maior valor de um dicionario e mostrar sua chaves
        System.out.println("Exiba os modelos mais econômicos e seus consumos:");
        Double consumoMaisEficiente = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet(); // retorna um Set con todos as chaves e valores
        String modeloMaisEficiente = "";
        for(Map.Entry<String, Double> entry: entries){ // precisamos disso pra poder usar os metodos getValue() e getKey()
            if(entry.getValue().equals(consumoMaisEficiente)){
                modeloMaisEficiente = entry.getKey();
                System.out.println(modeloMaisEficiente + " " + consumoMaisEficiente);
            }
        }

        // retornar o menor valor de um dicionario e mostrar sua chaves
        System.out.println("Exiba os modelos menos econômicos e seus consumos: ");
        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries1 = carrosPopulares.entrySet();
        String modeloMenosEficiente = "";
        for(Map.Entry<String, Double> entry: entries1){
            if(entry.getValue().equals(consumoMenosEficiente)){
                modeloMenosEficiente = entry.getKey();
                System.out.println(modeloMenosEficiente + " " + consumoMenosEficiente);
            }
        }

        // somar valores de um dicionario
        Double soma = 0d;
        Iterator<Double> iterator = carrosPopulares.values().iterator();
        while(iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println("Exiba a soma dos consumos: " + soma);

        // tamanho de um dicionario
        System.out.println("Exiba a média dos consumos deste dicionário de carros: " + (soma / carrosPopulares.size()));

        // remover elementos dada um condicao
        /*Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while (iterator1.hasNext()){
            if(iterator1.next().equals(15.6)) iterator1.remove();
        }*/
        carrosPopulares.values().removeIf(consumo -> consumo.equals(15.6));
        System.out.println(carrosPopulares);

        // exibir valores na ordem que foram informados (usar LinkedHashMap)
        System.out.println("Exiba todos os carros na ordem em que foram informados: ");
        Map<String, Double> carrosOrdemInfo = new LinkedHashMap<>(){{
            put("gol", 14.4); // adiciona valores ao dicionario
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosOrdemInfo);

        // ordenar dicionario pela chave (usar TreeMap)
        System.out.println("Exiba o dicionário pelo modelo:");
        Map<String, Double> carrosOrdemKey = new TreeMap<>(){{
            put("gol", 14.4); // adiciona valores ao dicionario
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosOrdemKey);

        // apagar todos os elementos de um dicionário
        carrosPopulares.clear();

        // verificar se um dicionario esta vazio
        System.out.println("Verificar se o dicionário está vazio: " + carrosPopulares.isEmpty());
    }
}
