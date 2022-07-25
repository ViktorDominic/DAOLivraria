/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.TLivrariaJF.DAO;


public class DAOFactory {

    private static final ClienteDAO cDAO = new ClienteDAO();

    public static ClienteDAO getClienteDAO() {
        return cDAO;
    }

    private static final EditoraDAO eDAO = new EditoraDAO();

    public static EditoraDAO getEditoraDAO() {
        return eDAO;
    }

    private static final LivroDAO lDAO = new LivroDAO();

    public static LivroDAO getLivroDAO() {
        return lDAO;
    }
}
