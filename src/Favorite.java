import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Stores the user's favorite cards in a fixed grid and supports basic updates.
 */
public class Favorite {
    private Card[][] favoritesList;

    /**
     * Creates an empty 4x4 favorites grid.
     */
    public Favorite(){
        favoritesList = new Card[4][4];
    }

    /**
     * Returns {@code true} when there is at least one empty favorite slot.
     *
     * @return {@code true} if an empty slot exists, otherwise {@code false}
     */
    public boolean checkEmpty(){
        for (int i = 0; i < favoritesList.length; i++){
            for (int j = 0; j < favoritesList[0].length; j++){
                if (favoritesList[i][j] == null){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Removes a favorite card by name, ignoring case.
     *
     * @param card the name of the card to remove
     * @return {@code true} if the card was removed, otherwise {@code false}
     */
    public boolean removeCard(String card){
        for (int i = 0; i < favoritesList.length; i++){
            for (int j = 0; j < favoritesList[0].length; j++){
                if (favoritesList[i][j] != null){
                    if (favoritesList[i][j].getName().equalsIgnoreCase(card)){
                        favoritesList[i][j] = null;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Adds a card to the first available favorite slot.
     *
     * @param card the card to add
     * @return {@code true} if the card was added, otherwise {@code false}
     */
    public boolean addCard(Card card){
        for (int i = 0; i < favoritesList.length; i++){
            for (int j = 0; j < favoritesList[0].length; j++){
                if (favoritesList[i][j] == null){
                    favoritesList[i][j] = card;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Replaces an existing favorite card by name.
     *
     * @param addedCard the card to place into the favorites grid
     * @param replacedCard the name of the card to replace
     */
    public void replaceCard(Card addedCard, String replacedCard){
        for (int i = 0; i < favoritesList.length; i++){
            for (int j = 0; j < favoritesList[0].length; j++){
                if (favoritesList[i][j].getName().equalsIgnoreCase(replacedCard)){
                    favoritesList[i][j] = addedCard;
                }
            }
        }
    }

    /**
     * Displays the favorites grid in a GUI window showing card images or empty slots.
     */
    public void displayFavorite(){
        JFrame favorites = new JFrame("Favorites List");
        favorites.setSize(800, 1200);

        favorites.setLayout(null);

        int x = 0;
        int y = 0;
        for (int i = 0; i < favoritesList.length; i++){
            for (int j = 0; j < favoritesList[0].length; j++){
                try {
                    String fileName = favoritesList[i][j].getImage() + ".png";
                    String path = "src/Data/" + fileName;
                    ImageIcon image = new ImageIcon(path);

                    //scale image
                    Image scaledImage = image.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
                    image = new ImageIcon(scaledImage);
                    JLabel label = new JLabel(image);
                    label.setBounds(x, y, 200, 300);
                    favorites.add(label);
                }
                catch (Exception e){
                    JLabel label = new JLabel("Empty");
                    label.setBounds(x, y, 200, 300);
                    favorites.add(label);
                }
                favorites.setVisible(true);

                x += 200;
            }
            x = 0;
            y += 300;

        }
    }

}
