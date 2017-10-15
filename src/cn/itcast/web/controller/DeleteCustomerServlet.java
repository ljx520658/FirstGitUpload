package cn.itcast.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.service.impl.BusinessService;

public class DeleteCustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			String id = request.getParameter("id");
			BusinessService service = new BusinessService();
			service.deleteCustomer(id);
			request.setAttribute("message", "ɾ���ɹ�����");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "ɾ��ʧ�ܣ���");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
