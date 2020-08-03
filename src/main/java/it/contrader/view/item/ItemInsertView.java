package it.contrader.view.item;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;
//import it.contrader.controller.ItemController;
//import java.lang.*;




public class ItemInsertView extends AbstractView {

	private Request request;
	private String nome;
	private String descrizione;
	private String tipo;
	private String taglia;
	private int colore;
	private String immagine;
	private String link;
	
	private final String mode = "INSERT";

	public ItemInsertView() {
	}
    
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Item", null);
		}
	}
	
	@Override
    public void showOptions()
	{
		

		System.out.println("Inserisci i campi dell'articolo:");
		System.out.println("Digita il nome dell'articolo: ");
		nome = getInput();
		System.out.println("Digita la descrizione:");
		descrizione = getInput();
		System.out.println("Digita il tipo di articolo:");
		tipo = getInput();
		System.out.println("Inserisci il colore dell'articolo:");
		colore=Integer.parseInt(getInput());
		System.out.println("Digita la taglia(se indumento):");
		taglia = getInput();
		System.out.println("Inserisci l'immagine:");
		immagine=getInput();
		System.out.println("Inserisci il link:");
		link=getInput();
		
		
	}


	@Override
	public void submit() {
		request = new Request();
		request.put("nome", nome);
		request.put("descrizione", descrizione);
		request.put("tipo", tipo);
		request.put("colore", colore);
		request.put("taglia", taglia);
		request.put("immagine", immagine);
		request.put("link", link);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Item", "doControl", request);
}


}