package set.exercicios;

/* Crie uma classe LinguagemFavorita que possua os atributos
   nome, anoDeCriacao e ide. Em seguida, crie um conjunto com
   3 linguagens e faça um programa que ordene esse conjunto
   por:
    * Ordem de Inserção
    * Ordem Natural (nome)
    * IDE
    * Ano de criação e nome
    * Nome, ano de criacao e IDE
   Ao final, exiba as linguagens no console, um abaixo da outra.
* */

import java.util.*;

public class Exercicio02 {
    public static void main(String[] args) {
        // instanciando um set com linguagens
        Set<LinguagemFavorita> linguagensFavoritas = new HashSet<>(){{
            add(new LinguagemFavorita("Java", 1990, "IntelliJ"));
            add(new LinguagemFavorita("Python", 1995, "PyCharm"));
            add(new LinguagemFavorita("C", 1980, "Code Blocks"));
        }};

        // exibindo linguagens por ordem de insercao
        System.out.print("A. Ordem de inserção: ");
        for(LinguagemFavorita linguagem : linguagensFavoritas) System.out.print(linguagem + " ");

        // ordenando por nome
        Set<LinguagemFavorita> linguagensFavoritasOrdenadas = new TreeSet<>(linguagensFavoritas);
        System.out.print("\n\nB. Ordenadas por nome: ");
        for(LinguagemFavorita linguagem : linguagensFavoritasOrdenadas) System.out.print(linguagem + " ");

        // ordenando por ide
        Set<LinguagemFavorita> linguagensFavoritasOrdenadasIde = new TreeSet<>(new ComparatorIDE());
        linguagensFavoritasOrdenadasIde.addAll(linguagensFavoritas);
        System.out.print("\n\nC. Ordenadas por IDE: ");
        for(LinguagemFavorita linguagem : linguagensFavoritasOrdenadasIde) System.out.print(linguagem + " ");

        // ordenando por ano de criacao e nome
        Set<LinguagemFavorita> linguagensFavoritasOrdenadasAnoNome = new TreeSet<>(new ComparatorAnoNome());
        linguagensFavoritasOrdenadasAnoNome.addAll(linguagensFavoritas);
        System.out.print("\n\nD. Ordenadas por ano de criação e nome: ");
        for(LinguagemFavorita linguagem : linguagensFavoritasOrdenadasAnoNome) System.out.print(linguagem + " ");

        // ordenando por nome, ano de criacao e ide
        Set<LinguagemFavorita> linguagensFavoritasOrdenadasNomeAnoIde = new TreeSet<>(new ComparatorNomeAnoIde());
        linguagensFavoritasOrdenadasNomeAnoIde.addAll(linguagensFavoritas);
        System.out.print("\n\nE. Ordenadas por nome, ano de criação e IDE: ");
        for(LinguagemFavorita linguagem : linguagensFavoritasOrdenadasNomeAnoIde) System.out.print(linguagem + " ");
    }
}


class LinguagemFavorita implements Comparable<LinguagemFavorita>{
    String nome;
    Integer anaDeCriacao;
    String ide;

    public LinguagemFavorita(String nome, Integer anaDeCriacao, String ide) {
        this.nome = nome;
        this.anaDeCriacao = anaDeCriacao;
        this.ide = ide;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAnaDeCriacao() {
        return anaDeCriacao;
    }

    public String getIde() {
        return ide;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", anaDeCriacao=").append(anaDeCriacao);
        sb.append(", ide='").append(ide).append('\'');
        sb.append('}');
        return sb.toString();
    }


    @Override
    public int compareTo(LinguagemFavorita l) {
        return this.nome.compareTo(l.getNome());
    }
}

class ComparatorIDE implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        return l1.getIde().toUpperCase().compareTo(l2.getIde().toUpperCase());
    }
}

class ComparatorAnoNome implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int ano = Integer.compare(l1.getAnaDeCriacao(), l2.getAnaDeCriacao());
        if (ano != 0) return ano;

        return l1.getNome().toUpperCase().compareTo(l2.getNome().toUpperCase());
    }
}

class ComparatorNomeAnoIde implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int nome = l1.getNome().compareToIgnoreCase(l2.getNome());
        if (nome != 0) return nome;

        int ano = Integer.compare(l1.getAnaDeCriacao(), l2.getAnaDeCriacao());
        if (ano != 0) return ano;

        return l1.getIde().compareToIgnoreCase(l2.getIde());
    }
}
