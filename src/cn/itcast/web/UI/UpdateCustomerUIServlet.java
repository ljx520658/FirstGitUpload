package cn.itcast.web.UI;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Customer;
import cn.itcast.service.impl.BusinessService;
import cn.itcast.utils.Globals;

public class UpdateCustomerUIServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		BusinessService service = new BusinessService();
		Customer c = service.findCustomer(id);
		request.setAttribute("customer", c);
		
		request.setAttribute("preferences", Globals.preferences);
		request.setAttribute("types", Globals.types);
		
		request.getRequestDispatcher("/WEB-INF/jsp/updatecustomer.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
