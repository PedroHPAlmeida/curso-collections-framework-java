package list.exercicios;

/*Utilizando listas, faça um programa que faça 5 perguntas para uma
pessoa sobre um crime. As perguntas são:
    "Telefonou para a vítima?"
    "Esteve no local do crime?"
    "Mora perto da vítima?"
    "Devia para a vítima?"
    "Já trabalhou com a vítima?"
Se a pessoa responder positivamente a 2 questões ela deve ser
classificada como "Suspeita", entre 3 e 4 como "Cúmplice" e 5 como
"Assassina". Caso contrário, ela será classificado como "Inocente".*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class Exercicio02 {
    public static void main(String[] args) throws IOException {
        // Lista de perguntas
        List<String> perguntas = new ArrayList<>(){{
            add("Telefonou para a vítima?");
            add("Esteve no local do crime?");
            add("Mora perto da vítima?");
            add("Devia para a vítima?");
            add("Já trabalhou com a vítima?");
        }};

        // entrada das respostas
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<String> respostas = new ArrayList<>();

        Iterator<String> iterator = perguntas.iterator();
        System.out.println("---\tRespontas apenas com [S/N]\t---");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
            respostas.add(bf.readLine().toUpperCase(Locale.ROOT));
        }

        // verificacao das respostas
        int contRespostasSim = 0;
        iterator = respostas.iterator();
        while(iterator.hasNext()){
            if(iterator.next().equalsIgnoreCase("S")) contRespostasSim++;
        }

        // classificando a pessoa de acordo com as respostas
        switch (contRespostasSim) {
            case 1 -> System.out.println("Inocente");
            case 2 -> System.out.println("Suspeita");
            case 3, 4 -> System.out.println("Cúmplice");
            case 5 -> System.out.println("Assassina");
        }
    }
}
