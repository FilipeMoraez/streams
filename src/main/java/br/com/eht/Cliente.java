package br.com.eht;


import java.util.Arrays;
import java.util.List;

public class Cliente{
    private String customerId;
    private List<Endereco> enderecos;

    public Cliente() {
    }

    public Cliente(String customerId, List<Endereco> enderecos) {
        this.customerId = customerId;
        this.enderecos = enderecos;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "customerId='" + customerId + '\'' +
                ", enderecos=" + enderecos +
                '}';
    }

    public static void populaClientesEnderecos(List<Cliente> clientes) {
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
}