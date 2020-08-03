package it.contrader.controller;

import java.util.List;


//import it.contrader.model.User;
import it.contrader.dto.ItemDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.ItemService;


public class ItemController implements Controller {

	private static String sub_package = "item.";
	private ItemService itemService;
	//private Request request;
	/**
	 * Costruisce un oggetto di tipo UserService per poterne usare i metodi
	 */
	public ItemController() {
		this.itemService = new ItemService();
	}
	   	
    	
    	/**
    	 * Metodo dell'interfaccia Controller. Estrae dalla request la mode
    	 * (che riceve dalle view specifiche e può essere la richesta di una 
    	 * scelta da parte dell'utente "GETCHOICE") e la scelta dell'utente.
    	 * 
    	 * Se la modalità corrisponde ad una CRUD il controller chiama i service,
    	 * altrimenti rimanda alla View della CRUD per richiedere i parametri
    	 */
    	@Override
    	public void doControl(Request request) {
    		
    		//Estrae dalla request mode e choice
    		String mode = (String) request.get("mode");
    		
    		String choice = (String) request.get("choice");

    		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
    	     int id;
    		 String nome;
    		 String desc;
    		 String tipo="";
    		 int colore;
    		 String taglia;
    		 String immagine;
    		 String QRLink;
    		 
    		switch (mode) {
    		
    		// Arriva qui dalla UserReadView. Invoca il Service con il parametro id e invia alla UserReadView uno user da mostrare 
    		case "READ":
    			id = Integer.parseInt(request.get("id").toString());
    			ItemDTO itemDTO =itemService.read(id);
    			request.put("item", itemDTO);
    			MainDispatcher.getInstance().callView(sub_package + "ItemRead", request);
    			break;
    		case "READUSER":
    			id = Integer.parseInt(request.get("id").toString());
    			ItemDTO itemuDTO =itemService.read(id);
    			request.put("item", itemuDTO);
    			MainDispatcher.getInstance().callView(sub_package + "ItemUserRead", request);
    			break;
    		
    		// Arriva qui dalla UserInsertView. Estrae i parametri da inserire e chiama il service per inserire uno user con questi parametri
    		case "INSERT":
    			nome = request.get("nome").toString();
    			desc = request.get("descrizione").toString();
    			tipo = request.get("tipo").toString();
    			colore = Integer.parseInt(request.get("colore").toString());
    			taglia = request.get("taglia").toString();
    			immagine = request.get("immagine").toString();
    			QRLink = request.get("link").toString();
    			
    			//costruisce l'oggetto user da inserire
    			ItemDTO itemToInsert = new ItemDTO(nome,desc, tipo, colore, taglia, immagine, QRLink);
    			//invoca il service
    			itemService.insert(itemToInsert);
    			request = new Request();
    			request.put("mode", "mode");
    			//Rimanda alla view con la risposta
    			MainDispatcher.getInstance().callView(sub_package + "ItemInsert", request);
    			break;
    		
    		// Arriva qui dalla UserDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
    		case "DELETE":
    			id = Integer.parseInt(request.get("id").toString());
    			//Qui chiama il service
    			itemService.delete(id);
    			request = new Request();
    			request.put("mode", "mode");
    			MainDispatcher.getInstance().callView(sub_package + "ItemDelete", request);
    			break;
    		case "SEARCH":
    			//Qui chiama il service
    			List<ItemDTO>item = itemService.search(request.get("tipo").toString());
    			request = new Request();
    			request.put("mode", "mode");
    			request.put("item", item);
    			MainDispatcher.getInstance().callView(sub_package + "ItemSearch", request);
    			break;    		
    			/*
    		// Arriva qui dalla UserUpdateView
    		case "UPDATE":
    			id = Integer.parseInt(request.get("id").toString());
    			nome = request.get("username").toString();
    			password = request.get("password").toString();
    			usertype = request.get("usertype").toString();
    			UserDTO usertoupdate = new UserDTO(username, password, usertype);
    			usertoupdate.setId(id);
    			userService.update(usertoupdate);
    			request = new Request();
    			request.put("mode", "mode");
    			MainDispatcher.getInstance().callView(sub_package + "UserUpdate", request);
    			break;
    			*/
    			
    		//Arriva qui dalla UserView Invoca il Service e invia alla UserView il risultato da mostrare 
    			
    		case "ITEMLIST":
			List<ItemDTO> itemsDTO = itemService.getAll();
			request.put("items", itemsDTO);
			MainDispatcher.getInstance().callView("Item", request);
			break;
    		case "ITEMUSERLIST":
    		List<ItemDTO> itemsuDTO = itemService.getAll();
    		request.put("items", itemsuDTO);
    		MainDispatcher.getInstance().callView("ItemUser", request);    			
			break;
    			
    		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
    		//con REQUEST NULL (vedi una View specifica)
			
			
    		case "GETCHOICE":
    					
    					//toUpperCase() mette in maiuscolo la scelta
    			switch (choice.toUpperCase()) {
    			
    			
    			case "L":
    				MainDispatcher.getInstance().callView(sub_package + "ItemRead", null);
    				break;
    				
    			case "I":
    				MainDispatcher.getInstance().callView(sub_package + "ItemInsert", null);
    				break;
    				
    			/*case "M":
    				MainDispatcher.getInstance().callView(sub_package + "UserUpdate", null);
    				break;*/
    				
    			case "C":
    				MainDispatcher.getInstance().callView(sub_package + "ItemDelete", null);
    				break;
    				
    			//case "O":
    				//MainDispatcher.getInstance().callView(sub_package + "UserOrder", null);
    				//break;
    				
    			case "E":
    				MainDispatcher.getInstance().callView("Login", null);
    				break;

    			case "B":
    				MainDispatcher.getInstance().callView("HomeAdmin", null);
    				break;
    				
    			default:
    				MainDispatcher.getInstance().callView("Login", null);
    			}
    		break;
    	case "GETCHOICEUSER":
				//toUpperCase() mette in maiuscolo la scelta
		switch (choice.toUpperCase()) {
		case "S":
			MainDispatcher.getInstance().callView(sub_package + "ItemSearch", null);
			break;
		case "L":
			MainDispatcher.getInstance().callView(sub_package + "ItemUserRead",null);
			break;
		case "E":
			MainDispatcher.getInstance().callView("Login", null);
			break;

		case "B":
			MainDispatcher.getInstance().callView("HomeUser", null);
			break;
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
		break;
    			
    		default:
    			MainDispatcher.getInstance().callView("Login", null);
    		}
    	}
    }
