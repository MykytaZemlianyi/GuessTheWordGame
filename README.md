
# Guess the word

## Hi there! 

I am an enthusiastic student from Kraków.  
I am actively
developing my skills in application development in Java and accompanying technologies.

---

## What is this game about?

#### This is a console game in which you have to try to guess a five letter word in 6 tries.

* At the beginning of the game, the secret word is randomly selected from the database if it has not been used before
* If there are no unused words left, the database will be automatically updated and all words will be available for selection again
>This eliminates randomly selecting the same word over and over again until all words are used
* The correct letters that are in their place are highlighted in green.
* Correct letters that are out of place are highlighted yellow.

---

## Why am I using the console for the UI?

In short, writing UI interface was not the main task of this project, so in order not to overload it and to be able to write it in a short time I decided to focus on the **main task**.

## Best part

#### Main task

My main task was to implement the database and work with queries to make it fun to play.  
PostgreSQL database connection settings are placed in global variables so that they can be easily customized.

```
	private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres";
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "1234";
	private static final String DB_NAME = "\"WordList\".wordlist";
```

---

## Structure 

The structure of the database is very simple and looks like this:
| word  | is_used |
| ------|:-------:|
| apple | false   |
| grape | false   |
| peach | true    |

---

## Special commands

`-help` shows help menu  
`-clear` Clears Database  
`-add` adds words from input separated with spaces into database

