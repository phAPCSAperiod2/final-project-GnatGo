import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Collection {
    private ArrayList<CardSlot> category;
    private int pageNumber;

    public Collection(){
        category = new ArrayList<>();
        pageNumber = 0;
    }

    public int getSize(){
        return category.size();
    }

    public CardSlot getSlot(int x){
        return category.get(x);
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
        JFrame frame = new JFrame("Collection: Page " + pageNumber + 1);
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

                //display-----------------------
                frame.add(new JLabel(image));

            }
            catch (Exception e){
                System.out.println("Failed to load image at: " + category.get(i).getCard().getImage());
                System.out.println("Error: " + e.getMessage());
                frame.add(new JLabel("Error"));
            }
        }

        //move pages with arrow keys
        frame.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                int maxPage = category.size() - 1 / 16;

                if(e.getKeyCode() == KeyEvent.VK_RIGHT && pageNumber < maxPage){
                    pageNumber++;
                    frame.dispose();
                    displayCollectionImage();
                }

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
