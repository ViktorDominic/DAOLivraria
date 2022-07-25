
package br.com.senactech.tlivrariaJF.model;


public class Editora {
    private int ideditora;
    private String nomeEditora;
    private String endereco;
    private String telefone;
    private String gerente;

    public Editora() {
    }


    public Editora(int ideditora, String nomeEditora, String endereco, String telefone, String gerente) {
        this.ideditora = ideditora;
        this.nomeEditora = nomeEditora;
        this.endereco = endereco;
        this.telefone = telefone;
        this.gerente = gerente;
    }
    
    public int getIdEditora() {
        return ideditora;
    }
    
    public void setIdEditora(int idEditora) {
        this.ideditora = idEditora;
    }

    public String getNmEditora() {
        return nomeEditora;
    }

    public void setNmEditora(String nmEditora) {
        this.nomeEditora = nmEditora;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    @Override
    public String toString() {
        return "editora{" + "idEditora=" + ideditora + ", nmEditora=" + 
                nomeEditora + ", endereco=" + endereco + ", telefone=" + 
                telefone + ", gerente=" + gerente + '}';
    }
    
    
}
