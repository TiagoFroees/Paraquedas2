/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.CompraDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import model.Compra;

/**
 *
 * @author Tiago-PC
 */
@Named(value = "guiCompra")
@SessionScoped
public class GuiCompra implements Serializable {
    
    @EJB
    CompraDao daoCompra;
    
    
    private Compra compra;
    

    public GuiCompra() {
      
    }

private String iniciar(){
    compra = new Compra();
    
    return"CadCompra";
}

}
