# Episode Counter
## Resume
> ### Episode Counter v1
> Episode Counter is a tool created to assist consumers of anime, series, films, books, among others, in their daily lives. It stores information related to the content such as the episode the user stopped at, the type of content, the release date, whether the user is still watching, has already watched or intends to watch, and several other available functions.
It was initially created for personal use, as I did not have access to large streaming platforms that stored the aforementioned information, so I developed my own.

This is version 2.0 of Episode Counter, which follows the same principles as its first version, however with fundamental changes for the tool to function properly.

**Change log:**

 - *Changed attributes:*
A forma que a ferramenta armazena as informações foi otimizada, economizando e muito os recursos da máquina e melhorando a eficiência da ferramenta.
 - *Pillars of OOP (Object Oriented Programming):*
The first version of Episode Counter was created with just 2 months of experience with Java. Now, after a more in-depth study of both **Java** and **Object Oriented Programming**, a more elaborate and professional application could be developed, using principles of **Abstraction**, **Polymorphism** and **Encapsulation** mainly for a more robust program.
 - *Database Change:*
To keep up with the pace of the job market, Episode Counter now has a connection to the **PostgreSQL** database, which is increasingly growing in the dev environment.
 - *Dependency Manager:*
In the first version of the tool, we used .jar files to add external libraries, now with **Maven**, this work was minimized exponentially, with just a few lines of code needed to bring the most recent version of the tool's dependencies.

## How it Works
### Object Creation
**Content**
Inside the Episode Counter we have a main object called *[Content](https://github.com/jnbdotdev/Episode-Counter-v2/blob/master/src/main/java/com/jnb/models/Content.java)* that has the respective attributes:

    Integer cod; // The unique and immutable code for each content
    String name; // The name of each content, such as super eleven, cobra kai, etc.
    Integer group; // The season, saga, volume, etc, where the user left off
    Integer unit; // The episode, chapter, etc, where the user left off
    String platform; // The platform on which the user consumes the content
    Calendar releaseDay; // The content release day
    Boolean releasing; // Logical data whether the content is being released or not
    Integer personalStatus; // If the user is watching, intends to watch, etc.
    Integer category; // The content category, series, anime, etc.

Values ​​like *group*, *unit*, *personalStatus* and *category* may seem confusing because they store their data as integers, but it is actually more versatile when applying custom values ​​to each integer, for example, in personalStatus we have the following table of values:
|int| valor |
|--|--|
| 1 | Plan to watch |
| 2 | Watching |
| 3 | Watched |
| 4 | Dropped |

This way, instead of storing a String value prone to typing errors, spell checking and other processes, we store an int value that will only need to be added or reduced in a simple way.
Inside the *Content* object, there are functions that perform the conversion from int to String automatically.

**SQL Queries**
Before even connecting to the database, I decided to make the job of executing SQL functions easier by creating the *[SQLQuery](https://github.com/jnbdotdev/Episode-Counter-v2/blob/master/src/main/java/com/jnb/db/SQLQuery.java)* object, which contains the main SQL functions used in the tool, namely:

    createTable;
    insertValue;
    updateValue;
    deleteValue;
    readTable;

Functions that require data input, such as *UPDATE*, use Java String format characters to be able to receive values ​​later, for example:

    this.updateValue = "UPDATE " + tableName + " SET name='%s' WHERE cod=%d";

When you execute the function, you will do it as follows:

    String sQuery = String.format(sqlQuery.updateValue(), String name, Integer cod);
    statement = connection.createStatement();
    statement.executeUpdate(sQuery);
    
And so we leave the SQL functions already predefined for when we use them, also making the class reusable for future occasions.

### Connection to Database

The connection to the Database was made in the [DBConnection](https://github.com/jnbdotdev/Episode-Counter-v2/blob/master/src/main/java/com/jnb/db/connection/DBConnection.java) class in a simple way using the *DriverManager* from the *java.sql* library. And after connecting, all you had to do was implement the CRUD (Create, Read, Update and Delete) methods.

## Method Implementation
Now with the main objects created and the database connected, it was only necessary to implement the methods responsible for managing the tool's data, the CRUD methods.
To bring these methods to the user in a safe and isolated way, I used the [Control](https://github.com/jnbdotdev/Episode-Counter-v2/blob/master/src/main/java/com/jnb/models/Control.java) *interface* which provides the main abstract functions that the user will use, they are:

    addContent();
    updateContent();
    deleteContent();
    listCatalog();
And because these are abstract functions that need to be implemented, they were developed in the [UserInterface](https://github.com/jnbdotdev/Episode-Counter-v2/blob/master/src/main/java/com/jnb/models/UserInterface.java) class.

## Conclusion
And so, in short, we can say that this is how the tool works. Noting that this is just the tool, unlike the previous one, it does not have a graphical interface as its focus is to be a remaster of the main functions of the previous version.
The version that will have a graphical interface will use an Episode Counter API that has already been developed, the [episodecounter-api-v2](https://github.com/jnbdotdev/episodecounter-api-v2), available right here on GitHub. Its "graphical interface" is actually a web version that will use the API and will have the front-end, you can check it out on the [Episode-Counter-Site](https://github.com/jnbdotdev/Episode-Counter-Site) project also available here on GitHub.


I truly thank everyone who read this far, effort and care were put into every word and line of code.
Until next time.

James.
