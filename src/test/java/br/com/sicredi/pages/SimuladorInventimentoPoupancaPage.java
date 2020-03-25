package br.com.sicredi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import br.com.sicredi.core.DSL;
import br.com.sicredi.core.DriverFactory;

public class SimuladorInventimentoPoupancaPage {

	public SimuladorInventimentoPoupancaPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}
	
	@FindBy(how = How.ID, using = "valorAplicar")
	private WebElement txtValorASerAplicado;
	
	@FindBy(how = How.ID, using = "valorInvestir")
	private WebElement txtValorASerInvestido;
	
	@FindBy(how = How.ID, using = "tempo")
	private WebElement txtTempo;
	
	@FindBy(how = How.CSS, using = ".btnSimular")
	private WebElement btnSimular;
	
	@FindBy(how = How.XPATH, using = "//form/div/input[2]")
	private WebElement chkEmpresa;
	
	public SimuladorInventimentoPoupancaPage preencherFormulario(Double valorASerAplicado, Double valorASerInvestido, int tempo) {
		inserirValorASerInvestido(valorASerInvestido);
		inserirValorASerAplicado(valorASerAplicado);
		inserirTempo(tempo);
		return this;
	}
	
	public SimuladorInventimentoPoupancaPage inserirValorASerInvestido(Double valorASerInvestido) {
		txtValorASerInvestido.sendKeys(String.valueOf(valorASerInvestido));
		return this;
	}
	
	public SimuladorInventimentoPoupancaPage inserirValorASerAplicado(Double valorASerAplicado) {
		txtValorASerAplicado.sendKeys(String.valueOf((valorASerAplicado)));
		return this;
	}
	
	public SimuladorInventimentoPoupancaPage tirarOFocoDoCampoValorASerInvestido() {
		txtValorASerInvestido.sendKeys(Keys.TAB);
		return this;
	}
	
	public SimuladorInventimentoPoupancaPage inserirTempo(int tempo) {
		txtTempo.sendKeys(String.valueOf(tempo));
		return this;
	}
	
	public SimuladorInventimentoPoupancaPage efetuarSimulacao() {
		btnSimular.submit();
		return this;
	}
	
	public SimuladorInventimentoPoupancaPage selecionarPerfilParaEmpresa() {
		chkEmpresa.click();
		return this;
	}
	
	public SimuladorInventimentoPoupancaPage selecionarOpcaoComboPerido(String tipoPeriodo) {		
		DSL.selecionarOpcaoDaCombo(tipoPeriodo);
		return this;
	}
	
	public boolean isFormularioDeSimulacaoVisivel() {
		return DSL.isElementoVisivel(10, By.xpath("//*[contains(@class, 'maisOpcoes')]/table/tbody/tr"));
	}
	
	public boolean isMensagemDeValorMinimoVisivelNoCampoValorASerInvestido() {
		By by = By.id("valorInvestir-error");
		String mensagemEsperada = "Valor mínimo de 20.00";
		return verificarSeEstaSendoExibidaAMensagemDeErroDesejada(by, mensagemEsperada, 10);	
	}
	
	public boolean isMensagemDeValorMinimoVisivelNoCampoValorASerAplicado() {
		By by = By.id("valorAplicar-error");
		String mensagemEsperada = "Valor mínimo de 20.00";
		return verificarSeEstaSendoExibidaAMensagemDeErroDesejada(by, mensagemEsperada, 10);
	}
	
	private boolean verificarSeEstaSendoExibidaAMensagemDeErroDesejada(By by, String mensagemDesejada, int tempoEsperaDoElemento) {
		if (DSL.isElementoVisivel(tempoEsperaDoElemento, by)) {
			String mensagemExibida = DSL.obterTextoDoElemento(by);
			return mensagemExibida.equals(mensagemDesejada);
		}
		return false;
	}
}