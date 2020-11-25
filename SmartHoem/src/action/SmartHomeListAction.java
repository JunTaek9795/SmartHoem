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
	//게시판 글보기 서비스 호출
	SmartHomeListService aaa = new SmartHomeListService();
	ArrayList<SmartHoemBean> articleList= aaa.getArticleList(); //db에서 게시글 받아와서
	
	//페이지셋팅
	request.setAttribute("articleList", articleList); //request영역에 게시글 담아서 전송
	ActionForward forward = new ActionForward();
	forward.setPath("qna_board_list.jsp");
	forward.setRedirect(false); //디스패쳐 방식으로 보내겠다.
	
	return forward;
}

}
