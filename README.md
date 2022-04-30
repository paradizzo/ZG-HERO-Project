# Criação do MVP
Criação do MVP do LinkeTinder, por enquanto somente com a listagem de pessoas. Eventualmente colocarei o sistema de curtidas e adicionar novas pessoas e empresas. 


# Adição de features e testes unitários
Adicionei testes unitários e também duas opções, uma de adição de pessoas e outra de adição de empresas, com isso tendo a listagem.
Futuramente será implementado o front end e o sistema de matchs.


# Front end do Linketinder


Esse é o front-end do LinkeTinder; A logo é composta por um fogo, representando o Tinder, e o logo do Linkedin. O front end no atual momento se encontra incompleto. 
### Features a serem adicionadas: 

- Cadastro de usuário com retenção de dados
- Cadastro de empresa com retenção de dados
- Sistema de login
- Banco de dados 
- Sistema de like, deslike e match 
- Upload de foto para ser usada nos perfis

O design atual está simples, é próvavel que mudanças ocorram, ideias são bem vindas ;) . 
Atualmente o projeto possui design responsivo.

## Como fazer funcionar o front-end
Depois de abrir o index.html, você verá uma aba de login. Dentro dessa área de login você pode escolher entrar como empresa ou como candidato.
Vá até a aba " Entrar como candidato " e se registre, lá poderá escolher 4 tecnologias, inserir seu email, nome e senha.
Depois vá até  a aba de empresas clicando em " Entrar como empresa " e faça login, o candidato recem criado deverá aparecer no display.
No botão hamburguer você pode conferir adição de novas vagas, gráfico de barras, delete de vagas pelo seu nome e retorno ao menu principal.
Se decidir criar uma vaga, escolha o seu nome e as tecnologias procuradas e a crie. 
Na aba de candidato faça login e a vaga recém criada deverá aparecer no display.

## Disclaimer front-end

As imagens usadas são meramente ilustrativas, o nome que você colocar na sua empresa ou candidato estão definidos como " Anon " por padrão, devido a anonimidade, futuramente com o sistema de Match isso irá mudar, você poderá ver a foto, nome e empresa que está sendo pareado com.


# Adição do REGEX no Linketinder

### Bugs corrigidos: 
- Caixas vaziam agora produzem um aviso de erro
- Gráfico de barras funcional


# Criação do banco de dados

Nenhum bug foi corrigido ou descoberto durante essa fase, uma criação de banco de dados foi feita apenas.
Segue abaixo uma imagem representativa do banco de dados: 
![Linketinder](https://user-images.githubusercontent.com/80402261/161648325-34355588-267d-4b1a-b8cb-8ab9339c8727.png)


# Atualização no banco de dados e no backend

Estou deixando a pasta LINKETINDER só para efeitos de comparação, eu refiz o código do Linketinder e renomeei para LinketinderREBORN, refiz o código de um jeito légivel, o outro código estava simplesmente INUTILIZAVEL. 
Atualmente o código é um exo esqueleto ( Não possui regex, testes unitarios, etc... ) mas agora é um código funcional para integração com banco de dados. 
Por questões de tempo não coloquei essas features/não-remoção-de-bugs; Na proxima trilha estarei modelando e tornando esse código menos desajeitado. 

# Adição do Gradle no LinketinderREBORN (?)

Gradle adicionado, não se da maneira correta, mas foi adicionado. 

# Clean Code 
Ok, aqui temos que colocar alguns pontos.
A refatação do BackEnd do Linketinder já havia sido feita, o código anterior está ilegivel então antes mesmo da trilha começar eu já havia refatorado o mesmo.
Dito isso, algumas pontas ficaram soltas, então ajeitei pequenos blocos de código, diminuindo linhas, retirando semicolons e booleans redundantes.
Outro ponto de refatoração foi no próprio banco de dados, mas não no código. 
O Banco de dados agora possui 2 tables, essas sendo: candidato_has_competencia e vagas_has_competencia, agora sim fazendo uma ligação N:N. 
O grande problema foi como traduzir isso pro Backend, dúvida que será sanado na próxima segunda-feira. 
Outra novidade que essa trilha trás é o spoiler do futuro projeto. O Job Cloud, já renomei o back end para CLOUD JOB por esse simples motivo. 
Por questões de tempo e outras dificuldades que também serão sanadas na próxima segunda, é provavel que o front end tenha uma nova cara. 

### Dito tudo isso, segue basicamente as diferenças:

- Refatação COMPLETA do código 
- Retirada de funções repetidas
- Retirada de booleans redundantes
- Um Main e um Utils, que é chamada do MAIN
- Uma pequena refatoração no menu de itens
- Adição de tratamento de erros
- Alguns ajustes no Gradle que SISMAVAM em dar erro

Segue támbem a foto do esquema do banco de dados:
![Linketinder](https://user-images.githubusercontent.com/80402261/166125840-d81eaba4-884a-42b1-ba15-2d71252af8f2.png)


Fique atento pras próximas semanas, onde irei upar e conectar esse novo backend com o front end com sua própria identidade visual.
Vou deixar a logo aqui pra dar um gosto na boca 😋

![logo-conjunta](https://user-images.githubusercontent.com/80402261/166125863-57d527b6-79fc-4cfd-abe5-bec01b0ef546.png)

