package it.contrader.view;

import java.util.List;


import it.contrader.controller.Request;
import it.contrader.dto.ItemDTO;
import it.contrader.main.MainDispatcher;


/*il programma è nostro!*/


public class ItemUserView extends AbstractView {

	private Request request;
	private String choice;

	public ItemUserView() {
		
	}

	/**
	 * Mostra la lista item
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n-----------------------------  Lista Oggetti--------------------------\n");
			System.out.println("Nome\tDescrizione\tTipo\tColore\tTaglia\tImmagine\tLink\tID");
			System.out.println("------------------------------------- ---------- -------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<ItemDTO> items = (List<ItemDTO>) request.get("items");
			for (ItemDTO u: items)
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
		
		System.out.println("[L]eggi [S]earch [B]ack [E]sci");
		this.choice= this.getInput();
		

	}
		
	
	/**
	 * Impacchetta la request e la manda allo ItemController.
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICEUSER");
		MainDispatcher.getInstance().callAction("Item", "doControl", this.request);
	}

    }
	
