# SISTEMA ORDER
### Sistema criado para o processamento de pedidos.


Aqui consumimos uma fila de um "Prouto A" chamada "process-order". Após coletar as informações dos pedidos desta fila, efetuados o calculo do mesmo, somando o valor total da compra e
disponibilizando em um "Produto B" após inserir no banco de dados.

Abaixo listo alguns endpoints para teste sistemico:

- http://localhost:8080/ambev/order (Listar todos os pedidos)
- http://localhost:8080/ambev/order/1 (Buscar pedido por ID)

- http://localhost:8080/ambev/product (Listar todos os produtos)
- http://localhost:8080/ambev/product/1 (Buscar produto por ID)

- http://localhost:8080/ambev/populate (Esta chamada POST criada para mocar dados e inseri-los no "Produto A")
