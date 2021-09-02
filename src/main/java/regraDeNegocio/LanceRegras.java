package regraDeNegocio;


import DAO.LanceDao;
import model.Lance;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class LanceRegras {

    private LanceDao dao = new LanceDao();

    public LanceRegras(LanceDao dao) {
        this.dao = dao;
    }

    public LanceRegras() {
    }


    public void CadastramentoDeLances(Lance lance, String veficarNome, float veficarvalor, int valorMinino) {
        if (NaoCadastraMenorQueOValorMinino(lance, valorMinino)) {
            System.out.println("Passou no valor Minimo");
            if (NaoCadastraLanceComNomeIgual(lance, veficarNome)) {
                System.out.println("Passou no nome ");
                if (NaoCadastraLanceComValorIgual(lance, veficarvalor)) {
                    System.out.println("Passou no valor");
                    dao.Cadastro(lance);
                }
            }
        }
    }

    public Boolean NaoCadastraLanceComNomeIgual(Lance lance, String veficarNome) {
        if ((lance.getNome().equals(veficarNome))) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean NaoCadastraLanceComValorIgual(Lance lance, float veficarvalor) {
        return lance.getValor() > veficarvalor;
    }

    public Boolean NaoCadastraMenorQueOValorMinino(Lance lance, int valorMinino) {
        return lance.getValor() >= valorMinino;
    }

    public String UtimoLance(String nome) {
        List<String> email1 = new ArrayList<>();
        List<Lance> list = BuscaOResultadoDeUmLeilao(nome);
        for (Lance l : list) {
            email1.add(l.getEmail());
        }
        String veficarEmail = email1.get(email1.size() - 1);
        return veficarEmail;
    }

    public List BuscaOResultadoDeUmLeilao(String nome) {
        List<Lance> list = new LanceDao().BuscarObjeto(nome);
        return list;
    }

    public void EnviaEmail(String veficarEmail) {
        String email = "wilsonpedon4@gmail.com";
        String senha = "";
        String mensagem = "Parabens o Senhor Ganhou o leilao!!!!! ";
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(email, senha);
                    }
                });
        session.setDebug(true);
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            Address[] toUser = InternetAddress.parse(veficarEmail);
            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("Ganhador do leilão");//titulo
            message.setContent(mensagem, "text/html; charset=utf-8");
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


}
