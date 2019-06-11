/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Venda;

/**
 *
 * @author Tiago-PC
 */
public class VendaWs {

    private LocalDate dataVenda;
    private BigDecimal valorTotal;

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public static List<VendaWs> toVendaWs(List<Venda> vendas) {
        List<VendaWs> vsw = new ArrayList();

        for (Venda v : vendas) {
            VendaWs vw = new VendaWs();
            vw.setDataVenda(v.getDataVenda());
            vw.setValorTotal(v.getValorTotal());

            vsw.add(vw);
        }

        return vsw;
    }

    public static Venda toVenda(VendaWs vendaWs) {

        Venda v = new Venda();

        v.setDataVenda(v.getDataVenda());
        v.setValorTotal(v.getValorTotal());
      

        return v;

    }

}
