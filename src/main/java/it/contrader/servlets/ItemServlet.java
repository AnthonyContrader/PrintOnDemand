package it.contrader.servlets;

import java.util.ArrayList;
import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.ItemDTO;
import it.contrader.dto.UserDTO;
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
		HttpSession session = request.getSession();
		Service<ItemDTO> service = new ItemService();
		String mode = request.getParameter("mode");
		ItemDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "ITEMLIST":
			
			UserDTO logged= (UserDTO) session.getAttribute("user");
			
			if((logged.getUsertype()).toUpperCase().compareTo("USER")==0) 
			{
				updateList(request);
				List<ItemDTO> filterlist=(List<ItemDTO>) request.getAttribute("list");
				List<ItemDTO> list=new ArrayList<>();
				for ( ItemDTO u: filterlist) 
				{
					
					if( ((u.getImmagine() == null) || (u.getImmagine().compareTo("")==0)) && (u.getLink() == null || (u.getLink().compareTo("")==0) )) 
					{ 
						
						list.add(u);
					}				
				}
				request.setAttribute("list", list);
				getServletContext().getRequestDispatcher("/item/useritemmanager.jsp").forward(request, response);
			}
			else 
			{
				updateList(request);
				getServletContext().getRequestDispatcher("/item/itemmanager.jsp").forward(request, response);
				//if((logged.getUsertype()).toUpperCase().compareTo("USER")==0) 
				//{
					/*System.out.println(true);
					List<ItemDTO> filterlist=(List<ItemDTO>) request.getAttribute("list");
					List<ItemDTO> list=new ArrayList<>();
					for ( ItemDTO u: filterlist) 
					{
						if((u.getImmagine() == null)&&(u.getLink() == null )) 
						{ 
							System.out.println(u);
							list.add(u);
						}				
					}
					request.setAttribute("list", list);
					getServletContext().getRequestDispatcher("/item/itemmanager.jsp").forward(request, response);*/
				
				
				//}
			}
			//getServletContext().getRequestDispatcher("/item/itemmanager.jsp").forward(request, response);
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

		case "READITEM":
			
			
			String tipoI = request.getParameter("tipo");
			//System.out.println(tipoI);
			id = Integer.parseInt(request.getParameter("iditem"));
			//dto = service.read(id);
			//request.setAttribute("dto", dto);
			updateList(request);
			List<ItemDTO> filterlist=(List<ItemDTO>) request.getAttribute("list");
				List<ItemDTO> list=new ArrayList<>();
				for ( ItemDTO u: filterlist) 
				{
					
					if(u.getTipo().compareTo(tipoI)==0)  
					{ 
					
						list.add(u);
					}				
				}
				String usertype= ( (UserDTO) session.getAttribute("user")).getUsertype();
				request.setAttribute("list", list);
				if(usertype.compareTo("USER")==0) 
					getServletContext().getRequestDispatcher("/item/useritemmanager.jsp").forward(request, response);
				else {getServletContext().getRequestDispatcher("/item/itemmanager.jsp").forward(request, response); }
			
				
			break;
			
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