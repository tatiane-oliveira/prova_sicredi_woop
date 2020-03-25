package br.com.sicredi.steps;

import org.junit.Assert;

import br.com.sicredi.core.Constantes;
import br.com.sicredi.utils.Simulacao;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ObterSimulacaoAPISteps {

	private final String RECURSO = "simulador";
	private Response resposta;
	private Simulacao simulacaoRetornada;

	@Quando("fizer a requisicao ao recurso Simulador")
	public void fizerARequisiçãoAoRecursoSimulador(){
		resposta = 	given().
					when().
                			get(RECURSO).
                	then().
                			extract().response();
		
		simulacaoRetornada = resposta.body().as(Simulacao.class);
	}

	@Entao("sera retornado um JSON com os valores")
	public void seraRetornadoUmJSONComOsValores(){
		Assert.assertEquals(200, resposta.getStatusCode());
		Assert.assertEquals(Constantes.CONTENT_TYPE, resposta.getContentType());
		Assert.assertEquals(1, simulacaoRetornada.getId());
		
		String[] valoresEsperados = {"2.802","3.174","3.564","3.971"};
		Assert.assertArrayEquals(valoresEsperados, simulacaoRetornada.getValor());
	}

	@Entao("os meses da simulacao")
	public void osMesesDaSimulacao() {
		String[] mesesEsperados = {"112","124","136","148"};
		Assert.assertArrayEquals(mesesEsperados, simulacaoRetornada.getMeses());
	}
}
