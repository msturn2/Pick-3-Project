import java.util.*;

public class Randomizer {
  private Random rand;
  private Pick3Cards p3c;
  private Scanner in = new Scanner(System.in);
  private int num;
  // private ArrayList<Integer> noDupList = new ArrayList<Integer>();
  private ArrayList<Integer> list = new ArrayList<Integer>();
  private ArrayList<String> tempList = new ArrayList<String>();
  private ArrayList<String> tempListCards = new ArrayList<String>();

  public Randomizer() {
    rand = new Random();
  }

  // public void setTempList(ArrayList<String> tempList) {
  //   this.tempList = tempList;
  // }

  // public ArrayList<String> getTempList() {
  //   return this.tempList;
  // }

  public void test() {
    p3c = new Pick3Cards();
    p3c.setCardNum(num = in.nextInt());
    
    System.out.println("Hello cardNum: " + p3c.getCardNum());
    System.out.println("Hello cards: " + p3c.getCards());
  }
    
  public ArrayList<String> randomNumber() {
    p3c = new Pick3Cards();
    p3c.setCardNum(num = in.nextInt());
    // p3c.setCards(tempList);
    tempList = p3c.getCards();

    for (int i = 1; i < num + 1; i++) {
      list.add(i);
    }

    while (list.size() > 0) {
      int index = rand.nextInt(list.size());
      // noDupList.add(list.remove(index));
      tempListCards.add(tempList.get(list.remove(index)));
      // System.out.println("Selected: " + list.remove(index));
    }

    System.out.println(tempListCards);
    return tempListCards;
  }

  // public ArrayList<String> shuffledList() {
  //   System.out.println(p3c.cards);

  //   for (int i = 0; i <= noDupList.size() - 1; i++) {
  //     tempList.add(p3c.cards.get(noDupList.get(i)));
  //   }

  //   System.out.println("Shuffled cards: " + tempList);

  //   return tempList;
  // }
}