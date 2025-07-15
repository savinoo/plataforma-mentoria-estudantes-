# Épicos e Histórias de Usuário - Plataforma de Mentoria

## EPIC-01: Descoberta e Conexão de Mentores

| Atributo | Valor |
| :--- | :--- |
| **ID do Épico** | EPIC-01 |
| **Persona Principal** | Mentorado (ou Visitante interessado) |

### Descrição
Este épico representa a "vitrine" da plataforma de mentoria. Seu objetivo é permitir que mentorados (ou visitantes) encontrem e se conectem com mentores adequados às suas necessidades. As funcionalidades desenvolvidas aqui são a primeira interação do mentorado com a principal proposta de valor do sistema: o acesso a especialistas. A interface deve ser clara, confiável e inspirar a ação. O sucesso deste épico é medido pela capacidade de transformar um visitante em um mentorado engajado que solicita uma mentoria.

### Escopo e Funcionalidades Principais
* **Listagem de Mentores:** Exibição de todos os mentores aprovados em um layout de fácil navegação.
* **Página de Perfil do Mentor:** Visualização de todas as informações relevantes de um mentor específico para ajudar na tomada de decisão do mentorado.
* **Busca e Filtragem:** Ferramentas para que o usuário possa encontrar mentores por nome, área de especialidade ou habilidades.

---

### 📜 Histórias de Usuário
As seguintes histórias de usuário compõem este épico. Cada uma representa uma entrega de valor que, juntas, completam a funcionalidade de descoberta e conexão.

* **HU01:** Listagem de Mentores Disponíveis na Plataforma
* **HU02:** Visualização do Perfil Detalhado de um Mentor
* **HU03:** Busca e Filtragem de Mentores

---

### 🚀 Requisitos Não-Funcionais Chave
* **Responsividade:** Todas as páginas devem ser totalmente funcionais e visualmente agradáveis em dispositivos móveis, tablets e desktops.
* **Desempenho:** O tempo de carregamento das páginas de listagem e perfil de mentores deve ser otimizado para não frustrar o usuário.
* **Acessibilidade:** A estrutura HTML deve ser semântica e seguir as boas práticas básicas de acessibilidade (WCAG) para garantir o uso por todos.

---

### ✅ Critérios de Aceite do Épico
Para que este épico seja considerado **concluído**, o fluxo completo de descoberta de mentores deve estar funcional e atender aos seguintes critérios:
- [ ]  Um usuário (logado ou não) consegue acessar a plataforma e visualizar a lista de mentores disponíveis.
- [ ]  A partir da lista, o usuário consegue navegar para a página de perfil detalhado de qualquer mentor.
- [ ]  O usuário consegue utilizar a busca e os filtros para refinar a lista de mentores, e os resultados são exibidos corretamente.
- [ ]  Toda a experiência de navegação é consistente, intuitiva e totalmente responsiva.

---
---

## HU01: Listagem de Mentores Disponíveis na Plataforma

### A Estrutura dos 3 Ws (Quem, O Quê, Por Quê)

| Pergunta | Resposta |
| :--- | :--- |
| **WHO? (Quem?)** | Um **Mentorado** |
| | Este é o nosso ator principal. Alguém em busca de orientação que acessa a plataforma para encontrar um especialista. |
| **WHAT? (O Quê?)** | Ver uma lista de todos os mentores disponíveis. |
| | Esta é a ação central: ter um panorama dos especialistas cadastrados para iniciar sua busca. |
| **WHY? (Por Quê?)** | Para ter uma visão geral de quem pode me ajudar e explorar minhas opções. |
| | Este é o valor: dar ao mentorado a capacidade de descobrir a variedade e a qualidade dos mentores na plataforma. |

### História de Usuário Completa
Como um **Mentorado** (Quem), eu quero **ver uma lista de todos os mentores disponíveis** (O Quê), para que eu possa **ter uma visão geral de quem pode me ajudar e explorar minhas opções** (Por Quê).

### Descrição
Esta é a galeria de especialistas da plataforma. Guiados pelo "Porquê" do usuário, nosso objetivo é apresentar os mentores de forma profissional e convidativa, destacando suas principais competências para incentivar o mentorado a clicar e saber mais.

### ✅ Critérios de Aceite
Para que esta história seja considerada **concluída**, todos os critérios a seguir devem ser atendidos:
- [ ]  **Exibição da Lista:** Ao acessar a página "Encontrar Mentores", uma seção contendo uma lista de cards de mentores deve ser exibida.
- [ ]  **Apenas Mentores Aprovados:** A lista deve conter **apenas** mentores cujo status seja "Aprovado" pelo administrador.
- [ ]  **Informações do Card:** Cada card de mentor na lista deve exibir, no mínimo: foto de perfil, nome completo, principal área de especialidade (ex: "Desenvolvimento de Software", "Gestão de Produtos") e uma tagline ou resumo curto.
- [ ]  **Navegação para Detalhes:** Cada card de mentor deve ser um link clicável que redireciona para a página de perfil detalhado daquele mentor (funcionalidade da HU02).
- [ ]  **Cenário Sem Mentores:** Caso não existam mentores cadastrados ou aprovados, uma mensagem amigável deve aparecer no lugar da lista (ex: "Nenhum mentor disponível no momento. Volte em breve!").
- [ ]  **Paginação:** Se houver mais de 15 mentores, a lista deve ser paginada, exibindo os controles para navegar para as próximas páginas.

---

## HU02: Visualização do Perfil Detalhado de um Mentor

### A Estrutura dos 3 Ws (Quem, O Quê, Por Quê)

