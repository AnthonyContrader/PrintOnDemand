package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import it.contrader.dto.UserDTO;
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
		HttpSession session = request.getSession();
		Service<ClientDTO> service = new ClientService();
		String mode = request.getParameter("mode");
		ClientDTO dto;
		int userid;
		int clientid;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "CLIENTLIST":
			UserDTO logged= (UserDTO) session.getAttribute("user");
			System.out.println(logged);
			updateList(request);
			getServletContext().getRequestDispatcher("/client/clientmanager.jsp").forward(request, response);
			break;

		case "READ":
			userid = Integer.parseInt(request.getParameter("idclient"));
			dto = service.read(userid);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/client/readclient.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/client/updateclient.jsp").forward(request, response);
			
			break;

		case "INSERT":
			
			String nome = request.getParameter("nome").toString();
			String cognome = request.getParameter("cognome").toString();
			String indirizzo =request.getParameter("indirizzo").toString();
			userid= Integer.parseInt(request.getParameter("userID").toString());
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
			clientid = Integer.parseInt(request.getParameter("idclient"));
			dto = new ClientDTO(nome, cognome,indirizzo,clientid);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/client/clientmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			clientid = Integer.parseInt(request.getParameter("idclient"));
			ans = service.delete(clientid);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/client/clientmanager.jsp").forward(request, response);
			break;
		}
	}
}