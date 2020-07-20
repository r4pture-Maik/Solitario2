import java.util.Stack;
public class Game {
    private Stack<Card> gameDeck;
    private Stack<Card> auxDeck;
    private Card[][] gameField;
    private Card[][] finalDecks;

    public Game(){
        Deck cards = new Deck();
        auxDeck = new Stack<>();
        gameField = new Card[20][7];
        finalDecks = new Card[13][4];
        gameDeck = cards.getDeck();
        //Collections.shuffle(gameDeck);
        startGame2();

    }

    private void startGame2() {
        this.gameField[0][0] = new Card(Card.Seed.PICCHE, Card.Value.RE,13, Card.Color.NERO);
        this.gameField[0][0].setHidden(false);
        this.gameField[1][0] = new Card(Card.Seed.QUADRI, Card.Value.REGINA,12, Card.Color.ROSSO);
        this.gameField[1][0].setHidden(false);
        this.gameField[2][0] = new Card(Card.Seed.FIORI, Card.Value.FANTE,11, Card.Color.NERO);
        this.gameField[2][0].setHidden(false);
        this.gameField[3][0] = new Card(Card.Seed.QUADRI, Card.Value.DIECI,10, Card.Color.ROSSO);
        this.gameField[3][0].setHidden(false);
        this.gameField[0][1] = new Card(Card.Seed.FIORI, Card.Value.RE,13, Card.Color.NERO);
        this.gameField[0][1].setHidden(false);
        this.gameField[0][2] = new Card(Card.Seed.PICCHE, Card.Value.FANTE,11, Card.Color.NERO);
        this.gameField[0][2].setHidden(false);
    }


    // metodo che inizializza la griglia a inizio gioco
    private void startGame(){
        for (int i = 0; i <= 6; i++){
            for (int j = i; j <= 6; j++){
                this.gameField[i][j] = this.gameDeck.pop();//tolto l'else in quanto superfluo
                if (j==i){
                    this.gameField[i][j].setHidden(false);
                }
            }
        }
    }

    /* metodo che se invocato mostra l'ultima carta del mazzo principale, la sposta in un mazzo ausiliario
       se il mazzo principale è vuoto, verrà rimpiazzato dal mazzo ausiliario che verrà azzerato.
       Appunti: array circolare per il gamedeck.
       Cambiare l'input dello spostamento: da riga e colonna a solo colonna di destinazione
       Appunti2 parte 2: migliorare l'indentazione che ora fa schifo
     */


    /*public Card showCard(){
        if (gameDeck.size()==0) {
            gameDeck = auxDeck;
            auxDeck.clear();
        }
            auxDeck.push(gameDeck.pop());
            auxDeck.peek().setHidden(false);
            System.out.println(auxDeck.peek());
            return auxDeck.peek();
    }*/
    public void showCard(){
        //se non è vuoto allora:
        if(!auxDeck.isEmpty()) {System.out.println(auxDeck.peek());} //stampala
    }

    public void pickCard(){
        if (gameDeck.isEmpty()){ //se il mazzo principale è vuoto, riempilo con le carte del mazzo ausiliario
            for (int i = 0; i<=auxDeck.size(); i++){
                gameDeck.push(auxDeck.pop());
            }
        }
        auxDeck.push(gameDeck.pop()); //togli una carta dal mazzo principale e mettila nell'ausiliario
        auxDeck.peek().setHidden(false); // imposta l'ultima carta dell'ausiliario come scoperta
    }

    //Metodo che ritorna true se la carta da muovere sarà posizionata sopra una carta con colore diverso e valore maggiore di 1
    public boolean canMoveCard(Card c, int destRow, int destCol) throws ArrayIndexOutOfBoundsException{
        if (destRow==0 &&
                c != null &&
                this.gameField[destRow][destCol] == null &&
                c.getValues()==Card.Value.RE && //Aggiunta la condizione che nella riga zero deve stare solo il RE
                !c.getHidden()
                // Qui non ho trovato molte informazioni in alcune versioni devi mettere il RE e in altri si mette la prima carta pescata
                || //Dato che i due if ritornano entrambi true li ho messi in OR
                this.gameField[destRow-1][destCol] != null &&
                        c != null &&
                        c.getColor() != this.gameField[destRow-1][destCol].getColor() &&
                        c.getRealCardValue() == this.gameField[destRow-1][destCol].getRealCardValue()-1 &&
                        this.gameField[destRow][destCol] == null &&
                        destCol >= 0 &&
                        destCol <= 6) {
            return true;
        } else return false;
    }


    //Metodo che sposta le carte dal mazzo ausiliario alla griglia di gioco
    public void moveCardFromDeck(int destRow, int destCol) throws ArrayIndexOutOfBoundsException{
        if (canMoveCard(auxDeck.peek(), destRow, destCol)){
            this.gameField[destRow][destCol] = auxDeck.pop();
        }else System.out.println("Mossa non valida");
    }

    //Metodo che sposta le carte all'interno della griglia di gioco **OBSOLETO**
 /*   public void moveCardFromGrid(int rowStart, int colStart, int rowDest, int colDest) throws ArrayIndexOutOfBoundsException{
        if ((rowStart >= 0 && rowStart < this.gameField.length)
            && (colStart >= 0 && colStart < this.gameField[rowStart].length)){

            if (canMoveCard(this.gameField[rowStart][colStart], rowDest, colDest) && this.gameField[rowStart+1][colStart]==null){
                this.gameField[rowDest][colDest] = this.gameField[rowStart][colStart];
                this.gameField[rowStart][colStart] = null;

        }
        }else System.out.println("Mossa non valida");
    }*/

    //Si deve fare si che si sceglie la carta e poi solo la colonna di destinazione
    // Per ora funziona
    public void moveCardGroup(int rowStart, int colStart, int rowDest, int colDest){
        if ((rowStart >= 0 && rowStart < this.gameField.length)
                && (colStart >= 0 && colStart < this.gameField[rowStart].length)){
            if (canMoveCard(this.gameField[rowStart][colStart], rowDest, colDest)){//soloto controllo tra la  posizione originale e la finake
                if (rowStart > 0) {//se non siamo nella prima riga
                    this.gameField[rowStart - 1][colStart].setHidden(false);//imposta la carta precedente come visibile
                }
                do {//continua a spostare le carte finchè non trovi uno slot vuoto
                    this.gameField[rowDest][colDest]=this.gameField[rowStart][colStart];
                    this.gameField[rowStart][colStart]=null;//libera gli slot dove avevamo le carte
                    rowStart ++;
                    rowDest ++;
                }while(this.gameField[rowStart][colStart]!=null);
            }else System.out.println("Mossa non valida");
        }else System.out.println("Hai scelto qualcosa di sbagliato!");
    }


    //Bisogna creare il "posto" per gli assi e quindi i 4 mazzi ausiliari per vincere

    public String toString() {
        String result = "";
        for (int i = 0; i < this.gameField.length; i++) {
            result += "\n[";
            for (int j = 0; j < this.gameField[i].length; j++) {
                String value = this.gameField[i][j] != null ?
                        String.valueOf(this.gameField[i][j]) /*"card"*/ : "               ";
                result += "[" + value +i+j+ "]";
            }
            result += "]";
        }
        return result;
    }
}
