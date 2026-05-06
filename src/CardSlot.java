/**
 * Tracks a specific card and the quantity owned in the collection.
 */
public class CardSlot {
    private Card card;
    private int amount;

    /**
     * Creates a card slot for a card and initial quantity.
     *
     * @param newCard the card instance
     * @param newAmount the starting quantity of this card
     */
    public CardSlot(Card newCard, int newAmount){
        card = newCard;
        amount = newAmount;
    }

    /**
     * Returns the card stored in this slot.
     *
     * @return the card instance
     */
    public Card getCard(){
        return card;
    }

    /**
     * Returns how many copies of the card are stored.
     *
     * @return the amount of the card
     */
    public int getAmount(){
        return amount;
    }

    /**
     * Increases the stored card quantity by the specified amount.
     *
     * @param add the number of cards to add
     */
    public void addAmount(int add){
        amount += add;
    }

    /**
     * Decreases the stored card quantity by the specified amount.
     *
     * @param subtract the number of cards to remove
     */
    public void subtractAmount(int subtract){
        amount -= subtract;
    }
}
