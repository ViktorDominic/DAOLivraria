
package br.com.senactech.tlivrariaJF.model;


public class Cliente {
    private int idcliente;
    private String nome;
    private String cpf;
    private String cnpj;
    private String enderecoCompleto;
    private String telefone;

    public Cliente() {
        //Construtor Vazio para acessar os metodos acessores get e set
    }
    
    /**
     * Contrutor Cliente
     * @param idcliente
     * @param nome
     * @param cpf
     * @param cnpj
     * @param enderecoCompleto
     * @param telefone 
     */
    public Cliente(int idcliente, String nome, String cpf, String cnpj, String enderecoCompleto, String telefone) {
        this.idcliente = idcliente;
        this.nome = nome;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.enderecoCompleto = enderecoCompleto;
        this.telefone = telefone;
    }

    /**
     * @return the idcliente
     */
    public int getIdcliente() {
        return idcliente;
    }

    /**
     * @param idcliente the idcliente to set
     */
    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the enderecoCompleto
     */
    public String getEndereco() {
        return enderecoCompleto;
    }

    /**
     * @param enderecoCompleto the enderecoCompleto to set
     */
    public void setEndereco(String enderecoCompleto) {
        this.enderecoCompleto = enderecoCompleto;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    @Override
    public String toString() {
        return "cliente{" + "idCliente=" + idcliente + ", nome=" + nome + ", cpf=" + cpf + ", cnpj=" + cnpj + ", enderecoCompleto=" + enderecoCompleto + ", telefone=" + telefone + '}';
    }
    
    
    
}
