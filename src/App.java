public class App {
    public static void main(String[] args) throws Exception {
        //initial cards-----------------------------------
        Card mew = new Card("Mew", "super rare");
        Card bulbasaur = new Card("Bulbasaur", "rare");
        Card altaria = new Card("Altaria", "rare");
        Card starly = new Card("Starly", "common");
        Card wingull = new Card("Wingull", "common");
        Card psyduck = new Card("Psyduck", "common");

        CardPack pack = new CardPack(15, 3);

        Collection collection = new Collection();

        System.out.println("Adding cards: ");
        pack.addCard(altaria);
        pack.addCard(bulbasaur);
        pack.addCard(mew);

        System.out.println("Opening pack: ");
        Card[] opened = pack.openPack();
        collection.addCards(opened);
        collection.displayCollection();



    }
}
