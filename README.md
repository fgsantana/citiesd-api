# citiesd-api
## API REST que retorna informações de todos os países. Retorna também informações de todas as cidades e estados brasileiros. Esta API também possui um endpoint que retorna a distância entre duas cidades que estão no banco de dados(apenas cidades brasileiras).

- Java 8
- Spring Boot 
- Spring Web
- Spring Data JPA 
- PostgreSQL
- Gradle 
- Heroku
- PostgreSQL Extensions(Earthdistance, Cube)


>Os endpoints da API podem ser acessadas em

[citiesd-api](https://citiesd-api.herokuapp.com/api/v1)


__Todas as requisições devem ser enviadas via método GET__

.

[/cities](https://citiesd-api.herokuapp.com/api/v1/cities) para listar todas as cidades do Brasil 
>A listagem é feita por paginação(20 elementos por página). Caso não seja informada a pagina, é retornada a primeira.

>Para se obter outra página, deve-se enviar como param:

page = número da página

__Um exemplo de uma requisição solicitando outra página é mostrado__ [aqui](https://citiesd-api.herokuapp.com/api/v1/cities?page=10) 

>Para listar uma cidade com um nome específico, pode-se passar o nome ou id da cidade, por exemplo:

[Recife](https://citiesd-api.herokuapp.com/api/v1/cities/recife)

[3315](https://citiesd-api.herokuapp.com/api/v1/cities/3315) 

>Ambos retornam a cidade Recife, apenas mudando a forma como a identificamos

>Existem cidades que possuem nomes iguais, nesse caso será retornada uma lista com as cidades com um dado nome, por exemplo:

[Bom Jesus](https://citiesd-api.herokuapp.com/api/v1/cities/Bom%20Jesus)


.


[/states](https://citiesd-api.herokuapp.com/api/v1/states) para listar todos os estados do Brasil

>Para listar um estado específico, pode-se passar o nome ou id do estado, por exemplo:

[Pernambuco](https://citiesd-api.herokuapp.com/api/v1/states/Pernambuco)

[16](https://citiesd-api.herokuapp.com/api/v1/states/16)

.


[/countries](https://citiesd-api.herokuapp.com/api/v1/countries) para listar todos os países

>Para listar um país específico, pode-se passar o nome ou id do país, por exemplo:

[Brasil](https://citiesd-api.herokuapp.com/api/v1/countries/Brasil)

[1](https://citiesd-api.herokuapp.com/api/v1/countries/1)

.

>Para se obter a distância entre as duas cidades do Brasil, deve-se enviar uma requisição para 

/distances

>E enviar como params:

by = como as duas cidades vão ser identificadas (deve ser __id__ ou __name__)

cidade1 = nome ou id da cidade x

cidade2 = nome ou id da cidade y

>O tipo do identificador escolhido deve ser o mesmo para as duas cidades(ou é enviado os nomes das cidades, ou os ids)

__Um exemplo de requisição é mostrado__ [aqui](https://citiesd-api.herokuapp.com/api/v1/distances?by=name&cityX=recife&cityY=sao%20paulo)

>Nesse caso, foi escolhido __name__ como identificador das duas cidades


