package acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Logaut {

    private HttpServletResponse resp;
    private HttpServletRequest req;

    public Logaut(HttpServletResponse resp, HttpServletRequest req) {
        this.resp = resp;
        this.req = req;
    }

    public void executa() throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();

        req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);

    }

}