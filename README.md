# osys

See javadoc on this link [Javadoc](http://wishyouhappy.github.io/osys/doc/index.html)

#### 1. BlackJack

#####Note
- After initialize 2 cards to each player, we should first check if blackjack exists, if exists, game over
- Before the score reaches the soft hit, a player should keep adding card
- Final winner should be the player who is not busted and has the highest score.

##### TEST
-Initialize number of players 

-run test.java

<pre>
-----------Initialize------------
Player 0 15 K Spade 4 Diamond 
Player 1 16 6 club 8 heart 
Player 2 16 5 Diamond K heart 
Player 3 18 7 club Q club 
Player 4 14 A Diamond 2 Diamond 
---------------------------------
Game over!
Player 0 21 K Spade 4 Diamond 5 heart 
Player 1 26 6 club 8 heart 9 Diamond 
Player 2 26 5 Diamond K heart J Diamond 
Player 3 18 7 club Q club 
Player 4 24 A Diamond 2 Diamond A Spade 8 club 9 heart 
---------------------------------
Winners: Player 0 
</pre>

#### 2. Call Center

#####Note
- Call Dispatcher is good to designed as singleton class
- A thread for each employee to handle call
- When dispatch call, dispatch from lower level to higher level
- For employee, handle from the high level to low level he could handle
- An employee need to pick up a call from queue if the queue is not empty when finishes the current call.

##### TEST
- Create call instances
- run test.java

<pre>
Call A is dispatched to Fresher 0
Call A is being handling
Call B is dispatched to Fresher 1
Call B is being handling
Call C is dispatched to Fresher 2
Call C is being handling
Call D is dispatched to Fresher 3
Call D is being handling
Call E is dispatched to Fresher 4
Call E is being handling
Call F is dispatched to TechnicalLeader 0
Call F is being handling
Call G is dispatched to TechnicalLeader 1
Call G is being handling
Call H is dispatched to Manager 0
Call H is being handling
Service is busy now, Call I is put into queue,  please wait.. Thanks
Service is busy now, Call J is put into queue,  please wait.. Thanks
Service is busy now, Call K is put into queue,  please wait.. Thanks
Service is busy now, Call L is put into queue,  please wait.. Thanks
Call A is hung up
Call G is hung up
Call B is hung up
Call K is being handling
Call C is hung up
Call F is hung up
Call D is hung up
Call H is hung up
Call E is hung up
Call L is being handling
Call I is being handling
Call J is being handling
Call K is hung up
Call L is hung up
Call I is hung up
Call J is hung up
</pre>


	




