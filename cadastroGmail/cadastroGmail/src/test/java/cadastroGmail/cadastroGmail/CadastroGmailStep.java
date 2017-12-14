package cadastroGmail.cadastroGmail;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class CadastroGmailStep {
	
		private WebDriver driver;
		
@Given("^Acessar o site do Gmail$")
public void acessar_o_site_do_Gmail()  {
	
	System.setProperty("webdriver.chrome.driver", "C:/Users/Administrator/Documents/Estudos Automação/cadastroGmail/cadastroGmail/drivers/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://accounts.google.com/SignUp?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ltmpl=default");
}

@Given("^preencher os campos Nome e SobreNome$")
public void preencher_os_campos_Nome_e_SobreNome()  {
	driver.findElement(By.xpath(".//*[@id='FirstName']")).sendKeys("Hugo");
	driver.findElement(By.xpath("//*[@id='LastName']")).sendKeys("Moura");
	    
}

@Given("^prenecher o usuário$")
public void prenecher_o_usuário()  {
	driver.findElement(By.xpath("//*[@id='GmailAddress']")).sendKeys("hugo.mora2356");
    
}

@Given("^criar uma senha e confirmar senha$")
public void criar_uma_senha_e_confirmar_senha() {
	driver.findElement(By.xpath("//*[@id='Passwd']")).sendKeys("Mudar@123");
	driver.findElement(By.xpath("//*[@id='PasswdAgain']")).sendKeys("Mudar@123");
    
}
@When("^digito a data de nascimento$")
public void digito_a_data_de_nascimento()  {
	
	 /*elect combo =  new Select(driver.findElement(By.id(":0")));
	 combo.selectByVisibleText("August");*/
	
	driver.findElement(By.xpath("//*[@id='BirthMonth']/div")).click();
	driver.findElement(By.xpath("//*[@id=':7']")).click();
	driver.findElement(By.xpath("//*[@id='BirthDay']")).sendKeys("12");
	driver.findElement(By.xpath("//*[@id='BirthYear']")).sendKeys("1979");
    
}

@When("^escolho o sexo$")
public void escolho_o_sexo()  {
	/*Select sexo = new Select(driver.findElement(By.xpath("//*[@id='Gender']/div")));
	sexo.selectByVisibleText("Masculino");*/
	
	driver.findElement(By.xpath("//*[@id='Gender']/div")).click();
	driver.findElement(By.xpath("//*[@id=':f']/div")).click();
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("scroll(0,250);");
			
	}
@When("^E digito o numero do Telefe, Email atual e clico no botão Next$")
public void e_digito_o_numero_do_Telefe_Email_atual_e_clico_no_botão_Next()  {
	
	driver.findElement(By.xpath("//*[@id='RecoveryPhoneNumber']")).sendKeys("1158423272");
	driver.findElement(By.xpath("//*[@id='RecoveryEmailAddress']")).sendKeys("hilario.bina@pitnag.com");
	
	try {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(scrFile, new File("C:\\Cadastro1parte.JPEG"));
	} catch (IOException e) {
			e.printStackTrace();
	}
	
	
	driver.findElement(By.xpath("//*[@id='submitbutton']")).click();
	
	try {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(scrFile, new File("C:\\Cadastro2parte.JPEG"));
	} catch (IOException e) {
			e.printStackTrace();
	}
	
	driver.findElement(By.xpath("//*[@id='tos-text']")).click();
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollTo(0, document.body.scrollIntoView(top))");
	
	
	//Termo de licença - 
	//Botão Aceito - //*[@id="iagreebutton"]
 
}

}
