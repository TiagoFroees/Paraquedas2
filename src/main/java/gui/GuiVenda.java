/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Tiago-PC
 */
@Named(value = "guiVenda")
@SessionScoped
public class GuiVenda implements Serializable {

    /**
     * Creates a new instance of GuiVenda
     */
    public GuiVenda() {
    }
    
}