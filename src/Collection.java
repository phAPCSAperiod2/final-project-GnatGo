import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
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
        frame.setSize(800, 1200);
        //method that sets jframe into 4 by 4 grid
        frame.setLayout(new GridLayout(4, 4));

        for (int i = 0; i < category.size() && i < 16; i++){
            try {
                URL url = new URL(category.get(i).getCard().getImage());
                BufferedImage originalImage = ImageIO.read(url);

                //scale image
                int newWidth = 200;
                int newHeight = 300;
                //SCALE_SMOOTH prioritizes making the image look smooth
                Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

                //convert back to bufferedimage to be displayed
                BufferedImage originalScaled = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = originalScaled.createGraphics();
                g2d.drawImage(scaledImage, 0, 0, null);
                g2d.dispose();

                //display-----------------------
                frame.add(new JLabel(new ImageIcon(originalScaled)));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //.pack() scales frame to fit window size
                frame.pack();
                frame.setVisible(true);



            }
            catch (Exception e){
                frame.add(new JLabel("Error"));
            }
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
