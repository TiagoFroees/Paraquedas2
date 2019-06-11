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
import model.Usuario;

/**
 *
 * @author Tiago-PC
 */

@Stateless
public class UsuarioDao {

    @PersistenceContext
    EntityManager em;

    public void incluir(Usuario usuario) {
        em.persist(usuario);
    }

    public void alterar(Usuario usuario) {
        em.merge(usuario);
    }

    public void excluir(Usuario usuario) {
        em.remove(em.merge(usuario));
    }

    public List<Usuario> getUsuarios() {
        Query q = em.createQuery("Select u from Usuario u");
        return q.getResultList();
    }

}
