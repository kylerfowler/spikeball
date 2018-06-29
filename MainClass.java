
/**
 * Write a description of class gamePlayer here.
 *
 * @author (Kyle Fowler)
 * @version (v2)
 */
import java.util.Scanner;
public class MainClass{
    public static void main(){
       int counter = 0;
       int numberer = 0;
       int gameCounter = 0;
       int playerTracker = 0;
       int scoreTracker = 0;
       int winTracker = 0;
       boolean valid = true;
       String[] pastGamePlayers = new String[400];
       int pastScores[] = new int[200];
       int[] score = new int[2];
       boolean pastTeamWins[] = new boolean[100];
       boolean teamWin = false;
       String[] bench = new String[]{};
       //Creates scanners for user input
       Scanner playerCountInput = new Scanner(System.in);
       Scanner playerInput = new Scanner(System.in);
       Scanner games = new Scanner(System.in);
       Scanner done = new Scanner(System.in);
       //Asks and records the number of players
       System.out.print("How many players? ");
       int playerCount = playerCountInput.nextInt();
       System.out.println(playerCount);
       //initializes an array to store the players
       String[] gamers = new String[playerCount];
       int[] playerWins = new int[playerCount];
       //Asks and records the player names 
       for(int i=0;i<playerCount;i++){
           System.out.print("Enter player "+(i+1)+": ");
           gamers[i] = playerInput.nextLine();
           System.out.println(gamers[i]);
       }
       String[] gamePlayers = new String[4];
       System.out.println("\nPress \"Enter\" to start a game");
       System.out.println("Type \"Done\" to cancel");
       System.out.println("Type \"Leaderboard\" to see the leaderboard");
       System.out.println("Type \"Help\" to see the key");
       //calls the gamePicker function and then prints the array it provides
       //It also seperates it into teams for the first time
       //repeats the formation of a game and teams until "Done" is typed 
       while(valid){
            boolean doneBool = false;
            boolean leaderboardBool = false;
            boolean helpBool = false;
            String userInput = games.nextLine();
            int counter2 = 0;
            if(userInput.equals("Done")){
                valid = false;
                doneBool = true;
            }
            if(userInput.equals("Leaderboard")){
                Leaderboard leaderboard = new Leaderboard(gamers,playerWins);
                leaderboard.leaderboard();
                leaderboardBool = true;
            }
            if(userInput.equals("Help")){
                System.out.println("\nPress \"Enter\" to start a game");
                System.out.println("Type \"Done\" to cancel");
                System.out.println("Type \"Leaderboard\" to see the leaderboard");
                System.out.println("Type \"Help\" to see the key");
                helpBool = true;
            }
            if(doneBool != true && leaderboardBool != true && helpBool != true){
                GamePick game = new GamePick(gamers,bench,playerWins);
                gamePlayers = game.getGamePlayers();
                for(int r = 0; r<playerWins.length;r++){
                    if(playerWins[r]>0){
                        counter2++;
                    }
                }
                if(counter2>0){
                    gamePlayers = game.fairMatch();
                }
                gameCounter++;
                numberer = 0;
                bench = new String[(playerCount-4)];
                System.out.println("Game "+gameCounter);
                System.out.println("Team1: ");
                for(int e = 0; e<2; e++){
                    System.out.println(gamePlayers[e]);
                } 
                System.out.println("Team2: ");
                for(int i = 2; i<4; i++){
                    System.out.println(gamePlayers[i]);
                }
                GameScore gameScore = new GameScore(gamers, gamePlayers, playerWins);
                playerWins = gameScore.playerWins();
                score = gameScore.score();
                Bench lastBench = new Bench(gamers, gamePlayers);
                bench = lastBench.setBench();
                for(int a=0; a<4; a++){
                    pastGamePlayers[a+playerTracker] = gamePlayers[a]; 
                }
                for(int s=0; s<2;s++){
                    pastScores[s+scoreTracker] = score[s];
                }
                pastTeamWins[winTracker] = gameScore.gameWin();
                winTracker += 1;
                playerTracker+=4;
                scoreTracker+=2;
            }
        }
    }
}
