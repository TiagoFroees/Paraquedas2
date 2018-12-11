/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Produto;

/**
 *
 * @author Tiago-PC
 */
@Stateless
public class ProdutoDao {

    @PersistenceContext
    EntityManager em;

    public void incluir(Produto produto) {
        em.persist(produto);
    }

    public void alterar(Produto produto) {
        em.merge(produto);
    }

    public void excluir(Produto produto) {
        em.remove(em.merge(produto));
    }

    public void gravar(Produto object, boolean edit) {
        if (edit == false) {
            em.persist(object);
        } else {
            em.merge(object);
        }
    }

    public List<Produto> getProdutos() {
        Query q = em.createQuery("Select o from Produto o");
        return q.getResultList();
    }

}
