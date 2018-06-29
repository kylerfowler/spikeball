
/**
 * Write a description of class GameScorer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class GameScore{
        boolean win = false;
        int[] score = new int[2];
        int score1 = 0;
        int score2 = 0;
        String[] gamers;
        String[] gamePlayers;
        int[] playerWins;
        public GameScore(String[] gamers, String[] gamePlayers, int[] playerWins){
            //makes the variables = the inputs 
            this.gamers = gamers;
            this.gamePlayers = gamePlayers;
            this.playerWins = playerWins;
            //creates a scanner to recieve the scores 
            Scanner scorer = new Scanner(System.in);
            //Asks what the score was, revieves the answer, and prints it
            System.out.print("Team 1's score: ");
            score1 = scorer.nextInt();
            System.out.println(score1);
            System.out.print("Team 2's score: ");
            score2 = scorer.nextInt();
            System.out.println(score2);
            if (score1>score2){
                System.out.println("Team 1 wins!");
            }
            else{
                System.out.println("Team 2 wins!");
            }
        }
        public boolean gameWin(){
            if(score1>score2){
                return true;
            }
            else{
                return false;
            }
        }
        public int[] playerWins(){
            //if team1 won then it adds a win to each player
            if(score1>score2){
                for(int i = 0; i<2; i++){
                    playerWins[finder.indexOfString(gamers, gamePlayers[i])]++;
                }
            }
            //if team2 won then it adds a win to each player
            else{
                for(int i = 2; i<4; i++){
                    playerWins[finder.indexOfString(gamers, gamePlayers[i])]++;
                }
            }
            return playerWins;
        }
        public int[] score(){
            int[] score = new int[]{score1, score2};
            return score;
        }
}
