# Work Report
# Tic-Tac-Toe-2.0

## Name: <ins> Yi Zhuang </ins>

## Features:
<pre>
- Implemented:
  - Allows 3-10 players 
  - Check for out-of-bounds and taken positions 
  - Check for the repeated names of players
  - Allow user to determine how many in a row determines a winner 
  - Announces a winner if there is so, else announces a Tie when the whole table has been filled out
  
  
<br><br>

- Not Implemented:
  - Change of colors for each player 
  - Size and different types of font for each user or announcing a Winner or a Tie
<br><br>
</pre>
# **Test Output**
<pre>
Please enter number of players (min: 3, max: 10): 3

Please enter piece of player 1: a
Please enter piece of player 2: b
Please enter piece of player 3: c

How many pieces in a row determines a winner (min: 3, max: 4): 3
   | 0 | 1 | 2 | 3 
——  ——  ——  ——  ——  
 0 |   |   |   |           =============================== 
——  ——  ——  ——  ——  
 1 |   |   |   |             REMINDER: 3 in a row to win  
——  ——  ——  ——  ——  
 2 |   |   |   |           =============================== 
——  ——  ——  ——  ——  
 3 |   |   |   |   

Player "a" please enter row and column position: 0 0 

   | 0 | 1 | 2 | 3 
——  ——  ——  ——  ——  
 0 | a |   |   |           =============================== 
——  ——  ——  ——  ——  
 1 |   |   |   |             REMINDER: 3 in a row to win  
——  ——  ——  ——  ——  
 2 |   |   |   |           =============================== 
——  ——  ——  ——  ——  
 3 |   |   |   |   

Player "b" please enter row and column position: 1 1 

   | 0 | 1 | 2 | 3 
——  ——  ——  ——  ——  
 0 | a |   |   |           =============================== 
——  ——  ——  ——  ——  
 1 |   | b |   |             REMINDER: 3 in a row to win  
——  ——  ——  ——  ——  
 2 |   |   |   |           =============================== 
——  ——  ——  ——  ——  
 3 |   |   |   |   

Player "c" please enter row and column position: 3 3 

   | 0 | 1 | 2 | 3 
——  ——  ——  ——  ——  
 0 | a |   |   |           =============================== 
——  ——  ——  ——  ——  
 1 |   | b |   |             REMINDER: 3 in a row to win  
——  ——  ——  ——  ——  
 2 |   |   |   |           =============================== 
——  ——  ——  ——  ——  
 3 |   |   |   | c 

Player "a" please enter row and column position: 5 5 

Not valid move: Out of Bounds.
   | 0 | 1 | 2 | 3 
——  ——  ——  ——  ——  
 0 | a |   |   |           =============================== 
——  ——  ——  ——  ——  
 1 |   | b |   |             REMINDER: 3 in a row to win  
——  ——  ——  ——  ——  
 2 |   |   |   |           =============================== 
——  ——  ——  ——  ——  
 3 |   |   |   | c 

Player "a" please enter row and column position: 0 1

   | 0 | 1 | 2 | 3 
——  ——  ——  ——  ——  
 0 | a | a |   |           =============================== 
——  ——  ——  ——  ——  
 1 |   | b |   |             REMINDER: 3 in a row to win  
——  ——  ——  ——  ——  
 2 |   |   |   |           =============================== 
——  ——  ——  ——  ——  
 3 |   |   |   | c 

Player "b" please enter row and column position: 0 2

   | 0 | 1 | 2 | 3 
——  ——  ——  ——  ——  
 0 | a | a | b |           =============================== 
——  ——  ——  ——  ——  
 1 |   | b |   |             REMINDER: 3 in a row to win  
——  ——  ——  ——  ——  
 2 |   |   |   |           =============================== 
——  ——  ——  ——  ——  
 3 |   |   |   | c 

Player "c" please enter row and column position: 2 0 

   | 0 | 1 | 2 | 3 
——  ——  ——  ——  ——  
 0 | a | a | b |           =============================== 
——  ——  ——  ——  ——  
 1 |   | b |   |             REMINDER: 3 in a row to win  
