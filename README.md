<h1 width="100%" align="center">
  <center><img src="img/logo.png"/></center>
</h1>
<div class="badges" align="center">
  <img src="https://img.shields.io/static/v1?label=Language&labelColor=FF9C28&message=Java&color=F6F5F2&style=for-the-badge"/>
  <img src="https://img.shields.io/static/v1?label=Status&labelColor=FF9C28&message=Finished&color=F6F5F2&style=for-the-badge&logo=github"/>
  <img src="https://img.shields.io/static/v1?label=Version&labelColor=FF9C28&message=2.0.0&color=F6F5F2&style=for-the-badge&logo=vonage"/>
  <img src="https://img.shields.io/static/v1?label=License&labelColor=FF9C28&message=MIT&color=F6F5F2&style=for-the-badge&logo=perforce"/>
</div>
<br>
<div class="badges" align="left">
  <h3>You're reading in:</h3>
  <a href="https://github.com/jnbdotdev/Episode-Counter-v2/blob/master/README.md" target="_blank"><img src="https://img.shields.io/badge/English-FF9C28?style=for-the-badge"/></a>
  <a href="https://github.com/jnbdotdev/Episode-Counter-v2/blob/master/README-br.md" target="_blank"><img src="https://img.shields.io/badge/PORTUGUESE-FFF?style=for-the-badge"/></a>
