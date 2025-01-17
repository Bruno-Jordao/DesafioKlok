# Testes Automatizados do Projeto Ecommerce

Este projeto contém testes automatizados para validar funcionalidades da aplicação de e-commerce. Os testes são escritos utilizando o framework JUnit e Selenium WebDriver.

## 📋 Casos de Teste Implementados

### 1. Caso de Sucesso: Busca por Produto Existente
- **Descrição:** Verifica se, ao buscar por um produto existente, uma lista de produtos é exibida corretamente.
- **Passos do Teste:**
    1. Abrir a página inicial: `https://www.magazineluiza.com.br`.
    2. Inserir o termo "Notebook" na barra de busca.
    3. Verificar se a lista de produtos é exibida.
    4. Validar que o primeiro produto contém o termo "notebook".
- **Resultado Esperado:**
    - A lista de produtos é exibida.
    - O primeiro produto contém o termo "notebook".
- **Status:** ❌ **Falhou**
    - **Motivo:** A lista de produtos não foi exibida (método `isProductListDisplayed` retornou `false`).


---

### 2. Caso Alternativo: Busca por Produto Inexistente
- **Descrição:** Verifica o comportamento da aplicação ao buscar por um produto inexistente.
- **Passos do Teste:**
    1. Abrir a página inicial: `https://www.magazineluiza.com.br`.
    2. Inserir o termo "ProdutoInexistente123" na barra de busca.
    3. Verificar se uma mensagem de "nenhum produto encontrado" é exibida.
- **Resultado Esperado:**
    - A mensagem "Nenhum produto encontrado" é exibida na tela.
- **Status:** ✅ **Passou**