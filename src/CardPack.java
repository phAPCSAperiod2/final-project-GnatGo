import java.util.ArrayList;
public class CardPack {
    private ArrayList<Card> cardList;
    private int cost;
    private int cardAmount;
    private int totalCards;

    public CardPack(int newCost, int newAmount){
        cardList = new ArrayList<>();
        cost = newCost;
        cardAmount = newAmount;
        totalCards = 0;
    }

    public int getCost(){
        return cost;
    }

    public int getAmount(){
        return cardAmount;
    }

    public void addCard(Card newCard){
        if(totalCards < cardAmount){
            cardList.add(newCard);
            totalCards++;
        }

        else{
            System.out.println("You can't add anymore cards.");
        }
    }

    public Card[] openPack(){
        System.out.println("Results: ");
        Card[] returnList = new Card[cardAmount];
        for(int i = 0; i < cardList.size(); i++){
            System.out.println("You pulled " + cardList.get(i).getName() + "!");
            returnList[i] = cardList.get(i);
        }
        return returnList;
    }
}
