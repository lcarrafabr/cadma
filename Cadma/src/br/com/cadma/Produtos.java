/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cadma;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/**
 *
 * @author Vitiazze
 */

public class Produtos implements Serializable {
    private static final long serialVersionUID = 1L;
     private Integer codProduto;
    private String produto;
    private Float quantidade;
    private String especificacao;
    private Double valorUnit;

    public Produtos() {
    }

    public Produtos(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public Integer getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public Double getValorUnit() {
        return valorUnit;
    }

    public void setValorUnit(double  valorUnit) {
        this.valorUnit = valorUnit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProduto != null ? codProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtos)) {
            return false;
        }
        Produtos other = (Produtos) object;
        if ((this.codProduto == null && other.codProduto != null) || (this.codProduto != null && !this.codProduto.equals(other.codProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cadma.Produtos[codProduto=" + codProduto + "]";
    }



      void setCadastrar(ClassConecta conexao){
  try{


        String comando = "INSERT INTO produtos  "+
" 	(codProduto,  "+
" 	produto,  "+
" 	quantidade,  "+
" 	especificacao, "+
"       valorUnit "+
" 	) "+
" 	VALUES "+
" 	(null,  "+
" 	?,  "+
" 	?,  "+
"       ?," +
"       ? "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) conexao.con.prepareStatement(comando);

        stmt.setString(1,getProduto());
        stmt.setFloat(2,getQuantidade());
        stmt.setString(3,getEspecificacao());
        stmt.setDouble(4,getValorUnit());

        stmt.execute();

        //System.out.println("Transação Concluída");
        //JOptionPane.showMessageDialog(null, "Transação Concluída", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
}

     public ResultSet getConsultar(ClassConecta conexao) throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "select * " +
                    "from produtos "+
                    "where codProduto = codProduto ";

            int quantParam = 0;

            if (getCodProduto() != null){
               comando = comando + " AND codProduto = ? ";
            }

            comando = comando + " order by codProduto ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = conexao.con.prepareStatement(comando);

            if (getCodProduto() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodProduto());

            }

        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }



  void setAlterar(ClassConecta conexao){

        try{
        //ClassConecta conexao = new ClassConecta();

        //conexao.conecta();

        String comando = "UPDATE produtos "+
" 	SET "+
" 	produto       = ?,        "+
" 	quantidade    = ?,  "+
" 	valorUnit     = ?,     "+
"       especificacao = ?  "+
" 	WHERE "+
" 	codProduto = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) conexao.con.prepareStatement(comando);

        stmt.setString(1, getProduto());
        stmt.setFloat(2, getQuantidade());
        stmt.setDouble(3, getValorUnit());
        stmt.setString(4, getEspecificacao());
        stmt.setInt(5, getCodProduto());

        stmt.executeUpdate();

        System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi salvo com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }


    }




         void setExcluir(ClassConecta conexao){

        try{
        //ClassConecta conexao = new ClassConecta();

        //conexao.conecta();

        String comando =

" DELETE FROM produtos  "+
" 	WHERE "+
" 	codProduto = ?  ";

        PreparedStatement stmt = (PreparedStatement) conexao.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCodProduto());


        stmt.executeUpdate();

        //System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi excluído com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }











}

