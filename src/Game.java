import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Game {
    private LinkedList<Card> gameDeck;
    private Stack<Card> auxDeck;
    private Card[][] gameField;
    private Card[][] finalDecks;

    public Game() {
        Deck cards = new Deck();
        auxDeck = new Stack();
        gameField = new Card[20][7];
        finalDecks = new Card[13][4];
        gameDeck = cards.getDeck();
        Collections.shuffle(gameDeck);
        startGame();
    }

    /*private void startGame2() {
        this.finalDecks[0][0] = new Card(Card.Seed.PICCHE, Card.Value.ASSO,1, Card.Color.NERO);
        this.finalDecks[0][0].setHidden(false);
        this.finalDecks[1][0] = new Card(Card.Seed.PICCHE, Card.Value.DUE,2, Card.Color.NERO);
        this.finalDecks[1][0].setHidden(false);
        this.finalDecks[2][0] = new Card(Card.Seed.PICCHE, Card.Value.TRE,3, Card.Color.NERO);
        this.finalDecks[2][0].setHidden(false);
        this.finalDecks[3][0] = new Card(Card.Seed.PICCHE, Card.Value.QUATTRO,4, Card.Color.NERO);
        this.finalDecks[3][0].setHidden(false);
        this.finalDecks[4][0] = new Card(Card.Seed.PICCHE, Card.Value.CINQUE,5, Card.Color.NERO);
        this.finalDecks[4][0].setHidden(false);
        this.finalDecks[5][0] = new Card(Card.Seed.PICCHE, Card.Value.SEI,6, Card.Color.NERO);
        this.finalDecks[5][0].setHidden(false);
        this.finalDecks[6][0] = new Card(Card.Seed.PICCHE, Card.Value.SETTE,7, Card.Color.NERO);
        this.finalDecks[6][0].setHidden(false);
        this.finalDecks[7][0] = new Card(Card.Seed.PICCHE, Card.Value.OTTO,8, Card.Color.NERO);
        this.finalDecks[7][0].setHidden(false);
        this.finalDecks[8][0] = new Card(Card.Seed.PICCHE, Card.Value.NOVE,9, Card.Color.NERO);
        this.finalDecks[8][0].setHidden(false);
        this.finalDecks[9][0] = new Card(Card.Seed.PICCHE, Card.Value.DIECI,10, Card.Color.NERO);
        this.finalDecks[9][0].setHidden(false);
        this.finalDecks[10][0] = new Card(Card.Seed.PICCHE, Card.Value.FANTE,11, Card.Color.NERO);
        this.finalDecks[10][0].setHidden(false);
        this.finalDecks[11][0] = new Card(Card.Seed.PICCHE, Card.Value.REGINA,12, Card.Color.NERO);
        this.finalDecks[11][0].setHidden(false);

        this.finalDecks[0][1] = new Card(Card.Seed.PICCHE, Card.Value.ASSO,1, Card.Color.NERO);
        this.finalDecks[0][1].setHidden(false);
        this.finalDecks[1][1] = new Card(Card.Seed.PICCHE, Card.Value.DUE,2, Card.Color.NERO);
        this.finalDecks[1][1].setHidden(false);
        this.finalDecks[2][1] = new Card(Card.Seed.PICCHE, Card.Value.TRE,3, Card.Color.NERO);
        this.finalDecks[2][1].setHidden(false);
        this.finalDecks[3][1] = new Card(Card.Seed.PICCHE, Card.Value.QUATTRO,4, Card.Color.NERO);
        this.finalDecks[3][1].setHidden(false);
        this.finalDecks[4][1] = new Card(Card.Seed.PICCHE, Card.Value.CINQUE,5, Card.Color.NERO);
        this.finalDecks[4][1].setHidden(false);
        this.finalDecks[5][1] = new Card(Card.Seed.PICCHE, Card.Value.SEI,6, Card.Color.NERO);
        this.finalDecks[5][1].setHidden(false);
        this.finalDecks[6][1] = new Card(Card.Seed.PICCHE, Card.Value.SETTE,7, Card.Color.NERO);
        this.finalDecks[6][1].setHidden(false);
        this.finalDecks[7][1] = new Card(Card.Seed.PICCHE, Card.Value.OTTO,8, Card.Color.NERO);
        this.finalDecks[7][1].setHidden(false);
        this.finalDecks[8][1] = new Card(Card.Seed.PICCHE, Card.Value.NOVE,9, Card.Color.NERO);
        this.finalDecks[8][1].setHidden(false);
        this.finalDecks[9][1] = new Card(Card.Seed.PICCHE, Card.Value.DIECI,10, Card.Color.NERO);
        this.finalDecks[9][1].setHidden(false);
        this.finalDecks[10][1] = new Card(Card.Seed.PICCHE, Card.Value.FANTE,11, Card.Color.NERO);
        this.finalDecks[10][1].setHidden(false);
        this.finalDecks[11][1] = new Card(Card.Seed.PICCHE, Card.Value.REGINA,12, Card.Color.NERO);
        this.finalDecks[11][1].setHidden(false);
        this.finalDecks[12][1] = new Card(Card.Seed.PICCHE, Card.Value.RE,13, Card.Color.NERO);
        this.finalDecks[12][1].setHidden(false);

        this.finalDecks[0][2] = new Card(Card.Seed.PICCHE, Card.Value.ASSO,1, Card.Color.NERO);
        this.finalDecks[0][2].setHidden(false);
        this.finalDecks[1][2] = new Card(Card.Seed.PICCHE, Card.Value.DUE,2, Card.Color.NERO);
        this.finalDecks[1][2].setHidden(false);
        this.finalDecks[2][2] = new Card(Card.Seed.PICCHE, Card.Value.TRE,3, Card.Color.NERO);
        this.finalDecks[2][2].setHidden(false);
        this.finalDecks[3][2] = new Card(Card.Seed.PICCHE, Card.Value.QUATTRO,4, Card.Color.NERO);
        this.finalDecks[3][2].setHidden(false);
        this.finalDecks[4][2] = new Card(Card.Seed.PICCHE, Card.Value.CINQUE,5, Card.Color.NERO);
        this.finalDecks[4][2].setHidden(false);
        this.finalDecks[5][2] = new Card(Card.Seed.PICCHE, Card.Value.SEI,6, Card.Color.NERO);
        this.finalDecks[5][2].setHidden(false);
        this.finalDecks[6][2] = new Card(Card.Seed.PICCHE, Card.Value.SETTE,7, Card.Color.NERO);
        this.finalDecks[6][2].setHidden(false);
        this.finalDecks[7][2] = new Card(Card.Seed.PICCHE, Card.Value.OTTO,8, Card.Color.NERO);
        this.finalDecks[7][2].setHidden(false);
        this.finalDecks[8][2] = new Card(Card.Seed.PICCHE, Card.Value.NOVE,9, Card.Color.NERO);
        this.finalDecks[8][2].setHidden(false);
        this.finalDecks[9][2] = new Card(Card.Seed.PICCHE, Card.Value.DIECI,10, Card.Color.NERO);
        this.finalDecks[9][2].setHidden(false);
        this.finalDecks[10][2] = new Card(Card.Seed.PICCHE, Card.Value.FANTE,11, Card.Color.NERO);
        this.finalDecks[10][2].setHidden(false);
        this.finalDecks[11][2] = new Card(Card.Seed.PICCHE, Card.Value.REGINA,12, Card.Color.NERO);
        this.finalDecks[11][2].setHidden(false);
        this.finalDecks[12][2] = new Card(Card.Seed.PICCHE, Card.Value.RE,13, Card.Color.NERO);
        this.finalDecks[12][2].setHidden(false);

        this.finalDecks[0][3] = new Card(Card.Seed.PICCHE, Card.Value.ASSO,1, Card.Color.NERO);
        this.finalDecks[0][3].setHidden(false);
        this.finalDecks[1][3] = new Card(Card.Seed.PICCHE, Card.Value.DUE,2, Card.Color.NERO);
        this.finalDecks[1][3].setHidden(false);
        this.finalDecks[2][3] = new Card(Card.Seed.PICCHE, Card.Value.TRE,3, Card.Color.NERO);
        this.finalDecks[2][3].setHidden(false);
        this.finalDecks[3][3] = new Card(Card.Seed.PICCHE, Card.Value.QUATTRO,4, Card.Color.NERO);
        this.finalDecks[3][3].setHidden(false);
        this.finalDecks[4][3] = new Card(Card.Seed.PICCHE, Card.Value.CINQUE,5, Card.Color.NERO);
        this.finalDecks[4][3].setHidden(false);
        this.finalDecks[5][3] = new Card(Card.Seed.PICCHE, Card.Value.SEI,6, Card.Color.NERO);
        this.finalDecks[5][3].setHidden(false);
        this.finalDecks[6][3] = new Card(Card.Seed.PICCHE, Card.Value.SETTE,7, Card.Color.NERO);
        this.finalDecks[6][3].setHidden(false);
        this.finalDecks[7][3] = new Card(Card.Seed.PICCHE, Card.Value.OTTO,8, Card.Color.NERO);
        this.finalDecks[7][3].setHidden(false);
        this.finalDecks[8][3] = new Card(Card.Seed.PICCHE, Card.Value.NOVE,9, Card.Color.NERO);
        this.finalDecks[8][3].setHidden(false);
        this.finalDecks[9][3] = new Card(Card.Seed.PICCHE, Card.Value.DIECI,10, Card.Color.NERO);
        this.finalDecks[9][3].setHidden(false);
        this.finalDecks[10][3] = new Card(Card.Seed.PICCHE, Card.Value.FANTE,11, Card.Color.NERO);
        this.finalDecks[10][3].setHidden(false);
        this.finalDecks[11][3] = new Card(Card.Seed.PICCHE, Card.Value.REGINA,12, Card.Color.NERO);
        this.finalDecks[11][3].setHidden(false);
        this.finalDecks[12][3] = new Card(Card.Seed.PICCHE, Card.Value.RE,13, Card.Color.NERO);
        this.finalDecks[12][3].setHidden(false);


        this.gameField[0][0] = new Card(Card.Seed.PICCHE, Card.Value.RE,13, Card.Color.NERO);
        this.gameField[0][0].setHidden(false);
        this.gameField[0][1] = new Card(Card.Seed.FIORI, Card.Value.ASSO,1, Card.Color.ROSSO);
        this.gameField[0][1].setHidden(false);

    }*/
    //Metodo che inizializza la griglia a inizio gioco
    private void startGame() {
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                this.gameField[i][j] = this.gameDeck.pop();
                if (j == i) {
                    this.gameField[i][j].setHidden(false);
                }
            }
        }
    }

    //Mostra se presente l'ultima carta del deck ausiliario
    public void showCard() {
        if (!auxDeck.isEmpty()) {
            System.out.println("Ultima carta pescata: " + auxDeck.peek());
        } //stampala
    }

    //Pesca una carta dal deck principale al deck ausiliario
    public void pickCard() {
        Iterator<Card> iterator = auxDeck.iterator();
        if (gameDeck.isEmpty()) {
            while (iterator.hasNext()) {
                Card c = iterator.next();
                c.setHidden(true);
                gameDeck.addLast(c);
            }
            auxDeck.clear();
        }
        auxDeck.push(gameDeck.pop()); //togli una carta dal mazzo principale e mettila nell'ausiliario
        auxDeck.peek().setHidden(false);
    }

    //Metodo che ritorna true se la carta da muovere sarà posizionata sopra una carta con colore diverso e valore maggiore di 1
    private boolean canMoveCard(Card c, int destRow, int destCol) throws ArrayIndexOutOfBoundsException {
        if ((destRow == 0 && c.getValues() != Card.Value.K) || (destCol > 6 || destCol < 0) || (destRow > 20 || destRow < 0)) {
            return false;
        } else return destRow == 0 && c.getValues() == Card.Value.K
                ||
                this.gameField[destRow - 1][destCol] != null &&
                        c != null &&
                        c.getColor() != this.gameField[destRow - 1][destCol].getColor() &&
                        c.getRealCardValue() == this.gameField[destRow - 1][destCol].getRealCardValue() - 1 &&
                        this.gameField[destRow][destCol] == null;
    }

    //Dal deck ausiliario al campo di gioco
    public void moveCardFromDeck(int destRow, int destCol) throws ArrayIndexOutOfBoundsException {
        if (!this.auxDeck.isEmpty() && canMoveCard(auxDeck.peek(), destRow, destCol)) {
            this.gameField[destRow][destCol] = auxDeck.pop();
        } else System.out.println("Mossa non valida");
    }

    //Muove le carte dentro il campo
    public void moveCards(int rowStart, int colStart, int rowDest, int colDest) {
        if ((rowStart >= 0 && rowStart < this.gameField.length)
                && (colStart >= 0 && colStart < this.gameField[rowStart].length)) {
            if (canMoveCard(this.gameField[rowStart][colStart], rowDest, colDest)) {//soloto controllo tra la  posizione originale e la finake
                if (rowStart > 0) {//se non siamo nella prima riga
                    this.gameField[rowStart - 1][colStart].setHidden(false);//imposta la carta precedente come visibile
                }
                do {//continua a spostare le carte finchè non trovi uno slot vuoto
                    this.gameField[rowDest][colDest] = this.gameField[rowStart][colStart];
                    this.gameField[rowStart][colStart] = null;//libera gli slot dove avevamo le carte
                    rowStart++;
                    rowDest++;
                } while (this.gameField[rowStart][colStart] != null);
            } else System.out.println("Mossa non valida");
        } else System.out.println("Hai scelto qualcosa di sbagliato!");
    }

    //Trova una riga libera dentro una colonna del deck finale
    private int whichRow(int destCol) {
        int destRow = 0;
        if (destCol >= 0 && destCol < this.finalDecks[destRow].length) {
            for (destRow = 0; destRow < this.finalDecks.length; destRow++) {
                if (this.finalDecks[destRow][destCol] == null) {
                    return destRow;
                }
            }
        }
        return destRow = this.finalDecks.length;
    }

    //Metodo di controllo se può mettere una carta all'interno del deck finale
    private boolean canMoveToFinalGrid(Card c, int destCol) throws ArrayIndexOutOfBoundsException {
        if ((destCol > 4 || destCol < 0) || (this.finalDecks[0][destCol] == null && c.getValues() != Card.Value.A)) {
            return false;
        } else {
            int destRow = whichRow(destCol);
            System.out.println(destRow);
            if (destRow == 0 && c.getValues() == Card.Value.A
                    ||
                    this.finalDecks[destRow][destCol] == null &&
                            //Aggiunta la condizione che nella riga zero deve stare solo l'asso
                            !c.getHidden() &&        // Qui non ho trovato molte informazioni in alcune versioni devi mettere il RE e in altri si mette la prima carta pescata                this.finalDecks[destRow - 1][destCol] != null &&
                            //c != null &&
                            c.getColor() == this.finalDecks[destRow - 1][destCol].getColor() &&
                            c.getSeeds() == this.finalDecks[destRow - 1][destCol].getSeeds() &&
                            c.getRealCardValue() == this.finalDecks[destRow - 1][destCol].getRealCardValue() + 1) {
                return true;
            }
        }
        return false;
    }

    //Dalla carta pescata al deck finale
    public void moveFromDeckToFinalGrid(int destCol) throws ArrayIndexOutOfBoundsException {
        if (!this.auxDeck.isEmpty() && canMoveToFinalGrid(auxDeck.peek(), destCol)) {
            this.finalDecks[whichRow(destCol)][destCol] = auxDeck.pop();
        } else System.out.println("Mossa non valida");
    }

    //Dal campo alla griglia finale
    public void moveCardToFinalGrid(int rowStart, int colStart, int colDest) {
        if ((rowStart >= 0 && rowStart < this.gameField.length)
                && (colStart >= 0 && colStart < this.gameField[rowStart].length)) {
            int rowDest = whichRow(colDest);
            if (canMoveToFinalGrid(this.gameField[rowStart][colStart], colDest)) {//soloto controllo tra la  posizione originale e la finake
                if (rowStart > 0) {//se non siamo nella prima riga
                    this.gameField[rowStart - 1][colStart].setHidden(false);//imposta la carta precedente come visibile
                }
                do {//continua a spostare le carte finchè non trovi uno slot vuoto
                    this.finalDecks[rowDest][colDest] = this.gameField[rowStart][colStart];
                    this.gameField[rowStart][colStart] = null;//libera gli slot dove avevamo le carte
                    rowStart++;
                    rowDest++;
                } while (this.gameField[rowStart][colStart] != null);
            } else System.out.println("Mossa non valida");
        } else System.out.println("Hai scelto qualcosa di sbagliato!");
    }

    //Metodo che controlla se hai vinto o meno
    public boolean win() {
        for (int x = 0; x <= this.finalDecks.length; x++) {
            for (int y = 0; y <= this.finalDecks[x].length; y++) {
                if (this.finalDecks[x][y] != null) {
                    System.out.println("yuppi");
                    return true;
                }
            }
        }
        return false;
    }
    /*
    Se nella posizione
    12-0
    12-1
    12-2
    12-3
    c'è qualcosa
    allora ritorna falso
    altrimenti ritorna vero
    */

    public boolean win2() {
        boolean winFlag = true;
        for (int i = 0; i <= 3; i++) { //Colonna
            if (this.finalDecks[12][i] != null) { //Controllo se riga non è nulla
                winFlag = false; //Se la riga non è null allora metti il flag a falso
            } else return true; //Altrimenti ritorna direttamente vero
        }
        return winFlag; //ritorna a fine ciclo il flag
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < this.gameField.length; i++) {
            result += "\n[";
            for (int j = 0; j < this.gameField[i].length; j++) {
                String value = this.gameField[i][j] != null ?
                        String.valueOf(this.gameField[i][j]) /*"card"*/ : "               ";
                if (i < 10) {
                    result += "[" + " " + i + "-" + j + " " + value + "]";
                } else
                    result += "[" + i + "-" + j + " " + value + "]";
            }
            result += "]";
        }
        String finalDecks = "";
        for (int i = 0; i < this.finalDecks.length; i++) {
            finalDecks += "\n[";
            for (int j = 0; j < this.finalDecks[i].length; j++) {
                String value = this.finalDecks[i][j] != null ?
                        String.valueOf(this.finalDecks[i][j]) /*"card"*/ : "               ";
                if (i < 10) {
                    finalDecks += "[" + " " + i + "-" + j + " " + value + "]";
                } else
                    finalDecks += "[" + i + "-" + j + " " + value + "]";
            }
            finalDecks += "]";
        }
        return finalDecks + "\n" + result;
    }


}