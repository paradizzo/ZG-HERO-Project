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

# Clean Code e Princípios SOLID
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

# Padrões de projeto

Eu sei eu sei, eu demorei a entregar essa trilha mas foi por um bom motivo. 
Primeiro vamos aos pontos, primeiro gostaria de agradecer ao instrutor e colega Victor Almeida, eu fiz uma cagada no git e ele me ajudou muito, então, OBRIGADO.
Segundo, eu tive uma ideia, segundo o Victor, meu pensamento estava muito focado em " Funções " ou métodos, apesar do código funcionar, o Groovy é orientado a objetos, então comecei a fazer um código com a translação do meu código para um focado em objetos... O problema foram as desventuras dessa semana que me seguraram, então, decidi seguir um plano. Vou seguir com meu código de métodos até o final do kit 2, onde vou fazer a ligação do Front e do Back e tentar me colocar no cronograma, eu sei que com frameworks o processo de criação de código vai ficar menos penoso, fazendo assim a refatoraão também.
Consigo sentir o código ficando mais emaranhado e talvez começar ele do 0, com mais conhecimento sobre os bancos de dados me dê uma grande ajuda.
Sim, eu estou abusando do fato do código ser pequeno e simples para simplesmente atualizar ele por completo quando for conveniente, sinto que assim eu economizo tempo futuro. Muitas vezes refatorando um código leio e preciso me adequar ao que está alí escrito, sendo que sinceramente? Com novos conhecimentos eu posso erradicar por completo blocos de código que se mostram naquele momento, obsoletos.
Enfim, vamos ao que interessa:

### Mudanças
Essa semana foram as mudanças de padrões de projeto, que pelo motivo citado acima, vou chamar de Sudo ou Pseudos padrões de projeto ( Na minha mente, como não estou me orientando a objetos eu sinto que estou falhando, mas infelizmente preciso me colocar no cronograma, e o programa funciona, então... ). 
Os padrões foram o Singleton para criação das conexões e os adapters, e TALVEZ o Dao ( Data Access Object ). 
Algumas refatorações foram feitas no banco de dados em relação a chaves estrangeiras.
Resolvi também usar a IDE ao meu favor em alguns casos, ao invés de usar, por exemplo o WHERE id = ? e ter mais 4 ou 5 linhas de código para achar o id que estou procurando, eu simplesmente uso uma variavel e coloco ele em um ${}, poupa tempo, poupa linha e deve ser mais otimizado.

Gostaria de agradecer novamente ao Victor por ter me salvado essa semana.


# Padrão MVC
Pelo que eu entendi o trabalho era simples, dividir a aplicação para não deixar existir uma superclass. 
O enunciado do problema diz que a view seria o front end, mas por questões  praticidade eu deixei o view como se fossem os menus do terminal. 

# Webservices e Microservices

Opa, tudo bom? To com umas novidades quentes aqui.  <br />
Essa semana foi a parte de integração de PELO MENOS o cadastro dos candidatos ou empresas, então decidi fazer um pouco mais que isso. <br />
Quando olhei pro meu View e vi aquela aberração eu decidi que gostaria de mudar alguns aspectos, visuais, forms e etc, então fiz uma refatoração do Front end, desenvolvi uma logo, dei uma identidade visual pro projeto e estruturei todos os forms e redirects para ser um site funcional, você pode abrir a landing page e fazer o caminho que um usuario faria.  <br />
Vamos ao de facto ponto da trilha, integração; A trilha tinha caráter exploratório, então tinhamos que procurar como fazer a integração sem frameworks e POR DEUS DO CÉU EU PROCUREI, mas nada que eu achava parecia interessante ou servir pro meu proposito, até que encontrei os servlets e foi PERFEITO.  Essa trilha teve em mim um efeito bastante de "disempowerment". <br> 
Eu tentava muita coisa, e quase nada dava certo e eu tive que TENTAR, TENTAR e TENTAR, mas no fim tudo deu certo, enfim, não tenho muito o que falar da trilha a não ser o fato de que foi exaustante e divertido até ficar procurando soluções e vendo tutoriais, certamente  a outra parte divertida foi produzir o design e montar o site. <br />

