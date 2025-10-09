# 🎌 AnimeSearch IA

![Java](https://img.shields.io/badge/Java-17+-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green)
![Frontend](https://img.shields.io/badge/Frontend-HTML_JS_CSS-orange)
![API](https://img.shields.io/badge/API-Gemini-purple)

> Um projeto Full-Stack que utiliza a API do Google Gemini para gerar sugestões personalizadas de animes com base em uma lista de animes cadastrados pelo usuário.

Este projeto foi desenvolvido como parte do programa **Java10x**.

## ✨ Funcionalidades

* **Catálogo de Animes:** Liste e adicione novos animes ao seu catálogo pessoal.
* **Interface Intuitiva:** Um frontend simples de página única (SPA) para gerenciar seu catálogo.
* **Sugestões com IA:** Um botão que analisa sua lista de animes cadastrados e usa a IA do Gemini para sugerir novos animes com base no seu gosto.
* **Modal de Adição:** Adicione novos animes sem sair da página principal através de uma janela popup.
* **Tema Escuro:** Interface com um layout moderno e tema escuro.

## 🚀 Tecnologias Utilizadas

#### Backend
* **Java 17+**
* **Spring Boot:** Framework principal para a construção da aplicação.
* **Spring Data JPA:** Para persistência de dados.
* **Spring WebFlux (WebClient):** Para fazer chamadas reativas à API externa do Gemini.
* **H2 Database:** Banco de dados em memória/arquivo para desenvolvimento.
* **Flyway:** Para versionamento e migração do schema do banco de dados.
* **Lombok:** Para reduzir código boilerplate nos modelos.

#### Frontend
* **HTML5**
* **CSS3:** Estilização moderna com Flexbox e variáveis CSS.
* **JavaScript (Vanilla):** Lógica do frontend, incluindo chamadas `fetch` para a API backend.

## 🔧 Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina:
1.  [JDK](https://www.oracle.com/java/technologies/downloads/) (Java Development Kit) - Versão 17 ou superior.
2.  [Maven](https://maven.apache.org/download.cgi) - Gerenciador de dependências.
3.  Uma **API Key do Google Gemini**, que pode ser obtida no [Google AI Studio](https://aistudio.google.com/app/apikey).

## ⚙️ Como Executar o Projeto

Siga os passos abaixo para rodar o projeto localmente.

**1. Clone o repositório:**
```bash
git clone [https://github.com/SEU_USUARIO/SEU_REPOSITORIO.git](https://github.com/SEU_USUARIO/SEU_REPOSITORIO.git)
cd SEU_REPOSITORIO
