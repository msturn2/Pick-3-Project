import java.util.*;

public class Randomizer {
  private Random rand;
  private Pick3Cards p3c;
  private int num;
  private int size;
  private int randCounter;
  private ArrayList<Integer> noDupList = new ArrayList<Integer>();
  private ArrayList<Integer> list = new ArrayList<Integer>();
  private ArrayList<String> tempList = new ArrayList<String>();
  private ArrayList<String> tempListCards = new ArrayList<String>();
  private ArrayList<String> cutPile1 = new ArrayList<String>();
  private ArrayList<String> cutPile2 = new ArrayList<String>();
  private ArrayList<String> cutPile3 = new ArrayList<String>();
  private ArrayList<String> cutPile4 = new ArrayList<String>();
  

  public Randomizer() {
    rand = new Random();
  }

  public void setRandCounter(int randCounter) {
    this.randCounter = randCounter;
  }

  public int getRandCounter() {
    return this.randCounter;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public int getNum() {
    return this.num;
  }

  public void setTempList(ArrayList<String> tempList) {
    this.tempList = tempList;
  }

  public ArrayList<String> getTempList() {
    return this.tempList;
  }

  public void setTempListCards(ArrayList<String> tempListCards) {
    this.tempListCards = tempListCards;
  }

  public ArrayList<String> getTempListCards() {
    return this.tempListCards;
  }

  public void setCutPile1(ArrayList<String> cutPile1) {
    this.cutPile1 = cutPile1;
  }

  public ArrayList<String> getCutPile1() {
    return this.cutPile1;
  }

  public void setCutPile2(ArrayList<String> cutPile2) {
    this.cutPile2 = cutPile2;
  }

  public ArrayList<String> getCutPile2() {
    return this.cutPile2;
  }

  public void setCutPile3(ArrayList<String> cutPile3) {
    this.cutPile3 = cutPile3;
  }

  public ArrayList<String> getCutPile3() {
    return this.cutPile3;
  }

  public void setCutPile4(ArrayList<String> cutPile4) {
    this.cutPile4 = cutPile4;
  }

  public ArrayList<String> getCutPile4() {
    return this.cutPile4;
  }
    
  public ArrayList<String> randomNumber() {
    p3c = new Pick3Cards();

    for (int i = 0; i < num; i++) {
      list.add(i);
    }

    while (list.size() > 0) {
      int index = rand.nextInt(list.size());
      noDupList.add(list.remove(index));
    }

    for (int i = 0; i < noDupList.size(); i++) {
      tempListCards.add(tempList.get(noDupList.get(i)));
    }
    
    return p3c.getCards();
  }

  public ArrayList<String> cutPile() {
    p3c = new Pick3Cards();

    if (randCounter == 4) {

      for (int i = 0; i < 10; i++){
        cutPile1.add(tempListCards.remove(0));
      }
  
      for (int i = 0; i < 15; i++){
        cutPile2.add(tempListCards.remove(0));
      }
  
      for (int i = 0; i < 15; i++){
        cutPile3.add(tempListCards.remove(0));
      }

      cutPile1.add(tempList.remove(0));

      for (int i = num - 1; i < 15; i++) {
        cutPile1.add(cutPile2.remove(num - 1));
      }

    } else if (randCounter == 5) {
      cutPile2.add(tempList.remove(0));

      for (int i = num - 1; i < 15; i++) {
        cutPile2.add(cutPile3.remove(num - 1));
      }

      cutPile3.add(tempList.remove(0));

      for (int i = 0; i < 9; i++) {
        cutPile3.add(tempListCards.remove(0));
      }

      size = cutPile3.size();

      for (int i = 0; i < size; i++) {
        cutPile2.add(cutPile3.remove(0));
      }

      size = cutPile2.size();

      for (int i = 0; i < size; i++) {
        cutPile1.add(cutPile2.remove(0));
      }

      size = cutPile1.size();

      for (int i = 0; i < size; i++) {
        tempListCards.add(cutPile1.remove(0));
      }
    }

    p3c.setCards(tempListCards);

    return p3c.getCards();
  }

  public ArrayList<String> flipPile() {
    p3c = new Pick3Cards();
    if (randCounter == 6) {
      num = 51;
      tempList.clear();
      while (num > 47) {

        tempList.add(tempListCards.remove(num));
        num--;
      }
      randCounter++;
    }
    if (randCounter == 7) {

      while (tempList.size() > 0) {
        tempListCards.add(0, tempList.remove(0));
      }
      randCounter++;
    }

    /**
     * Decided against using conditionals to trigger progressing
     * through 5 steps, all which would have had similar coding.
     * Used DRY best practices to minimize repetition.
     * Used a duel counter to handle gate apertures and closures within
     * conditionals.
     */
    size = tempListCards.size();
    num = 100;

    if (randCounter >= 8 && randCounter < 12) {
      
      while (randCounter < 12) {
        num++;
        
        while (tempListCards.size() > 0 && num < 105) {
          
          if (num != 103) {
            if (tempListCards.size() % 2 == 0) {
              tempList.add(tempListCards.remove(tempListCards.size() - 1));
      
            } else if (tempListCards.size() % 2 != 0) {
              cutPile1.add(tempListCards.remove(tempListCards.size() - 1));
            }
          } else {
            if (tempListCards.size() % 2 == 0) {
              cutPile1.add(tempListCards.remove(tempListCards.size() - 1));
      
            } else if (tempListCards.size() % 2 != 0) {
              tempList.add(tempListCards.remove(tempListCards.size() - 1));
            }
          }
        }

        if (num < 105) {
          while (cutPile1.size() > 0) {
            tempListCards.add(cutPile1.remove(0));
          }
          
          if (num == 101) {
            cutPile4.addAll(tempList);
            tempList.clear();
          } else if (num == 102) {
            cutPile3.addAll(tempList);
            tempList.clear();
          } else if (num == 103) {
            cutPile2.addAll(tempList);
            tempList.clear();
          }
        }
        randCounter++;
      }
    }

    return tempListCards;
  }
}