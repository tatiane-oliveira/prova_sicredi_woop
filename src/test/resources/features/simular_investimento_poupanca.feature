# language: pt

Funcionalidade: Simular Investimento
	Com o proposito de Simular um Investimento na Poupanca
	como um Associado,
	eu gostaria de preencher o formulario de simulacao
	e ver a tabela de resultado com Mes e Valor.
	
Contexto:
	Dado que acessei o simulador

@UI	
Esquema do Cenario: Deve fazer a simulacao
	E que preenchi todos os campos corretamente "<perfil>" <valorDaPoupanca> <valorDaAplicacao> <periodo> "<tipoPeriodo>"
 	Quando efetuar a simulacao
	Entao o formulario com as informacoes da simulacao deve ser exibido

Exemplos:
	|    perfil   |valorDaPoupanca|valorDaAplicacao| periodo | tipoPeriodo  |
	|   paraVoce  |			25,87     |			200,76     |	 24	   |		M    			|
	| paraEmpresa |	   3000,00    |	  10000,00     |	 2	   |		A	    		|

@UI	
Cenario: Deve exibir mensagem de orientacao para valores abaixo de R$ 20,00
	Quando informar um valor abaixo do minimo R$ 18.45
	Entao sera exibida a mensagem de orientacao