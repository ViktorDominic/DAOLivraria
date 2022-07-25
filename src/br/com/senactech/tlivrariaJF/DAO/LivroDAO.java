
package br.com.senactech.TLivrariaJF.DAO;

import br.com.senactech.TLivrariaJF.conexao.Conexao;
import br.com.senactech.tlivrariaJF.model.Livro;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class LivroDAO {

    public ArrayList<Livro> selectLivro() throws SQLException {
        Connection con = Conexao.getConnection();
        Statement stmt = con.createStatement();
        try {
            String sql;
            sql = "select * from livro";
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Livro> livros = new ArrayList<>();
            while (rs.next()) {
                Livro l = new Livro();
                l.setIdLivro(rs.getInt("idlivro"));
                l.setTitulo(rs.getString("tituloLivro"));
                l.setAutor(rs.getString("autor"));
                l.setAssunto(rs.getString("assunto"));
                l.setIsbn(rs.getString("isbn"));
                l.setEstoque(rs.getInt("estoque"));
                l.setPreco(rs.getFloat("valor"));
                l.setIdEditora(rs.getInt("ideditora"));
                livros.add(l);
            }
            return livros;
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar livros" + e.getMessage());
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    public void cadastrarLivro(Livro lVO) throws SQLException {
        Connection con = Conexao.getConnection();
        Statement stmt = con.createStatement();
        try {
            String sql;
            sql = "insert into livro values (null,'" + lVO.getTitulo() + "','"
                    + lVO.getIsbn() + "','"
                    + lVO.getAssunto() + "','"
                    + lVO.getAutor() + "',"
                    + lVO.getEstoque() + ","
                    + lVO.getPreco() + ","
                    + lVO.getIdEditora() + ")";
            System.out.println(sql);
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao cadastrar Livro!" + e.getMessage());
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    public void atualizarLivro(Livro lVO) throws SQLException {
        Connection con = Conexao.getConnection();
        Statement stmt = con.createStatement();
        try {
            String sql;
            sql = "update livro set"
                    + "tituloLivro = '" + lVO.getTitulo() + "',"
                    + "autor = '" + lVO.getAutor() + "',"
                    + "assunto = '" + lVO.getAssunto() + "',"
                    + "isbn = '" + lVO.getIsbn() + "',"
                    + "estoque = " + lVO.getEstoque() + ","
                    + "valor = " + lVO.getPreco() + "";
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao atualizar livro! " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    public void deletarLivro(int id) throws SQLException {
        Connection con = Conexao.getConnection();
        Statement stmt = con.createStatement();

        try {
            String sql;
            sql = "delete from livro where idlivro = " + id;
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar livro! " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
}
