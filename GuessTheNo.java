
import java.util.*;
public class GuessTheNo {
    public static void main(String[] args){
        Game ob=new Game();
        System.out.println("A Number Is Chosen Between 1 to 100");
        System.out.println("You have only 5 chance to guess the number");
        //Number of tries;
        int k=5;
        
        int  user_no=ob.takeauserInput();
       
       
        while(ob.r!=user_no && k>1){
          
           
           if(ob.r<user_no){
               System.out.println("Number is too larger");
               System.out.println("You have "+(k-1)+" tries left");
           }
           else{
           System.out.println("Number is too smaller");
           System.out.println("You have "+(k-1)+" tries left");
           }
           System.out.println("Try Again!!!!!!!\n");
           k--;
           user_no= ob.takeauserInput();
           ob.setGuess();
           
           
       }

      boolean correct= ob.isCorrect(user_no);
      if(correct){
        System.out.println("Your Answer  is correct in "+ob.getGuess()+" Guess");
      }else{
        System.out.println("You ran out of tries.\n You lose!!!!!!!");
          }   
    System.out.println("\n-------------------**********------------------");
   }
}
//Game is guess the number
class Game{
    int r;//random number
    int input;
    int gno=1;
    Scanner sc = new Scanner(System.in);
   

//constructor to generate random number between 1 to 100
public Game(){
        Random rnd =new Random();
        r=rnd.nextInt(1,100);
        
        System.out.println("-------------------**********------------------");
        System.out.println("           <<<< GUESS THE NUMBER >>>>\n");
    }


//method to take input from user
public int takeauserInput(){

    //take a input between 1 to 100;
   
    System.out.println("Enter the number");
    int input=sc.nextInt();
    return input;
}

//check correct number
public boolean isCorrect(int user_no){
    
    if(user_no==r){
        System.out.println("Your guess is correct!!!");
        return true;
    }
    return false;
    
}

//for counting the of tries
public void  setGuess(){
         gno++;
    }
public int  getGuess(){
       return  gno;
   }

} 
//END OF PROGRAM