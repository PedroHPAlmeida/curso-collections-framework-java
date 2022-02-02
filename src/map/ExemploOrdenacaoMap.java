package map;

/*Dadas as seguintes informações sobre meus livros favoritos e seus autores,
* crie um dicionário e ordene este dicionário:
* exibindo (Nome Autor - Nome Livro)
*
* Autor = Hawking, Stephen - Livro = nome: Uma breve história do tempo, páginas: 256
* Autor = Duhigg, Charles - Livro = nome: O poder do hábito, páginas: 408
* Autor = Harari, Yuval Noah - Livro = nome: 21 lições para o século 21, páginas: 432
*/

import java.util.*;

public class ExemploOrdenacaoMap {
    public static void main(String[] args) {
        System.out.println("---\tOrdem aleatória\t---");
        Map<String, Livro> livros = new HashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma breve história do tempo", 256));
            put("Duhigg, Charles", new Livro("O poder do hábito", 408));
            put("Harari, Yuval Noah", new Livro("21 lições para o século 21", 432));
        }};
        for(Map.Entry<String, Livro> livro: livros.entrySet()) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }

        System.out.println("\n---\tOrdem Inserção\t---");
        Map<String, Livro> livrosOrdemInsercao = new LinkedHashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma breve história do tempo", 256));
            put("Duhigg, Charles", new Livro("O poder do hábito", 408));
            put("Harari, Yuval Noah", new Livro("21 lições para o século 21", 432));
        }};
        for(Map.Entry<String, Livro> livro : livrosOrdemInsercao.entrySet()){
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }

        System.out.println("\n---\tOrdem alfabética autores\t---");
        Map<String, Livro> livrosOrdemAutores = new TreeMap<>(livros);
        for(Map.Entry<String, Livro> livro : livrosOrdemAutores.entrySet()){
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }

        System.out.println("\n---\tOrdem alfabética nomes dos livros\t---");
        Set<Map.Entry<String, Livro>> livrosOrdemNomeLivro = new TreeSet<>(new ComparatorNome());
        livrosOrdemNomeLivro.addAll(livros.entrySet());
        for(Map.Entry<String, Livro> livro : livrosOrdemNomeLivro){
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }

        System.out.println("\n---\tOrdem número de páginas\t---");
        Set<Map.Entry<String, Livro>> livrosOrdemPaginas = new TreeSet<>(new ComparatorPaginas());
        livrosOrdemPaginas.addAll(livros.entrySet());
        for(Map.Entry<String, Livro> livro : livrosOrdemPaginas){
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome() + " - " + livro.getValue().getPaginas());
        }
    }
}

class Livro {
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nome.equals(livro.nome) && paginas.equals(livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Livro{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", paginas=").append(paginas);
        sb.append('}');
        return sb.toString();
    }
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}

class ComparatorPaginas implements Comparator<Map.Entry<String, Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return Integer.compare(l1.getValue().getPaginas(), l2.getValue().getPaginas());
    }
}

