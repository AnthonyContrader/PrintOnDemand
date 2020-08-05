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
			id = Integer.parseInt(request.getParameter("iditem"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/item/readitem.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/item/updateitem.jsp").forward(request, response);
			
			break;

		/*case "READITEM":
			
			String tipoI = request.getParameter("tipo").toString();
			dto = service.readItem(tipoI);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/item/readitem.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/item/updatitem.jsp").forward(request, response);
			
			break;*/
			
		case "INSERT":
			String nome = request.getParameter("nome").toString();
			String descrizione = request.getParameter("descrizione").toString();
			String tipo = request.getParameter("tipo").toString();
			String colore = request.getParameter("colore").toString();
			String taglia = request.getParameter("taglia").toString();
			String immagine = request.getParameter("immagine");
			String link = request.getParameter("link");
			dto = new ItemDTO (nome,descrizione,tipo,colore,taglia,"","");
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/item/itemmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			
			 nome = request.getParameter("nome");
			 descrizione = request.getParameter("descrizione");
			 tipo = request.getParameter("tipo");
			 colore = request.getParameter("colore");
			 taglia = request.getParameter("taglia");
			// immagine = request.getParameter("immagine");
			 //link = request.getParameter("link");
			id = Integer.parseInt(request.getParameter("iditem"));
			dto = new ItemDTO (nome,descrizione,tipo,colore,taglia,"","",id);
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