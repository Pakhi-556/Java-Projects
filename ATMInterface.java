import java.util.*;

public class ATMInterface {

    static Scanner sc=new Scanner(System.in);
    static HashMap<String ,Integer> userBalance= new HashMap<>();
    static HashMap<String ,Integer> userPassword= new HashMap<>();

    static ArrayList<String> historyArray =new ArrayList<>();//for showing history

    //Assume that some account are already created;
    public static void defaultUserName(){
    userBalance.put("prerna",10000);
    userBalance.put("nitya",50000);
    userBalance.put("aman",100000);
    userBalance.put("pakhi",1000000);


    userPassword.put("prerna",1432);
    userPassword.put("nitya",1202);
    userPassword.put("aman",3290);
    userPassword.put("pakhi",7654);
}

//function for withdrawing money
public static void withdrawMoney(String username){
    System.out.println("Enter the amount  you want to withdram:");
    int amount=sc.nextInt();
  
    if(userBalance.get(username) > amount){
        int newbalance=userBalance.get(username)-amount;
        userBalance.replace(username,newbalance);
        System.out.println("Rs."+amount+" has been  withdrawed from your account.");
        System.out.println("\n-------------**************-------------\n");
        historyArray.add("Rs."+amount +" withdrawed from your account.");

    }
    else{
        System.out.println("Insufficient balance for withdraw from your account.");
        System.out.println("\n-------------**************-------------\n");

    }

}

//function to deposite money in account
public static void depositeMoney(String username){

    System.out.println("Enter the amount you want to deposite:");
    int amount=sc.nextInt();
    int newbalance=userBalance.get(username)+amount;
    userBalance.replace(username,newbalance);
    System.out.println("Rs."+amount+" has been deposite to your account.");
    System.out.println("\n-------------**************-------------\n");
    historyArray.add("Rs."+amount +" deposite to your account");

}

//function to transfer money
public static void trasferMoney(String username){
     System.out.println("To whom account you want you transfer money: ");
     String recipient = sc.next().toLowerCase();
     if(userBalance.containsKey(recipient)){
        System.out.println("Enter amount you want to transfer to "+recipient+" :");
        int transferAmount=sc.nextInt();
        System.out.println();

        if(userBalance.get(username)>=transferAmount){
            int  userNewBalance=userBalance.get(username)-transferAmount;
            int  recipientNewBalance=userBalance.get(username)+transferAmount;

            userBalance.replace(recipient,recipientNewBalance);
            userBalance.replace(username,userNewBalance);
            System.out.println("Money transfer has been done successfully.");
            historyArray.add("RS. "+transferAmount +" transfered to "+recipient);
            System.out.println("\n-------------**************-------------\n");
            

        }
        else{
            System.out.println("You don't have enough balance to transfer money.");
            System.out.println("\n-------------**************-------------\n");
        }
     }
     else{
        System.out.println(recipient+" don't have account in our bank.");
        System.out.println("\n-------------**************-------------\n");
     }
}


//function for check bank balance
public static void checkBankBalance(String username){
    System.out.println("Your Bank Balance is "+userBalance.get(username));

    System.out.println("\n-------------**************-------------\n");

}

//function to show transaction history
public static void showHistory(){
    for(String str:historyArray){
        System.out.println(str);
    }
    System.out.println("\n-------------**************-------------\n");
}

    
public static void main(String[] args) {
        defaultUserName();
        System.out.println("__________________WELCOME___________________\n");
        Scanner sc= new Scanner(System.in);

        int passwordAttempts=0;//intially zero
        boolean isLogedin=false;
        boolean flag=true;

        
        System.out.println("Enter the user name:");
        String username=sc.next().toLowerCase();
        
        if(userPassword.containsKey(username)){
            while(passwordAttempts<3){
                System.out.println("Please enter your ATM pin:");
                int pin=sc.nextInt();
                System.out.println("\n-------------**************-------------\n");
            

                if(userPassword.get(username)==pin){
                    isLogedin=true;
                    break;
                }else{
                    System.out.println("Invalid Password");
                    passwordAttempts++;
                }
                if(passwordAttempts==3){
                    System.out.println("Your ATM has been blocked for one day");
                }
            }
        }
        else{
            System.out.println("YOU D'NOT HAVE ANY BANK ACCOUNT IN OUR BANK");
        }


        while(isLogedin){
            while(flag){

                System.out.println("Press 1: Show History");
                System.out.println("Press 2: Withdraw ");
                System.out.println("Press 3: Deposite");
                System.out.println("Press 4: Transfer");
                System.out.println("Press 5: Check Bank Balance");
                System.out.println("Press 6:  Exit");
                System.out.println();

                System.out.println("Enter the Key: ");
                int ch=sc.nextInt();

                switch(ch){
                    case 1:
                    showHistory();
                    break;
                    case 2:
                    withdrawMoney(username);
                    break;
                    case 3:
                    depositeMoney(username);
                    break;
                    case 4:
                    trasferMoney(username);
                    break;
                    case 5:
                    checkBankBalance(username);
                    break;
                    case 6:
                    flag=false;
                    if(!flag){
                        System.out.println("\n-------------------------THANK YOU------------------------------");
                    }
                    break;
                    default:
                    System.out.println("Enter the valid Key");


                }
            }
        }

        
        
    }
    
}
