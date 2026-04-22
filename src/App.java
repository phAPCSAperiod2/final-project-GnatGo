public class App {
    public static void main(String[] args) throws Exception {
<<<<<<< HEAD
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
=======
        //initial cards-----------------------------------
        Card mew = new Card("Mew", "super rare");
        Card bulbasaur = new Card("Bulbasaur", "rare");
        Card altaria = new Card("Altaria", "rare");
        Card starly = new Card("Starly", "common");
        Card wingull = new Card("Wingull", "common");
        Card psyduck = new Card("Psyduck", "common");

        CardPack pack = new CardPack(15, 3);
>>>>>>> parent of 86d02d6 (Can generate random cards with csv file)

        Collection collection = new Collection();
<<<<<<< HEAD
        CardPack pack = new CardPack(15, 30);
        for (int j = 0; j < 30; j++){
            int rand = (int)(Math.random() * 60);
            pack.addCard(pokemonCardArray[rand]);
        }
        Card[] openCards = pack.openPack();
        collection.addCards(openCards);
        collection.displayCollectionImage();
=======

        System.out.println("Adding cards: ");
        pack.addCard(altaria);
        pack.addCard(bulbasaur);
        pack.addCard(mew);

        System.out.println("Opening pack: ");
        Card[] opened = pack.openPack();
        collection.addCards(opened);
        collection.displayCollection();
>>>>>>> parent of 86d02d6 (Can generate random cards with csv file)



    }
}
