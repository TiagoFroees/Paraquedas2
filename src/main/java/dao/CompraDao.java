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
import model.Compra;
import model.ItemCompra;

/**
 *
 * @author Tiago-PC
 */
@Stateless
public class CompraDao {
    
    
    @PersistenceContext
    EntityManager em;

    public void incluir(Compra compra) {
        em.persist(compra);
    }
    public void alterar(Compra compra) {
        em.merge(compra);
    }
    public void excluir(Compra compra) {
        em.remove(em.merge(compra ));
    }

    public List<ItemCompra> getItensCompra() {
        Query  q = em.createQuery("Select  c from Compra  c ");
        return q.getResultList();
    }
    
}
