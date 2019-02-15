/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cadma;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class jItens {

    private int codItensPedido;
    private int codPedido;
    private int codProduto;
    private String quantidade;
    private Float valorUni;
    private String especificacao;
    private Float valorTotal;

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }


    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public int getCodItensPedido() {
        return codItensPedido;
    }

    public void setCodItensPedido(int codItensPedido) {
        this.codItensPedido = codItensPedido;
    }

    public int getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public Float getValorUni() {
        return valorUni;
    }

    public void setValorUni(Float valorUni) {
        this.valorUni = valorUni;
    }

    void setCadastrar(ClassConecta conexao){

        try{
        //ClassConecta conexao = new ClassConecta();

        String comando = 
    "INSERT INTO itens_pedido  "+ 
	" (codItensPedido,  "+ 
	" codPedido,  "+ 
	" codProduto,  "+ 
	" quantidade,  "+ 
	" valorUni,  "+ 
	" especificacao,  "+
	" valorTotal "+ 
	" ) "+ 
	" VALUES "+ 
	" (null,  "+ 
	" ?,  "+ 
	" ?,  "+ 
	" ?,  "+ 
	" ?,  "+ 
	" ?,  "+ 
	" ?,  "+ 
	" ?)  ";



        System.out.println("Executando operação...");
        //conexao.conecta();
        PreparedStatement stmt = (PreparedStatement) conexao.con.prepareStatement(comando);
      

        if (getValorUni() == null){
            setValorUni((float) 0);
        }

        if (getValorTotal() == null){
            setValorTotal((float) 0);
        }


        stmt.setInt(1,getCodItensPedido());
        stmt.setInt(2,getCodPedido());
        stmt.setInt(3, getCodPedido());
        stmt.setInt(4,getCodProduto());
        stmt.setString(5,getQuantidade());
        stmt.setFloat(6,getValorUni());
        stmt.setString(7,getEspecificacao());
        stmt.setFloat(8, getValorTotal());
       


        stmt.execute();

        System.out.println("Transação Concluída");
        //JOptionPane.showMessageDialog(null, "Transação Concluída", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }

// colocar o metodo getConsultar ItensPedido






}
