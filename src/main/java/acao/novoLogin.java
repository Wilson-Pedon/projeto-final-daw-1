package acao;

import DAO.ClienteDao;
import model.Cliente;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class novoLogin {

    private final HttpServletRequest req;
    private final HttpServletResponse resp;

    public novoLogin(HttpServletRequest req, HttpServletResponse resp) {
        this.req = req;
        this.resp = resp;
    }

    public void executa() throws ServletException, IOException {

        //Cliente cliente = new Cliente();
        ClienteDao dao = new ClienteDao();
        String user = req.getParameter("nome");
        String senha = req.getParameter("senha");

        List<Cliente> cliente = new ClienteDao().findAll();
        for (Cliente l : cliente) {
            if (user != null && (user.equals(l.getNome()) && senha.equals(l.getSenha()))) {
                HttpSession session = req.getSession();
                session.setAttribute("usuarioLogado", user);
                //resp.sendRedirect(req.getServletContext().getContextPath() + "/entrada?acao=leilaoAberto");
                req.getRequestDispatcher("/WEB-INF/pages/erro.jsp").forward(req, resp);
                return;
            }
        }
        req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
    }
}
