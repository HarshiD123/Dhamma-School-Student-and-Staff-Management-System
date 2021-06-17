package com.itpm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itpm.model.Event;
import com.itpm.service.EventServiceImpl;
import com.itpm.service.IEventService;




/**
 * Servlet implementation class AddEventServlet
 */
@WebServlet("/AddEventServlet")
public class AddEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEventServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Event event = new Event();
		
		event.setName(request.getParameter("name"));
		event.setPlace(request.getParameter("place"));
		event.setDate(request.getParameter("date"));
		event.setStime(request.getParameter("stime"));
		event.setDuration(request.getParameter("duration"));
		event.setIncharg_id(request.getParameter("incharg_id"));
		event.setParticipants(request.getParameter("participants"));

		IEventService iEventService = new EventServiceImpl();
		iEventService.addEvent(event);

		request.setAttribute("event", event);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListEvents.jsp");
		dispatcher.forward(request, response);
	}

}
