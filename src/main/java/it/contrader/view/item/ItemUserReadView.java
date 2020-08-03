package it.contrader.view.item;

import it.contrader.controller.Request;

import it.contrader.dto.ItemDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

	public class ItemUserReadView extends AbstractView {
		
		private int id;
		private Request request;
		private final String mode = "READUSER";

		public ItemUserReadView() {
		}

		/**
		 * Se la request è null (ovvero quando arriva dal controller con mode GETCHOICE e choice L 
		 * il metodo è vuoto.
		 * 
		 * Altrimenti se arriva con uno user nella request (ovvero quando arriva
		 * dal controller con mode READ) mostra lo user. In questo caso torna alla UserView senza eseguire
		 * gli altri due metodi
		 */
		@Override
		public void showResults(Request request) {
			if (request != null) {
				ItemDTO item = (ItemDTO) request.get("item");
				System.out.println(item);
				MainDispatcher.getInstance().callView("ItemUser", null);
			}
		}

		
		@Override
		public void showOptions() {
			
			System.out.println("Inserisci l'ID dell'articolo:");
			id = Integer.parseInt(getInput());
		}
			
			
			/*
			int idToRead;
			System.out.println("Inserisci l'ID dell'item:");

			try {
				idToRead = Integer.parseInt(getInput());
				ItemDTO itemDB = itemController.readItem(idToRead);

				System.out.println("Id: " + itemDB.getId());
				System.out.println("nome: " + itemDB.getName());
				System.out.println("Descrizione : " + itemDB.getDesc());
				System.out.println("Tipo : " + itemDB.getItemtype());
				System.out.println("Colore : " + itemDB.getColor());
				System.out.println("Taglia : " +itemDB.getSize());
				System.out.println("Immagine : " +itemDB.getImage());
				System.out.println("QRCode: " + itemDB.getQRLink());
				
				//Wait user to show
				System.out.println("Premi un tasto per continuare");
				try {
					getInput();
				} catch (Exception e) {
					
				}

			} catch (Exception e) {
				System.out.println("Valore inserito errato.");
			}
		}
*/

		/**
		 * impacchetta una request con l'id dell'utente da leggere e la manda al controller tramite il Dispatcher
		 */
		@Override
		
			public void submit() {
				request = new Request();
				request.put("id", id);
				request.put("mode", mode);
				MainDispatcher.getInstance().callAction("Item", "doControl", request);
			}
			/*
			request = new Request();
			request.put("mode", "L");
			request.put("choice", mode);
			MainDispatcher.getInstance().callAction("Item", "doControl", request);
		}*/

	}

