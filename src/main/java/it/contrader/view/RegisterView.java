/**
 * Manage a Business Owner view
 */

package it.contrader.view;


/**
 * Per Ulteriori dettagli vedi Guida sez 9 View.
 * Per la descrizione dei metodi vedi l'interfaccia View in questo pacchetto.
 */
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class RegisterView extends AbstractView {

    private String choice;
    
	private Request request;
	private static String sub_package = "user.";

	/**
	 * Se la request non è nulla mostra un messaggio di benvenuto
	 */
    public void showResults(Request request) {
    }


    /**
     * Chiede all'utente di effettuare una scelta (da console)
     */
    public void showOptions() {
        System.out.println("-------------MENU------------\n");
        System.out.println(" Seleziona cosa vuoi fare:");
        System.out.println("[R]egistrati  [L]ogin");
        //Il metodo che salva l'input nella stringa choice.
        //getInput() è definito in AbstractView.
        choice = this.getInput();
    }

    /**
     * Impacchetta una request (in base alla scelta sarà diversa) che invia ai controller tramite il
     * Dispatcher
     */
    @Override
    public void submit() {    
    	//crea una nuova Request (vedi classe Request)
    	request = new Request();
        switch (choice) {
        
     
        case "r":
    		request.put("choice", choice);
    		request.put("mode", "GETCHOICE");
        	MainDispatcher.getInstance().callAction("User", "doControl", request);
        	break;
		
        case "l":
        	MainDispatcher.getInstance().callAction("Login", "doControl", null);
        	break; 
        	
        	
       default:
        	
            request.put("choice", choice);
        	MainDispatcher.getInstance().callAction("Register", "doControl", request);
        }
    }
}
