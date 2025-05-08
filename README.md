## Projeto Backend - Integração de API externa(Tabela Fipe)

  Este projeto é uma API RESTful desenvolvida com Spring Boot, com foco na integração com a API pública da Tabela Fipe para obter informações de marcas de carros. 
A aplicação permite criar, consultar, atualizar e excluir recursos internos relacionados a veículos, consumindo dados em tempo real da API externa.

## 📚 Índice

* [](link)Tecnologias Utilizadas
* Pré-requisitos
* Instalação e Execução
* Modelos de Dados
* Rotas de API
  *  GET /marcas
  *  GET /marcas/{codigo}
  *  POST /modelos
  *  POST /api/marcas/favorita
  *  GET /marcas/favoritas
  *  GET /sobre
* Integração com a API Fipe


## 🚀 Tecnologias Utilizadas

* Java 17
* Spring Boot
* Maven
* API externa: [Tabela Fipe - Marcas de Carros](https://parallelum.com.br/fipe/api/v1/carros/marcas)


## ⚙️ Pré-Requisitos

* Java 11 ou superior
* Maven


## ▶️ Instalação e Execução

__1. Clone o repositório:__
```
git clone https://github.com/patriciamrs/backend-projeto-Patricia-Morais.git
cd backend-projeto-Patricia-Morais
```
__2. Compile o projeto:__
```
mvn clean install
```
__3. Execute a aplicação:__
```
mvn spring-boot:run
```


__A aplicação estará disponível em http://localhost:8000__


## 🧾Modelo de Dados


Cada objeto contém os seguintes campos:
* nome: Nome da marca do veículo.
* codigo: Código númerico único atribuído à marca.

exemplo:
```
{
  "nome": "Alfa Romeo",
  "codigo": "3"
}
```  

## 🔀 Rotas da API



__1. GET /marcas__

Retorna todas as marcas de carros cadastradas.
```
[
	{
		"codigo": "1",
		"nome": "Acura"
	},
	{
		"codigo": "2",
		"nome": "Agrale"
	},
	{
		"codigo": "3",
		"nome": "Alfa Romeo"
	},
	{
		"codigo": "4",
		"nome": "AM Gen"
	},
	{
		"codigo": "5",
		"nome": "Asia Motors"
	}
(...)]
```

__2. GET /marcas/{codigo}__

Retorna a marca correspondente ao código digitado pelo usuário.
Exemplo: /marcas/10
```
{
	"codigo": "10",
	"nome": "Cadillac"
}
```

__3. POST /modelos__

Body > JSON > Digite o código da marca conforme o exemplo:
```
{
  "codigo": "32"
}
```
Retorna todos os modelos de carros da marca pesquisada através do código.


__4. POST /api/marcas/favorita__

Body > JSON > Digite o código e o nome da marca correspondente conforme exemplo:
```
{
		"codigo": "59",
		"nome": "Volkswagen"
}
```
Adiciona a marca à uma lista de favoritos.

__5. GET /marcas/favoritas__

Retorna a lista das marcas adicionadas aos favoritos anteriormente.


![WhatsApp Image 2025-05-07 at 21 01 34](https://github.com/user-attachments/assets/8bff7240-7075-4bd2-9e1b-1c90e3a2cfb1)

__6. GET /sobre__

Retorna informações sobre os integrantes do projeto e o nome do mesmo.
```
{
	"nome do projeto": "Projeto Backend Integração de API externa(Tabela Fipe)",
	"integrantes": "Patricia Morais da Silva"
}
```

## 🌐 Integração com a API Fipe

A aplicação consome dados da API pública da Tabela Fipe, especificamente da rota:
```
https://parallelum.com.br/fipe/api/v1/carros/marcas
```












