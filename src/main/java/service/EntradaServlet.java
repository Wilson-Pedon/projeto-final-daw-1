package service;


import acao.*;
import org.hibernate.sql.Update;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(urlPatterns = "/entrada")
public class EntradaServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();


        if(session.getAttribute("usuarioLogado") == null){
            novoLogin novoLogin = new novoLogin(req,resp);
            novoLogin.executa();
            return;
        }

        String acao = req.getParameter("acao");


                if(session.getAttribute("usuarioLogado").equals("admin")) {

                    if(acao.equals("novoLeilao")) {
                        System.out.println("Novo Leilao acionado");
                        NovoLeilao novoLeilao = new NovoLeilao(req, resp);
                        novoLeilao.executa();
                    }
                    //---------------------------------------------------------------------------------
                    if(acao.equals("cadastrarLeilao")) {
                        System.out.println("cadastro acionado");
                        CadastrarLeilao cadastrarLeilao = new CadastrarLeilao(resp, req);
                        cadastrarLeilao.executa();
                    }
                    //---------------------------------------------------------------------------------
                    else if(acao.equals("deleta")){
                        System.out.println("delata acionado");
                        DeletarLeilao deletarLeilao = new DeletarLeilao(resp, req);
                        deletarLeilao.executa();
                        //---------------------------------------------------------------------------------

                    }else if(acao.equals("listarLeilao")){
                        System.out.println("listar acionado");
                        ListarLeilao listarLeilao = new ListarLeilao(resp,req);
                        listarLeilao.executa();
                        //---------------------------------------------------------------------------------
                    }else if(acao.equals("novoUpdateLeilao")){
                        System.out.println("update leilao acionado");
                        NovoUpdate novoUpdate = new NovoUpdate(req,resp);
                        novoUpdate.executa();
                        //---------------------------------------------------------------------------------

                    }else if(acao.equals("updateLeilao")) {
                        System.out.println("novoUpdateLeilao acionado");
                        UpdateLeilaoAcao updateLeilaoAcao = new UpdateLeilaoAcao(resp, req);
                        updateLeilaoAcao.executa();
                        //---------------------------------------------------------------------------------
                    }else if(acao.equals("listarCliente")){
                        ListarCliente listarCliente = new ListarCliente(resp, req);
                        listarCliente.executa();
                    }else if(acao.equals("deletaCliente")){
                        DeletarCliente deletarCliente = new DeletarCliente(resp, req);
                        deletarCliente.executa();
                    }else if(acao.equals("upgradeCliente")){
                        NovoUpdateCliente novoUpdateCliente = new NovoUpdateCliente(req, resp);
                        novoUpdateCliente.executa();
                    }else if(acao.equals("fazUpgradeCliente")){
                        UpgradeClienteAcao upgradeClienteAcao = new UpgradeClienteAcao(resp, req);
                        upgradeClienteAcao.executa();
                    }else if(acao.equals("filtroLeilao")){
                        FiltroLeilao filtroLeilao = new FiltroLeilao(resp, req);
                        filtroLeilao.executa();
                    }else if(acao.equals("listaLance")){
                        ListarLeilaoLance listarLeilaoLance = new ListarLeilaoLance(resp, req);
                        listarLeilaoLance.executa();
                    }else if(acao.equals("filtroLance")){
                        FiltroLance filtroLance = new FiltroLance(resp, req);
                        filtroLance.executa();
                    }else if(acao.equals("leilaoAberto")){
                        ListadeLeilaoAberto listadeLeilaoAberto = new ListadeLeilaoAberto(resp, req);
                        listadeLeilaoAberto.executa();
                    }else if(acao.equals("cadastraLance")){
                        CadastraLance lance = new CadastraLance(resp, req);
                        lance.executa();
                    }else if(acao.equals("finalizarLeilao")){
                        finalizarLeilao finalizar = new finalizarLeilao(resp, req);
                        finalizar.executa();
                    }

            }
            else {
                        if(acao.equals("leilaoAberto")){
                        ListadeLeilaoAberto listadeLeilaoAberto = new ListadeLeilaoAberto(resp, req);
                        listadeLeilaoAberto.executa();
                        }else if(acao.equals("cadastraLance")){
                            CadastraLance lance = new CadastraLance(resp, req);
                            lance.executa();
                        }else if(acao.equals("filtroLance")){
                            FiltroLance filtroLance = new FiltroLance(resp, req);
                            filtroLance.executa();
                        }else if(acao.equals("listaLance")){
                            ListarLeilaoLance listarLeilaoLance = new ListarLeilaoLance(resp, req);
                            listarLeilaoLance.executa();
                        }
            }

            if(acao.equals("login")){
                novoLogin novoLogin = new novoLogin(req, resp);
                novoLogin.executa();
            }else if(acao.equals("logaut")){
                Logaut logaut = new Logaut(resp, req);
                logaut.executa();
            }


    }

}
