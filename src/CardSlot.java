public class CardSlot {
    private String name;
    private int amount;

    public CardSlot(String newName, int newAmount){
        name = newName;
        amount = newAmount;
    }

    public String getName(){
        return name;
    }

    public int getAmount(){
        return amount;
    }

    public void addAmount(int add){
        amount += add;
    }
}
