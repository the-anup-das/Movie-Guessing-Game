import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
class Main {
  public static void main(String[] args) throws Exception {

    //opeing movie names file
    File file= new File("movies.txt");
    ArrayList<String> MovieNames=new ArrayList();

    try{
        Scanner fileScanner= new Scanner(file);
        while(fileScanner.hasNextLine()){
          MovieNames.add(fileScanner.nextLine());
          
        }
        fileScanner.close();
        //picking an random movie
        int randomNumber= (int) (Math.random()*MovieNames.size());
        String MovieName=MovieNames.get(randomNumber).toLowerCase();
        //System.out.println("Movie Name:"+ MovieName);
        GameLogic obj=new GameLogic(MovieName);
        obj.gamePlay();
    }
    catch (FileNotFoundException exception) {
       System.out.println(exception);
    }
    catch (Exception exception) {
            System.out.println(exception);
        }

       
    

  }
  
}
/*public class Output{
  void printing(int points,String str){
        System.out.println("You are guessing:"+ str);
        System.out.println("You have guessed ("+points+") wrong letters:");
        System.out.println("Guess a letter :");
      }
  String changeValues(String movieNames){
    int i=movieNames.length();
    
    
  }
}*/