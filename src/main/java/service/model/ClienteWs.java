/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

/**
 *
 * @author Tiago-PC
 */
public class ClienteWs {

    private String nome;
    private String endereco;
    private String bairro;
    private String telefone;
    private String email;
    private LocalDate dataNascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public static List<ClienteWs> toClienteWs(List<Cliente> clientes) {
        List<ClienteWs> csw = new ArrayList();

        for (Cliente c : clientes) {
            ClienteWs cw = new ClienteWs();
            cw.setEndereco(c.getEndereco());
            cw.setBairro(c.getBairro());
            cw.setNome(c.getNome());
            cw.setTelefone(c.getTelefone());

            csw.add(cw);
        }

        return csw;
    }

    public static Cliente toCliente(ClienteWs clienteWs) {

        Cliente c = new Cliente();

        c.setNome(clienteWs.getNome());
        c.setTelefone(clienteWs.getTelefone());
        c.setEndereco(clienteWs.getEndereco());

   
        return c;

    }
}
