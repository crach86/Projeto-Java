# Sistema de Gerenciamento de Financiamento em Java

Este projeto é um sistema em Java desenvolvido como parte de atividades acadêmicas, focado na modelagem orientada a objetos, tratamento de exceções personalizadas e manipulação de arquivos (texto e binários). O sistema gerencia diferentes tipos de financiamentos (Casas, Apartamentos e Terrenos).

---

## Tecnologias Utilizadas
* **Linguagem:** Java
* **Conceitos Aplicados:** 
  * Programação Orientada a Objetos (POO) (Herança, Polimorfismo, Encapsulamento)
  * Tratamento de Exceções Personalizadas
  * Persistência de Dados (Manipulação de Arquivos Texto e Binários)
  * Coleções em Java

---

## Estrutura do Projeto

O código está organizado nos seguintes pacotes:

* **`main`**: Contém a classe principal para execução do sistema.
  * `Main.java` — Ponto de entrada da aplicação e testes das regras de negócio.
* **`modelo`**: Contém as classes que representam as entidades de negócio.
  * `Financiamento.java` — Classe base abstrata com os atributos e regras gerais de cálculo.
  * `Casa.java` — Especialização para financiamento de casas (com regras de seguro e tamanho).
  * `Apartamento.java` — Especialização para financiamento de apartamentos (com cálculo de vagas e andares).
  * `Terreno.java` — Especialização para financiamento de terrenos (com acréscimos específicos).
* **`utils`**: Classes utilitárias para manipulação de arquivos e interface.
  * `ArquivoTextoUtils.java` — Leitura e escrita de dados em formato de texto.
  * `ArquivoBinarioUtils.java` — Serialização e persistência de objetos em arquivos binários.
  * `InterfaceUsuario.java` — Interação e leitura de dados fornecidos pelo usuário.
  * `AumentoMaiorDoQueJurosException.java` — Exceção personalizada para validação de regras financeiras.

---

## Como Executar o Projeto

1. Certifique-se de ter o **Java Development Kit (JDK)** instalado na sua máquina.
2. Abra a pasta do projeto no **VS Code** (ou na sua IDE Java preferida).
3. Compile e execute a classe principal localizada no pacote `main`:
   * Caminho: `Projeto Java/main/Main.java`
