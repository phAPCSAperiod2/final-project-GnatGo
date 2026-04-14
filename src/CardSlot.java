public class CardSlot {
    private String name;
    private int amount;
    private int tier;
    private final int MAX_TIER = 3;

    public CardSlot(String newName, int newAmount){
        name = newName;
        amount = newAmount;
        tier = 1;
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

    public void subtractAmount(int subtract){
        amount -= subtract;
    }

    public boolean checkMaxTier(){
        if (tier < MAX_TIER){
            return true;
        }
        return false;
    }

    public void upgradeCard(){
        if (tier < MAX_TIER){
            tier ++;
        }
    }
}
