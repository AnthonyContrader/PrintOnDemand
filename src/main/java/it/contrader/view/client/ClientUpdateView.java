package it.contrader.view.client;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class ClientUpdateView extends AbstractView {
	private Request request;

	private int id;
	private String nome;
	private String cognome;
	private String indirizzo;
	private final String mode = "UPDATE";

	public ClientUpdateView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Client", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da modificare
	 */
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id del cliente:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci il nuovo nome:");
			nome = getInput();
			System.out.println("Inserisci il nuovo cognome:");
			cognome = getInput();
			System.out.println("Inserisci il nuovo indirizzo:");
			indirizzo= getInput();
		} catch (Exception e) {

		}
	}


	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("nome", nome);
		request.put("cognome", cognome);
		request.put("indirizzo", indirizzo);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Client", "doControl", request);
	}

}
