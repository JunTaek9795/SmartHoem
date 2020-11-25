package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

public class SmartHomeListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
	//�Խ��� �ۺ��� ���� ȣ��
	SmartHomeListService aaa = new SmartHomeListService();
	ArrayList<SmartHoemBean> articleList= aaa.getArticleList(); //db���� �Խñ� �޾ƿͼ�
	
	//����������
	request.setAttribute("articleList", articleList); //request������ �Խñ� ��Ƽ� ����
	ActionForward forward = new ActionForward();
	forward.setPath("qna_board_list.jsp");
	forward.setRedirect(false); //������ ������� �����ڴ�.
	
	return forward;
}

}
