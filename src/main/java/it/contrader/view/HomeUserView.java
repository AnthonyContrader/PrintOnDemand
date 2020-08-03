package it.contrader.view;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeUserView extends AbstractView{

	String choice;
	Request request;
	private Request infos;
	@Override
	public void showResults(Request request) {
		if(request!=null) {
	    	System.out.println("\n Benvenuto in SAMPLE PROJECT "+request.get("username").toString() + "\n");
	    	infos=request;
	    	}
	}

	@Override
	public void showOptions() {
        System.out.println("-------------MENU------------\n");
        System.out.println(" Seleziona cosa vuoi gestire:");
        System.out.println("[A]rticoli [C]lienti [O]rdini [E]sci");
		choice = this.getInput();

	}

	//@Override
	public void submit() {
		request = new Request();
		switch (choice) {
		

        case "a":
        	this.request.put("mode", "ITEMUSERLIST");
        	MainDispatcher.getInstance().callAction("Item", "doControl", request);
        	//MainDispatcher.getInstance().callView("Item", null);
        	break;
        case "o":
        	this.request.put("mode", "ORDERUSERLIST");
        	MainDispatcher.getInstance().callAction("Order", "doControl", request);
        	break;
        	
		case "e":
			MainDispatcher.getInstance().callAction("Register", "doControl", null);
			break;

		case "c":
			this.request.put("mode", "CLIENTUSERLIST");
			request.put("userid",infos.get("userid"));
			MainDispatcher.getInstance().callAction("Client", "doControl", request);
			break;

		default:
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
		}
	}

}
