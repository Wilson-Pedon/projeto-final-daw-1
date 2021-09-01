package acao;

import DAO.ClienteDao;
import model.Cliente;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class UpgradeClienteAcao {

    private final HttpServletRequest req;
    private final HttpServletResponse resp;

    public UpgradeClienteAcao(HttpServletResponse resp, HttpServletRequest req) throws ServletException, IOException {
        this.req = req;
        this.resp = resp;
    }

    public void executa() throws IOException, ServletException {


        System.out.println("entrou no upgrade!!!!!!!!!!!!!!!!!!!!!!");
        String id = req.getParameter("pID");
        ClienteDao dao = new ClienteDao();

        String nome = req.getParameter("cadastra-nome");
        String Email = req.getParameter("cadastra-email");
        String senha = req.getParameter("cadastra-senha");


        Cliente cliente = new Cliente(nome,Email,senha);


        cliente.setId(Integer.parseInt(id));
        dao.update(cliente);

        resp.sendRedirect(req.getServletContext().getContextPath() + "/entrada?acao=listarCliente");

    }

}
