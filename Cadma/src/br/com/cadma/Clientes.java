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

public class Clientes implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer codCliente;
    private String nome;
    private String tipoCliente;
    private String cpfCnpj;
    private String rgInsEstadual;
    private String endereco;
    private String numero;
    private String bairro;
    private String complemento;
    private String cidade;
    private String uf;
    private String telefone;
    private String email;


    public Clientes() {
    }

    public Clientes(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoPessoa) {
        this.tipoCliente = tipoPessoa;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getRgInsEstadual() {
        return rgInsEstadual;
    }

    public void setRgInsEstadual(String rgInsEstadual) {
        this.rgInsEstadual = rgInsEstadual;
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

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCliente != null ? codCliente.hashCode() : 0);
        return hash;
    }
 

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.codCliente == null && other.codCliente != null) || (this.codCliente != null && !this.codCliente.equals(other.codCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cadma.Clientes[codCliente=" + codCliente + "]";
    }


          void setCadastrar(ClassConecta conexao){
  try{


        String comando = "INSERT INTO clientes  "+
" 	(codCliente,  "+
" 	nome,  "+
" 	tipoCliente,  "+
" 	cpfCnpj, "+
"       rgInsEstadual, "+
"       endereco, "+
"       numero, "+
"       bairro, "+
"       complemento, "+
"       cidade,"+
"       uf, "+
"       telefone, "+
"       email "+
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
"       ?,   "+
"       ?   "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) conexao.con.prepareStatement(comando);

        stmt.setString(1,getNome());
        stmt.setString(2,getTipoCliente());
        stmt.setString(3, getCpfCnpj());
        stmt.setString(4, getRgInsEstadual());
        stmt.setString(5, getEndereco());
        stmt.setString(6, getNumero());
        stmt.setString(7, getBairro());
        stmt.setString(8, getComplemento());
        stmt.setString(9, getCidade());
        stmt.setString(10, getUf());
        stmt.setString(11, getTelefone());
        stmt.setString(12, getEmail());

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
                    "from clientes "+
                    "where codCliente = codCliente ";

            int quantParam = 0;

            if (getNome() != null) {
                comando = comando + "AND nome like ?";
            }
            if (getCodCliente() != null){
               comando = comando + " AND codCliente = ? ";
            }




            comando = comando + " order by codCliente,nome ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = conexao.con.prepareStatement(comando);


           if (getNome() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getNome()+"%");

            }
            if (getCodCliente() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodCliente());

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

        String comando = "UPDATE clientes "+
" 	SET "+
" 	nome = ?,        "+
" 	tipoCliente = ?,  "+
" 	cpfCnpj = ?,     "+
"       rgInsEstadual = ?,          "+
"       endereco = ?,    "+
"       numero = ?,      "+
"       bairro = ?,      "+
"       complemento = ?, "+
"       cidade = ?,      "+
"       uf = ?,          "+
"       telefone = ?,    "+
"       email = ?        "+
" 	WHERE "+
" 	codCliente = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) conexao.con.prepareStatement(comando);

        stmt.setString(1, getNome());
        stmt.setString(2, getTipoCliente());
        stmt.setString(3, getCpfCnpj());
        stmt.setString(4, getRgInsEstadual());
        stmt.setString(5, getEndereco());
        stmt.setString(6, getNumero());
        stmt.setString(7, getBairro());
        stmt.setString(8, getComplemento());
        stmt.setString(9, getCidade());
        stmt.setString(10, getUf());
        stmt.setString(11, getTelefone());
        stmt.setString(12, getEmail());
        stmt.setInt(13, getCodCliente());

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

" DELETE FROM clientes  "+
" 	WHERE "+
" 	codCliente = ?  ";

        PreparedStatement stmt = (PreparedStatement) conexao.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCodCliente());


        stmt.executeUpdate();

        //System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi excluído com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }
























}
