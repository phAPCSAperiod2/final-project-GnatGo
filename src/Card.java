public class Card {
    private String name;
    private String rarity;

    public Card(String newName, String newRarity){
        name = newName;
        rarity = newRarity;
    }

    public String getName(){
        return name;
    }

    public String getRarity(){
        return rarity;
    }
}
