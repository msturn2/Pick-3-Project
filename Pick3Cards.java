/**
 * Pick3Cards Class
 * ****** Handles the majority of game play*******
 */


import java.util.*;

public class Pick3Cards {

  // Constructors and instance variables are private for use in public methods

  private Randomizer randomizer = new Randomizer();
  private ArrayList<String> cards = new ArrayList<String>();
  private ArrayList<String> selected = new ArrayList<String>();
  private ArrayList<String> selectedFinal = new ArrayList<String>();
  private ArrayList<String> pile1 = new ArrayList<String>();
  private ArrayList<String> pile2 = new ArrayList<String>();
  private ArrayList<String> pile3 = new ArrayList<String>();
  private ArrayList<String> pile4 = new ArrayList<String>();
  private Scanner sc = new Scanner(System.in);
  private String[] numbers = {"2", "3", "4", "5", "6", "7", "8", 
    "9", "10", "Jack", "Queen", "King", "Ace"
  };
  private String[] suits = {
    "Hearts", 
    "Diamonds", 
    "Clubs", 
    "Spades"
  };
  private int counter = 0;
  private int cardNum;
  private int suitNum;
  private boolean bool = false;

  /**
   * Getters and Setters
   * @param randomizer - Randomizer object
   * @param cards - Collection ArrayList<String> handles 
   *              - majority of iterations and state changes
   * @param selected - Collection ArrayList<String> holds selected cards so 
   *                 - the user doesn't have to write them down.....Hard Copy
   *                 - .......Yuck!!! LOL
   * @param pile1 - Collection ArrayList<String> hold face down cards
   * @param pile2 - Collection ArrayList<String> hold face down cards
   * @param pile3 - Collection ArrayList<String> hold face down cards
   * @param pile4 - Collection ArrayList<String> hold face down cards
   * @param sc - Scanner Object used as sc.nextInt();
   * @param numbers - instance variable int
   * @param suits - instance variable String[]
   * @param counter - instance variable int
   * @param cardNum - instance variable int to store user input
   * @param suitNum - instance variable int to store user input
   */
  public void setPick3Cards(
    Randomizer randomizer,
    // Pick3Cards p3c,
    ArrayList<String> cards, 
    ArrayList<String> selected, 
    ArrayList<String> pile1, 
    ArrayList<String> pile2, 
    ArrayList<String> pile3, 
    ArrayList<String> pile4, 
    Scanner sc, 
    String[] numbers, 
    String[] suits, 
    int counter, 
    int cardNum, 
    int suitNum
  ) {
    this.randomizer = randomizer;
    this.cards = cards;
    this.selected = selected;
    this.pile1 = pile1;
    this.pile2 = pile2;
    this.pile3 = pile3;
    this.pile4 = pile4;
    this.sc = sc;
    this.numbers = numbers;
    this.suits = suits;
    this.counter = counter;
    this.cardNum = cardNum;
    this.suitNum = suitNum;
  }

  public Pick3Cards getPick3Cards(int counter, int cardNum, int suitNum) {
    return this.getPick3Cards(counter, cardNum, suitNum);
  }

  public void setCardNum(int cardNum) {
    this.cardNum = cardNum;
  }

  public int getCardNum() {
    return this.cardNum;
  }

  public void setCounter(int counter) {
    this.counter = counter;
  }

  public int getCounter() {
    return this.counter;
  }

  public void setSelected(ArrayList<String> selected) {
    this.selected = selected;
  }

  public ArrayList<String> getSelected() {
    return this.selected;
  }

  public void setCards(ArrayList<String> cards) {
    this.cards = cards;
  }

  public ArrayList<String> getCards() {
    return this.cards;
  }

  public void setPile1(ArrayList<String> pile1) {
    this.pile1 = pile1;
  }

  public ArrayList<String> getPile1() {
    return this.pile1;
  }

  public void setPile2(ArrayList<String> pile2) {
    this.pile2 = pile2;
  }

  public ArrayList<String> getPile2() {
    return this.pile2;
  }

  public void setPile3(ArrayList<String> pile3) {
    this.pile3 = pile3;
  }

