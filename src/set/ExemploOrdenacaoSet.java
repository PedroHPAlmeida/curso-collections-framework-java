package set;

/* Dadas as seguintes informações sobre minhas séries favoritas,
*  crie um conjunto e ordene-o exibindo:
* (nome - genero - numero de eps)
*
* Série 1 = nome: got, genero: fantasia, numEps = 60
* Série 1 = nome: dark, genero: drama, numEps = 60
* Série 1 = nome: that '70s show, genero: comedia, numEps = 25 */

import java.util.*;

public class ExemploOrdenacaoSet {
    public static void main(String[] args) {
        System.out.println("---\tOrdem Aleatória\t---");
        Set<Serie> series = new HashSet<>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70s show", "comedia", 25));
        }};
        System.out.println(series);


        System.out.println("\n---\tOrdem de Inserção\t---");
        Set<Serie> series2 = new LinkedHashSet<>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70s show", "comedia", 25));
        }};
        System.out.println(series2);

        System.out.println("\n---\tOrdem Natural (Número de eps)\t---");
        Set<Serie> series3 = new TreeSet<>(series);
        System.out.println(series3);

        System.out.println("\n---\tOrdem Nome/Genero/NumeroEps\t---");
        Set<Serie> series4 = new TreeSet<>(new ComparatorNomeGeneroNumeroEps());
        series4.addAll(series);
        System.out.println(series4);

        System.out.println("\n---\tOrdem Genero\t---");
        Set<Serie> series5 = new TreeSet<>(new ComparatorGenero());
        series5.addAll(series);
        System.out.println(series5);
    }
}

class Serie implements Comparable<Serie>{

    private String nome;
    private String genero;
    private Integer numEps;

    public Serie(String nome, String genero, Integer numEps) {
        this.nome = nome;
        this.genero = genero;
        this.numEps = numEps;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getNumEps() {
        return numEps;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", genero='").append(genero).append('\'');
        sb.append(", numEps=").append(numEps);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return nome.equals(serie.nome) && genero.equals(serie.genero) && numEps.equals(serie.numEps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, numEps);
    }

    @Override
    public int compareTo(Serie serie) {
        int numEps = Integer.compare(this.numEps, serie.getNumEps());
        if(numEps != 0) return numEps;

        return this.genero.compareTo(serie.getGenero());
    }
}

class ComparatorNomeGeneroNumeroEps implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        int nome =  s1.getNome().compareTo(s2.getNome());
        if(nome != 0) return nome;

        int genero =  s1.getGenero().compareTo(s2.getGenero());
        if(genero != 0) return genero;

        return Integer.compare(s1.getNumEps(), s2.getNumEps());
    }
}

class ComparatorGenero implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        return s1.getGenero().compareTo(s2.getGenero());
    }
}


