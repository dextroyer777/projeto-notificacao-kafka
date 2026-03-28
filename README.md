# 🚀 Sistema de Notificações Assíncronas (Event-Driven)

Este projeto é um ecossistema de microserviços desenvolvido para demonstrar alta performance, resiliência e escalabilidade no processamento de notificações, utilizando as tecnologias mais modernas do ecossistema Java e infraestrutura containerizada.

## 🛠 Tecnologias e Conceitos
* **Java 21**: Aproveitando o poder das **Virtual Threads** (Project Loom) para concorrência leve e eficiente.
* **Spring Boot 3.x**: Framework base para injeção de dependências e integração de serviços.
* **Apache Kafka**: Message Broker utilizado para desacoplamento de serviços e garantia de entrega de mensagens.
* **Redis**: Cache de alta performance utilizado para armazenamento de estado (Check-point) e redução de latência.
* **Docker & Docker Compose**: Orquestração de containers para garantir uma infraestrutura imutável e reprodutível.

---

## 🏗 Arquitetura do Sistema

O sistema opera sob o modelo de **Consistência Eventual** e comunicação assíncrona:
1.  **API (Producer)**: Recebe uma notificação via endpoint REST e a publica imediatamente no tópico do Kafka.
2.  **Broker (Kafka)**: Garante a durabilidade do evento, permitindo que a mensagem seja consumida no tempo do worker.
3.  **Worker (Consumer)**: Consome a mensagem, processa a lógica de negócio e registra o status final no **Redis**.



---

## 🚦 Como Executar o Projeto no openSUSE

### 1. Pré-requisitos
* Docker e Docker Compose instalados e configurados.
* Java 21 (JDK) instalado.
* Maven (ou uso do `./mvnw` incluso no repositório).

### 2. Subir a Infraestrutura
Na raiz do projeto (onde está o arquivo `docker-compose.yml`), execute:
```bash
docker-compose up -d