  public ArrayList<String> getPile3() {
    return this.pile3;
  }

  public void setPile4(ArrayList<String> pile4) {
    this.pile4 = pile4;
  }

  public ArrayList<String> getPile4() {
    return this.pile4;
  }

  /**
   * Embeded for loop builds the deck as oppossed to 
   * Hard Coding it
   */
  public void BuildDeck() {
    for (int i = 0; i < numbers.length; i++) {
      for (int j = 0; j < suits.length; j++) {
        cards.add(numbers[i] + " of " + suits[j]);
      }
    }
  }

  public void giveFirstTimeInstructions() {
    System.out.println("Welcome to Pick 3 Cards!");  
    System.out.println("Choose any three cards from the deck.");
    System.out.println();
    System.out.println("Don't worry about remembering them as we'll do that for you.");
    System.out.println("Please enter a number 2 - 14. 11 - 14 will represent Jacks - Aces.");
  }

  public void moveToNextCycle() {
    System.out.println();
    System.out.println("Please enter another number 2 - 14.");
    System.out.println("As before, 11 - 14 will represent Jacks - Aces.");
  }

  /**
   * Error handling in the event of null Collection or []
   * @throws NullPointerException
   */
  public void giveInstructions() throws NullPointerException {
    new NullPointerException();
    String[] cycles = {"first", "second", "third"};

    // while loop holds user until conditions are met
    while (cardNum < 2 || cardNum > 14 && counter < 3) {
      if (cardNum < 2 || cardNum > 14 && counter < 3) {
        System.out.println();
        System.out.println("You don't like to read directions...Do you?...LOL, just kidding.");
        System.out.println("Please ONLY enter a number 2 - 14.  All other numbers will make this message repeat.");
        cardNum = sc.nextInt();
      }
    }

    if (cardNum >= 2 && cardNum <= 10) {
      System.out.println();
      System.out.println("You have selected a " + cardNum);
      System.out.println("Please select the suit. 1 = 'Hearts', 2 = 'Diamonds', 3 = 'Clubs', and 4 = 'Spades'.");
      suitNum = sc.nextInt();

      while (suitNum < 0 || suitNum > 4 && counter < 3) {
        if (suitNum < 0 || suitNum > 4 && counter < 3) {
          System.out.println();
          System.out.println("Please enter a number 1 - 4 to select your suit.");
          System.out.println("Again, 1 = 'Hearts', 2 = 'Diamonds', 3 = 'Clubs', and 4 = 'Spades'.");
          suitNum = sc.nextInt();
        }
      }

      if (suitNum > 0 && suitNum <= 4) {

        if (selected.isEmpty()) {
          selected.add(String.valueOf(cardNum) + " of " + suits[suitNum - 1]);
          System.out.println();
          System.out.println("You've chosen the " + cardNum + " of " + suits[suitNum - 1] + " for your " + cycles[counter] + " card.");
          cards.remove(String.valueOf(cardNum) + " of " + suits[suitNum - 1]);
          counter++;
        
        } else if (!(selected.isEmpty()) && (!selected.contains(String.valueOf(cardNum) + " of " + suits[suitNum - 1]))) {
          selected.add(String.valueOf(numbers[cardNum - 2]) + " of " + suits[suitNum - 1]);
          System.out.println();
          System.out.println("You've chosen the " + cardNum + " of " + suits[suitNum - 1] + " for your " + cycles[counter] + " card.");
          cards.remove(String.valueOf(cardNum) + " of " + suits[suitNum - 1]);
          counter++;

        } else if (!(selected.isEmpty()) && selected.contains(String.valueOf(cardNum) + " of " + suits[suitNum - 1])) {
          System.out.println();
          System.out.println("You've already chosen the: " + String.valueOf(cardNum) + " of " + suits[suitNum - 1]);
          System.out.println("Please pick a card that you haven't alredy picked.");
        }
      }
    } else if (cardNum > 10 && cardNum <= 14) {
      System.out.println();
      System.out.println("You have selected a " + numbers[cardNum - 2]);
      System.out.println("Please select the suit. 1 = 'Hearts', 2 = 'Diamonds', 3 = 'Clubs', and 4 = 'Spades'.");
      suitNum = sc.nextInt();

      while (suitNum < 0 || suitNum > 4 && counter < 3) {
        if (suitNum < 0 || suitNum > 4 && counter < 3) {
          System.out.println();
          System.out.println("Please enter a number 1 - 4 to select your suit.");
          System.out.println("Again, 1 = 'Hearts', 2 = 'Diamonds', 3 = 'Clubs', and 4 = 'Spades'.");
          suitNum = sc.nextInt();
        }
      }
      
      if (suitNum > 0 && suitNum <= 4) {

        if (selected.isEmpty()) {
          selected.add(String.valueOf(numbers[cardNum - 2]) + " of " + suits[suitNum - 1]);
          System.out.println();
          System.out.println("You've chosen the " + numbers[cardNum - 2] + " of " + suits[suitNum - 1] + " for your " + cycles[counter] + " card.");
          cards.remove(cards.indexOf(String.valueOf(numbers[cardNum - 2]) + " of " + suits[suitNum - 1]));
          counter++;

        } else if (!(selected.isEmpty()) && (!selected.contains(String.valueOf(cardNum) + " of " + suits[suitNum - 1]))) {
          selected.add(String.valueOf(numbers[cardNum - 2]) + " of " + suits[suitNum - 1]);
          System.out.println();
          System.out.println("You've chosen the " + numbers[cardNum - 2] + " of " + suits[suitNum - 1] + " for your " + cycles[counter] + " card.");
          cards.remove(cards.indexOf(String.valueOf(numbers[cardNum - 2]) + " of " + suits[suitNum - 1]));
          counter++;

        } else if (!(selected.isEmpty()) && selected.contains(String.valueOf(numbers[cardNum - 2]) + " of " + suits[suitNum - 1])) {
          System.out.println();
          System.out.println("You've already chosen the: " + String.valueOf(numbers[cardNum - 2]) + " of " + suits[suitNum - 1]);
          System.out.println("Please pick a card that you haven't alredy picked.");
        }
      }
    }
  }

