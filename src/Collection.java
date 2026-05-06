import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Manages the user's card collection and displays it as pages of card images.
 */
public class Collection {
    private ArrayList<CardSlot> category;
    private int pageNumber;

    /**
     * Creates a new empty collection.
     */
    public Collection(){
        category = new ArrayList<>();
        pageNumber = 0;
    }

    /**
     * Returns the number of unique card slots in the collection.
     *
     * @return the number of card slots
     */
    public int getSize(){
        return category.size();
    }

    /**
     * Returns the card slot at the specified index.
     *
     * @param x the index of the card slot
     * @return the card slot at the index
     */
    public CardSlot getSlot(int x){
        return category.get(x);
    }

    /**
     * Checks whether a card with the same name is already in the collection.
     *
     * @param checkCard the card to look for
     * @return {@code true} if the card exists in the collection, otherwise {@code false}
     */
    public boolean checkCard (Card checkCard){
        for (int i = 0; i < category.size(); i++){
            if (category.get(i).getCard().getName().equals(checkCard.getName())){
                return true;
            }
        }
        return false;
    }

    /**
     * Adds an array of cards to the collection, incrementing quantity for duplicates.
     *
     * @param cardList the cards to add
     */
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

    /**
     * Displays the current page of the collection as card images in a GUI window.
     */
    public void displayCollectionImage(){
        //set up JFrame and resize
        JFrame frame = new JFrame("Collection: Page " + (pageNumber + 1));
        frame.setSize(800, 1200);

        //method that sets jframe into 4 by 4 grid
        frame.setLayout(new GridLayout(4, 4));

        //starting and ending indexes for the loop to display cards
        int startIndex = pageNumber * 16; //restarts at every 16 pages
        int endIndex = Math.min(startIndex + 16, category.size()); //either starting index + 16, or till the end of category

        for (int i = startIndex; i < endIndex; i++){
            try {
                String fileName = category.get(i).getCard().getImage() + ".png";
                String path = "src/Data/" + fileName;
                ImageIcon image = new ImageIcon(path);

                //scale image
                Image scaledImage = image.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
                image = new ImageIcon(scaledImage);

                //display
                frame.add(new JLabel(image));
            }
            catch (Exception e){
                frame.add(new JLabel("Error"));
            }
        }

        //move pages with arrow keys
        frame.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                int maxPage = category.size() - 1 / 16;

                //right arrow key
                if(e.getKeyCode() == KeyEvent.VK_RIGHT && pageNumber < maxPage){
                    pageNumber++;
                    frame.dispose(); //gets rid of frame
                    displayCollectionImage();
                }

                //left arrow key
                else if(e.getKeyCode() == KeyEvent.VK_LEFT && pageNumber > 0){
                    pageNumber--;
                    frame.dispose();
                    displayCollectionImage();
                }
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
