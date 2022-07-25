/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.TLivrariaJF.DAO;

import br.com.senactech.tlivrariaJF.model.Cliente;
import br.com.senactech.TLivrariaJF.conexao.Conexao;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;


public class ClienteDAO {

    public ArrayList<Cliente> selectCliente() throws SQLException {
        Connection con = Conexao.getConnection();
        Statement stmt = con.createStatement();
        try {
            String sql;
            sql = "select * from cliente";
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Cliente> clientes = new ArrayList<>();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdcliente(rs.getInt("idcliente"));
                c.setNome(rs.getString("nome"));
                c.setEndereco(rs.getString("enderecoCompleto"));
                c.setTelefone(rs.getString("telefone"));
                c.setCpf(rs.getString("cpf"));
                c.setCnpj(rs.getString("cnpj"));
                clientes.add(c);
            }
            return clientes;
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar Clientes" + e.getMessage());
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    public void cadastrarClienteCPF(Cliente cVO) throws SQLException {
        Connection con = Conexao.getConnection();
        Statement stmt = con.createStatement();
        try {
            String sql;
            sql = "insert into cliente values (null,'" + cVO.getNome() + "','"
                    + cVO.getEndereco() + "','"
                    + cVO.getTelefone() + "','"
                    + cVO.getCpf() + "',"
                    + "null" + ")";
            System.out.println(sql);
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao cadastrar cliente Físico! " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    public void cadastrarClienteCNPJ(Cliente cVO) throws SQLException {
        Connection con = Conexao.getConnection();
        Statement stmt = con.createStatement();
        try {
            String sql;
            sql = "insert into cliente values (null,'" + cVO.getNome() + "','"
                    + cVO.getEndereco() + "','"
                    + cVO.getTelefone() + "',"
                    + "null" + ",'"
                    + cVO.getCnpj() + "')";
            System.out.println(sql);
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao cadastrar cliente Jurídico! " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    public void atualizarCliente(Cliente cVO) throws SQLException {
        Connection con = Conexao.getConnection();
        Statement stmt = con.createStatement();
        try {
            String sql;
            sql = "update cliente set "
                    + "nome = '" + cVO.getNome() + "',"
                    + "enderecoCompleto = '" + cVO.getEndereco() + "',"
                    + "telefone = '" + cVO.getTelefone() + "' "
                    + "where idCliente = " + cVO.getIdcliente() + "";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao atualizar cliente! " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    public Cliente getByDocCPF(String cpf) throws SQLException {
        Connection con = Conexao.getConnection();
        Statement stmt = con.createStatement();
        Cliente c = new Cliente();
        try {
            String sql;
            sql = "select * from cliente where cpf = " + cpf;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                c.setIdcliente(rs.getInt("idcliente"));
                c.setNome(rs.getString("nome"));
                c.setEndereco(rs.getString("enderecoCompleto"));
                c.setTelefone(rs.getString("telefone"));
                c.setCpf(rs.getString("cpf"));
            }
        } catch (SQLException e) {
            throw new SQLException("Cliente com este CPF não existe. \n"
                    + e.getMessage());
        } finally {
            Conexao.closeConnection(con, stmt);
        }
        return c;
    }

    public Cliente getByDocCNPJ(String cnpj) throws SQLException {
        Connection con = Conexao.getConnection();
        Statement stmt = con.createStatement();
        Cliente c = new Cliente();
        try {
            String sql;
            sql = "select * from cliente where cnpj = " + cnpj;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                c.setIdcliente(rs.getInt("idcliente"));
                c.setNome(rs.getString("nome"));
                c.setEndereco(rs.getString("enderecoCompleto"));
                c.setTelefone(rs.getString("telefone"));
                c.setCnpj(rs.getString("cnpj"));
            }
        } catch (SQLException e) {
            throw new SQLException("Cliente com este CPNJ não existe. \n"
                    + e.getMessage());
        } finally {
            Conexao.closeConnection(con, stmt);
        }
        return c;
    }

    public void deletarCliente(int id) throws SQLException {
        Connection con = Conexao.getConnection();
        Statement stmt = con.createStatement();

        try {
            String sql;
            sql = "delete from cliente where idcliente = " + id;
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar cliente! " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    public Boolean verificaCliente(int idcliente) throws SQLException {
        boolean verCliente = false;
        try {
            for (Cliente cli : selectCliente()) {
                if (cli.getIdcliente() == idcliente) {
                    verCliente = true;
                    break;
                }
            }
            return verCliente;
        } catch (SQLException e) {
            throw new SQLException("Cliente com este id não existe");
        }
    }

    public Cliente pesqCli(int cpfCNPJ, String pesq) throws SQLException {
        Cliente c = new Cliente();
        try {
            switch (cpfCNPJ) {
                case 1:
                    for (Cliente cli : selectCliente()) {
                        if (cli.getCpf() != null && cli.getCpf().equals(pesq)) {
                            c = cli;
                            break;
                        }
                    }
                    break;
                case 2:
                    for (Cliente cli : selectCliente()) {
                        if (cli.getCnpj() != null && cli.getCnpj().equals(pesq)) {
                            c = cli;
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("Cliente não Encontrado!!!");
                    break;
            }
            return c;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
}

//  || 
