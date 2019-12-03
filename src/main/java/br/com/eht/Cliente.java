package br.com.eht;


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
}