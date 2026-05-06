/**
 * Represents a Pokémon card with a name, rarity, and image identifier.
 */
public class Card {
    private String name;
    private String rarity;
    private String image;

    /**
     * Creates a new card with the specified properties.
     *
     * @param newName the card name
     * @param newRarity the rarity of the card
     * @param newImage the image file name or identifier for this card
     */
    public Card(String newName, String newRarity, String newImage){
        name = newName;
        rarity = newRarity;
        image = newImage;
    }

    /**
     * Returns the image identifier for this card.
     *
     * @return the image identifier or file name
     */
    public String getImage(){
        return image;
    }

    /**
     * Returns the card name.
     *
     * @return the card name
     */
    public String getName(){
        return name;
    }

    /**
     * Returns the card rarity.
     *
     * @return the card rarity
     */
    public String getRarity(){
        return rarity;
    }
}
