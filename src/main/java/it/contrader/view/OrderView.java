package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.OrderDTO;
import it.contrader.main.MainDispatcher;


/**
 * 
 * @author Vittorio
 *
 * Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */
public class OrderView extends AbstractView {

	private Request request;
	private String choice;

	public OrderView() {
		
	}

	/**
	 * Mostra la lista utenti
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n----------------------------- Gestione utenti --------------------------\n");
			System.out.println("IDClient\tIDItem\tData\tPrezzo\tIDOrdine");
			System.out.println("------------------------------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<OrderDTO> order = (List<OrderDTO>) request.get("orders");
			for (OrderDTO u: order)
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
		System.out.println("[L]eggi [I]nserisci  [C]ancella [B]ack [E]sci");

		this.choice = getInput();

		
	}
	
	/**
	 * Impacchetta la request e la manda allo UserController.
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Order", "doControl", this.request);
	}

}
