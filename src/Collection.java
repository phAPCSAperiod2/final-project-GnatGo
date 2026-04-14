public class Collection {
    private CardSlot[][] category;

    public Collection(){
        category = new CardSlot[4][4];
    }

    public void addToCollection(Card compareCard){
        for (int i = 0; i < category.length; i++){
            for (int j = 0; j < category[0].length; j++){
                if (compareCard.getName().equals(category[i][j].getName())){
                    category[i][j].addAmount(1);
                    break;
                }
            }
        }

    }
}
