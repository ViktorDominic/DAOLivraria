
package br.com.senactech.tlivrariaJF.model;

import java.util.Date;


public class VendaLivro {

    private int idcliente;
    private int idlivro;
    private int qtd;
    private float subTotal;
    private Date dataVenda;

    public VendaLivro() {
    }

    public VendaLivro(int idCliente, int idLivro, int qtd, float subTotal, Date dataVenda) {
        this.idcliente = idCliente;
        this.idlivro = idLivro;
        this.qtd = qtd;
        this.subTotal = subTotal;
        this.dataVenda = dataVenda;
    }

    public int getIdCliente() {
        return idcliente;
    }

    public void setIdCliente(int idCliente) {
        this.idcliente = idCliente;
    }

    public int getIdLivro() {
        return idlivro;
    }

    public void setIdLivro(int idLivro) {
        this.idlivro = idLivro;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    @Override
    public String toString() {
        return "vendaLivro{" + "idCliente=" + idcliente + ", idLivro=" + idlivro + ", qtd=" + qtd + ", subTotal=" + subTotal + ", dataVenda=" + dataVenda + '}';
    }
}