  public void roundOne() {

    /**
     * Do while loop so that the first time instructions run
     */
    do {
      giveFirstTimeInstructions();
      cardNum = sc.nextInt();

      /**
       * While loop holds user with a switch inside to move user through rounds
       */
      while (counter < 4) {
        switch(counter) {
          case 0:
            giveInstructions();
          case 1: 
            moveToNextCycle();
            cardNum = sc.nextInt();
            giveInstructions();
          case 2:
            moveToNextCycle();
            cardNum = sc.nextInt();
            giveInstructions();
          case 3:

            // used addAll Super Implementation method as opposed to building a loop
            // , which makes for less code to write.
            selectedFinal.addAll(selected);
            System.out.println();
            System.out.println("Your cards are " + selected);
            System.out.println();
            System.out.println("Although we just showed you your cards, it's the program showing you the cards,");
            System.out.println("not me the dealer. The dealer can't see your cards.");

            // Break keyword used to end switch for this case
            if (selected.size() == 3) {
              System.out.println();
              System.out.println("Now, are you ready to see some MAGIC!?...Of course you are!");
              randomizer.setTempList(cards);
              counter++;
              break;
            }

            break;
          
          // Continue skips the current iteration as I really didn't have
          // a default case.  It would be bad coding not to include a default
          // case if there is an unforsee circumstance that would trigger it.
          default:
            continue;  
        }
      }
    } while (counter < 4);
  }

