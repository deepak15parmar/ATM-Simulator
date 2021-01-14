# ATM-Simulator
An ATM Simulation system using Java Swings and MySQL.
# FEATURES :

- SQL ,Java
- Wamp Server MySql used
- Enter cardnumber -> select transaction -> enter pin.
- Email validation using regex
- Most of the fields checked for correct input using regex
- Registration if account does not exist
- Checking of Balance before transaction
- 5 transactions can be performed -> Reset PIN, Withdraw, Deposit, Check Balance, Fast Cast


- NOTE: 
  1. alter table bank modify id INTEGER PRIMARY KEY AUTO_INCREMENT;
  2. conn.java contains JDBC connection part.
  3. first create conn.java followed by login.java, signup.java,signup2.java and so on.
  4. the main class to be executed is login.java
