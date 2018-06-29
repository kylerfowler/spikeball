
/**
 * Write a description of class Bench here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bench{
    String[] gamers;
    String[] gamePlayers;
    //makes each variable = the input 
    public Bench(String[] gamers, String[] gamePlayers){
        this.gamers = gamers;
        this.gamePlayers = gamePlayers;
    }
    public String[] setBench(){ 
        int numberer = 0;
        String[] bench = new String[gamers.length-4];
        //for each player not in the game, it adds them to the bench
        for(int j=0;j<gamers.length; j++){
               if (!gamers[j].equals(gamePlayers[0])&&!gamers[j].equals(gamePlayers[1])&&!gamers[j].equals(gamePlayers[2])&&!gamers[j].equals(gamePlayers[3])){   
                    bench[numberer] = gamers[j];
                    numberer++;
               }
        }
        return bench;
    }
}