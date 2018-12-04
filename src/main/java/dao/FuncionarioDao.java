/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Funcionario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Tiago-PC
 */
@Stateless
public class FuncionarioDao {

    @PersistenceContext
    EntityManager em;

    public void incluir(Funcionario funcionario) {
        em.persist(funcionario);
    }

    public void alterar(Funcionario funcionario) {
        em.merge(funcionario);
    }

    public void excluir(Funcionario funcionario) {
        em.remove(em.merge(funcionario));
    }

    public List<Funcionario> getFuncionarios() {
        Query q = em.createQuery("Select d from Funcionario d");
        return q.getResultList();
    }

}
