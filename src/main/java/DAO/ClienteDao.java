package DAO;

import controler.BancoDeDados;
import model.Cliente;


import javax.persistence.Query;
import java.util.List;

public class ClienteDao {

    private final BancoDeDados conexao = new BancoDeDados();

    public void cadastro(Cliente cliente) {

        try {
            conexao.session.getTransaction().begin();
            conexao.session.save(cliente);
            conexao.session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            conexao.session.getTransaction().rollback();
        }
    }

    public List findAll() {
        return BancoDeDados.em.createQuery("FROM " + Cliente.class.getName()).getResultList();
    }

    public Cliente getID(final int id) {
        return conexao.em.find(Cliente.class, id);
    }

    public List BuscarNome(String nome) {
        Query query = conexao.session.createQuery("from Cliente where nome = :nome ");
        query.setParameter("nome", nome);
        return query.getResultList();
    }

    public void deleta(int IDCliente) {
        try {
            conexao.em.getTransaction().begin();
            Cliente cliente = conexao.em.find(Cliente.class, IDCliente);
            conexao.em.remove(cliente);
            conexao.em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            conexao.em.getTransaction().rollback();
        }
    }

    public void update(Cliente cliente) {
        try {
            conexao.em.getTransaction().begin();
            conexao.em.merge(cliente);
            conexao.em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            conexao.em.getTransaction().rollback();
        }
    }
}


