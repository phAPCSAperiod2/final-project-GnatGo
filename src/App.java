import java.io.File;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        //set up file and scanner stuff------------------------
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

        //user input--------------------------------
        Collection collection = new Collection();
        CardPack pack = new CardPack(15, 30);
        for (int j = 0; j < 30; j++){
            int rand = (int)(Math.random() * 60);
            pack.addCard(pokemonCardArray[rand]);
        }
        Card[] openCards = pack.openPack();
        collection.addCards(openCards);
        collection.displayCollectionImage();





    }
}
