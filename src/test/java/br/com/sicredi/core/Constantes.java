package br.com.sicredi.core;

import io.restassured.http.ContentType;

public interface Constantes {

	String BASE_PATH = "";
	
	final String BASE_URI = "http://5b847b30db24a100142dce1b.mockapi.io/api/v1/";
	final String URL = "https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/";	
	final String CONTENT_TYPE = ContentType.JSON.toString();
	
	Long MAX_TIMEOUT = 8000L;
}
