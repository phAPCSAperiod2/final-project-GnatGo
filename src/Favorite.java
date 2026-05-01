import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Favorite {
    private Card[][] favoritesList;

    public Favorite(){
        favoritesList = new Card[4][4];
    }

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

    public void replaceCard(Card addedCard, String replacedCard){
        for (int i = 0; i < favoritesList.length; i++){
            for (int j = 0; j < favoritesList[0].length; j++){
                if (favoritesList[i][j].getName().equalsIgnoreCase(replacedCard)){
                    favoritesList[i][j] = addedCard;
                }
            }
        }
    }

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
                    JLabel label = new JLabel("Error");
                    label.setBounds(x, y, 200, 300);
                    favorites.add(label);
                }
                favorites.setVisible(true);

                x += 200;
            }
            y += 300;

        }
    }

}
