package interfaceTeste;

import DAO.ClienteDao;
import DAO.LanceDao;
import DAO.LeilaoDaoSession;
import io.github.bonigarcia.wdm.WebDriverManager;
import model.Cliente;
import model.Leilao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.crypto.Data;

import static org.junit.Assert.assertEquals;


public class TestesInterface {


    private WebDriver driver;
    private LeilaoDaoSession dao = new LeilaoDaoSession();
    private ClienteDao daoc = new ClienteDao();
    private LanceDao daol = new LanceDao();

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void fecha(){
        driver.close();
    }

    @Test
    public void testaLogin(){
        driver.get("http://localhost:8080/Desenvolivmento_Web3_war/entrada?acao=leilaoAberto");
        driver.findElement(By.name("nome")).click();
        driver.findElement(By.name("nome")).sendKeys("admin");
        driver.findElement(By.name("senha")).click();
        driver.findElement(By.name("senha")).sendKeys("1234");
        driver.findElement(By.cssSelector("input:nth-child(5)")).click();
    }

    @Test
    public void cadastraleilao() {
        driver.get("http://localhost:8080/Desenvolivmento_Web3_war/");
        driver.findElement(By.linkText("Cadastrar leilão")).click();
        driver.findElement(By.name("nome")).click();
        driver.findElement(By.name("nome")).sendKeys("admin");
        driver.findElement(By.name("senha")).click();
        driver.findElement(By.name("senha")).sendKeys("1234");
        driver.findElement(By.cssSelector("input:nth-child(5)")).click();
        driver.findElement(By.cssSelector("body")).click();
        driver.findElement(By.linkText("INCIO")).click();
        driver.findElement(By.linkText("Cadastrar leilão")).click();
        driver.findElement(By.cssSelector("form")).click();
        driver.findElement(By.name("objeto")).click();
        driver.findElement(By.name("objeto")).sendKeys("ps5");
        driver.findElement(By.name("valor")).click();
        driver.findElement(By.name("valor")).sendKeys("5000");
        driver.findElement(By.name("data")).click();
        driver.findElement(By.name("data")).sendKeys("2021-09-16");
        driver.findElement(By.cssSelector("input:nth-child(5)")).click();
    }

    @Test
    public void upgradeLeilao(){
        driver.get("http://localhost:8080/Desenvolivmento_Web3_war/");
        driver.findElement(By.linkText("Cadastrar leilão")).click();
        driver.findElement(By.name("nome")).click();
        driver.findElement(By.name("nome")).sendKeys("admin");
        driver.findElement(By.name("senha")).click();
        driver.findElement(By.name("senha")).sendKeys("1234");
        driver.findElement(By.cssSelector("input:nth-child(5)")).click();
        driver.findElement(By.linkText("INCIO")).click();
        driver.findElement(By.linkText("Lista de leilões")).click();
        driver.findElement(By.linkText("Upgrade")).click();
        driver.findElement(By.cssSelector("html")).click();
        driver.findElement(By.name("objeto")).sendKeys("ps4");
        driver.findElement(By.name("valor")).click();
        driver.findElement(By.name("valor")).sendKeys("500");
        driver.findElement(By.name("data")).click();
        driver.findElement(By.name("data")).sendKeys("2021-09-16");
        driver.findElement(By.name("status")).click();
        {
            WebElement dropdown = driver.findElement(By.name("status"));
            dropdown.findElement(By.xpath("//option[. = 'Aberto']")).click();
        }
        driver.findElement(By.cssSelector("input:nth-child(7)")).click();
    }

    @Test
    public void listaleilao() {
        driver.get("http://localhost:8080/Desenvolivmento_Web3_war/entrada?acao=listarLeilao");
        driver.findElement(By.name("nome")).click();
        driver.findElement(By.name("nome")).sendKeys("admin");
        driver.findElement(By.name("senha")).click();
        driver.findElement(By.name("senha")).sendKeys("1234");
        driver.findElement(By.name("senha")).sendKeys(Keys.ENTER);
        driver.findElement(By.linkText("INCIO")).click();
        driver.findElement(By.linkText("Lista de leilões")).click();
        driver.findElement(By.name("filtro-status")).click();
        {
            WebElement dropdown = driver.findElement(By.name("filtro-status"));
            dropdown.findElement(By.xpath("//option[. = 'Inativo']")).click();
        }
        driver.findElement(By.cssSelector("input")).click();
        driver.findElement(By.name("filtro-status")).click();
        {
            WebElement dropdown = driver.findElement(By.name("filtro-status"));
            dropdown.findElement(By.xpath("//option[. = 'Aberto']")).click();
        }
        driver.findElement(By.cssSelector("input")).click();
        driver.findElement(By.name("filtro-status")).click();
        {
            WebElement dropdown = driver.findElement(By.name("filtro-status"));
            dropdown.findElement(By.xpath("//option[. = 'Fechado']")).click();
        }
        driver.findElement(By.cssSelector("input")).click();
        driver.findElement(By.name("filtro-status")).click();
        {
            WebElement dropdown = driver.findElement(By.name("filtro-status"));
            dropdown.findElement(By.xpath("//option[. = 'Expirado']")).click();
        }
        driver.findElement(By.cssSelector("input")).click();
    }

