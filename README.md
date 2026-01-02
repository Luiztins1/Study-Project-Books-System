# Porto Books - System 📚

##Protótipo de sistema de gerencimanto de livros desenvolvido para estudos de persistência de dados.

## 🛠 Tecnologias e ferramentas
* **Java 17** (Core e JavaFX para inteface)
* **Maven** (Gerenciamento de dependências)
* **JPA/Hibernate** (Mapeamento Objeto-Relacional)
* **H2 Database** (Banco de dados embutido)

## 🏗 Arquitetura
* **DAO Pattern:** Implementação manual de persistência de dados.
* **Factory Pattern:** Gerencimaneto customizado de 'EntityManagerFactory'.
* **MVC Pattern:** Padrão organizacional de resposabilidades.
* **SOLID:** SRP(Single Responsibility Principle) e DIP (Dependency Inversion Principle).
* **Resource Management:** Controle rigoroso do ciclo de vida de conexões (abertura e fechamento manual) para evitar vazamentos de memória e deadlocks no banco H2.

## Como rodar o projeto
1. Clone o repositório.
2. Certifique-se de ter o Maven instalado.
3. Execute 'mvn install'.
4. O projeto possui uma classe dedicada para inicialização:
5. **Pela IDE:**
   - Execute a classe `com.application.Application`.
6. **Pelo Terminal (Maven):**
   ```bash
   mvn exec:java -Dexec.mainClass="com.application.Application"