Deixa eu explicar como eu fiz a integração: <br />
Primeiro eu abro um servlet via tomcat, esse servidor recebe os dados via POST do javascript usando ajax, pega os dados, verifica o Trigger, que é um input escondido, esse trigger pode SER 2 ou 1 , dependendo do valor do Trigger ele adiciona os dados no banco de dados do candidato ou da empresa. Simples, fácil e rápido. <br />
Cabe dizer que usei o Maven também, o melhor tutorial usava Maven então é isso.
Outro ponto a se dizer é que você não pode enviar campos vazios, eu desabilitei o botão de submit caso tenha algum campo vazio, deixei os campos de CEP, CPF e CNPJ com um max e min length e com um regex que só permite números e VOALÁ, você não pode colocar valores inválidos no campo.

### O que falta implementar?
- Registro de vagas
- Login 
- Feed de vagas e candidatos responsívo 

### O que tem que não foi pedido? 
Basicamente o site inteiro, pode ter sido uma decisão ruim mas eu não aguentava olhar pro design daquele site antigo, estava MUITO feio e com os forms todos errados e mal feitos.  <br />
O site todo é responsivo, dá uma olhada ai!  <br /> 
Vou adicionar umas fotos comparativas aqui e é isso, até semana que vem, OU ANTES... 

### Comparativos
- Antigo
 <br />

![logo_feia](https://user-images.githubusercontent.com/80402261/170729884-1cb689e5-e7c0-4508-ba43-a16b6061bb7f.png)
![landingpage_feia](https://user-images.githubusercontent.com/80402261/170729828-6d358235-2ca0-407b-b948-f84e5fae2e32.png)
![registro_feio](https://user-images.githubusercontent.com/80402261/170729943-f69ff6db-7c86-4afa-9706-44eb3ac2bfe5.png)

- Novo 
![logo-conjunta](https://user-images.githubusercontent.com/80402261/170730060-34583d01-cfb0-41e3-aec6-d786809ca4ee.png)
![landing_page_bonita_cel](https://user-images.githubusercontent.com/80402261/170730103-68a8fb36-999d-4197-880a-a484fd41ca96.png)
![registro-cel-bonito](https://user-images.githubusercontent.com/80402261/170730145-a8e9be2a-6c51-41ed-8680-988ef517ca05.png)


# REST/RESTFUL API

Ok ok, eu sei que eu atrasei mas eu posso explicar, EU JURO! <br />
Comecei essa semana tendo muita dificuldade de como implementar as APIS, pensei em usar os servlets como apis, que mandam pro model e lá ocorre o cadastro do candidato, empresa e vaga, e foi isso que eu fiz, só teve um pequeno problema, por algum motivo quando eu tentava comunicar o servlet com uma classe Groovy...dava erro (?). Eu também não entendi, fiquei o dia todo procurando a solução e tudo que tentei NÃO FUNCIONOU, com meu tempo acabando eu decidi ir fazer coisas de faculdade e dormir, quando acordei no outro dia eu estava Febril, tonto e com tosse, então fiquei 4 dias nervoso por causa do código enquanto tudo que meu cerébro pensava era o tempo que eu tava perdendo tendo que ficar na cama tomando remédio.  <br />

Sabádo melhorei e decidi ajeitar o erro de novo, e dessa vez, munido de confiança e vias nasais limpas eu FALHEI NOVAMENTE! <br />
Não entendi muito bem como ajeitar o erro que eu estava tendo mas descobri que uma classe Java funcionava, então, devido ao tempo acabando  eu decidi que usaria Java.  <br />

Como o site está com vários Htmls, quando você manda o form e faz o request, se der sucesso ele te leva até a página de login, e se der erro um alerta bem grande aparece dizendo: ALGO DEU ERRADO MANINHO! 
Outra coisa também é a impossibilidade de colocar dados errados, como estado com mais de 2 letras, ou um cpf com mais de 11 digitos. 
É isso, agora é correr pra começar o kit 3! 


# KIT 3 

Opa, dá uma olhada nesse repo [aqui]( https://github.com/paradizzo/JobCloud-Microservices ) 
