package org.drill.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.drill.service.LawService;
import org.drill.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("law")
public class LawController {
	@Autowired
	private LawService lawService;

	@RequestMapping("execute")
	public String Execute(Map<String, Object> model, String idCard) throws IOException {

		String content = null;
		if (idCard == null || idCard.isEmpty()) {
			content = Status.QUERY_FAILD.getCodeDesc();
			model.put("content", content);
			return "information";
		} else {
			content = lawService.executeService(idCard);
			lawService.save(idCard);
			model.put("content", content);
			return "information";
		}
	}

	@RequestMapping("dishonesty")
	public String Dishonesty(Map<String, Object> model, String idCard) throws IOException {
		String content = "";
		if (idCard == null || idCard.isEmpty()) {
			content = Status.QUERY_FAILD.getCodeDesc();
			model.put("content", content);
			return "information";
		} else {
			content = lawService.dishonestyService(idCard);
			lawService.save(idCard);
			model.put("content", content);
			return "information";
		}
	}

	@RequestMapping("judgment")
	public String Judgment(Map<String, Object> model, String text) throws IOException {
		String content = "";
		if (text == null || text.isEmpty()) {
			content = Status.QUERY_FAILD.getCodeDesc();
			model.put("content", content);
			return "information";
		} else {
			content = lawService.judgmentService(text);
			lawService.save(text);
			model.put("content", content);
			return "information";
		}
	}

	@RequestMapping("courthouse")
	public String Courthouse(Map<String, Object> model, String text) throws IOException {
		String content = "";
		if (text == null || text.isEmpty()) {
			content = Status.QUERY_FAILD.getCodeDesc();
			model.put("content", content);
			return "information";
		} else {
			content = lawService.courthouseService(text);
			lawService.save(text);
			model.put("content", content);
			return "information";
		}
	}

	@RequestMapping("login")
	public String login(HttpServletRequest request, HttpSession session, String username, String password) {
		request.getSession().setMaxInactiveInterval(200);
		int i = lawService.selectUsers(username, password);
		if (i == 1) {
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			return "success";
		} else {
			return "login";
		}

	}
}
