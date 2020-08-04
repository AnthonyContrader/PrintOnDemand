package it.contrader.servlets;


import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.UserDTO;
import it.contrader.service.Service;
import it.contrader.service.UserService;
import it.contrader.dto.ItemDTO;
import it.contrader.dto.OrderDTO;
//import it.contrader.dto.UserDTO;
import it.contrader.service.OrderService;

/**
 * 
 * @author Vittorio
 *
 *Si osservi che nel Controller compaiono solo oggetti del DTO e non del Model!
 */
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public OrderServlet() {
	}

	public void updateList(HttpServletRequest request) {
		Service<OrderDTO> service = new OrderService();
		List<OrderDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<OrderDTO> service = new OrderService();
		String mode = request.getParameter("mode");
		OrderDTO dto;
		int id;
		boolean ans;
		
		switch (mode.toUpperCase()) {
		case "ORDERLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/order/ordermanager.jsp").forward(request, response);
			break;
		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/order/readorder.jsp").forward(request, response);
				
			}
			else getServletContext().getRequestDispatcher("/order/updateorder.jsp").forward(request, response);
			
			break;
		case "INSERT":
			
			int idclient = Integer.parseInt(request.getParameter("IDclient").toString());
			int iditem = Integer.parseInt(request.getParameter("IDitem").toString());
			int prezzo = Integer.parseInt(request.getParameter("prezzo").toString());
			String immagine = request.getParameter("immagine").toString();
			String link = request.getParameter("link").toString();
			dto = new OrderDTO(idclient,iditem,"0", prezzo,0);
			//ItemDTO itemToInsert = new ItemDTO("0","0","0",0,"0",immagine,link,iditem);
			//ItemDTO dtoi=new ItemDTO("0","0","0",0,"0",immagine,link,iditem);
			//boolean ansi=service.insert(dto) MANCA L'INSERIMENTO DELL'ITEMCONGIUNTO!
			ans= service.insert(dto);
			//if (ans && ansi) ans=true;
			//else ans=false;
			request.setAttribute("ans",ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/order/ordermanager.jsp").forward(request, response);
			break;
		}
	}
}