package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.ClientDTO;
import it.contrader.service.ClientService;
import it.contrader.service.Service;


public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClientServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<ClientDTO> service = new ClientService();
		List<ClientDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<ClientDTO> service = new ClientService();
		String mode = request.getParameter("mode");
		ClientDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "CLIENTLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/client/clientmanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/client/readclient.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/client/updateclient.jsp").forward(request, response);
			
			break;

		case "INSERT":
			int userid= Integer.parseInt(request.getParameter("userID").toString());
			String nome = request.getParameter("nome").toString();
			String cognome = request.getParameter("cognome").toString();
			String indirizzo =request.getParameter("indirizzo").toString();
			dto = new ClientDTO (userid, nome, cognome, indirizzo);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/client/clientmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			nome = request.getParameter("nome");
			cognome = request.getParameter("cognome");
			indirizzo = request.getParameter("indirizzo");
			userid = Integer.parseInt(request.getParameter("userID"));
			dto = new ClientDTO(nome, cognome,indirizzo,userid);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/client/clientmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			userid = Integer.parseInt(request.getParameter("idclient"));
			ans = service.delete(userid);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/client/usermanager.jsp").forward(request, response);
			break;
		}
	}
}