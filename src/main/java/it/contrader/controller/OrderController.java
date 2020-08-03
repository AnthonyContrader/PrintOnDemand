package it.contrader.controller;


import java.util.List;

import it.contrader.dto.ItemDTO;
import it.contrader.dto.OrderDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.OrderService;

/**
 * 
 * @author Vittorio
 *
 *Si osservi che nel Controller compaiono solo oggetti del DTO e non del Model!
 */
public class OrderController implements Controller {

	/**
	 * definisce il pacchetto di vista user.
	 */
	private static String sub_package = "order.";
	
	private OrderService orderService;
	/**
	 * Costruisce un oggetto di tipo UserService per poterne usare i metodi
	 */
	public OrderController() {
		this.orderService = new OrderService();
	}
	
public void doControl(Request request) {
		
		//Estrae dalla request mode e choice
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		 int idclient;
		 int iditem;
		 int idorder;
		 int prezzo;
		 String data,immagine,link;
		 
		
		switch (mode) {
		
		// Arriva qui dalla UserReadView. Invoca il Service con il parametro id e invia alla UserReadView uno user da mostrare 
		case "READ":
			idorder = Integer.parseInt(request.get("id").toString());
			List<OrderDTO> orderDTO = orderService.read(idorder);
			request.put("order", orderDTO);
			MainDispatcher.getInstance().callView(sub_package + "OrderRead", request);
			break;
		
		// Arriva qui dalla OrderInsertView. Estrae i parametri da inserire e chiama il service per inserire uno user con questi parametri
		case "INSERT":
			
			idclient = Integer.parseInt(request.get("IDclient").toString());
			iditem = Integer.parseInt(request.get("IDitem").toString());
			//idorder = Integer.parseInt(request.get("IDorder").toString());
			prezzo = Integer.parseInt(request.get("prezzo").toString());
			//data = request.get("data").toString();
			immagine=request.get("immagine").toString();
			link=request.get("link").toString();
			
			
			
			//costruisce l'oggetto order da inserire
			OrderDTO orderToInsert = new OrderDTO(idclient,iditem,"0",prezzo,0);
			
			ItemDTO itemToInsert = new ItemDTO("0","0","0",0,"0",immagine,link,iditem);
			//invoca il service
			
			orderService.insert(orderToInsert,itemToInsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "OrderInsert", request);
			break;
		
		// Arriva qui dalla UserDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
			
			//la cancellazione abbiamo detto che non la puo fare l'utente ma solo admin giusto?
			
		/*case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			//Qui chiama il service
			userService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "UserDelete", request);
			break;*/ 
		
		// Arriva qui dalla UserUpdateView
		/*case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			username = request.get("username").toString();
			password = request.get("password").toString();
			usertype = request.get("usertype").toString();
			UserDTO usertoupdate = new UserDTO(username, password, usertype);
			usertoupdate.setId(id);
			userService.update(usertoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "UserUpdate", request);
			break;*/
			
		//Arriva qui dalla UserView Invoca il Service e invia alla UserView il risultato da mostrare 
		case "ORDERLIST":
			
			List<OrderDTO> ordersDTO = orderService.getAll();
			//Impacchetta la request con la lista degli user
			
			request.put("orders", ordersDTO);
			
			MainDispatcher.getInstance().callView("Order", request);
			break;
			
		
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
			
			
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "OrderRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "OrderInsert", null);
				break;
				
			/*case "M":
				MainDispatcher.getInstance().callView(sub_package + "UserUpdate", null);
				break;*/
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "OrderDelete", null);
				break;
				
			/*case "O":
				MainDispatcher.getInstance().callView(sub_package + "OrderOrder", null);
				break;*/
				
			case "E":
				MainDispatcher.getInstance().callView("Register", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
}