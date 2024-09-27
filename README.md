# Episode Counter
## Resume
> ### Episode Counter v1
> Episode Counter é uma ferramenta criada para auxiliar no dia a dia de consumidores de animes, séries, filmes, livros, entre outros. Ela armazena informações relacionadas ao conteúdo como o episódio no qual o usuário parou, qual o tipo do conteúdo, o dia de lançamento, se o usuário ainda está assistindo, já assistiu ou pretende assistir, e diversas outras funções disponíveis.
Foi criado inicialmente para uso pessoal, pois eu não tinha acesso a grandes plataformas de streaming que armazenavam as informações citadas, portanto, desenvolvi a minha própria.

Esta é a  versão 2.0 do Episode Counter, que segue os mesmos princípios da sua primeira versão, entretanto com mudanças fundamentais para o bom funcionamento da ferramenta.

**Principais mudanças:**

 - *Mudança de atributos:*
A forma que a ferramenta armazena as informações foi otimizada, economizando e muito os recursos da máquina e melhorando a eficiência da ferramenta.
 - *Pilares da POO (Programação Orientada a Objetos):*
A primeira versão do Episode Counter foi criada com apenas 2 meses de experiência com Java. Agora após um estudo mais aprofundado tanto de **Java** quanto de **Programação Orientada a Objetos**, uma aplicação mais trabalhada e profissional pôde ser desenvolvida, utilizando princípios de **Abstração**, **Polimorfismo** e **Encapsulamento** principalmente para um programa mais robusto.
 - *Mudança no Banco de Dados:*
Para seguir o ritmo do mercado de trabalho, agora o Episode Counter conta com conexão ao banco de dados **PostgreSQL** que se mostra cada vez maior no ambiente dev.
 - *Gerenciador de Dependências:*
Na primeira versão da ferramenta, utilizávamos arquivos .jar para adicionar bibliotecas externas, agora com o **Maven**, este trabalho foi minimizado exponencialmente, bastando apenas algumas linhas de código para trazer a versão mais recente das dependências da ferramenta.

## Funcionamento
### Criação de Objetos
**Content**
Dentro do Episode Counter temos um objeto principal chamado *[Content](https://github.com/jnbdotdev/Episode-Counter-v2/blob/master/src/main/java/com/jnb/models/Content.java)* que possui os respectivos atributos:

    Inteiro cod; // O código único e imutável de cada conteúdo
    String name; // O nome de cada conteúdo, como super onze, cobra kai, etc
    Inteiro group; // A temporada, saga, volume, etc, onde o usuário parou
    Inteiro unit; // A episódio, capítulo, etc, onde o usuário parou
    String platform; // A plataforma na qual o usuário consome o conteúdo
    Calendar releaseDay; // O dia de lançamento do conteúdo
    Booleano releasing; // Dado lógico se o conteúdo está sendo lançado ou não
    Inteiro personalStatus; // Se o usuário está assistindo, pretende assistir, etc
    Inteiro category; // A categoria do conteúdo, serié, anime, etc

Valores como *group*, *unit*, *personalStatus* e *category* podem parecer confusos por armazenarem seus dados como inteiros, mas na verdade é mais versátil quando se aplica valores personalizados para cada número inteiro, como por exemplo, em personalStatus temos a seguinte tabela de valores:
|int| valor |
|--|--|
| 1 | Pretende Assistir |
| 2 | Está assistindo |
| 3 | Terminou de assistiu |
| 4 | Parou no meio |

Dessa forma, ao invés de armazenar um valor String propenso a erros de digitação, verificação ortográfica entre outros processos, armazenamos um valor int que apenas precisará ser acrescido ou reduzido de forma simples.
Dentro do objeto *Content*, há funções que realizam a conversão de int para String automaticamente.

**SQL Queries**
Antes mesmo de fazer a conexão com o banco de dados, decidi facilitar o trabalho de executar funções SQL criando o objeto *[SQLQuery](https://github.com/jnbdotdev/Episode-Counter-v2/blob/master/src/main/java/com/jnb/db/SQLQuery.java)*, o qual conta com as principais funções  SQL utilizadas na ferramenta sendo elas:

    createTable;
    insertValue;
    updateValue;
    deleteValue;
    readTable;

As funções que necessitam de entrada de dados como *UPDATE*, utilizam caracteres de String format do java para poderem receber valores depois, por exemplo:

    this.updateValue = "UPDATE " + tableName + " SET name='%s' WHERE cod=%d";
Quando for executar a função fará da seguinte forma:

    String sQuery = String.format(sqlQuery.updateValue(), String name, Inteiro cod);
    statement = connection.createStatement();
    statement.executeUpdate(sQuery);
    
E assim deixamos as funções SQL já predefinidas para quando formos utilizar, além disso tornando a classe reutilizável para ocasiões futuras.

### Conexão com Banco de Dados

A conexão com o Banco de Dados foi feita na classe [DBConnection](https://github.com/jnbdotdev/Episode-Counter-v2/blob/master/src/main/java/com/jnb/db/connection/DBConnection.java) de forma simples utilizando o *DriverManager* da biblioteca *java.sql*. E após a conexão bastou implementar o métodos CRUD (Create, Read, Update e Delete).

## Implementação de Métodos
Agora com os principais objetos criados e com o banco de dados conectado, foi preciso apenas implementar os métodos responsáveis por gerenciar os dados da ferramenta, os métodos CRUD.
Para trazer esses métodos para o usuário de forma segura e isolada, utilizei a *interface* [Control](https://github.com/jnbdotdev/Episode-Counter-v2/blob/master/src/main/java/com/jnb/models/Control.java) que disponibiliza as principais funções abstratas que o usuário irá utilizar, são elas:

    addContent();
    updateContent();
    deleteContent();
    listCatalog();
E por se tratar de funções abstratas que precisam ser implementadas, as mesmas foram desenvolvidas na classe [UserInterface](https://github.com/jnbdotdev/Episode-Counter-v2/blob/master/src/main/java/com/jnb/models/UserInterface.java).

## Conclusão
E assim, resumidamente, podemos dizer que é assim que a ferramenta funciona. Deixando em evidência que esta é apenas a ferramenta, diferentemente da anterior, ela não possui interface gráfica pois seu foco é ser uma remasterização das principais funções da versão anterior.
A versão que contará com interface gráfica, utilizará uma API do Episode Counter que aliás já foi desenvolvida, a [episodecounter-api-v2](https://github.com/jnbdotdev/episodecounter-api-v2) disponível aqui mesmo no GitHub. Sua "interface gráfica" na realidade se trata de uma versão web que utilizará a API e contará com o front-end, é possível conferir no projeto [Episode-Counter-Site](https://github.com/jnbdotdev/Episode-Counter-Site) também disponível aqui  no GitHub.

Agradeço verdadeiramente a todos que leram até aqui, em cada palavra e cada linha de código foram depositados esforço e carinho.
Até uma próxima.

James.
