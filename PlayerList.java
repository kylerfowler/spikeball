
/**
 * Write a description of class Gamers here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class PlayerList{
    int playerCount = 0;
    String[] gamers;
    public PlayerList(){
       Scanner playerCountInput = new Scanner(System.in);
       Scanner playerInput = new Scanner(System.in);
       //Asks and records the number of players
       System.out.print("How many players? ");
       playerCount = playerCountInput.nextInt();
       System.out.println(playerCount);
       
       gamers = new String[playerCount];
       //Asks and records the player names 
       for(int i=0;i<playerCount;i++){
           System.out.print("Enter player "+(i+1)+": ");
           gamers[i] = playerInput.nextLine();
           System.out.println(gamers[i]);
       }
    }
    public String[] getGamers(){
        return gamers;
    }
    public int getPlayerCount(){
        return playerCount;
    }
}