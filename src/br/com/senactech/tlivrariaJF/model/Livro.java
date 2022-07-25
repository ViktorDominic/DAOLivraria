
package br.com.senactech.tlivrariaJF.model;


public class Livro {

    private int idlivro;
    private String tituloLivro;
    private String autor;
    private String assunto;
    private String isbn;
    private int estoque;
    private float valor;
    private int ideditora;

    public Livro() {
    }

    public Livro(int idlivro, String tituloLivro, String autor, String assunto, String isbn, int estoque, float preco, int idEditora) {
        this.idlivro = idlivro;
        this.tituloLivro = tituloLivro;
        this.autor = autor;
        this.assunto = assunto;
        this.isbn = isbn;
        this.estoque = estoque;
        this.valor = preco;
        this.ideditora = idEditora;
    }

    public int getIdLivro() {
        return idlivro;
    }

    public void setIdLivro(int idLivro) {
        this.idlivro = idLivro;
    }

    public String getTitulo() {
        return tituloLivro;
    }

    public void setTitulo(String titulo) {
        this.tituloLivro = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public float getPreco() {
        return valor;
    }

    public void setPreco(float preco) {
        this.valor = preco;
    }
    
    public int getIdEditora() {
        return ideditora;
    }

    public void setIdEditora(int idEditora) {
        this.ideditora = idEditora;
    }

    @Override
    public String toString() {
        return "livro{" + "idLivro=" + idlivro + ", titulo=" + tituloLivro + ", autor=" + autor + ", assunto=" + assunto + ", isbn=" + isbn + ", estoque=" + estoque + ", preço=" + valor + ", idEditora=" + ideditora + '}';
    }

}
