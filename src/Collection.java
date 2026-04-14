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
        for (int i = 0; i < category.size(); i++){
            System.out.print(category.get(i).getName() + " ");
            if ((i + 1) % 4 == 0){
                System.out.println();
            }

        }
    }
}
