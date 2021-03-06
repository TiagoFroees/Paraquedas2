/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.PessoaDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.Pessoa;

/**
 *
 * @author Tiago-PC
 */
@Named(value = "guiPessoa")
@SessionScoped
public class GuiPessoa implements Serializable {

    private List<Pessoa> pessoas;
    private Pessoa pessoa;
    private Boolean incluindo;

    @EJB
    PessoaDao daopessoa;

    /**
     * Creates a new instance of GuiPessoa
     */
    public GuiPessoa() {
    }

    public String iniciarListaPessoas() {
        pessoas = daopessoa.getPessoas();
        return "LstPessoas";

    }

    public String novaPessoa() {
        pessoa = new Pessoa();
        incluindo = true;
        return "CadPessoas";

    }

    public String gravarPessoa() {
        if (incluindo) {
            daopessoa.incluir(pessoa);
        } else {
            daopessoa.alterar(pessoa);
        }
        pessoas = daopessoa.getPessoas();
        return "LstPessoas";
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public String excluirPessoa(Pessoa pessoa) {
        daopessoa.excluir(pessoa);
        pessoas = daopessoa.getPessoas();
        return "LstPessoas";
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Boolean getIncluindo() {
        return incluindo;
    }

    public void setIncluindo(Boolean incluindo) {
        this.incluindo = incluindo;
    }

}
