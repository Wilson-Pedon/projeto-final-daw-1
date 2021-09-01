package model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "leiloes")
public class Leilao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private Integer valorMinimo;
    private LocalDate data;
    private String status;


    public Leilao(int id, String nome, Integer valorMinimo, LocalDate data, String status){
        this.nome = nome;
        this.valorMinimo = valorMinimo;
        this.data = data;
        this.status = status;
        this.id = id;
    }


    public Leilao(String nome, Integer valorMinimo, LocalDate data, String status) {
        this.nome = nome;
        this.valorMinimo = valorMinimo;
        this.data = data;
        this.status = status;
    }

    public Leilao() {}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(Integer valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
