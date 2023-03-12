# YourMovies - Projeto feito por Antonio Neto e Maria Helena

Projeto final - WEB I - Santander Coders

## API de Filmes

Foi feito uma API de Usuários integrada com a API de filmes do OMDB para a consulta dos filmes para ser adicionados na lista de filmes favoritos de cada Usuário.

```bash
Foi usado a Arquitetura REST para o desenvolvimento e gerenciamento do projeto.
Para o front-end, foi usado o framework Thymeleaf.
```

## YourMovies na prática

```java
import YourMovies

# add um Usuário - localhost:8080/yourmovies/users
Ele irá 'salvar' seus dados ('nome, e-mail e senha') e irá gerar um ID único para você.
Retornando para você como confirmação seu nome e seu e-mail, não retornando a senha
como forma de segurança.

'Exemplo de Usuario'
{
	"name": "Antonio Neto",
	"email": "antonioneto@gmail.com",
	"password": "12345678"
	 
}

# Validação do 'Usuário'
('nome') = não pode ser em branco;
('email') = deve conter o padrão de e-mail;
('senha') = deve ter no minimo 4 caracteres e no máximo 15 caracteres.

# Pegar ID por usuario localhost:8080/yourmovies/users/1
# Listar todos os Usuarios localhost:8080/yourmovies/users/all
# Pegar um filme e suas informações localhost:8080/yourmovies/omdb/nome+do+filme
# Adicionar um filme a um usuario - localhost:8080/yourmovies/users/{idDoUsuario}/save
# Listar todos os Filmes do Usuario - localhost:8080/yourmovies/users/{idDoUsuario}/allmovies
# Deletar filme por ID do filme - localhost:8080/yourmovies/movies/{idDoFilme}
# Deletar todos os filmes de um Usuario por ID do usuario - localhost:8080/yourmovies/users/{idDoUsuario}/movies


# Pesquisar seu filme favorito através da nossa API
Você irá conseguir pesquisar seu filme favorito a partir do nome e irá receber todas as
informações necessárias para adicionar seu filme favorito na Base de dados.
Informações que você irá receber do Filme:
'Titulo' do filme; 'Genero' do filme, 'Ano' do filme e o 'imdb Rating' do filme.

# Adicionar o filme no seu Usuário
A partir disso, você consegue adicionar quantos filmes quiser no seu usuário!
```

## Contribuição

O respectivo projeto foi feito por Antonio Neto e Maria Helena, mas toda e qualquer contribuição será válida para novas atualizações do código e novas funcionalidades.

## LinkedIn dos Autores

[Antonio Neto](https://www.linkedin.com/in/aasneto/) -
[Maria Helena](https://www.linkedin.com/in/maria-helena-juvito-/)
