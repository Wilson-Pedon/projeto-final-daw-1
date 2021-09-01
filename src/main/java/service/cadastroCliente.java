package service;

import DAO.ClienteDao;
import model.Cliente;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "cadastro-cliente", value = "/cadastro_cliente")
public class cadastroCliente extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/cadastro-cliente.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("cadastra-email");
        String nome = req.getParameter("cadastra-nome");
        String senha = req.getParameter("cadastra-senha");
        Cliente cliente = new Cliente(nome, senha, email);
        ClienteDao dao = new ClienteDao();
        dao.cadastro(cliente);
        req.getRequestDispatcher("/WEB-INF/pages/cadastro-cliente.jsp").forward(req, resp);
    }


}
