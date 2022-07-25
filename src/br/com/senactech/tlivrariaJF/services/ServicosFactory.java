
package br.com.senactech.TLivrariaJF.services;


public class ServicosFactory {

    private static final ClienteServicos clienteServicos = new ClienteServicos();

    public static ClienteServicos getClienteServicos() {
        return clienteServicos;
    }
    
    private static final EditoraServicos editoraServicos = new EditoraServicos();
    
    public static EditoraServicos getEditoraServicos() {
        return editoraServicos;
    }
    
    private static final LivroServicos livroServicos = new LivroServicos();
    
    public static LivroServicos getLivroServicos() {
        return livroServicos;
    }
}
