package list;

/* Dadas as seguintes informações sobre os alunos de uma determinada disciplina, crie uma lista
e ordene-a exibindo:
(nome - idade - sexo)

Aluno 1 = nome: Jon, idade: 18, sexo: m
Aluno 2 = nome: Sara, idade: 6, sexo: f
Aluno 3 = nome: Jon, idade: 12, sexo: m
* */


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExemploOrdenacaoList {
    public static void main(String[] args) {
        List<Aluno> alunos = new ArrayList<>(){{
            add(new Aluno("Jon", 18, "m"));
            add(new Aluno("Sara", 6, "f"));
            add(new Aluno("Jon", 14, "m"));
        }};

        System.out.println("---\tOrdem de Inserção\t---");
        System.out.println(alunos);

        System.out.println("---\tOrdem Aleatória\t---");
        Collections.shuffle(alunos);
        System.out.println(alunos);

        System.out.println("---\tOrdem Natural (nome)\t---");
        Collections.sort(alunos);
        System.out.println(alunos);

        System.out.println("---\tOrdem Idade\t---"); // ordenar valores por idade
        //Collections.sort(alunos, new ComparatorIdade());
        alunos.sort(new ComparatorIdade());
        System.out.println(alunos);

        System.out.println("---\tOrdem Sexo\t---"); // ordenar valores por sexo
        //Collections.sort(alunos, new ComparatorSexo());
        alunos.sort(new ComparatorSexo());
        System.out.println(alunos);

        System.out.println("---\tOrdem Nome/Sexo/Idade\t---"); // ordenar a lista baseado em todos os atributos do objeto
        //Collections.sort(alunos, new ComparatorNomeSexoIdade());
        alunos.sort(new ComparatorNomeSexoIdade());
        System.out.println(alunos);
    }
}

class Aluno implements Comparable<Aluno>{ // tornando a classe "comparavel"
    private String nome;
    private Integer idade;
    private String sexo;

    public Aluno(String nome, Integer idade, String sexo) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getSexo() {
        return sexo;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", idade=").append(idade);
        sb.append(", sexo=").append(sexo);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Aluno aluno) { // sobrescrevendo metodo que compara os atributos do objeto
        return this.getNome().compareToIgnoreCase(aluno.getNome());
    }
}

class ComparatorIdade implements Comparator<Aluno> { // criando um comparator para idade
    @Override
    public int compare(Aluno aluno1, Aluno aluno2) {
        return Integer.compare(aluno1.getIdade(), aluno2.getIdade());
    }
}

class ComparatorSexo implements Comparator<Aluno> { // criando um comparator para sexo
    @Override
    public int compare(Aluno aluno1, Aluno aluno2) {
        return aluno1.getSexo().compareToIgnoreCase(aluno2.getSexo());
    }
}

class ComparatorNomeSexoIdade implements Comparator<Aluno>{
    @Override
    public int compare(Aluno aluno1, Aluno aluno2) {
        int nome = aluno1.getNome().compareToIgnoreCase(aluno2.getNome());
        if(nome != 0) return nome;

        int cor = aluno1.getSexo().compareToIgnoreCase(aluno2.getSexo());
        if(cor != 0) return cor;

        return Integer.compare(aluno1.getIdade(), aluno2.getIdade());
    }
}





