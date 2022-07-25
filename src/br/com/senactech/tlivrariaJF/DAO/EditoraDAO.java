/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.TLivrariaJF.DAO;

import br.com.senactech.TLivrariaJF.conexao.Conexao;
import br.com.senactech.tlivrariaJF.model.Editora;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EditoraDAO {

    public ArrayList<Editora> selectEditora() throws SQLException {
        Connection con = Conexao.getConnection();
        Statement stmt = con.createStatement();
        try {
            String sql;
            sql = "select * from editora";
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Editora> editoras = new ArrayList<>();
            while (rs.next()) {
                Editora e = new Editora();
                e.setIdEditora(rs.getInt("ideditora"));
                e.setNmEditora(rs.getString("nomeEditora"));
                e.setEndereco(rs.getString("endereco"));
                e.setTelefone(rs.getString("telefone"));
                e.setGerente(rs.getString("gerente"));
                editoras.add(e);
            }
            return editoras;
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar Editora" + e.getMessage());
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    public void cadastrarEditora(Editora eVO) throws SQLException {
        Connection con = Conexao.getConnection();
        Statement stmt = con.createStatement();
        try {
            String sql;
            sql = "insert into editora values (null,'" + eVO.getNmEditora() + "','"
                    + eVO.getEndereco() + "','"
                    + eVO.getTelefone() + "','"
                    + eVO.getGerente() + "')";
            System.out.println(sql);
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao cadastrar editora!" + e.getMessage());
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    public void atualizarEditora(Editora eVO) throws SQLException {
        Connection con = Conexao.getConnection();
        Statement stmt = con.createStatement();
        try {
            String sql;
            sql = "update editora set "
                    + "endereco = '" + eVO.getEndereco() + "',"
                    + "telefone = '" + eVO.getTelefone() + "',"
                    + "gerente = '" + eVO.getGerente() + "'"
                    + "where ideditora = " + eVO.getIdEditora() + "";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao atualizar editora! " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    public Editora getByDocID(int id) throws SQLException {
        Connection con = Conexao.getConnection();
        Statement stat = con.createStatement();
        Editora e = new Editora();
        try {
            String sql;
            sql = "select * from editora where ideditora = " + id;
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                e.setIdEditora(rs.getInt("ideditora"));
                e.setNmEditora(rs.getString("nomeEditora"));
                e.setEndereco(rs.getString("endereco"));
                e.setTelefone(rs.getString("telefone"));
                e.setGerente(rs.getString("gerente"));
            }
        } catch (SQLException ev) {
            throw new SQLException("Editora com este id não existe. \n"
                    + ev.getMessage());
        } finally {
            con.close();
            stat.close();
        }
        return e;
    }

    public void deletarEditora(int id) throws SQLException {
        Connection con = Conexao.getConnection();
        Statement stmt = con.createStatement();
        try {
            String sql;
            sql = "delete from editora where ideditora = " + id;
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar editora! " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    public String getNomeEdt(int idEditora) throws SQLException {
        String nome = "";
        for (Editora edt : selectEditora()) {
            if (edt.getIdEditora() == idEditora) {
                nome = edt.getNmEditora();
                System.out.println("Editora: " + edt.getNmEditora());
            }
        }
        return nome;
    }

    public int getIdEditora(String nome) throws SQLException {
        int idEditora = 0;
        for (Editora edt : selectEditora()) {
            if (edt.getNmEditora().equals(nome)) {
                idEditora = edt.getIdEditora();
                System.out.println("Editora: " + edt.getNmEditora());
            }
        }
        return idEditora;
    }

}
