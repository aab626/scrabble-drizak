# Scrabble

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

Interactive graphic programming language heavily inspired by 
[Scratch](https://scratch.mit.edu).
This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/), 
and aims purely to be used with the purpose of teaching in the context of the course 
_CC3002 Metodologías de Diseño y programación_ of the 
[_Computer Sciences Department (DCC)_](https://www.dcc.uchile.cl) of the 
_University of Chile_.

---

## CC3002 - Scrabble
Inside `src` folder there are 2 folders:

* `main` stores the logic of the program.
* `test` stores the JUnit5 tests classes.

### Building and Testing
Build with `gradle build`, and test with `gradle test`.


### Implementation details
* Binary types `SBinary` can be arithmetically operated with Float types `SFloat`,
  but as the decimal part of Float type will carry on to the output, the output
  type will be a `SFloat` too.
  
* `BinaryUtils.toInt` can only transform strings accurately into integers when  
  they hold less than 32 bits of data (or 32 characters).
  
* The package `cl.uchile.dcc.scrabble.utils` store utility (helper) classes, to avoid
  code cluttering inside others. ie: `BinaryUtils` stores some code related
  to binary numbers, in particular to avoid cluttering the `SBinary` class. 
  All classes in this package are well documented, and their purpose should be clear.  