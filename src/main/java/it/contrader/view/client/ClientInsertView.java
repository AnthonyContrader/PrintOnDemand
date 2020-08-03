package it.contrader.view.client;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;
//import it.contrader.controller.ItemController;
//import java.lang.*;




public class ClientInsertView extends AbstractView {

	private Request request;
	private int id;
	private String nome;
	private String cognome;
	private String indirizzo;
	
	private final String mode = "INSERT";

	public ClientInsertView() {
	}
    
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Client", null);
		}
	}
	
	@Override
    public void showOptions()
	{
		

		System.out.println("Inserisci i campi dell'articolo:");
		System.out.println("Digita l'id del tuo user: ");
		id = Integer.parseInt(getInput());
		System.out.println("Digita il nome del cliente: ");
		nome = getInput();
		System.out.println("Digita il cognome del cliente: ");
		cognome = getInput();
		System.out.println("Digita l'indirizzo del cliente: ");
		indirizzo = getInput();
		
	}


	@Override
	public void submit() {
		request = new Request();
		request.put("userID", id);
		request.put("nome", nome);
		request.put("cognome", cognome);
		request.put("indirizzo", indirizzo);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Client", "doControl", request);
}


}