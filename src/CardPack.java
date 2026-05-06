import java.util.ArrayList;

/**
 * Models a card pack that can hold a fixed number of cards and be opened.
 */
public class CardPack {
    private ArrayList<Card> cardList;
    private int cost;
    private int cardAmount;
    private int totalCards;

    /**
     * Constructs a pack with the specified cost and maximum card amount.
     *
     * @param newCost the cost of the pack
     * @param newAmount the maximum number of cards the pack can hold
     */
    public CardPack(int newCost, int newAmount){
        cardList = new ArrayList<>();
        cost = newCost;
        cardAmount = newAmount;
        totalCards = 0;
    }

    /**
     * Returns the cost of this card pack.
     *
     * @return the pack cost
     */
    public int getCost(){
        return cost;
    }

    /**
     * Returns the number of cards this pack is configured to contain.
     *
     * @return the card amount
     */
    public int getAmount(){
        return cardAmount;
    }

    /**
     * Adds a card to the pack if there is room.
     *
     * @param newCard the card to add
     */
    public void addCard(Card newCard){
        if(totalCards < cardAmount){
            cardList.add(newCard);
            totalCards++;
        }

        else{
            System.out.println("You can't add anymore cards.");
        }
    }

    /**
     * Opens the pack and returns the cards inside.
     *
     * @return an array containing the cards in the pack
     */
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
