package it.contrader.controller;

import java.util.List;

import it.contrader.dto.ClientDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.ClientService;


public class ClientController implements Controller {

	private static String sub_package = "client.";
	private ClientService clientService;
	private Request infos;
	//private Request request;
	/**
	 * Costruisce un oggetto di tipo UserService per poterne usare i metodi
	 */
	public ClientController() {
		this.clientService = new ClientService();
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
    		infos=request;
    		String choice = (String) request.get("choice");

    		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
    		 int id;
    		 
    		 String nome;
    		 String cognome;
    		 String indirizzo;
    		 
    		switch (mode) {
    		
    		// Arriva qui dalla UserReadView. Invoca il Service con il parametro id e invia alla UserReadView uno user da mostrare 
    		case "READ":
    			
    			id = Integer.parseInt(request.get("id").toString());
    			
    			List<ClientDTO> clientDTO =clientService.read(id);
    			
    			request.put("client", clientDTO);
    			MainDispatcher.getInstance().callView(sub_package + "ClientRead", request);
    			break;
    		case "USERREAD":
    			request.put("userid", request.get("id").toString());
    			id = Integer.parseInt(request.get("id").toString());
    			List<ClientDTO> clientUserDTO =clientService.read(id);
    			request.put("client", clientUserDTO);
    			MainDispatcher.getInstance().callView(sub_package + "ClientUserRead", request);
    			break;
    		
    		// Arriva qui dalla UserInsertView. Estrae i parametri da inserire e chiama il service per inserire uno user con questi parametri
    		case "INSERT":
    			id= Integer.parseInt(request.get("userID").toString());
    			nome = request.get("nome").toString();
    			cognome = request.get("cognome").toString();
    			indirizzo = request.get("indirizzo").toString();
    			
    			//costruisce l'oggetto user da inserire
    			ClientDTO clientToInsert = new ClientDTO(id, nome, cognome, indirizzo);
    			//invoca il service
    			clientService.insert(clientToInsert);
    			request = new Request();
    			request.put("mode", "mode");
    			//Rimanda alla view con la risposta
    			MainDispatcher.getInstance().callView(sub_package + "ClientInsert", request);
    			break;
    		
    		// Arriva qui dalla UserDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
    		case "DELETE":
    			id = Integer.parseInt(request.get("id").toString());
    			//Qui chiama il service
    			clientService.delete(id);
    			request = new Request();
    			request.put("mode", "mode");
    			MainDispatcher.getInstance().callView(sub_package + "ClientDelete", request);
    			break;
    		
    			
    		// Arriva qui dalla UserUpdateView
    		case "UPDATE":
    			id = Integer.parseInt(request.get("id").toString());
    			//userId = Integer.parseInt(request.get("userID").toString());
    			nome = request.get("nome").toString();
    			cognome = request.get("cognome").toString();
    			indirizzo = request.get("indirizzo").toString();
    			ClientDTO clienttoupdate = new ClientDTO(nome, cognome,indirizzo,id);
    			//clienttoupdate.setId(id);
    			
    			clientService.update(clienttoupdate);
    			request = new Request();
    			request.put("mode", "mode");
    			MainDispatcher.getInstance().callView(sub_package + "ClientUpdate", request);
    			break;
    			
    			
    		//Arriva qui dalla UserView Invoca il Service e invia alla UserView il risultato da mostrare 
    			
    		case "CLIENTLIST":
			List<ClientDTO> clientsDTO = clientService.getAll();
			request.put("clients", clientsDTO);
			MainDispatcher.getInstance().callView("Client", request);
			break;
			
       		case "CLIENTUSERLIST":
    			List<ClientDTO> clientUserDTO1 = clientService.read(Integer.parseInt(infos.get("userid").toString()));
    			request.put("clients", clientUserDTO1);
    			request.put("userid", infos.get("userid"));
    			MainDispatcher.getInstance().callView("ClientUser", request);
    			break;
    			
    		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
    		//con REQUEST NULL (vedi una View specifica)
			
			
    		case "GETCHOICE":
    					
    					//toUpperCase() mette in maiuscolo la scelta
    			switch (choice.toUpperCase()) {
    			
    			case "L":
    				MainDispatcher.getInstance().callView(sub_package + "ClientRead", null);
    				break;
    				
    			case "I":
    				MainDispatcher.getInstance().callView(sub_package + "ClientInsert", null);
    				break;
    				
    			case "R":
    				MainDispatcher.getInstance().callView(sub_package + "ClientInsert", null);
    				break;
    				
    			 case "A":
    				MainDispatcher.getInstance().callView(sub_package + "ClientUpdate", null);
    				break;
    				
    			case "C":
    				MainDispatcher.getInstance().callView(sub_package + "ClientDelete", null);
    				break;
    				
    			//case "O":
    				//MainDispatcher.getInstance().callView(sub_package + "UserOrder", null);
    				//break;
    				
    			case "E":
    				MainDispatcher.getInstance().callView("Register", null);
    				break;

    			case "B":
    				MainDispatcher.getInstance().callView("HomeAdmin", null);
    				break;
    				
    			default:
    				MainDispatcher.getInstance().callView("Register", null);
    			}
    			
    		default:
    			MainDispatcher.getInstance().callView("Register", null);
    		break;
    		}
	}
}
   