  // Decided to show that I know to handle exceptions both ways. Used
  // throws keyword 
  public void roundTwo() throws IndexOutOfBoundsException {

    /**
     * Very unique case where it made sense to use a do do loop....
     * No pun intended, I have never seen it before and don't know if
     * it's part of best practices or not, but it handle aberrant behavior
     * by my program when you got further down the through the method
     */
    do {

      do {
        System.out.println();
        System.out.println("Now we'll suffle the deck without your three cards");
        System.out.println("Please enter the number 49 and ONLY 49");
        randomizer.setRandCounter(counter);
        // System.out.println(counter);
        cardNum = sc.nextInt();
        
        while (cardNum != 49) {
          System.out.println();
          System.out.println("You must enter 49 and ONLY 49.");
          System.out.println("Any other number will not shuffle the deck");

          cardNum = sc.nextInt();
        }
        
      } while (cardNum != 49);
      
      while (counter < 6) {

        if (cardNum == 49 && counter == 4) {
          randomizer.setNum(cardNum);

          // Very proud of this piece of code, the *****shuffleDeck()***** method.
          // It took me quite some time to figure out how to accomplish this task.
          // Once I did, it was able to use it to solve multiple areas throughout the program.
          shuffleDeck();
          cards = randomizer.getTempListCards();
          System.out.println();
          System.out.println("Thank you. The deck is shuffled.");
          System.out.println();
          System.out.println("Now I will place the deck into 4 piles. A pile of 10, 15, 15 and 9 cards");
          System.out.println("Next, we'll place your first card on top of the pile of 10.");
          System.out.println();
          System.out.println("Now we'll cut the first pile of 15 and place the cut on top of the pile of 10 cards.");
          System.out.println();
          System.out.println("Next, please pick a number between 1 - 15, but not 1, or 15. Your number will represent where to cut the pile");
          randomizer.setRandCounter(counter);
          cardNum = sc.nextInt();
        }  
        
        while (counter < 5) {
          if (cardNum > 1 && cardNum < 15) {
            randomizer.setNum(cardNum);
            randomizer.setTempList(selected);
            randomizer.setTempListCards(cards);
            randomizer.cutPile();
            counter++;
            randomizer.setRandCounter(counter);
            // bool = false;
          } 
          
          while (cardNum < 2 || cardNum > 14) {
            System.out.println("You may only choose to cut the deck by entering a number between 1 - 15.");
            System.out.println("You may not pick 1 or 15.  Any number not inside 1 - 15 will repeat this message.");
            // bool = true;
            counter = 4;
            cardNum = sc.nextInt();
          }
        }

        while (counter < 6 && counter != 4) {
          if (cardNum > 1 && cardNum < 15) {
            System.out.println();
            System.out.println("Let's now place your second card on top of the pile that we just cut.");
            System.out.println();
            System.out.println("Now we'll cut the second pile of 15 and place the cut on top of the pile that we just cut.");
            System.out.println("Again, please pick a number between 1 - 15, but not 1, or 15.");

            /**
             * Boolean helped to not have user enter number twice if original cardNum
             * would throw IndexOutOfBoundsException.
             */
            if (!bool) {
              cardNum = sc.nextInt();
            }

            if (cardNum > 1 && cardNum < 15 || !bool && cardNum > 1 && cardNum < 15) {
              counter++;
              randomizer.setNum(cardNum);
              randomizer.cutPile();
              randomizer.setRandCounter(counter);
              cards = randomizer.getTempListCards();
              bool = false;
            } else {
              while (cardNum < 2 || cardNum > 14) {
  
                System.out.println("You may only choose to cut the deck by entering a number between 1 - 15.");
                System.out.println("You may not pick 1 or 15.  Any number not inside 1 - 15 will repeat this message.");
                bool = true;
                cardNum = sc.nextInt();
              }
            }
          }
        }
      }

    } while (counter < 6);

    // testing for exception handling
    // throw new IndexOutOfBoundsException();
  }
  
