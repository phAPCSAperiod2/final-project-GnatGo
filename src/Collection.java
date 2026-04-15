import java.util.ArrayList;

public class Collection {
    private ArrayList<CardSlot> category;

    public Collection(){
        category = new ArrayList<>();
    }

    public boolean checkCard (Card card){
        for (int i = 0; i < category.size(); i++){
            if (category.get(i).getName().equals(card.getName())){
                return true;
            }
        }
        return false;
    }

    public void addCards (Card[] cardList){
        for (Card card : cardList){
            if (checkCard(card)){
                for (int i = 0; i < category.size(); i++){
                    if (card.getName().equals(category.get(i).getName())){
                        category.get(i).addAmount(1);
                        break;
                    }
                }
            }
            else {
                CardSlot newCard = new CardSlot(card.getName(), 1);
                category.add(newCard);
            }
        }
    }

    public void upgrade (String card){
        boolean found = false;
        for (int i = 0; i < category.size(); i++){
            if (card.equals(category.get(i).getName())){
                if (!category.get(i).checkMaxTier()){
                    System.out.println("Your card is already upgraded to the max.");
                    found = true;
                    break;
                }
                else {
                    System.out.println("You upgraded your card!");
                    category.get(i).subtractAmount(5);
                    category.get(i).upgradeCard();
                    found = true;
                    break;
                }
            }
        }
        if (!found){
            System.out.println("This card isn't in your collection.");
        }
    }

    public void displayCollection(){
        int PAGE_SIZE = 16;
        int TOTAL_CARDS = category.size();
        int TOTAL_PAGE = (TOTAL_CARDS + PAGE_SIZE - 1) / PAGE_SIZE;
        //for each page
        for (int page = 0; page < TOTAL_PAGE; page++){
            System.out.println("Page " + (page + 1) + ": ");
            CardSlot[][] pageGrid = new CardSlot[4][4];
            //add to grid
            int index = page * PAGE_SIZE;
            for (int i = 0; i < 4; i++){
                for (int j = 0; j < 4; j++){
                    if (index < TOTAL_CARDS){
                        pageGrid[i][j] = category.get(index);
                        index++;
                    }
                    else {
                        pageGrid[i][j] = null;
                    }
                }
            }
            //print grid
            for (int i = 0; i < 4; i++){
                for (int j = 0; j < 4; j++){
                    if (pageGrid[i][j] != null){
                        System.out.print(pageGrid[i][j].getName() + "  ");
                    }
                    else {
                        System.out.print("---   ");
                    }
                }
                System.out.println();
            }
        }
    }
}
