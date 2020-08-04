package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.ItemDTO;
import it.contrader.service.Service;
import it.contrader.service.ItemService;

/*
 * Per dettagli vedi Guida sez Servlet
 */
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ItemServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<ItemDTO> service = new ItemService();
		List<ItemDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<ItemDTO> service = new ItemService();
		String mode = request.getParameter("mode");
		ItemDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "ITEMLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/item/itemmanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/item/readitem.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/item/updatitem.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String nome = request.getParameter("nome").toString();
			String descrizione = request.getParameter("descrizione").toString();
			String tipo = request.getParameter("tipo").toString();
			String colore = request.getParameter("colore").toString();
			String taglia = request.getParameter("taglia").toString();
			String immagine = request.getParameter("immagine").toString();
			String link = request.getParameter("link").toString();
			dto = new ItemDTO (nome,descrizione,tipo,colore,taglia,immagine,link);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/item/itemmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			
			 nome = request.getParameter("nome").toString();
			 descrizione = request.getParameter("descrizione").toString();
			 tipo = request.getParameter("tipo").toString();
			 colore = request.getParameter("colore").toString();
			 taglia = request.getParameter("taglia").toString();
			 immagine = request.getParameter("immagine").toString();
			 link = request.getParameter("link").toString();
			id = Integer.parseInt(request.getParameter("iditem"));
			dto = new ItemDTO (nome,descrizione,tipo,colore,taglia,immagine,link);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/item/itemmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("iditem"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/item/itemmanager.jsp").forward(request, response);
			break;
		}
	}
}