import java.io.File;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
public class App {
    public static void main(String[] args) throws Exception {
        //set up file and scanner stuff-----------------------------------------------------------
        File file = new File("src/Data/PokemonList.csv");
        Scanner scanner = new Scanner(file);
        Card[] pokemonCardArray = new Card[60];
        int i = 0;
        scanner.nextLine();
        //put csv file into pokemonLines array--------------------
        while (scanner.hasNext() && i < 60){
            String line = scanner.nextLine();
            //split up csv file and create card object to put in array--------
            String[] data = line.split(",");
            String name = data[1];
            String rarity = data[2];
            String url = data[3];
            Card newCard = new Card(name, rarity, url);
            pokemonCardArray[i] = newCard;
            i++;
        }
        scanner.close();

        //set up java swing-----------------------------------------------------------------------------
        Collection collection = new Collection();

        JFrame menu = new JFrame("Main Menu");
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setSize(800, 1200);

        menu.setLayout(null);

        JButton collectionButton = new JButton("Collection");
        collectionButton.setBounds(300, 200, 100, 50);
        JButton openPack = new JButton("Rip Pack");
        openPack.setBounds(300, 500, 100, 50);

        menu.add(openPack);
        menu.add(collectionButton);
        menu.setVisible(true);

        openPack.addActionListener(e -> {
            CardPack cardpack = new CardPack(15, 10);
            for (int j = 0; j < 10; j++) {
                int rand = (int)(Math.random() * 60);
                cardpack.addCard(pokemonCardArray[rand]);
            }

            Card[] openedCards = cardpack.openPack();
            collection.addCards(openedCards);
        });


        collectionButton.addActionListener(e -> {
            menu.dispose();
            collection.displayCollectionImage();
            System.out.println("Total cards in collection: " + collection.getSize());
        });
    }
}
