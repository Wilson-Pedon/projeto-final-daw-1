package model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String nome;
    private String objeto;
    private String email;
    private float valor;


    public Lance(String nome, String objeto, float valor, String email) {
        this.nome = nome;
        this.valor = valor;
        this.objeto = objeto;
        this.email = email;
    }

    public Lance(int id, String nome, String objeto, float valor, String email) {
        this.nome = nome;
        this.valor = valor;
        this.objeto = objeto;
        this.email = email;
        this.id = id;
    }

    public Lance() {
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

}
