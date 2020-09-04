# citiesd-api
## API REST que retorna informações de todos os países. Retorna também informações de todas as cidades e estados brasileiros. Esta API também possui um endpoint que retorna a distância entre duas cidades que estão no banco de dados(apenas cidades brasileiras estão no banco de dados).

- Java 8
- Spring Boot 
- Spring Web
- Spring Data JPA 
- PostgreSQL
- Gradle 


>Os endpoints da API podem ser acessadas em

[citiesd-api](https://dashboard.heroku.com/apps/nameless-atoll-64784/)

__Todas as requisições devem ser via método HTTP GET__

[/api/cities](https://nameless-atoll-64784.herokuapp.com/api/cities) para listar todas as cidades do Brasil 

[/api/states](https://nameless-atoll-64784.herokuapp.com/api/states) para listar todos os estados do Brasil

[/api/countries](https://nameless-atoll-64784.herokuapp.com/api/countries) para listar todos os países

>Para se obter a distância entre as duas cidades do Brasil, deve-se enviar uma requisição para 

[/distances](https://nameless-atoll-64784.herokuapp.com/api/distances)

>E passar como params:

cidade1 = nome da cidade x

cidade2 = nome da cidade y

[Exemplo de requisição](https://nameless-atoll-64784.herokuapp.com/api/distances?cidade1=2&cidade2=1)

>Será retornado a distância, e a unidade de medida utilizada


