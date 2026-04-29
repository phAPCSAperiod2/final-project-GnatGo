public class Favorite {
    private Card[][] favoritesList;

    public Favorite(){
        favoritesList = new Card[4][4];
    }

    public boolean checkCard(int x, int y, Card card){
        if (favoritesList[x][y] == null){
            return false;
        }
        else if (!favoritesList[x][y].getName().equals(card.getName())){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean addCard(Card card){
        for (int i = 0; i < favoritesList.length; i++){
            for (int j = 0; j < favoritesList[0].length; j++){
                if (favoritesList[i][j] == null){
                    favoritesList[i][j] = card;
                    return true;
                }
            }
        }
        return false;
    }

    public void replaceCard(Card addedCard, String replacedCard){
        for (int i = 0; i < favoritesList.length; i++){
            for (int j = 0; j < favoritesList[0].length; j++){
                if (favoritesList[i][j].getName().equalsIgnoreCase(replacedCard)){
                    favoritesList[i][j] = addedCard;
                }
            }
        }
    }

}
