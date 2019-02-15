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
 * @author Vitiazze
 */

public class Funcionarios implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer codFuncionario;
    private String funcionario;
    private String cpf;
    private String rg;
    private String endereco;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
    private String telefone;
    private String cargo;
    private String usuario;
    private String senha;
    private String resenha;
    private String tipoUser;
    private String complemento;




    public Funcionarios() {
    }

    public Funcionarios(Integer codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public Integer getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(Integer codFunc) {
        this.codFuncionario = codFunc;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getResenha() {
        return resenha;
    }

    public void setResenha(String resenha) {
        this.resenha = resenha;
    }

    public String getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento( String complemento) {
        this.complemento = complemento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFuncionario != null ? codFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionarios)) {
            return false;
        }
        Funcionarios other = (Funcionarios) object;
        if ((this.codFuncionario == null && other.codFuncionario != null) || (this.codFuncionario != null && !this.codFuncionario.equals(other.codFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cadma.Funcionarios[codFunc=" + codFuncionario + "]";
    }


              void setCadastrar(ClassConecta conexao){
  try{


        String comando = "INSERT INTO funcionarios  "+
" 	(codFuncionario,  "+
" 	funcionario,  "+
" 	cpf,  "+
"       rg, "+
"       endereco, "+
"       numero, "+
"       bairro, "+
"       cidade, "+
"       uf, "+
"       telefone, "+
"       complemento, "+
"       cargo, "+
"       usuario, "+
"       senha, "+
"       resenha, "+
"       tipoUser "+
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
"       ?,  "+
"       ?,  "+
"       ?,  "+
"       ?,  "+
"       ?   "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) conexao.con.prepareStatement(comando);

        stmt.setString(1,getFuncionario());
        stmt.setString(2,getCpf());
        stmt.setString(3, getRg());
        stmt.setString(4, getEndereco());
        stmt.setString(5, getNumero());
        stmt.setString(6, getBairro());
        stmt.setString(7, getCidade());
        stmt.setString(8, getUf());
        stmt.setString(9, getTelefone());
        stmt.setString(10, getComplemento());
        stmt.setString(11, getCargo());
        stmt.setString(12, getUsuario());
        stmt.setString(13, getSenha());
        stmt.setString(14, getResenha());
        stmt.setString(15, getTipoUser());

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
                    "from funcionarios "+
                    "where codFuncionario = codFuncionario ";

            int quantParam = 0;

            if (getFuncionario() != null) {
                comando = comando + "AND funcionario like ?";
            }
            if (getCodFuncionario() != null){
               comando = comando + " AND codFuncionario = ? ";
            }




            comando = comando + " order by codFuncionario,funcionario ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = conexao.con.prepareStatement(comando);


           if (getFuncionario() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getFuncionario()+"%");

            }
            if (getCodFuncionario() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCodFuncionario());

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

        String comando = "UPDATE funcionarios "+
" 	SET "+
" 	funcionario = ?,  "+
" 	cpf = ?,  "+
"       rg = ?, "+
"       endereco = ?, "+
"       numero = ?, "+
"       bairro = ?, "+
"       cidade = ?, "+
"       uf = ?, "+
"       telefone = ?, "+
"       complemento = ?, "+
"       cargo = ?, "+
"       usuario = ?, "+
"       senha = ?, "+
"       resenha = ?, "+
"       tipoUser = ? "+
" 	WHERE "+
" 	codFuncionario = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) conexao.con.prepareStatement(comando);

        stmt.setString(1,getFuncionario());
        stmt.setString(2,getCpf());
        stmt.setString(3, getRg());
        stmt.setString(4, getEndereco());
        stmt.setString(5, getNumero());
        stmt.setString(6, getBairro());
        stmt.setString(7, getCidade());
        stmt.setString(8, getUf());
        stmt.setString(9, getTelefone());
        stmt.setString(10, getComplemento());
        stmt.setString(11, getCargo());
        stmt.setString(12, getUsuario());
        stmt.setString(13, getSenha());
        stmt.setString(14, getResenha());
        stmt.setString(15, getTipoUser());
        stmt.setInt(16, getCodFuncionario());

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

" DELETE FROM funcionarios  "+
" 	WHERE "+
" 	codFuncionario = ?  ";

        PreparedStatement stmt = (PreparedStatement) conexao.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCodFuncionario());


        stmt.executeUpdate();

        //System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi excluído com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }


















}
