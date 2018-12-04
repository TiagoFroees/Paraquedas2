/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.FornecedorDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.Fornecedor;
import org.primefaces.component.messages.Messages;

/**
 *
 * @author Tiago-PC
 */
@Named(value = "guiFornecedor")
@SessionScoped
public class GuiFornecedor implements Serializable {

    private List<Fornecedor> fornecedores;
    private Fornecedor fornecedor;
    private Boolean incluindo;

    @EJB
    FornecedorDao daofornecedor;

    /**
     * Creates a new instance of GuiFornecedor
     */
    public GuiFornecedor() {
    }

    public String iniciarListaFornecedores() {
        fornecedores = daofornecedor.getFornecedores();
        return "LstFornecedores";

    }

    public String novoFornecedor() {
        fornecedor = new Fornecedor();
        incluindo = true;
        return "CadFornecedores";

    }

    public String gravarFornecedor() {
        if (incluindo == true) {
            daofornecedor.incluir(fornecedor);
            System.out.println("Fornecedor criado!");
        } else {
            daofornecedor.alterar(fornecedor);
            System.out.println("fornecedor editado!");
        }
        fornecedor = new Fornecedor();
        
        fornecedores = daofornecedor.getFornecedores();
        return "LstFornecedores";
    }

    public String alterarFornecedor(Fornecedor fornec) {
        fornecedor = fornec;
        incluindo = false;
        return "CadFornecedores";
    }

    public String excluirFornecedor(Fornecedor fornecedor) {
        daofornecedor.excluir(fornecedor);
        fornecedores = daofornecedor.getFornecedores();
        return "LstFornecedores";
    }

    public List<Fornecedor> getFornecedores() {
        if(fornecedor == null){
            fornecedor = new Fornecedor();
        }
        return fornecedores;

    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Boolean getIncluindo() {
        return incluindo;
    }

    public void setIncluindo(Boolean incluindo) {
        this.incluindo = incluindo;

    }

}
