
package br.com.senactech.TLivrariaJF.services;

import br.com.senactech.TLivrariaJF.DAO.EditoraDAO;
import br.com.senactech.TLivrariaJF.DAO.DAOFactory;
import br.com.senactech.tlivrariaJF.model.Editora;
import java.sql.SQLException;
import java.util.ArrayList;


public class EditoraServicos {

    public ArrayList<Editora> buscarEditora() throws SQLException {
        EditoraDAO eDAO = DAOFactory.getEditoraDAO();
        return eDAO.selectEditora();
    }

    public void cadastrarEditora(Editora eVO) throws SQLException {
        EditoraDAO eDAO = DAOFactory.getEditoraDAO();
        eDAO.cadastrarEditora(eVO);
    }

    public void atualizarEditora(Editora eVO) throws SQLException {
        EditoraDAO eDAO = DAOFactory.getEditoraDAO();
        eDAO.atualizarEditora(eVO);
    }

    public void deletarEditora(int id) throws SQLException {
        EditoraDAO eVO = DAOFactory.getEditoraDAO();
        eVO.deletarEditora(id);
    }

    public Editora getByDocID(int id) throws SQLException {
        EditoraDAO eDAO = DAOFactory.getEditoraDAO();
        return eDAO.getByDocID(id);
    }

    public String getNomeEdt(int id) throws SQLException {
        EditoraDAO eVO = DAOFactory.getEditoraDAO();
        return eVO.getNomeEdt(id);
    }

    public int getIdEditora(String nome) throws SQLException {
        EditoraDAO eVO = DAOFactory.getEditoraDAO();
        return eVO.getIdEditora(nome);
    }

}
