import java.util.Scanner;

public class GameLogic{
  private int points;
  private int MaxPoints;
  private boolean win;
  private String movieName;
  private String rightGuess;
  private String wrongGuess;
  private String allGuess;

  public GameLogic(String movieN){
      this.movieName=movieN;
      points=0;
      MaxPoints=10;
      win=false;
      rightGuess="";
      wrongGuess="";
  }
  public void gamePlay(){
    while(!endCheck()){
      System.out.println("You are guessing:"+getHiddenMovieName() );
      System.out.println("You have guessed ("+wrongGuess.length()/2+") wrong letters:"+wrongGuess);
      
      checkGuess();
     // System.out.println(movieName);
    }
    if(win){
      System.out.println("You Win!");
      System.out.println("You have guessed '"+movieName+"' correctly.");
    }
    else{
      System.out.println("Game over!");
      System.out.println("You could not guess '"+movieName+"' correctly.");
    }
    
  }

  public String getHiddenMovieName(){
    if(rightGuess.equals("")){
      //replace all the characters with underscores
      return movieName.replaceAll("[a-zA-Z]","_");
    }
    else{
      //show right guessed letters in movie name
      return movieName.replaceAll("[a-zA-Z&&[^" + rightGuess + "]]", "_");
    }

  }

  //This function will take a guess
  public String takingGuess(){
    System.out.println("Guess a letter:");
    Scanner scanner=new Scanner(System.in);
    //converting everything to lowercase so don't have to think about cases
    String guess=scanner.nextLine().toLowerCase();

    if(!guess.matches("[a-z]")){
      System.out.println("Check your input, you have to enter a letter");
      return takingGuess();
    }
    else if(rightGuess.contains(guess)||wrongGuess.contains(guess)){
      System.out.println("You already guessed \""+guess+ "\" latter. Try again! ");
      return takingGuess();
    }
    else
      return guess;
  }
  
  public void checkGuess(){
    String guess= takingGuess();

    if(movieName.contains(guess)){
      rightGuess=rightGuess+guess;
    }
    else{
      points++;
      wrongGuess=wrongGuess+" "+guess;
    }
  }

  public boolean endCheck(){
    //Lost 
    if(points>=MaxPoints){
     // win=false;
      return true;
    }
    //win
    else if(!getHiddenMovieName().contains("_")){
      win=true;
      return true;
    }
    //game not ended
    else
      return false;
  }
}