    @Test
    public void cadastraCliente(){
        driver.get("http://localhost:8080/Desenvolivmento_Web3_war/");
        driver.findElement(By.linkText("Cadastrar Cliente")).click();
        driver.findElement(By.name("cadastra-email")).click();
        driver.findElement(By.name("cadastra-email")).sendKeys("wilson@hotmail.com");
        driver.findElement(By.name("cadastra-nome")).click();
        driver.findElement(By.name("cadastra-nome")).sendKeys("wilson");
        driver.findElement(By.name("cadastra-senha")).click();
        driver.findElement(By.name("cadastra-senha")).sendKeys("1234");
        driver.findElement(By.cssSelector("input:nth-child(9)")).click();
    }

    @Test
    public void updateCliente(){
        driver.get("http://localhost:8080/Desenvolivmento_Web3_war/");
        driver.findElement(By.linkText("Cadastrar leilão")).click();
        driver.findElement(By.name("nome")).click();
        driver.findElement(By.name("nome")).sendKeys("admin");
        driver.findElement(By.name("senha")).click();
        driver.findElement(By.name("senha")).sendKeys("1234");
        driver.findElement(By.cssSelector("input:nth-child(5)")).click();
        driver.findElement(By.linkText("INCIO")).click();
        driver.findElement(By.linkText("Lista de Clientes")).click();
        driver.findElement(By.cssSelector("tr:nth-child(3) > td:nth-child(6) > a")).click();
        driver.findElement(By.name("cadastra-email")).click();
        driver.findElement(By.name("cadastra-email")).sendKeys("joao@hotmail.com");
        driver.findElement(By.name("cadastra-nome")).click();
        driver.findElement(By.name("cadastra-nome")).sendKeys("admin");
        driver.findElement(By.name("cadastra-senha")).click();
        driver.findElement(By.name("cadastra-senha")).sendKeys("1234");
        driver.findElement(By.cssSelector("input:nth-child(8)")).click();
    }

    @Test
    public void excluiCliente(){
        driver.get("http://localhost:8080/Desenvolivmento_Web3_war/");
        driver.findElement(By.linkText("Lista de Clientes")).click();
        driver.findElement(By.name("nome")).click();
        driver.findElement(By.name("nome")).sendKeys("admin");
        driver.findElement(By.name("senha")).click();
        driver.findElement(By.name("senha")).sendKeys("1234");
        driver.findElement(By.cssSelector("input:nth-child(5)")).click();
        driver.findElement(By.linkText("INCIO")).click();
        driver.findElement(By.linkText("Lista de Clientes")).click();
        driver.findElement(By.linkText("excluir")).click();
    }

    @Test
    public void Cadastralance(){
        driver.get("http://localhost:8080/Desenvolivmento_Web3_war/");
        driver.findElement(By.linkText("Cadastrar leilão")).click();
        driver.findElement(By.name("nome")).click();
        driver.findElement(By.name("nome")).sendKeys("admin");
        driver.findElement(By.name("senha")).click();
        driver.findElement(By.name("senha")).sendKeys("1234");
        driver.findElement(By.cssSelector("input:nth-child(5)")).click();
        driver.findElement(By.cssSelector("form")).click();
        driver.findElement(By.linkText("INCIO")).click();
        driver.findElement(By.linkText("Lista de Leilões Abertos")).click();
        driver.findElement(By.linkText("Fazer-Lance")).click();
        driver.findElement(By.name("usuario")).click();
        driver.findElement(By.name("usuario")).sendKeys("joao");
        driver.findElement(By.name("valordolance")).click();
        driver.findElement(By.name("valordolance")).sendKeys("15000");
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("netofelipeferreira1@gmail.com");
        driver.findElement(By.id("butao")).click();
    }

    @Test
    public void finalizaLeilao(){
        driver.get("http://localhost:8080/Desenvolivmento_Web3_war/");
        driver.findElement(By.linkText("Cadastrar leilão")).click();
        driver.findElement(By.cssSelector("div")).click();
        driver.findElement(By.name("nome")).click();
        driver.findElement(By.name("nome")).sendKeys("admin");
        driver.findElement(By.name("senha")).click();
        driver.findElement(By.name("senha")).sendKeys("1234");
        driver.findElement(By.cssSelector("input:nth-child(5)")).click();
        driver.findElement(By.linkText("INCIO")).click();
        driver.findElement(By.linkText("Lista de leilões")).click();
        driver.findElement(By.linkText("Finalizar Leilão")).click();
    }

    @Test
    public void excluiLeilao(){
        driver.get("http://localhost:8080/Desenvolivmento_Web3_war/");
        driver.findElement(By.linkText("Cadastrar leilão")).click();
        driver.findElement(By.name("nome")).click();
        driver.findElement(By.name("nome")).sendKeys("admin");
        driver.findElement(By.name("senha")).click();
        driver.findElement(By.name("senha")).sendKeys("1234");
        driver.findElement(By.cssSelector("input:nth-child(5)")).click();
        driver.findElement(By.linkText("INCIO")).click();
        driver.findElement(By.linkText("Cadastrar leilão")).click();
        driver.findElement(By.name("objeto")).click();
        driver.findElement(By.name("objeto")).sendKeys("nsei");
        driver.findElement(By.name("valor")).click();
        driver.findElement(By.name("valor")).sendKeys("5000");
        driver.findElement(By.name("data")).click();
        driver.findElement(By.name("data")).sendKeys("2021-09-14");
        Leilao leilao = new Leilao("nsei",5000, null,"Inativo");
        dao.Cadastro(leilao);
        driver.findElement(By.cssSelector("input:nth-child(5)")).click();
        driver.findElement(By.linkText("Lista De leilões")).click();
        driver.findElement(By.linkText("excluir")).click();
    }

}





