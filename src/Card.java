public class Card {
    private String name;
    private String rarity;
    private String image;

    public Card(String newName, String newRarity, String newImage){
        name = newName;
        rarity = newRarity;
        image = newImage;
    }

    public String getImage(){
        return image;
    }

    public String getName(){
        return name;
    }

    public String getRarity(){
        return rarity;
    }
}
