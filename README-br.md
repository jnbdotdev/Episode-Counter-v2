<h1 width="100%" align="center">
  <center><img src="img/logo.png"/></center>
</h1>
<div class="badges" align="center">
  <img src="https://img.shields.io/static/v1?label=Language&labelColor=FF9C28&message=Java&color=F6F5F2&style=for-the-badge&logo=visualstudiocode"/>
  <img src="https://img.shields.io/static/v1?label=Status&labelColor=FF9C28&message=Finished&color=F6F5F2&style=for-the-badge&logo=github"/>
  <img src="https://img.shields.io/static/v1?label=Version&labelColor=FF9C28&message=2.0.0&color=F6F5F2&style=for-the-badge&logo=vonage"/>
  <img src="https://img.shields.io/static/v1?label=License&labelColor=FF9C28&message=MIT&color=F6F5F2&style=for-the-badge&logo=perforce"/>
</div>
<br>
<div class="badges" align="left">
  <h3>You're reading in:</h3>
  <a href="https://github.com/jnbdotdev/Episode-Counter-v2/blob/master/README-br.md" target="_blank"><img src="https://img.shields.io/badge/PORTUGUESE-FF9C28?style=for-the-badge"/></a>
  <a href="https://github.com/jnbdotdev/Episode-Counter-v2/blob/master/README.md" target="_blank"><img src="https://img.shields.io/badge/English-FFF?style=for-the-badge"/></a>
