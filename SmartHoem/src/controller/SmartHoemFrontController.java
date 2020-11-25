package controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import vo.ActionForward;

@WebServlet("*.bo")
public class SmartHoemFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public SmartHoemFrontController() {
        super();
    
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//get, post ������� ó���ϱ� ���� ���� ���� �޼ҵ�
    	//1. � ��û���� Ȯ��
    	request.setCharacterEncoding("UTF-8");
   		String requestURI = request.getRequestURI();
   		System.out.println(requestURI);
   		String contextPath =request.getContextPath();
   		System.out.println(contextPath);
   		String command=requestURI.substring(contextPath.length());
   		System.out.println(command);
   		ActionForward forward=null;
   		Action action=null;
   		
   		if(command.equals("/boardWriteForm.bo")) {
   			//�۵��
   			forward = new ActionForward();
   			forward.setPath("qna_board_write.jsp"); //�������� ������ �ּ� ����
   			
   		
   		}
   		
   		else {
   			forward = new ActionForward();
   			forward.setPath("inputerror.jsp");
   			forward.setRedirect(false);
   		}
   		
   		//������ ó���� �����鳪�� �������̵�
   		if(forward.isRedirect()) {
   			response.sendRedirect(forward.getPath());
   		}else {
   			RequestDispatcher dispatcher =request.getRequestDispatcher(forward.getPath());
   			dispatcher.forward(request, response);
   		}
   		
   		
   		
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}

