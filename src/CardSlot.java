public class CardSlot {
    private Card card;
    private int amount;

    public CardSlot(Card newCard, int newAmount){
        card = newCard;
        amount = newAmount;
    }

    public Card getCard(){
        return card;
    }

    public int getAmount(){
        return amount;
    }

    public void addAmount(int add){
        amount += add;
    }

    public void subtractAmount(int subtract){
        amount -= subtract;
    }
}
