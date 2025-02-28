import java.util.Scanner;
public class Game {
    Scanner input = new Scanner(System.in);
    private int[] spaces;
    private int playersTurn;
    public static int[] playerStats = new int[] {0, 0};
    
    public Game(){
        int once = 1;
        if(playerStats[0] != 0 || playerStats[1] != 0){
            System.out.println("Current Player Stats:\n" + "Player 1 wins: " + playerStats[0] + "\nPlayer 2 wins: " + playerStats[1] + "\n");
        }
        spaces = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
        playersTurn = 1;
        
        while(true){
            if(once == 1){
                once = 0;
            } else {
                System.out.println();
            }
            System.out.println("Player " + playersTurn + ", it is your turn. \nSelect a space [1-9] to place your token");
            System.out.println(this);
            
            while(true){
                int choice = input.nextInt();
                if(choice > 9 || choice < 1){
                    System.out.println("Sorry! That's not a choice! Try again!");
                } else if(spaces[choice - 1] != 0){
                    System.out.println("Sorry, that space has already been claimed! Try again!");
                } else {
                    spaces[choice - 1] = playersTurn;
                    break;
                }
            }
            if(checkWinner()){
                System.out.println(this);
                System.out.println("Player " + playersTurn + " has won!");
                playerStats[(playersTurn - 1)] += 1;
                break;
            } else if (checkTie()){
                System.out.println("The game has resulted in a tie!");
                break;
            } else {
                if(playersTurn == 1){
                    playersTurn ++;
                } else {
                    playersTurn --;
                }
            }
        }
        
        System.out.println("Would you like to play again? 1 - Yes, 2 - No");
        while(true){
            int choice2 = input.nextInt();
            if(choice2 != 1 && choice2 != 2){
                System.out.println("Not a valid choice! Try again!");
            }
            if(choice2 == 1){
                Game nextGame = new Game();
            }
            if(choice2 == 2){
                break;
            }
        }
    }
    
    public boolean checkWinner(){
        if((spaces[0] == spaces[1] && spaces[0] == spaces[2] && spaces[0] != 0) || 
            (spaces[3] == spaces[4] && spaces[3] == spaces[5] && spaces[3] != 0) ||
            (spaces[6] == spaces[7] && spaces[6] == spaces[8] && spaces[6] != 0) ||
            (spaces[0] == spaces[3] && spaces[0] == spaces[6] && spaces[0] != 0) ||
            (spaces[1] == spaces[4] && spaces[1] == spaces[7] && spaces[1] != 0) ||
            (spaces[2] == spaces[5] && spaces[2] == spaces[8] && spaces[2] != 0) ||
            (spaces[0] == spaces[4] && spaces[0] == spaces[8] && spaces[0] != 0) ||
            (spaces[2] == spaces[4] && spaces[2] == spaces[6] && spaces[2] != 0)){
                return true;
            } else {
                return false;
            }
    }
    
    public boolean checkTie(){
        return (spaces[0] != 0 && spaces[1] != 0 && spaces[2] != 0 && spaces[3] != 0
        && spaces[4] != 0 && spaces[5] != 0 && spaces[6] != 0 && spaces[7] != 0
        && spaces[8] != 0 && !checkWinner());
    }
    
    public String toString(){
        String returnString = "-------------";
        for(int i = 0; i < spaces.length; i ++){
            if(i % 3 == 0){
                returnString += "\n|   |   |   |\n|";
            }
            if(spaces[i] == 1){
                returnString += " X |";
            } else if (spaces[i] == 2){
                returnString += " O |";
            } else {
                returnString += " " + ((i + 1) + "") + " |";
            }
        }
        returnString += "\n|   |   |   |\n-------------";
        return returnString;
    }
}
