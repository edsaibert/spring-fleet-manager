##  Fleet Manager (Monitoramento de Frota)

API feita em Spring Boot com Java 17 e PostgreSQL com o intuito de:
- Realizar CRUD de veículos e profissionais
- Realizar o monitoramento de frota com RabbitMQ

## Log 10/11/2025 - Início do Projeto
- Realização dos CRUDs básicos do projeto
- Configuração do docker e docker compose

## Log 12/11/2025 
- Adiciona padrão UUID
- Adiciona DTOs
- Primeiro _chart_ sobre a evolução do sistema, onde surgem as perguntas:
    - como criar o sistema de logs (GPS), no sentido estrutural?
    - os logs serão armazenados no banco ou em arquivos?
    - todos os logs são necessários?
<img width="741" height="511" alt="schema drawio" src="https://github.com/user-attachments/assets/df29a55a-13b2-42bf-ab4a-ff95f7b06460" />

## Log 16/12/2025
- Adiciona o banco de dados em memória H2 para o ambiente de testes 
- Adiciona o primeiro teste em veículos para checagem do ambiente de testes