</div>
<h2 id="resumo">Resumo</h2>
<blockquote>
<h3 id="episode-counter-v1">Episode Counter v1</h3>
<p>Episode Counter é uma ferramenta criada para auxiliar no dia a dia de consumidores de animes, séries, filmes, livros, entre outros. Ela armazena informações relacionadas ao conteúdo como o episódio no qual o usuário parou, qual o tipo do conteúdo, o dia de lançamento, se o usuário ainda está assistindo, já assistiu ou pretende assistir, e diversas outras funções disponíveis.
Foi criado inicialmente para uso pessoal, pois eu não tinha acesso a grandes plataformas de streaming que armazenavam as informações citadas, portanto, desenvolvi a minha própria.</p>
</blockquote>
<p>Esta é a  versão 2.0 do Episode Counter, que segue os mesmos princípios da sua primeira versão, entretanto com mudanças fundamentais para o bom funcionamento da ferramenta.</p>
<p><strong>Principais mudanças:</strong></p>
<ul>
<li><em>Mudança de atributos:</em>
A forma que a ferramenta armazena as informações foi otimizada, economizando e muito os recursos da máquina e melhorando a eficiência da ferramenta.</li>
<li><em>Pilares da POO (Programação Orientada a Objetos):</em>
A primeira versão do Episode Counter foi criada com apenas 2 meses de experiência com Java. Agora após um estudo mais aprofundado tanto de <strong>Java</strong> quanto de <strong>Programação Orientada a Objetos</strong>, uma aplicação mais trabalhada e profissional pôde ser desenvolvida, utilizando princípios de <strong>Abstração</strong>, <strong>Polimorfismo</strong> e <strong>Encapsulamento</strong> principalmente para um programa mais robusto.</li>
<li><em>Mudança no Banco de Dados:</em>
Para seguir o ritmo do mercado de trabalho, agora o Episode Counter conta com conexão ao banco de dados <strong>PostgreSQL</strong> que se mostra cada vez maior no ambiente dev.</li>
<li><em>Gerenciador de Dependências:</em>
Na primeira versão da ferramenta, utilizávamos arquivos .jar para adicionar bibliotecas externas, agora com o <strong>Maven</strong>, este trabalho foi minimizado exponencialmente, bastando apenas algumas linhas de código para trazer a versão mais recente das dependências da ferramenta.</li>
</ul>
<h2 id="funcionamento">Funcionamento</h2>
<h3 id="cria-o-de-objetos">Criação de Objetos</h3>
<p><strong>Content</strong>
Dentro do Episode Counter temos um objeto principal chamado <em><a href="https://github.com/jnbdotdev/Episode-Counter-v2/blob/master/src/main/java/com/jnb/models/Content.java">Content</a></em> que possui os respectivos atributos:</p>
<pre><code>Inteiro cod; <span class="hljs-comment">// O código único e imutável de cada conteúdo</span>
<span class="hljs-keyword">String</span> <span class="hljs-keyword">name</span>; <span class="hljs-comment">// O nome de cada conteúdo, como super onze, cobra kai, etc</span>
Inteiro group; <span class="hljs-comment">// A temporada, saga, volume, etc, onde o usuário parou</span>
Inteiro <span class="hljs-keyword">unit</span>; <span class="hljs-comment">// A episódio, capítulo, etc, onde o usuário parou</span>
<span class="hljs-keyword">String</span> <span class="hljs-keyword">platform</span>; <span class="hljs-comment">// A plataforma na qual o usuário consome o conteúdo</span>
Calendar releaseDay; <span class="hljs-comment">// O dia de lançamento do conteúdo</span>
Booleano releasing; <span class="hljs-comment">// Dado lógico se o conteúdo está sendo lançado ou não</span>
Inteiro personalStatus; <span class="hljs-comment">// Se o usuário está assistindo, pretende assistir, etc</span>
Inteiro category; <span class="hljs-comment">// A categoria do conteúdo, serié, anime, etc</span>
</code></pre><p>Valores como <em>group</em>, <em>unit</em>, <em>personalStatus</em> e <em>category</em> podem parecer confusos por armazenarem seus dados como inteiros, mas na verdade é mais versátil quando se aplica valores personalizados para cada número inteiro, como por exemplo, em personalStatus temos a seguinte tabela de valores:
<br>
1 | Pretende Assistir
2 | Está assistindo
3 | Terminou de assistiu
4 | Parou no meio
<br>
</p>
<p>Dessa forma, ao invés de armazenar um valor String propenso a erros de digitação, verificação ortográfica entre outros processos, armazenamos um valor int que apenas precisará ser acrescido ou reduzido de forma simples.
Dentro do objeto <em>Content</em>, há funções que realizam a conversão de int para String automaticamente.</p>
<p><strong>SQL Queries</strong>
Antes mesmo de fazer a conexão com o banco de dados, decidi facilitar o trabalho de executar funções SQL criando o objeto <em><a href="https://github.com/jnbdotdev/Episode-Counter-v2/blob/master/src/main/java/com/jnb/db/SQLQuery.java">SQLQuery</a></em>, o qual conta com as principais funções  SQL utilizadas na ferramenta sendo elas:</p>
<pre><code>createTable<span class="hljs-comment">;</span>
insertValue<span class="hljs-comment">;</span>
updateValue<span class="hljs-comment">;</span>
deleteValue<span class="hljs-comment">;</span>
readTable<span class="hljs-comment">;</span>
</code></pre><p>As funções que necessitam de entrada de dados como <em>UPDATE</em>, utilizam caracteres de String format do java para poderem receber valores depois, por exemplo:</p>
<pre><code>this.updateValue = "<span class="hljs-keyword">UPDATE</span> <span class="hljs-string">" + tableName + "</span> <span class="hljs-keyword">SET</span> <span class="hljs-keyword">name</span>=<span class="hljs-string">'%s'</span> <span class="hljs-keyword">WHERE</span> cod=%d<span class="hljs-string">";</span>
</code></pre><p>Quando for executar a função fará da seguinte forma:</p>
<pre><code><span class="hljs-keyword">String</span> sQuery = <span class="hljs-keyword">String</span>.format(sqlQuery.updateValue(), <span class="hljs-keyword">String</span> <span class="hljs-keyword">name</span>, Inteiro cod);
statement = connection.createStatement();
statement.executeUpdate(sQuery);
</code></pre><p>E assim deixamos as funções SQL já predefinidas para quando formos utilizar, além disso tornando a classe reutilizável para ocasiões futuras.</p>
<h3 id="conex-o-com-banco-de-dados">Conexão com Banco de Dados</h3>
<p>A conexão com o Banco de Dados foi feita na classe <a href="https://github.com/jnbdotdev/Episode-Counter-v2/blob/master/src/main/java/com/jnb/db/connection/DBConnection.java">DBConnection</a> de forma simples utilizando o <em>DriverManager</em> da biblioteca <em>java.sql</em>. E após a conexão bastou implementar o métodos CRUD (Create, Read, Update e Delete).</p>
<h2 id="implementa-o-de-m-todos">Implementação de Métodos</h2>
<p>Agora com os principais objetos criados e com o banco de dados conectado, foi preciso apenas implementar os métodos responsáveis por gerenciar os dados da ferramenta, os métodos CRUD.
Para trazer esses métodos para o usuário de forma segura e isolada, utilizei a <em>interface</em> <a href="https://github.com/jnbdotdev/Episode-Counter-v2/blob/master/src/main/java/com/jnb/models/Control.java">Control</a> que disponibiliza as principais funções abstratas que o usuário irá utilizar, são elas:</p>
<pre><code>addContent()<span class="hljs-comment">;</span>
updateContent()<span class="hljs-comment">;</span>
deleteContent()<span class="hljs-comment">;</span>
listCatalog()<span class="hljs-comment">;</span>
</code></pre><p>E por se tratar de funções abstratas que precisam ser implementadas, as mesmas foram desenvolvidas na classe <a href="https://github.com/jnbdotdev/Episode-Counter-v2/blob/master/src/main/java/com/jnb/models/UserInterface.java">UserInterface</a>.</p>
<h2 id="conclus-o">Conclusão</h2>
<p>E assim, resumidamente, podemos dizer que é assim que a ferramenta funciona. Deixando em evidência que esta é apenas a ferramenta, diferentemente da anterior, ela não possui interface gráfica pois seu foco é ser uma remasterização das principais funções da versão anterior.
A versão que contará com interface gráfica, utilizará uma API do Episode Counter que aliás já foi desenvolvida, a <a href="https://github.com/jnbdotdev/episodecounter-api-v2">episodecounter-api-v2</a> disponível aqui mesmo no GitHub. Sua &quot;interface gráfica&quot; na realidade se trata de uma versão web que utilizará a API e contará com o front-end, é possível conferir no projeto <a href="https://github.com/jnbdotdev/Episode-Counter-Site">Episode-Counter-Site</a> também disponível aqui  no GitHub.</p>
<p>Agradeço verdadeiramente a todos que leram até aqui, em cada palavra e cada linha de código foram depositados esforço e carinho.
Até uma próxima.</p>
<p>James.</p>

