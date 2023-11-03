# 🍕 PizzariaBAN: Sistema de Gerenciamento de Pizzaria

Um sistema simples de gerenciamento para pizzarias, escrito em Java, que permite ao usuário adicionar pedidos, pizzas e bebidas, bem como listar informações sobre eles. O sistema utiliza um banco de dados PostgreSQL para armazenar e gerenciar os dados.

### Aplicação:

O sistema `PizzariaBAN` oferece um menu interativo para o usuário, permitindo realizar as seguintes operações:

- Adicionar pedidos, pizzas e bebidas.
- Listar todos os pedidos, pizzas e bebidas.
- Listar pizzas ou bebidas de um pedido específico.
- Listar todos os pedidos que contêm bebidas ou pizzas.
- Listar o(s) pedido(os) com a data mais recente.

### Esquema do Banco de Dados:

O sistema utiliza três tabelas principais:

- **pedidos**: Armazena informações sobre os pedidos, incluindo um código de pedido e a data do pedido.
- **pizza**: Armazena informações sobre as pizzas, incluindo um código de pizza, sabores e o código do pedido associado.
- **bebida**: Armazena informações sobre as bebidas, incluindo um código de bebida, nome da bebida, quantidade e o código do pedido associado.

As tabelas `pizza` e `bebida` têm chaves estrangeiras que se referem à tabela `pedidos`, indicando a qual pedido uma pizza ou bebida específica pertence.

## 🛠 Pré-requisitos

- Java JDK 8 ou superior.
- PostgreSQL 15.1 ou superior.



