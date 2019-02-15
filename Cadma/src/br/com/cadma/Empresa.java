/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cadma;

import com.mysql.jdbc.PreparedStatement;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 *
 * @author LKFalcao
 */

public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;
   
    private Integer codEmpresa;
    private String empresa;
    private String cnpj;
    private String insEstadual;
    private String endereco;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
    private String telefone;
    private String homePage;
    private String email;

    public Empresa() {
    }

    public Empresa(Integer codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public Integer getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(Integer codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInsEstadual() {
        return insEstadual;
    }

    public void setInsEstadual(String insEstadual) {
        this.insEstadual = insEstadual;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEmpresa != null ? codEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.codEmpresa == null && other.codEmpresa != null) || (this.codEmpresa != null && !this.codEmpresa.equals(other.codEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cadma.Empresa[codEmpresa=" + codEmpresa + "]";
    }

          void setCadastrar(ClassConecta conexao){
  try{


        String comando = "INSERT INTO empresa  "+
" 	(codEmpresa,  "+
" 	empresa,  "+
" 	cnpj,  "+
" 	insEstadual, "+
"       endereco, "+
"       numero, "+
"       bairro, "+
"       cidade,"+
"       uf, "+
"       telefone, "+
"       email, "+
"       homePage"+
" 	) "+
" 	VALUES "+
" 	(null,  "+
" 	?,  "+
" 	?,  "+
"       ?,  "+
"       ?,  "+
"       ?,  "+
"       ?,  "+
"       ?,  "+
"       ?,  "+
"       ?,  "+
"       ?,  "+
"       ?   "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) conexao.con.prepareStatement(comando);

        stmt.setString(1,getEmpresa());
        stmt.setString(2,getCnpj());
        stmt.setString(3, getInsEstadual());
        stmt.setString(4, getEndereco());
        stmt.setString(5, getNumero());
        stmt.setString(6, getBairro());
        stmt.setString(7, getCidade());
        stmt.setString(8, getUf());
        stmt.setString(9, getTelefone());
        stmt.setString(10, getEmail());
        stmt.setString(11, getHomePage());

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
                    "from empresa "+
                    "where codEmpresa = codEmpresa ";

            int quantParam = 0;

            if (getEmpresa() != null) {
                comando = comando + "AND empresa like ?";
            }
            if (getCodEmpresa() != null){
               comando = comando + " AND codEmpresa = ? ";
            }




            comando = comando + " order by codEmpresa,empresa ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = conexao.con.prepareStatement(comando);


           if (getEmpresa() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getEmpresa()+"%");

            }
            if (getCodEmpresa() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodEmpresa());

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

        String comando = "UPDATE empresa "+
" 	SET "+
" 	empresa = ?,        "+
" 	cnpj = ?,     "+
"       insEstadual = ?, "+
"       endereco = ?,    "+
"       numero = ?,      "+
"       bairro = ?,      "+
"       cidade = ?,      "+
"       uf = ?,          "+
"       telefone = ?,    "+
"       email = ?,        "+
"       homePage = ? "+
" 	WHERE "+
" 	codEmpresa = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) conexao.con.prepareStatement(comando);

        stmt.setString(1, getEmpresa());
        stmt.setString(2, getCnpj());
        stmt.setString(3, getInsEstadual());
        stmt.setString(4, getEndereco());
        stmt.setString(5, getNumero());
        stmt.setString(6, getBairro());
        stmt.setString(7, getCidade());
        stmt.setString(8, getUf());
        stmt.setString(9, getTelefone());
        stmt.setString(10, getEmail());
        stmt.setString(11, getHomePage());
        stmt.setInt(12, getCodEmpresa());

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

" DELETE FROM empresa  "+
" 	WHERE "+
" 	codEmpresa = ?  ";

        PreparedStatement stmt = (PreparedStatement) conexao.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCodEmpresa());


        stmt.executeUpdate();

        //System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi excluído com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }



}
}
