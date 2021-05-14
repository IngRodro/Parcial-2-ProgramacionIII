package com.Parcial2.Controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Parcial2.Entidades.Usuario;
import com.Parcial2.Negocio.ClsLoguin;

/**
 * Servlet implementation class ControllerUser
 */
public class ControllerUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession(true);

		String btncerrar = request.getParameter("btncerrar");
		String btniniciar = request.getParameter("btniniciar");

	
			if (btncerrar != null) {
				response.sendRedirect("index.jsp");
				session.invalidate();

			}else if(btniniciar != null) {
				response.sendRedirect("iniciar.jsp");
			}
			
			else{

				String user = request.getParameter("user");
				String pass = request.getParameter("pass");
				Usuario usuario = new Usuario();

				usuario.setNombre(user);
				usuario.setContrasena(pass);

				ClsLoguin clsL = new ClsLoguin();

				int valoracceso = clsL.acceso(usuario);

				if (valoracceso == 1) {
					session.setAttribute("usuario", user);
					response.sendRedirect("index.jsp");
				} else {
					response.sendRedirect("iniciar.jsp");

				}
			}

		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
