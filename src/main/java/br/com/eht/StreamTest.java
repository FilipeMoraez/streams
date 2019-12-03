package br.com.eht;

import java.util.ArrayList;
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
        // percorre a lista de clientes e adiciona em uma outra lista todos os endereços de todos clientes
        mapSubItens(true);
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
        List<String> array = Arrays.asList("Primeiro_", "Segundo_", "Terceiro_", "Quarto_", "Quinto_", "Sexto_", "Sétimo_", "Oitavo_");
        if(out) print("Lista: "+array);

        boolean existeUltimo = array.stream().anyMatch(e -> e.equals("Ultimo"));
        boolean existePrimeiro = array.stream().anyMatch(e -> e.equals("Primeiro"));
        boolean existeALgumComUndo = array.stream().anyMatch(e -> e.indexOf("undo")>=0);

        boolean todosComecamComP = array.stream().allMatch(e -> e.equals("P"));
        boolean todosTerminamComUnder = array.stream().allMatch(e -> e.endsWith("_"));


        if(out) print("Existe a string 'Ultimo' : " + existeUltimo);
        if(out) print("Existe a string 'Primeiro' : " + existePrimeiro);
        if(out) print("Existe a algum com  'undo' na string : " + existeALgumComUndo);

        if(out) print("Todos começam com p : " + todosComecamComP);
        if(out) print("Todos terminam com _  : " + todosTerminamComUnder);


    }
    private static void mapSubItens(boolean out){
        List<Cliente> clientes = new ArrayList<>();
        populaClientesEnderecos(clientes);
        if(out) print("Lista de clientes :" + clientes);

        List<Endereco> todosEnderecos = clientes.stream().flatMap(cliente -> cliente.getEnderecos().stream()).collect(Collectors.toList());
        List<Endereco> todosEnderecosComN = clientes.stream().flatMap(cliente -> cliente.getEnderecos().stream().filter(e -> e.getRua().startsWith("N"))).collect(Collectors.toList());

        if(out) print(todosEnderecos);
        if(out) print(todosEnderecosComN);
    }



    private static void populaClientesEnderecos(List<Cliente> clientes) {
        clientes.add(
                new Cliente("1003",
                        Arrays.asList(
                                new Endereco("Nicolas Cage", "410")
                        )
                )
        );
        clientes.add(
                new Cliente("1002",
                        Arrays.asList(
                                new Endereco("Padre Oliveiros", "1"),
                                new Endereco("Castelo Branco", "99"),
                                new Endereco("Tavares", "9")
                        )
                )
        );
        clientes.add(
                new Cliente("1001",
                        Arrays.asList(
                                new Endereco("Jose Padilha", "2")
                        )
                )
        );
        clientes.add(
                new Cliente("9991",
                        Arrays.asList(
                                new Endereco("Nicolau Maevisky", "43"),
                                new Endereco("Nicolai Maestro", "1")
                        )
                )
        );
        clientes.add(
                new Cliente("2000",
                        Arrays.asList(
                                new Endereco("Nicolau Maevisky", "410"),
                                new Endereco("Nicolau Maevisky", "410"),
                                new Endereco("Nicolau Maevisky", "410")
                        )
                )
        );
    }


    public static void print(Object any){
        System.out.println(any);
    }
}




