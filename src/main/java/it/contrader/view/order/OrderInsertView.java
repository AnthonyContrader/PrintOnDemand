package it.contrader.view.order;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class OrderInsertView extends AbstractView{
	private Request request;

	//private int clientId;
	//private int itemId;
	//private String date;
	private int prezzo=10;
	private int Idcliente,iditem;
	private String immagine;
	private String link;
	//private int orderId;
	
	private final String mode = "INSERT";

	public OrderInsertView() {
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Order", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'ordine da inserire
	 */
	@Override
	public void showOptions() {
			/*System.out.println("Inserisci data dell'ordine gg/mm/aaaa:");
			date = getInput();
						idclient = Integer.parseInt(request.get("IDclient").toString());
			iditem = Integer.parseInt(request.get("IDitem").toString());
			idorder = Integer.parseInt(request.get("IDorder").toString());
			prezzo = Integer.parseInt(request.get("prezzo").toString());*/
		System.out.println("Inserisci l'id del cliente che vuole fare l'ordine:");
		Idcliente=Integer.parseInt(getInput());
		System.out.println("Inserisci l'id dell'oggetto da ordinare:");
		iditem=Integer.parseInt(getInput());
		System.out.println("Inserisci il nome dell'immagine:");
		immagine=getInput()+".jpg";
		System.out.println("Inserisci il link qr:");
		link=getInput();		
			
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("IDclient", Idcliente);
		request.put("IDitem", iditem);
		request.put("prezzo",prezzo);
		request.put("immagine",immagine);
		request.put("link", link);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Order", "doControl", request);
	}


}
