# Prova Técnica da Plataforma Digital do Sicredi

Desenvolvimento de testes automatizados para testes de UI e serviços. O projeto foi feito em **Java** de forma simples e objetiva, sem deixa de utilizar boas práticas no desenvolvimento de software.


# Descrição da solução

Foi criado um projeto **Maven**  com as seguintes dependências:

- **Commons IO**,
- **Cucumber**,
- **JUnit**,
-  **Selenium WebDriver**,
- **RestAssured**,
- **Gson**.

## Estrutura do Projeto

### br.com.sicredi.core

- **Constantes** (interface com dados como URL do simulador e URI base da API),
- **DriverFactory**,
- **DSL** (métodos customizados para interagir com os elementos das páginas);
- **SeleniumWait** (esperas explícitas).


### br.com.sicredi.pages

- Contempla todas as páginas (PageObject Pattern).

### br.com.sicredi.runners

- Contém uma classe Runner para que seja executados os testes do Cucumber.

### br.com.sicredi.steps
- Contém as classes com os Steps dos testes de UI e de serviço. Também possui uma classe com os Hooks.

### br.com.sicredi.utils

Classes de apoio ao teste:

- **Simulacao** (classe utilizada no processo de desserialização do retorno da API),
- **PropertiesReader** (classe utilizada para ler o arquivo de propriedades).

### src/test/resources/features
- Contém dois arquivo **.feature** com a definição dos cenários dos testes de UI e serviço no formato BDD.

### Pasta "/configs"

Localizada na raíz do projeto, ela contém o arquivo de propriedades "**config.properties**" onde é permitido informar a localização do chromedriver através da propriedade **caminhoChromeDriver**.

> **O driver não foi adicionado ao projeto, logo, é necessário alterar o valor desta propriedade para execução dos testes.**

## Execução dos testes

Basta acessar a pasta do projeto e executar via linha de comando: 

* mvn test verify (gera o relatório utilizando o plugin **maven-cucumber-reporting**).

> No término da execução dos testes de UI é gerada uma evidência na pasta **target/screenshots** com o nome do método, data, e horário da execução.

> O relatório é gerado na pasta **target/cucumber-reports**.