</div>
<h2 id="resume">Resume</h2>
<blockquote>
<h3 id="episode-counter-v1">Episode Counter v1</h3>
<p>Episode Counter is a tool created to assist consumers of anime, series, films, books, among others, in their daily lives. It stores information related to the content such as the episode the user stopped at, the type of content, the release date, whether the user is still watching, has already watched or intends to watch, and several other available functions.
It was initially created for personal use, as I did not have access to large streaming platforms that stored the aforementioned information, so I developed my own.</p>
</blockquote>
<p>This is version 2.0 of Episode Counter, which follows the same principles as its first version, however with fundamental changes for the tool to function properly.</p>
<p><strong>Change log:</strong></p>
<ul>
<li><em>Changed attributes:</em>
A forma que a ferramenta armazena as informações foi otimizada, economizando e muito os recursos da máquina e melhorando a eficiência da ferramenta.</li>
<li><em>Pillars of OOP (Object Oriented Programming):</em>
The first version of Episode Counter was created with just 2 months of experience with Java. Now, after a more in-depth study of both <strong>Java</strong> and <strong>Object Oriented Programming</strong>, a more elaborate and professional application could be developed, using principles of <strong>Abstraction</strong>, <strong>Polymorphism</strong> and <strong>Encapsulation</strong> mainly for a more robust program.</li>
<li><em>Database Change:</em>
To keep up with the pace of the job market, Episode Counter now has a connection to the <strong>PostgreSQL</strong> database, which is increasingly growing in the dev environment.</li>
<li><em>Dependency Manager:</em>
In the first version of the tool, we used .jar files to add external libraries, now with <strong>Maven</strong>, this work was minimized exponentially, with just a few lines of code needed to bring the most recent version of the tool&#39;s dependencies.</li>
</ul>
<h2 id="how-it-works">How it Works</h2>
<h3 id="object-creation">Object Creation</h3>
<p><strong>Content</strong>
Inside the Episode Counter we have a main object called <em><a href="https://github.com/jnbdotdev/Episode-Counter-v2/blob/master/src/main/java/com/jnb/models/Content.java">Content</a></em> that has the respective attributes:</p>
<pre><code><span class="hljs-built_in">Integer</span> cod; <span class="hljs-comment">// The unique and immutable code for each content</span>
<span class="hljs-built_in">String</span> name; <span class="hljs-comment">// The name of each content, such as super eleven, cobra kai, etc.</span>
<span class="hljs-built_in">Integer</span> <span class="hljs-keyword">group</span>; <span class="hljs-comment">// The season, saga, volume, etc, where the user left off</span>
<span class="hljs-built_in">Integer</span> unit; <span class="hljs-comment">// The episode, chapter, etc, where the user left off</span>
<span class="hljs-built_in">String</span> platform; <span class="hljs-comment">// The platform on which the user consumes the content</span>
Calendar releaseDay; <span class="hljs-comment">// The content release day</span>
<span class="hljs-built_in">Boolean</span> releasing; <span class="hljs-comment">// Logical data whether the content is being released or not</span>
<span class="hljs-built_in">Integer</span> personalStatus; <span class="hljs-comment">// If the user is watching, intends to watch, etc.</span>
<span class="hljs-built_in">Integer</span> category; <span class="hljs-comment">// The content category, series, anime, etc.</span>
</code></pre><p>Values ​​like <em>group</em>, <em>unit</em>, <em>personalStatus</em> and <em>category</em> may seem confusing because they store their data as integers, but it is actually more versatile when applying custom values ​​to each integer, for example, in personalStatus we have the following table of values:
<br><br>
1 | Plan to watch<br>
2 | Watching<br>
3 | Watched<br>
4 | Dropped<br>
<br>
</p>
<p>This way, instead of storing a String value prone to typing errors, spell checking and other processes, we store an int value that will only need to be added or reduced in a simple way.
Inside the <em>Content</em> object, there are functions that perform the conversion from int to String automatically.</p>
<p><strong>SQL Queries</strong>
Before even connecting to the database, I decided to make the job of executing SQL functions easier by creating the <em><a href="https://github.com/jnbdotdev/Episode-Counter-v2/blob/master/src/main/java/com/jnb/db/SQLQuery.java">SQLQuery</a></em> object, which contains the main SQL functions used in the tool, namely:</p>
<pre><code>createTable<span class="hljs-comment">;</span>
insertValue<span class="hljs-comment">;</span>
updateValue<span class="hljs-comment">;</span>
deleteValue<span class="hljs-comment">;</span>
readTable<span class="hljs-comment">;</span>
</code></pre><p>Functions that require data input, such as <em>UPDATE</em>, use Java String format characters to be able to receive values ​​later, for example:</p>
<pre><code>this.updateValue = "<span class="hljs-keyword">UPDATE</span> <span class="hljs-string">" + tableName + "</span> <span class="hljs-keyword">SET</span> <span class="hljs-keyword">name</span>=<span class="hljs-string">'%s'</span> <span class="hljs-keyword">WHERE</span> cod=%d<span class="hljs-string">";</span>
</code></pre><p>When you execute the function, you will do it as follows:</p>
<pre><code><span class="hljs-keyword">String</span> sQuery = <span class="hljs-keyword">String</span>.format(sqlQuery.updateValue(), <span class="hljs-keyword">String</span> <span class="hljs-keyword">name</span>, Integer cod);
statement = connection.createStatement();
statement.executeUpdate(sQuery);
</code></pre><p>And so we leave the SQL functions already predefined for when we use them, also making the class reusable for future occasions.</p>
<h3 id="connection-to-database">Connection to Database</h3>
<p>The connection to the Database was made in the <a href="https://github.com/jnbdotdev/Episode-Counter-v2/blob/master/src/main/java/com/jnb/db/connection/DBConnection.java">DBConnection</a> class in a simple way using the <em>DriverManager</em> from the <em>java.sql</em> library. And after connecting, all you had to do was implement the CRUD (Create, Read, Update and Delete) methods.</p>
<h2 id="method-implementation">Method Implementation</h2>
<p>Now with the main objects created and the database connected, it was only necessary to implement the methods responsible for managing the tool&#39;s data, the CRUD methods.
To bring these methods to the user in a safe and isolated way, I used the <a href="https://github.com/jnbdotdev/Episode-Counter-v2/blob/master/src/main/java/com/jnb/models/Control.java">Control</a> <em>interface</em> which provides the main abstract functions that the user will use, they are:</p>
<pre><code>addContent()<span class="hljs-comment">;</span>
updateContent()<span class="hljs-comment">;</span>
deleteContent()<span class="hljs-comment">;</span>
listCatalog()<span class="hljs-comment">;</span>
</code></pre><p>And because these are abstract functions that need to be implemented, they were developed in the <a href="https://github.com/jnbdotdev/Episode-Counter-v2/blob/master/src/main/java/com/jnb/models/UserInterface.java">UserInterface</a> class.</p>
<h2 id="conclusion">Conclusion</h2>
<p>And so, in short, we can say that this is how the tool works. Noting that this is just the tool, unlike the previous one, it does not have a graphical interface as its focus is to be a remaster of the main functions of the previous version.
The version that will have a graphical interface will use an Episode Counter API that has already been developed, the <a href="https://github.com/jnbdotdev/episodecounter-api-v2">episodecounter-api-v2</a>, available right here on GitHub. Its &quot;graphical interface&quot; is actually a web version that will use the API and will have the front-end, you can check it out on the <a href="https://github.com/jnbdotdev/Episode-Counter-Site">Episode-Counter-Site</a> project also available here on GitHub.</p>
<p>I truly thank everyone who read this far, effort and care were put into every word and line of code.
Until next time.</p>
<p>James.</p>