——  ——  ——  ——  ——  
 2 | c |   |   |           =============================== 
——  ——  ——  ——  ——  
 3 |   |   |   | c 

Player "a" please enter row and column position: 1 2

   | 0 | 1 | 2 | 3 
——  ——  ——  ——  ——  
 0 | a | a | b |           =============================== 
——  ——  ——  ——  ——  
 1 |   | b | a |             REMINDER: 3 in a row to win  
——  ——  ——  ——  ——  
 2 | c |   |   |           =============================== 
——  ——  ——  ——  ——  
 3 |   |   |   | c 

Player "b" please enter row and column position: 2 3

   | 0 | 1 | 2 | 3 
——  ——  ——  ——  ——  
 0 | a | a | b |           =============================== 
——  ——  ——  ——  ——  
 1 |   | b | a |             REMINDER: 3 in a row to win  
——  ——  ——  ——  ——  
 2 | c |   |   | b         =============================== 
——  ——  ——  ——  ——  
 3 |   |   |   | c 

Player "c" please enter row and column position: 3 2

   | 0 | 1 | 2 | 3 
——  ——  ——  ——  ——  
 0 | a | a | b |           =============================== 
——  ——  ——  ——  ——  
 1 |   | b | a |             REMINDER: 3 in a row to win  
——  ——  ——  ——  ——  
 2 | c |   |   | b         =============================== 
——  ——  ——  ——  ——  
 3 |   |   | c | c 

Player "a" please enter row and column position: 3 1

   | 0 | 1 | 2 | 3 
——  ——  ——  ——  ——  
 0 | a | a | b |           =============================== 
——  ——  ——  ——  ——  
 1 |   | b | a |             REMINDER: 3 in a row to win  
——  ——  ——  ——  ——  
 2 | c |   |   | b         =============================== 
——  ——  ——  ——  ——  
 3 |   | a | c | c 

Player "b" please enter row and column position: 2 1

   | 0 | 1 | 2 | 3 
——  ——  ——  ——  ——  
 0 | a | a | b |           =============================== 
——  ——  ——  ——  ——  
 1 |   | b | a |             REMINDER: 3 in a row to win  
——  ——  ——  ——  ——  
 2 | c | b |   | b         =============================== 
——  ——  ——  ——  ——  
 3 |   | a | c | c 

Player "c" please enter row and column position: 1 0 

   | 0 | 1 | 2 | 3 
——  ——  ——  ——  ——  
 0 | a | a | b |           =============================== 
——  ——  ——  ——  ——  
 1 | c | b | a |             REMINDER: 3 in a row to win  
——  ——  ——  ——  ——  
 2 | c | b |   | b         =============================== 
——  ——  ——  ——  ——  
 3 |   | a | c | c 

Player "a" please enter row and column position: 1 0 

Not valid move: Position already taken. 
   | 0 | 1 | 2 | 3 
——  ——  ——  ——  ——  
 0 | a | a | b |           =============================== 
——  ——  ——  ——  ——  
 1 | c | b | a |             REMINDER: 3 in a row to win  
——  ——  ——  ——  ——  
 2 | c | b |   | b         =============================== 
——  ——  ——  ——  ——  
 3 |   | a | c | c 

Player "a" please enter row and column position: 3 0 

   | 0 | 1 | 2 | 3 
——  ——  ——  ——  ——  
 0 | a | a | b |           =============================== 
——  ——  ——  ——  ——  
 1 | c | b | a |             REMINDER: 3 in a row to win  
——  ——  ——  ——  ——  
 2 | c | b |   | b         =============================== 
——  ——  ——  ——  ——  
 3 | a | a | c | c 

Player "b" please enter row and column position: 2 2

   | 0 | 1 | 2 | 3 
——  ——  ——  ——  ——  
 0 | a | a | b |           =============================== 
——  ——  ——  ——  ——  
 1 | c | b | a |             REMINDER: 3 in a row to win  
——  ——  ——  ——  ——  
 2 | c | b | b | b         =============================== 
——  ——  ——  ——  ——  
 3 | a | a | c | c 

       ======================================================
                         "b" is the WINNER
       ======================================================
 </pre>
