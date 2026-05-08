import java.awt.Font;
import java.io.File;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * This code was developed with the help of Github Copilot AI
 * Main application class for the Pokémon card pack opening simulator.
 *
 * <p>The {@code App} class loads card data from the CSV file, creates the main
 * menu GUI, and connects the pack opening, collection display, and favorites
 * management features.</p>
 */
public class App {
    /**
     * Entry point for the application.
     *
     * @param args command line arguments (not used)
     * @throws Exception if the card data file cannot be read
     */
    public static void main(String[] args) throws Exception {
        //set up file and scanner stuff-----------------------------------------------------------
        Scanner input = new Scanner(System.in);
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
        Favorite favorites = new Favorite();

        JFrame menu = new JFrame("Main Menu");
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setSize(800, 1200);

        menu.setLayout(null);

        JLabel title = new JLabel("Card Pack Opening Simulator");
        title.setBounds(80, 50, 800, 100);
        title.setFont(new Font("Arial", Font.PLAIN, 50));

        JButton collectionButton = new JButton("Collection");
        collectionButton.setBounds(300, 200, 100, 50);
        JButton openPack = new JButton("Rip Pack");
        openPack.setBounds(300, 500, 100, 50);
        JButton chaseCard = new JButton("Chase Cards");
        chaseCard.setBounds(300, 800, 100, 50);

        menu.add(title);
        menu.add(openPack);
        menu.add(collectionButton);
        menu.add(chaseCard);
        menu.setVisible(true);

        openPack.addActionListener(e -> {
            CardPack cardpack = new CardPack(15, 10);
            for (int j = 0; j < 6; j++) {
                int rand = (int)(Math.random() * 60);
                cardpack.addCard(pokemonCardArray[rand]);
            }

            Card[] openedCards = cardpack.openPack();
            collection.addCards(openedCards);
        });


        collectionButton.addActionListener(e -> {
            collection.displayCollectionImage();
            System.out.println("Total cards in collection: " + collection.getSize());
        });

        chaseCard.addActionListener(e -> {
            System.out.print("1)View Chase Cards \n2)Add Chase Card\n3)Remove Chase Card\n");
            System.out.print("Choose an action [enter number]: ");
            int userInput = input.nextInt();
            input.nextLine();
            if (userInput == 1){
                favorites.displayFavorite();
            }
            else if (userInput == 2){
                for(int k = 0; k < pokemonCardArray.length; k++){
                    System.out.println((k + 1) + ") " + pokemonCardArray[k].getName());
                }
                System.out.print("Choose a card to add: ");
                int chosenCard = input.nextInt();
                if (favorites.checkEmpty()){
                    favorites.addCard(pokemonCardArray[chosenCard - 1]);
                    System.out.println(pokemonCardArray[chosenCard - 1].getName() + " was added!");
                }
                else {
                    System.out.print("Choose a card to replace: ");
                    String replacedCard = input.nextLine();
                    favorites.replaceCard(pokemonCardArray[chosenCard - 1], replacedCard);
                }

            }

            else {
                System.out.print("Choose a card to remove: ");
                String removeCard = input.nextLine();
                favorites.removeCard(removeCard);
            }

        });
    }
}
