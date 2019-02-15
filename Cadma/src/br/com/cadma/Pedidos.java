/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cadma;

import com.mysql.jdbc.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


/**
 *
 * @author Luciano Carrafa Benfica
 */
public class Pedidos {

private int codPedido;
private int codFuncionario;
private int codCliente;
private String situacao;
private String tipoPedido;
private Date data;
private String observacao;
private int codEmpresa;
private Float valorPago;
private Float diferenca;
private Float desconto;

    public Float getDesconto() {
        return desconto;
    }

    public void setDesconto(Float desconto) {
        this.desconto = desconto;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public int getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(int codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public int getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public int getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Float getDiferenca() {
        return diferenca;
    }

    public void setDiferenca(Float diferenca) {
        this.diferenca = diferenca;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public Float getValorPago() {
        return valorPago;
    }

    public void setValorPago(Float valorPago) {
        this.valorPago = valorPago;
    }



    void setCadastrar(ClassConecta conexao){

        try{

        String comando = " INSERT INTO pedidos " +
" (codPedido,       " +
" codFuncionario,   " +
" codCliente,       " +
" situacao,         " +
" tipoPedido,       " +
" data,             " +
" observacao,       " +
" codEmpresa,       " +
" valorPago,        " +
" diferenca         " +
" )" +
" VALUES" +
" (null, " +
" ?, " +
" ?, " +
" ?, " +
" ?, " +
" ?, " +
" ?, " +
" ?, " +
" ?, " +
" ? " +
" ) ";


       System.out.println("Executando operação...");
        PreparedStatement stmt = (PreparedStatement) conexao.con.prepareStatement(comando);

        //Formado da data
    //    SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");


        //Formatar data
        String oDataPedido = null;
        if (getData() != null){
          SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
          oDataPedido = formatoData.format(getData());
        }
        if (getValorPago() == null){
            setValorPago((float) 0);
        }
        if (getDiferenca() == null){
            setDiferenca((float) 0);
        }

        stmt.setInt(1,getCodFuncionario());
        stmt.setInt(2, getCodCliente());
        stmt.setString(3,getSituacao());
        stmt.setString(4,getTipoPedido());
        stmt.setString(5, oDataPedido);
        stmt.setString(6,getObservacao());
        stmt.setInt(7, getCodEmpresa());
        stmt.setFloat(8, getValorPago());
        stmt.setFloat(9, getDiferenca());



        stmt.execute();

        System.out.println("Transação Concluída");
        //JOptionPane.showMessageDialog(null, "Transação Concluída", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }


     public ResultSet getConsultarPedido(ClassConecta conexao) throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "SELECT p.codPedido as 'Pedido', c.nome , p.data as 'Data do Pedido',f.funcionario " +
                    "FROM pedidos p, funcionarios f, clientes c "+
                    "WHERE p.codPedido = p.codPedido "+
                    "AND c.codCliente = p.codCliente "+
                    "AND f.codFuncionario = p.codFuncionario";

            int quantParam = 0;


            if (getCodPedido() > 0){
               comando = comando + " AND p.codPedido = ? ";
            }

            if (getCodCliente() > 0){
               comando = comando + " AND c.codCliente = ? ";
            }

            comando = comando + " order by p.codPedido ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = conexao.con.prepareStatement(comando);

            if (getCodPedido() > 0){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodPedido());
            }

        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }
















    

}
















