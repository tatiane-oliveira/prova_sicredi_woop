package br.com.sicredi.steps;

import org.junit.Assert;

import br.com.sicredi.core.Constantes;
import br.com.sicredi.core.DriverFactory;
import br.com.sicredi.pages.SimuladorInventimentoPoupancaPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class SimularInventimentoPoupancaSteps {

	private SimuladorInventimentoPoupancaPage simuladorInventimentoPage;

	@Dado("que acessei o simulador")
	public void queEuAcesseiOSimulador() {		
		DriverFactory.getDriver().get(Constantes.URL);
		simuladorInventimentoPage = new SimuladorInventimentoPoupancaPage();
	}

	@Dado("que preenchi todos os campos corretamente {string} {double} {double} {int} {string}")
	public void quePreenchiTodosOsCamposCorretamente(String perfil, Double valorASerAplicado, Double valorASerInvestido,
			int periodo, String tipoPeriodo) {
		if (perfil.equals("paraEmpresa"))
			simuladorInventimentoPage.selecionarPerfilParaEmpresa();
		simuladorInventimentoPage.preencherFormulario(valorASerAplicado, valorASerInvestido, periodo);
		if (tipoPeriodo.equals("A"))
			simuladorInventimentoPage.selecionarOpcaoComboPerido(tipoPeriodo);
	}

	@Quando("efetuar a simulacao")
	public void efetuarASimulacao() {
		simuladorInventimentoPage.efetuarSimulacao();
	}

	@Entao("o formulario com as informacoes da simulacao deve ser exibido")
	public void oFormularioComAsInformacoesDaSimulaçãoDeveSerExibido() {
		Assert.assertTrue(simuladorInventimentoPage.isFormularioDeSimulacaoVisivel());
	}

	@Quando("informar um valor abaixo do minimo R$ {double}")
	public void informarUmValorAbaixoDoMinimoR$(Double valor) {
		simuladorInventimentoPage
			.inserirValorASerAplicado(valor)
			.inserirValorASerInvestido(valor)
			.tirarOFocoDoCampoValorASerInvestido();
	}

	@Entao("sera exibida a mensagem de orientacao")
	public void seraExibidaAMensagemDeOrientaçao() {
		Assert.assertTrue(simuladorInventimentoPage.isMensagemDeValorMinimoVisivelNoCampoValorASerAplicado());
		Assert.assertTrue(simuladorInventimentoPage.isMensagemDeValorMinimoVisivelNoCampoValorASerInvestido());
	}

}