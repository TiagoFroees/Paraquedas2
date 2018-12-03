/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Cliente;
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
public class ClienteDao {

    @PersistenceContext
    EntityManager em;

    public void incluir(Cliente cliente) {
        em.persist(cliente);
    }

    public void alterar(Cliente cliente) {
        em.merge(cliente);
    }

    public void excluir(Cliente cliente) {
        em.remove(em.merge(cliente));
    }

    public List<Cliente> getClientes(){
        Query q = em.createQuery("Select c from Cliente c");
        return q.getResultList();
    }

}
