# StickerTrack

## Sobre o Projeto

O StickerTrack é um aplicativo mobile desenvolvido para gerenciamento de coleções de figurinhas. O sistema permite cadastrar, visualizar, atualizar e remover figurinhas, além de acompanhar estatísticas da coleção por meio de indicadores visuais.

Este projeto foi desenvolvido como trabalho da AP2 (Avaliação Parcial 2) do curso de Análise e Desenvolvimento de Sistemas (ADS) do IBMEC, durante o 2º período, na disciplina de Desenvolvimento Mobile.

---

## Funcionalidades

* Cadastro de figurinhas
* Listagem de figurinhas
* Exclusão de figurinhas
* Atualização do status de figurinhas coladas
* Compartilhamento da coleção
* Estatísticas da coleção
* Contagem de figurinhas coladas
* Contagem de figurinhas não coladas
* Contagem de figurinhas repetidas
* Contagem de figurinhas únicas
* Barra de progresso da coleção

---

## Tecnologias Utilizadas

### Backend

* Python
* FastAPI
* SQLite
* Swagger/OpenAPI

### Mobile

* Kotlin
* Android Studio
* RecyclerView
* Retrofit
* Fragments
* Intents

---

## Arquitetura do Projeto

O projeto é dividido em duas partes:

### Backend

Responsável pelo armazenamento e gerenciamento dos dados das figurinhas através de uma API REST desenvolvida com FastAPI.

### Aplicativo Android

Responsável pela interface do usuário e comunicação com a API através do Retrofit.

---

## Estrutura do Projeto

text
StickerTrack
├── android
│   └── StickerTrack
├── backend
└── README.md


---

## Como Executar o Backend

1. Acesse a pasta backend:

bash
cd backend


2. Execute o servidor:

bash
uvicorn main:app --reload


3. Acesse a documentação da API:

text
http://127.0.0.1:8000/docs


---

## Como Executar o Aplicativo Android

1. Abra o projeto Android Studio.
2. Aguarde a sincronização do Gradle.
3. Execute o aplicativo em um emulador ou dispositivo Android.
4. Certifique-se de que o backend esteja em execução.

---

## Autor

Fagner De Paiva

Projeto desenvolvido para a disciplina de Desenvolvimento Mobile do curso de Análise e Desenvolvimento de Sistemas (ADS) do IBMEC.
