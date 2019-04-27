import java.util.Scanner;

public class TestToArray {

    //Testing
    public static void main(String[] args) {
        String firstWord;
        String secondWord;
        String message;
        boolean keepGoing = true;

        while (keepGoing) {
            Scanner input = new Scanner(System.in);


            System.out.println("Enter a message (Anything goes): ");
            message = input.nextLine();

            for (int k = 0; k < 2; k++) {

                System.out.println("Enter two 10 letter words: ");

                firstWord = input.nextLine();
                secondWord = input.nextLine();
                
                while (firstWord.length() != 10 || secondWord.length() != 10 || message.equalsIgnoreCase("")) {
                    if (message.equalsIgnoreCase(""))
                    {
                        keepGoing = false;
                        System.out.println("Good Bye");
                        System.exit(0);
                    }
                    else if(firstWord.equalsIgnoreCase("Stop"))
                    {
                        keepGoing = false;
                        System.out.println("Good Bye");
                        System.exit(0);
                    }
                    else if(secondWord.equalsIgnoreCase("Stop"))
                    {
                        keepGoing = false;
                        System.out.println("Good Bye");
                        System.exit(0);
                    }

                     else {
                        System.out.println("That's not a ten letter word...");
                        System.out.println("Enter a 10 letter word: ");
                        firstWord = input.nextLine();
                        secondWord = input.nextLine();
                    }
                }

                ToArray combinedMessage = new ToArray(firstWord, message);

                System.out.println("First run of cypher that has been created! (1st row): 10 letter word / (Rest of the Rows): Message");
                System.out.println();

                combinedMessage.printArray(combinedMessage.bigArray());


                String[][] sorted = combinedMessage.sortByLetter(combinedMessage.bigArray());
                System.out.println();

                System.out.println("Cypher after columns have been sorted (EXCLUDES FIRST ROW): ");
                System.out.println();
                combinedMessage.printArray(sorted);

                System.out.println();

                System.out.println("Five letter Strings retrieved from sorted columns: ");
                System.out.println(combinedMessage.toString(sorted));

                System.out.println();

                String newMessage = combinedMessage.toString(sorted);
                
                ToArray secondRun = new ToArray(secondWord, newMessage);
                
                System.out.println("Second run of cypher!");
                System.out.println();
                
                String[][] secondSort = secondRun.sortByLetter(secondRun.bigArray());
                
                secondRun.printArray(secondSort);
                System.out.println();
                
                System.out.println("Five letter Strings retrieved from sorted columns: ");
                System.out.println(secondRun.toString(secondSort));
                System.out.println();
                System.out.println("Double Encryption completed!");


                System.out.println();
                System.out.println("Re Enter both ten letter words to decrypt message:");
                String userFirstGuess = input.nextLine();
                String userSecondGuess = input.nextLine();

                if(!userFirstGuess.equalsIgnoreCase(firstWord) || !userSecondGuess.equalsIgnoreCase(secondWord))
                {
                    System.out.println("Unauthorized entry detected. Computer will not continue decrypting!");
                }
                else
                {
                   String[][] firstDecrypt = secondRun.decrpyt(userSecondGuess, secondSort);
                   String[][] secondDecrypt = secondRun.decrpyt(userFirstGuess, firstDecrypt);

                   System.out.println(secondRun.toString(secondDecrypt));
                }

                System.out.println();
                System.out.println("TIME TO ENCRYPT A NEW MESSAGE!");
                System.out.println("If you don't want to continue making another encryption, leave message empty and/or type 'stop' for 10 letter word)");
            
            }
            
        }
    }
}

