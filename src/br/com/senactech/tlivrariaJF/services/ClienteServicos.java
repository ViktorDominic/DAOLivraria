/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.TLivrariaJF.services;

import br.com.senactech.TLivrariaJF.DAO.ClienteDAO;
import br.com.senactech.TLivrariaJF.DAO.DAOFactory;
import br.com.senactech.tlivrariaJF.model.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;


public class ClienteServicos {

    public ArrayList<Cliente> buscarCliente() throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        return cDAO.selectCliente();
    }

    public void cadastrarClienteCPF(Cliente cVO) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        cDAO.cadastrarClienteCPF(cVO);
    }

    public void cadastrarClienteCNPJ(Cliente cVO) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        cDAO.cadastrarClienteCNPJ(cVO);
    }

    public void atualizarCliente(Cliente cVO) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        cDAO.atualizarCliente(cVO);
    }

    public void deletarCliente(int id) throws SQLException {
        ClienteDAO cVO = DAOFactory.getClienteDAO();
        cVO.deletarCliente(id);
    }

    public Boolean verificaCliente(int idcliente) throws SQLException {
        ClienteDAO cVO = DAOFactory.getClienteDAO();
        return cVO.verificaCliente(idcliente);
    }

    public Cliente pesqCli(int cpfCNPJ, String pesq) throws SQLException {
        ClienteDAO cVO = DAOFactory.getClienteDAO();
        return cVO.pesqCli(cpfCNPJ, pesq);
    }

    public Cliente getByDocCPF(String cpf) throws SQLException {
        ClienteDAO cVO = DAOFactory.getClienteDAO();
        return cVO.getByDocCPF(cpf);
    }

    public Cliente getByDocCNPJ(String cnpj) throws SQLException {
        ClienteDAO cVO = DAOFactory.getClienteDAO();
        return cVO.getByDocCNPJ(cnpj);
    }

}
