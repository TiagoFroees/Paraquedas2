/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Compra;
import model.ItemVenda;

/**
 *
 * @author Tiago-PC
 */
public class VendaDao {

    @PersistenceContext
    EntityManager em;

    public void gravar(Compra object, boolean edit) {
        if (edit == false) {
            em.persist(object);
        } else {
            em.merge(object);
        }
    }

    public void gravar(ItemVenda object, boolean edit) {
        if (edit == false) {
            em.persist(object);
        } else {
            em.merge(object);
        }
    }

}