| Pergunta | Resposta |
| :--- | :--- |
| **WHO? (Quem?)** | Um **Mentorado** |
| | Alguém que já identificou um mentor em potencial na listagem e agora precisa de mais informações para validar sua escolha. |
| **WHAT? (O Quê?)** | Clicar em um mentor para ver seu perfil completo. |
| | A ação de se aprofundar nas qualificações e na experiência de um especialista específico. |
| **WHY? (Por Quê?)** | Para avaliar se a experiência e as habilidades do mentor são compatíveis com minhas necessidades antes de solicitar uma mentoria. |
| | O valor é a **confiança**. O usuário precisa de todos os detalhes para tomar a decisão informada de contatar aquele mentor. |

### História de Usuário Completa
Como um **Mentorado** (Quem), eu quero **clicar em um mentor para ver seu perfil completo** (O Quê), para que eu possa **avaliar se a experiência e as habilidades dele são compatíveis com minhas necessidades antes de solicitar uma mentoria** (Por Quê).

### Descrição
Esta história representa o momento da decisão. Após ser atraído por um perfil na listagem (HU01), o mentorado precisa de um local com todas as informações que comprovem a autoridade e a adequação daquele mentor. A página deve ser bem estruturada, informativa e conter um claro "chamado para ação" (Call to Action) para o próximo passo: a solicitação de mentoria.

### ✅ Critérios de Aceite
- [ ]  **Acesso à Página:** Ao clicar em um card de mentor, o usuário é redirecionado para uma URL única e específica (ex: `/mentores/lucas-savino`).
- [ ]  **Conteúdo Completo:** A página de perfil deve exibir todas as informações relevantes do mentor, incluindo: foto, nome, resumo profissional, áreas de especialidade, lista de habilidades, experiência profissional detalhada e formação acadêmica.
- [ ]  **Chamado para Ação (CTA):** Um botão claro e destacado com o texto "Solicitar Mentoria" (ou similar) deve estar presente.
- [ ]  **Fluxo de Usuário Não Autenticado:** Se um visitante (não logado) clica no botão "Solicitar Mentoria", ele deve ser redirecionado para a página de login/cadastro.
- [ ]  **Tratamento de Erro (404):** Se um usuário tentar acessar a URL de um mentor que não existe ou não está aprovado (ex: `/mentores/usuario-invalido`), uma página de erro "Mentor não encontrado" (Página 404) deve ser exibida.
- [ ]  **Navegação de Retorno:** A página deve ter um meio claro de voltar para a lista de mentores (ex: um link "Voltar" ou um breadcrumb de navegação).

---

## HU03: Busca e Filtragem de Mentores

### A Estrutura dos 3 Ws (Quem, O Quê, Por Quê)

| Pergunta | Resposta |
| :--- | :--- |
| **WHO? (Quem?)** | Um **Mentorado** |
| | Um usuário que tem uma necessidade específica (ex: "preciso de ajuda com Python") ou que deseja refinar a lista para encontrar o especialista perfeito. |
| **WHAT? (O Quê?)** | Buscar mentores por nome ou filtrar por área de especialidade/habilidade. |
| | A ação de usar ferramentas de pesquisa para encontrar informações relevantes de forma rápida e eficiente. |
| **WHY? (Por Quê?)** | Para encontrar rapidamente o especialista ideal para minhas necessidades. |
| | O valor é a **eficiência e precisão**. O usuário economiza tempo e aumenta a chance de encontrar a pessoa certa, melhorando sua experiência. |

### História de Usuário Completa
Como um **Mentorado** (Quem), eu quero **buscar mentores por nome ou filtrar por área de especialidade/habilidade** (O Quê), para que eu possa **encontrar rapidamente o especialista ideal para minhas necessidades** (Por Quê).

### Descrição
Com o crescimento da plataforma, encontrar o mentor certo pode se tornar um desafio. Esta funcionalidade empodera o mentorado, dando a ele o controle para navegar pela base de especialistas de forma inteligente e direcionada. A implementação deve ser reativa, atualizando a lista de mentores com base nas escolhas do usuário.

### ✅ Critérios de Aceite
- [ ]  **Componentes de UI:** A página de listagem de mentores deve conter um campo de texto (`<input type="text">`) para a busca por nome e um ou mais menus suspensos (`<select>`) ou checkboxes para filtrar por "Área de Especialidade" e "Habilidades".
- [ ]  **Funcionalidade da Busca por Nome:** Quando o usuário digita um nome no campo de busca e submete, a lista é atualizada para exibir apenas os mentores cujo nome contenha o termo pesquisado.
- [ ]  **Funcionalidade do Filtro:** Quando o usuário seleciona uma ou mais opções nos filtros (ex: Categoria "Carreira" e Habilidade "Entrevista de Emprego"), a lista é atualizada para exibir apenas os mentores que atendam a todos os critérios selecionados.
- [ ]  **Busca e Filtro Combinados:** As funcionalidades devem operar em conjunto. Se o usuário busca por "Maria" e filtra por "Design", o resultado deve conter apenas mentoras chamadas "Maria" que atuam na área de Design.
- [ ]  **Retenção de Estado:** Após a atualização da lista, os termos buscados e os filtros selecionados devem permanecer visíveis e ativos nos componentes de UI.
- [ ]  **Cenário Sem Resultados:** Se a busca ou o filtro não encontrarem nenhum mentor correspondente, uma mensagem clara deve ser exibida (ex: "Nenhum mentor encontrado com esses critérios.").
- [ ]  **Limpar Filtros:** Deve existir um botão ou link para "Limpar Filtros" que, ao ser clicado, reseta todos os campos de busca e filtros, recarregando a lista completa de mentores aprovados.
