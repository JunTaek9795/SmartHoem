package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

public interface Action {
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
}
