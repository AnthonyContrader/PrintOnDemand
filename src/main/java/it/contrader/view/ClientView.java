package it.contrader.view;

import java.util.List;


import it.contrader.controller.Request;
import it.contrader.dto.ClientDTO;
import it.contrader.main.MainDispatcher;



/*il programma è nostro!*/


public class ClientView extends AbstractView {

	private Request request;
	private String choice;

	public ClientView() {
		
	}

	/**
	 * Mostra la lista clienti
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n-----------------------------  Lista Clienti--------------------------\n");
			System.out.println("IDUtente\tNome\tCognome\tIndirizzo\tIDCliente");
			System.out.println("------------------------------------- ---------- -------------------------\n");
			//MainDispatcher.getInstance().callView("client.ClientRead", null);
			@SuppressWarnings("unchecked")
			List<ClientDTO> clients = (List<ClientDTO>) request.get("clients");
			for (ClientDTO u: clients)
				System.out.println(u);
			System.out.println();
		}
	}

	/**
	 * Chiede all'utente un input (lettera da tastiera) per la choice (vedi UserController). 
	 * Mette la modalità GETCHOICE nella mode.
	 */
	@Override
	public void showOptions() {

		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [C]ancella [A]ggiorna [B]ack [E]sci");
		this.choice=this.getInput();
		
	}
		
	
	/**
	 * Impacchetta la request e la manda allo ClientController.
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Client", "doControl", this.request);
	}

    }
	
