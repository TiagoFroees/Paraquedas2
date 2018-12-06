/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.FuncionarioDao;
import model.Funcionario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.Fornecedor;

/**
 *
 * @author Tiago-PC
 */
@Named(value = "guiFuncionario")
@SessionScoped
public class GuiFuncionario implements Serializable {

    private List<Funcionario> funcionarios;
    private Funcionario funcionario;
    private Boolean incluindo;

    @EJB
    FuncionarioDao daofuncionario;

    /**
     * Creates a new instance of GuiFuncionario
     */
    public GuiFuncionario() {
    }

    public String iniciarListaFuncionarios() {
        funcionarios = daofuncionario.getFuncionarios();
        return "LstFuncionarios";

    }

    public String novoFuncionario() {
        funcionario = new Funcionario();
        incluindo = true;
        return "CadFuncionarios";

    }

    public String gravarFuncionario() {
        if (incluindo == true) {
            daofuncionario.incluir(funcionario);
            System.out.println("Funcionario criado!");
        } else {
            daofuncionario.alterar(funcionario);
            System.out.println("Funcionario editado!");
        }
        funcionario = new Funcionario();

        funcionarios = daofuncionario.getFuncionarios();
        return "LstFuncionarios";
    }

    public String alterarFuncionario(Funcionario funcio) {
        funcionario = funcio;
        incluindo = false;
        return "CadFuncionarios";
    }

    public String excluirFuncionario(Funcionario funcionario) {
        try {
            daofuncionario.excluir(funcionario);
            funcionarios = daofuncionario.getFuncionarios();
            System.out.println("Funcionario excluido com sucesso!");

        } catch (RuntimeException e) {
            System.out.println("Erro ao excluir funcionario " + e);
        }
        return "LstFuncionarios";
    }

    public List<Funcionario> getFuncionarios() {
        if (funcionario == null) {
            funcionario = new Funcionario();
        }
        return funcionarios;

    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Boolean getIncluindo() {
        return incluindo;
    }

    public void setIncluindo(Boolean incluindo) {
        this.incluindo = incluindo;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

}
