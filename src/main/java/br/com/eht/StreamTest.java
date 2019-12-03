package br.com.eht;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {

        // Convertendo arrays em streams
        conversao(false);
        // Lidando arrays em paralelo
        processamentoParalelo(false);
        // Verifica se contem na lista
        exists(false);
        // Aplica filtro
        filtro(false);
        // Contadores com condições de lista
        contador(false);
        // True/false para quem match na lista
        match(true);
    }

    private static  void conversao(boolean out){
        String[] arr = new String[]{"a1", "b2", "c3"};
        if(out) print(arr);
        Stream<String> stream = Arrays.stream(arr);
        Stream<String> streamOf = Stream.of("aA", "bB", "cC");

        if (out) print("Conversão de array para stream");
        if (out) stream.forEach(StreamTest::print);
        if (out) print("Declaração de stream já na assinatura");
        if (out) streamOf.forEach(StreamTest::print);
    }
    private static void processamentoParalelo(boolean out){
        List<String> array = Arrays.asList("Primeiro", "Segundo", "Terceiro", "Quarto", "Quinto", "Sexto");
        if(out) print(array);
        if(out) System.out.print(array);
        if (out) array.forEach(StreamTest::print);
        if (out) array.stream().forEach(StreamTest::print);
    }
    private static void exists(boolean out){
        List<String> array = Arrays.asList("Primeiro", "Segundo", "Terceiro", "Quarto", "Quinto", "Sexto");
        boolean quarto = array.stream().anyMatch(e -> e.equals("Quarto"));
        boolean teste = array.stream().anyMatch(e -> e.equals("teste"));
        boolean containsPedaco = array.stream().anyMatch(e -> e.indexOf("Ter")>=0);
        if(out) print("Lista: "+array);
        if(out) print("Existe o 'Quarto' na lista: "+quarto);
        if(out) print("Existe o 'teste' na lista: "+teste);
        if(out) print("Alguém da lista começa com 'Ter' : "+containsPedaco);
    }

    private static void filtro(boolean out){
        List<String> array = Arrays.asList("Primeiro", "Segundo", "Terceiro", "Quarto", "Quinto", "Sexto", "Sétimo", "Oitavo");
        if(out) print("Lista: "+array);

        // Exemplo retornando uma lista
        List<String> filtradoQ = array.stream().filter(e -> e.startsWith("Q")).collect(Collectors.toList());

        Stream<String> filtradoTerceiro = array.stream().filter(e -> e.equals("Terceiro"));

        String sexta = array.stream().filter(e -> e.startsWith("Sext")).findFirst().get();
        String naoEncontra = array.stream().filter(e -> e.startsWith("ASDSD")).findFirst().orElse(null);

        if(out) print("Filtrado quem começa com Q :" + filtradoQ);
        if(out) print("Filtrado quem é igual com Terceiro :" + filtradoTerceiro.collect(Collectors.toList()));
        if(out) print("O primeiro que começa com 'sext' :" + sexta);
        if(out) print("O primeiro que começa com 'ASDSD' :" + naoEncontra);
    }

    private static void contador(boolean out) {
        List<String> array = Arrays.asList("Primeiro", "Segundo", "Terceiro", "Quarto", "Quinto", "Sexto", "Sétimo", "Oitavo");
        if(out) print("Lista: "+array);

        long comecaComQ = array.stream().filter(e -> e.startsWith("Q")).count();
        long comecaComS = array.stream().filter(e -> e.startsWith("S")).count();
        long comecaComI = array.stream().filter(e -> e.startsWith("I")).count();
        if (out) print("Começa com Q : "+ comecaComQ );
        if (out) print("Começa com S: "+ comecaComS );
        if (out) print("Começa com I: "+ comecaComI );
    }
    private static void match(boolean out){


    }




    private static void print(Object any){
        System.out.println(any);
    }




}