  public void roundThree() throws NullPointerException {
    // testing for exception handling
    // throw new NullPointerException();

    /**
     * At this point the game is really finished as far as coding goes.
     * I just need to finish walking the user through the steps and show
     * them the cards they picked.
     */
    do {
      
      System.out.println();
      System.out.println("Great! Now, we'll place your third and final card on top of the pile that we just cut and then place the remaining pile of 9 cards on top of that.");
      System.out.println();
      System.out.println("Next, we'll take that pile and place it on top of the pile that has your second card.");
      System.out.println();
      System.out.println("Now, we'll take that pile and place it atop of the pile that has your first card.");
      System.out.println();
      System.out.println("Now that all of the cards are back into one pile");
      System.out.println(", I will now take the top four cards and place them on the bottom of the deck.");
      System.out.println();
      System.out.println("Now I will turn one card face up and one card face down and then repeat this all the way through the deck.");
      System.out.println("I will show you all of the cards that are turned face up.");
      System.out.println("Please tell me when you see your cards face up.");
      System.out.println();
      System.out.println("Please press 1 to continue.");

      cardNum = sc.nextInt();
      while (cardNum != 1) {
        System.out.println("Only by entering 1 may you continue to the next stage.");
        System.out.println("Please press 1, AND ONLY 1 to continue.");
        cardNum = sc.nextInt();
      }

      while (counter < 16) {
        if (cardNum == 1 && counter == 6) {
          
          // Managing state changes
          randomizer.setNum(cardNum);
          randomizer.setRandCounter(counter);
          randomizer.setTempListCards(cards);
          randomizer.flipPile();
          pile1 = randomizer.getTempList();
          pile2 = randomizer.getCutPile2();
          pile3 = randomizer.getCutPile3();
          pile4 = randomizer.getCutPile4();
          cards = randomizer.getTempListCards();
          counter = randomizer.getRandCounter();
  
          System.out.println("AS A REMINDER, YOUR SELECTED CARDS ARE " + selectedFinal);
          System.out.println();
          System.out.println("Are any of your cards in the list below?");
          System.out.println();
          
          // Used a forEach loop to show cards elements on an indivdual line
          // instead of grouped together with a print().  Took into account
          // user experience and made for better readability.
          for (String pile4El : pile4) {
            System.out.println(pile4El);
          } 

          System.out.println();
          System.out.println("If you see any of your cards in the list above, please press 2.");
          System.out.println();
          System.out.println("If none of your cards are in the list above, please press 1");
          counter++;
          cardNum = sc.nextInt();

          while (cardNum != 1) {
            while (cardNum == 2) {
              System.out.println("ARE YOU SURE THAT YOUR CARDS ARE IN THE PILE SHOWN?????");
              System.out.println("AS YOU RECALL, YOUR SELECTED CARDS ARE " + selectedFinal);
              System.out.println();
              for (String pile4El : pile4) {
                System.out.println(pile4El);
              } 
              System.out.println();
              System.out.println("Please press 2, and only 2 IF YOU DO SEE ANY OF YOUR CARDS.");
              System.out.println("Please press 1, AND ONLY 1 IF THE LIST DOES NOT!!! contain any of your cards");
              cardNum = sc.nextInt();
            }

            while (cardNum != 1 && cardNum != 2) {
              System.out.println("Please press 2, and only 2 IF YOU DO SEE ANY OF YOUR CARDS.");
              System.out.println("Please press 1, AND ONLY 1 IF THE LIST DOES NOT!!! contain any of your cards");
              cardNum = sc.nextInt();
            }
          }
  
          if (cardNum == 1 && counter == 13) {
            System.out.println();
            System.out.println("Since you din't see any of your cards in the list above, ");
            System.out.println("we'll take the face down pile of cards and turn one card face up and");
            System.out.println("one card face down all the way through the pile.");
            System.out.println();
            System.out.println("Just as before, I will show you all of the cards that are turned face up.");
            System.out.println("Please tell me when you see your cards face up.");
            System.out.println();
            System.out.println("AS YOU RECALL, YOUR SELECTED CARDS ARE " + selectedFinal);
            System.out.println("Are any of your cards in the list below?");
            System.out.println();
            
            for (String pile3El : pile3) {
              System.out.println(pile3El);
            }
            
            System.out.println();
            System.out.println("If you see any of your cards in the list above, please press 2.");
            System.out.println();
            System.out.println("If none of your cards are in the list above, please press 1");
            
            counter++;
            cardNum = sc.nextInt();

            while (cardNum != 1) {
              while (cardNum == 2) {
                System.out.println("ARE YOU SURE THAT YOUR CARDS ARE IN THE PILE SHOWN?????");
                System.out.println("AS YOU RECALL, YOUR SELECTED CARDS ARE " + selectedFinal);
                System.out.println();
                for (String pile3El : pile3) {
                  System.out.println(pile3El);
                } 
                System.out.println();
                System.out.println("Please press 2, and only 2 IF YOU DO SEE ANY OF YOUR CARDS.");
                System.out.println("Please press 1, AND ONLY 1 IF THE LIST DOES NOT!!! contain any of your cards");
                cardNum = sc.nextInt();
              }
  
              while (cardNum != 1 && cardNum != 2) {
                System.out.println("Please press 2, and only 2 IF YOU DO SEE ANY OF YOUR CARDS.");
                System.out.println("Please press 1, AND ONLY 1 IF THE LIST DOES NOT!!! contain any of your cards");
                cardNum = sc.nextInt();
              }
            }
          }

          if (cardNum == 1 && counter == 14) {
            System.out.println();
            System.out.println("Since you din't see any of your cards in the list above, ");
            System.out.println("we'll take the face down pile of cards and turn one card face up and");
            System.out.println("one card face down all the way through the pile.");
            System.out.println();
            System.out.println("Just as before, I will show you all of the cards that are turned face up.");
            System.out.println("Please tell me when you see your cards face up.");
            System.out.println();
            System.out.println("AS YOU RECALL, YOUR SELECTED CARDS ARE " + selectedFinal);
            System.out.println("Are any of your cards in the list below?");
            System.out.println();
            
            for (String pile2El : pile2) {
              System.out.println(pile2El);
            }
            
            System.out.println();
            System.out.println("If you see any of your cards in the list above, please press 2.");
            System.out.println();
            System.out.println("If none of your cards are in the list above, please press 1");
            
            counter++;
            cardNum = sc.nextInt();

            while (cardNum != 1) {
              while (cardNum == 2) {
                System.out.println("ARE YOU SURE THAT YOUR CARDS ARE IN THE PILE SHOWN?????");
                System.out.println("AS YOU RECALL, YOUR SELECTED CARDS ARE " + selectedFinal);
                System.out.println();
                for (String pile2El : pile2) {
                  System.out.println(pile2El);
                } 
                System.out.println();
                System.out.println("Please press 2, and only 2 IF YOU DO SEE ANY OF YOUR CARDS.");
                System.out.println("Please press 1, AND ONLY 1 IF THE LIST DOES NOT!!! contain any of your cards");
                cardNum = sc.nextInt();
              }
  
              while (cardNum != 1 && cardNum != 2) {
                System.out.println("Please press 2, and only 2 IF YOU DO SEE ANY OF YOUR CARDS.");
                System.out.println("Please press 1, AND ONLY 1 IF THE LIST DOES NOT!!! contain any of your cards");
                cardNum = sc.nextInt();
              }
            }
          }

          if (cardNum == 1 && counter == 15) {
            System.out.println();
            System.out.println("Since you din't see any of your cards in the list above, ");
            System.out.println("we'll take the face down pile of cards and turn one card face up and");
            System.out.println("one card face down all the way through the pile.");
            System.out.println();
            System.out.println("Just as before, I will show you all of the cards that are turned face up.");
            System.out.println("Please tell me when you see your cards face up.");
            System.out.println();
            System.out.println("ARE THESE YOUR CARDS!!!!!!!!!!");
            System.out.println();
            
            for (String card : cards) {
              System.out.println(card);
            }

            System.out.println();
            System.out.println(selectedFinal + "  Just in case you forgot your cards.");
            System.out.println();
            System.out.println("And now you say.....WOOOOOOOOW!!!!  How did you do that!?!?!  It's MAGIC!");
            
            counter++;
            sc.close();
          }
        } else if (counter == 16) {
          sc.close();
          System.exit(1);
        }
      }
    } while (counter < 16);
  }

  public void shuffleDeck() {
    randomizer.randomNumber();
  }
}

// * 4 Pillars of OOP
// * Must create and use at least 3 Constructors
// * Must have at least 4 methods
// * Must include a section to get responses from User
// * Must contain a switch statement
// * Must handle at least 1 exception
// * Project must include at least 3 Classes
// * Use one of the Collections structures.
// * Use a loop to traverse through your Collection structure that you chose and modify,// * organize, or return values from the iteration. 
// * ex. Sort my structure, Search, find and return object 