import java.awt.GridLayout;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Collection {
    private ArrayList<CardSlot> category;

    public Collection(){
        category = new ArrayList<>();
    }

    public boolean checkCard (Card checkCard){
        for (int i = 0; i < category.size(); i++){
            if (category.get(i).getCard().getName().equals(checkCard.getName())){
                return true;
            }
        }
        return false;
    }

    public void addCards (Card[] cardList){
        for (Card card : cardList){
            if (checkCard(card)){
                for (int i = 0; i < category.size(); i++){
                    if (card.getName().equals(category.get(i).getCard().getName())){
                        category.get(i).addAmount(1);
                        break;
                    }
                }
            }
            else {
                CardSlot newCard = new CardSlot(card, 1);
                category.add(newCard);
            }
        }
    }

    public void displayCollectionImage(){
        JFrame frame = new JFrame("Collection");
        frame.setSize(800, 800);
        //method that sets jframe into 4 by 4 grid
        frame.setLayout(new GridLayout(4, 4));

        for (int i = 0; i < category.size() && i < 16; i++){
            try {
                String url = category.get(i).getCard().getImage();

                ImageIcon icon = new ImageIcon(new URL(url));
                JLabel label = new JLabel(icon);

                frame.add(label);
            }
            catch (Exception e){
                frame.add(new JLabel("Error"));
            }
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
