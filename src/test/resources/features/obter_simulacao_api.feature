# language: pt

Funcionalidade: Obter Simulacao de Investimento

@API
Cenario: Deve obter simulacao de id 1 atraves da API
	Quando fizer a requisicao ao recurso Simulador
	Entao sera retornado um JSON com os valores
	E os meses da simulacao