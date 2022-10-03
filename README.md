# Desafio de Programação Java Jr.

## Tecnologias:
 * JavaEE;
 * RESTful API JAX-RS;
 * Banco de dados H2.
 
## Instruções:
* Crie o banco de dados com as tabelas:
   - cliente;
   - produto;
   - pedido.
* No arquivo jdbc.properties preencha corretamente os dados do seu banco.


### Explicando os arquivos:

* Temos o pacote com.sazax.conexao com a classe DbConexao que faz a conexao com nosso banco;

* Temos o pacote com.sazax.entidade que temos as classes pais de cliente, pedido e produto, nela declaramos os construtores e os getters e setters;

* No pacote com.sazax.resources é onde usamos a tecnologia do JAX-RS;

* No pacote com.sazax.dao 
   - Temos a classe DaoFactory para testar nossa conexão com o banco e a classe DaoException para informar o tipo de erro caso algum ocorra;
   - As classes Jdbc para cliente, produto e pedido, onde temos as interações com o banco;
   - E por ultimo nossas interfaces de cliente, produto e pedido.
   
   
