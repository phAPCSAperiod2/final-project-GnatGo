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

    }
}
