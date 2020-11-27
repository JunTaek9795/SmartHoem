package controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import vo.SmartHomeForward;

@WebServlet("*.bo")
public class SmartHoemFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public SmartHoemFrontController() {
        super();
    
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//get, post 상관없이 처리하기 위한 공통 실행 메소드
    	//1. 어떤 요청인지 확인
    	request.setCharacterEncoding("UTF-8");
   		String requestURI = request.getRequestURI();
   		System.out.println(requestURI);
   		String contextPath =request.getContextPath();
   		System.out.println(contextPath);
   		String command=requestURI.substring(contextPath.length());
   		System.out.println(command);
   		SmartHomeForward forward=null;
   		
   		if(forward.isRedirect()) {
   			response.sendRedirect(forward.getPath());
   		}else {
   			RequestDispatcher dispatcher =request.getRequestDispatcher(forward.getPath());
   			dispatcher.forward(request, response);
   		}
   		if(command.equals("/SmartHoemList.do")) {
   			forward = new SmartHomeForward();
   			forward.setPath("SmartHoemList.jsp");
   		}
    }
   		
   		
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}

