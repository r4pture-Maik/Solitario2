import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Game solitaire = new Game();
        System.out.println("Campo di gioco: \n "+solitaire.toString());
        Scanner input = new Scanner(System.in);
        do {
            int destRow, destCol, startRow, startCol, choose=0;
            //semplice try e catch per controllare che non si mettano robe strane nell'input
            try{
                choose = input.nextInt();
            }
            catch (Exception e){
                System.out.println("Errore input!");
                input.next(); //pulisce lo scanner
            }
//qua
            //implementato switch case

            switch (choose) {

                //Pick 1 card from deck
                case 1:
                    //System.out.println("Campo di gioco:\n"+solitaire.toString());
                    //System.out.println("\nI quattro mazzi: \n"+solitaire.toStringFinalGrid());
                    solitaire.pickCard();solitaire.pickCard();solitaire.pickCard();solitaire.pickCard();solitaire.pickCard();
                    solitaire.pickCard();solitaire.pickCard();solitaire.pickCard();solitaire.pickCard();solitaire.pickCard();
                    solitaire.pickCard();solitaire.pickCard();solitaire.pickCard();solitaire.pickCard();solitaire.pickCard();
                    solitaire.pickCard();solitaire.pickCard();solitaire.pickCard();solitaire.pickCard();solitaire.pickCard();
                    solitaire.pickCard();solitaire.pickCard();solitaire.pickCard();solitaire.pickCard();
                    solitaire.deckSize();
                    solitaire.pickCard();
                    //solitaire.showCard();
                    break;

                //Pick card from deck and move to field
                case 2:

                        destRow = input.nextInt();
                        destCol = input.nextInt();
                        solitaire.moveCardFromDeck(destRow, destCol);
                        System.out.println(solitaire.toString());
                        solitaire.showCard();

                    break;

                //Move card inside field
                case 5:
                    startRow = input.nextInt();
                    startCol = input.nextInt();
                    destRow = input.nextInt();
                    destCol = input.nextInt();
                    solitaire.moveCards(startRow,startCol,destRow,destCol);
                    System.out.println(solitaire.toString());
                    solitaire.showCard();
                    break;
                case 6:
                    destCol = input.nextInt();
                    solitaire.moveFromDeckToFinalGrid(destCol);
                    System.out.println(solitaire.whichRow(destCol));
                    System.out.println(solitaire.toString());
                    System.out.println(solitaire.toStringFinalGrid());
                    solitaire.showCard();
                    break;
                case 7:
                    startRow = input.nextInt();
                    startCol = input.nextInt();
                    destCol = input.nextInt();
                    solitaire.moveCardToFinalGrid(startRow,startCol,destCol);
                    System.out.println("Campo di gioco:\n"+solitaire.toString());
                    System.out.println("\nI quattro mazzi: \n"+solitaire.toStringFinalGrid());
                    solitaire.showCard();
                    break;


                default:
                    System.out.println("Qualcosa è andato storto");
                    break;

            }
                /*}else if (choose == 3) {
                int x = s.nextInt();//riga inizio pila
                int y = s.nextInt();// colonna inizio pila
                int k = s.nextInt();// colonna fine pila
                //g.cardGroup(x,y,k);
                int i = s.nextInt();// riga finale
                int j = s.nextInt();// colonna finale
                g.moveCardGroup(x,y,k, i,j);
                System.out.println(g.toString());*/
        }while (!solitaire.win());
    }
}
