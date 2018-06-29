
/**
 * Creates a leaderboard to display each players wins 
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Leaderboard {
    String[] gamers;
    int[] playerWins;
    //makes the variables in this class equal to the inputs 
    public Leaderboard(String[] gamers, int[] playerWins){
        this.gamers = gamers;
        this.playerWins = playerWins;
    }
    //prints out each players name and then how many wins they have
    public void leaderboard(){
        System.out.println(" ");
        for(int i = 0; i < gamers.length; i++){
            System.out.println(gamers[i]+": "+playerWins[i]+" wins");
        }
    }
}