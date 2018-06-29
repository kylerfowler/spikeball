
/**
 * Write a description of class Test1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Random;
public class GamePick{
   String[] gamers;
   String[] lastGameBench;
   int[] playerWins;
   int counter = -1;
   int numberer = -1;
   String[] gamePlayers;
   String[] gameBench;
   String[] numberKeeperLength;
   int[] numberKeeper;
   int[] reverse;
   public GamePick(String[] gamers,String[] lastGameBench, int[] playerWins){
       this.gamers = gamers;
       this.lastGameBench = lastGameBench;
       this.playerWins = playerWins;
       numberKeeperLength = new String[lastGameBench.length];
       gameBench = new String[gamers.length-1];
       //creates a group of 4 people to play in the game
       //sets each player to a random number and loops until the number hasnt been used by another
       Random rand = new Random();
       int player1 = rand.nextInt(gamers.length);
       int player2 = rand.nextInt(gamers.length);
       while(player2 == player1){
           player2 = rand.nextInt(gamers.length);
       }
       int player3 = rand.nextInt(gamers.length);
       while(player3 == player1||player3 == player2){
           player3 = rand.nextInt(gamers.length);
       }
       int player4 = rand.nextInt(gamers.length);
       while(player4 == player1||player4 == player2||player4 == player3){
           player4 = rand.nextInt(gamers.length);
       }
       gamePlayers = new String[]{gamers[player1],
                                  gamers[player2],
                                  gamers[player3],
                                  gamers[player4]};
       //Checks if the players who didn't play in the last round are playing
       //this round, if not, it subs them in
       //adds each bench player who is not in gamePlayers to an array
       for(int j=0;j<lastGameBench.length; j++){
           if (lastGameBench[j].equals(gamePlayers[0])||lastGameBench[j].equals(gamePlayers[1])||lastGameBench[j].equals(gamePlayers[2])||lastGameBench[j].equals(gamePlayers[3])){   
           }
           else{ 
               numberKeeperLength[j] = lastGameBench[j];
           }    
       }  
       numberKeeper = new int[lastGameBench.length];
       reverse = new int[lastGameBench.length];
       //creates an array that starts a the length of the bench and goes to 0
       for(int q = reverse.length-1; q>-1; q--){
           reverse[q] = q;
       }
       for(int c = 0; c<lastGameBench.length; c++){
           numberKeeper[c] = rand.nextInt(4);
           //it goes through and replaces numbers in c if it equals another 
           //I dont know why this works but it does 
           for(int o = 0; o<reverse.length; o++){
               if(c-reverse[o]<-1){
                   while(numberKeeper[c]==numberKeeper[c-reverse[o]]){
                       numberKeeper[c] = rand.nextInt(4);
                   }
               }
           }
           //inserts the new players into the game
           if(numberKeeperLength[c]!=null){
               gamePlayers[numberKeeper[c]] = lastGameBench[c];
           }
       }
   }
   public String[] getGamePlayers(){
       return gamePlayers;
    }
   public String[] fairMatch(){
       int maxWins = -1;
       int minWins = 1000000000;
       String prevBestPlayer = (" ");
       String bestPlayer = (" ");
       String worstPlayer = (" ");
       String mehPlayer1 = (" ");
       String mehPlayer2 = (" ");
       int counter2 = 0;
       String[] tempGamePlayers = gamePlayers;
       //possible to make more fair later if I want by adding random chance
       for(int i = 0; i<gamers.length; i++){
           if((finder.indexOfString(tempGamePlayers, gamers[i])!=-1)){
               /*if the player is in the game and has the most wins so far
               they become the bestPlayer*/
               if(playerWins[i]>maxWins){
                   prevBestPlayer = bestPlayer;
                   bestPlayer = gamers[i];
                   //maxWins is now = to the wins of the bestPlayer
                   maxWins = playerWins[i];
               }
               else{
                   /*if the player is in the game and has the least wins so far
                   they become the worstPlayer*/
                   if(playerWins[i]<minWins){
                       worstPlayer = gamers[i];
                       //minWins = the wins of the worstPlayer
                       minWins = playerWins[i];
                   }
                   //this makes it so the first player can still be the worst player
                   if(!prevBestPlayer.equals(" ")&&playerWins[finder.indexOfString(gamers, prevBestPlayer)]<minWins){
                       worstPlayer = prevBestPlayer;
                       minWins = playerWins[finder.indexOfString(gamers, prevBestPlayer)];
                   }
               }
           }
       }
       //makes for the mehPlayers = to the two other players 
       for(int i = 0; i<tempGamePlayers.length; i++){
           if(!tempGamePlayers[i].equals(bestPlayer)&&!tempGamePlayers[i].equals(worstPlayer)){
               if(mehPlayer1.equals(" ")){
                   mehPlayer1 = tempGamePlayers[i];
               }
               else{
                   mehPlayer2 = tempGamePlayers[i];
               }
           }
       }
       gamePlayers = new String[]{bestPlayer,
                                  worstPlayer,
                                  mehPlayer1,
                                  mehPlayer2};
       return gamePlayers;                                    
   }
}
