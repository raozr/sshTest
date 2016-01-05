/* 这只是一个控制类 */
package test.demo.controller;

import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.log4j.Logger;

import test.demo.model.User;
import test.demo.service.UserService;

@Controller
public class UserController {

	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/index")
	public String index(ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {

		logger.info("start index---------------------");
		User myUser = new User();
		myUser.setName("mic");
		myUser.setSex(12);

		userService.insertUser(myUser);

		logger.info("index---" + resp.toString());
		model.addAttribute("name", "michael");

		return "index";
	}

	@RequestMapping(value = "/test")
	public void test(ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {

		logger.info("start test---------------------");

		String data = "中国";

		// OutputStream stream = resp.getOutputStream();

		resp.setHeader("Content-type", "text/html;charset=UTF-8");
		// stream.write(data.getBytes("UTF-8"));

		PrintWriter myWriter = resp.getWriter();
		myWriter.write("的地得");
	}

	@RequestMapping(value = "/request")
	public void request(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("start request---------------------");

		String requestUrl = request.getRequestURL().toString();// 得到请求的URL地址
		String requestUri = request.getRequestURI();// 得到请求的资源
		String queryString = request.getQueryString();// 得到请求的URL地址中附带的参数
		String remoteAddr = request.getRemoteAddr();// 得到来访者的IP地址
		String remoteHost = request.getRemoteHost();
		int remotePort = request.getRemotePort();
		String remoteUser = request.getRemoteUser();
		String method = request.getMethod();// 得到请求URL地址时使用的方法
		String pathInfo = request.getPathInfo();
		String localAddr = request.getLocalAddr();// 获取WEB服务器的IP地址
		String localName = request.getLocalName();// 获取WEB服务器的主机名
		response.setCharacterEncoding("UTF-8");// 设置将字符以"UTF-8"编码输出到客户端浏览器
		// 通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
		response.setHeader("content-type", "text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("获取到的客户机信息如下：");
		out.write("<hr/>");
		out.write("请求的URL地址：" + requestUrl);
		out.write("<br/>");
		out.write("请求的资源：" + requestUri);
		out.write("<br/>");
		out.write("请求的URL地址中附带的参数：" + queryString);
		out.write("<br/>");
		out.write("来访者的IP地址：" + remoteAddr);
		out.write("<br/>");
		out.write("来访者的主机名：" + remoteHost);
		out.write("<br/>");
		out.write("使用的端口号：" + remotePort);
		out.write("<br/>");
		out.write("remoteUser：" + remoteUser);
		out.write("<br/>");
		out.write("请求使用的方法：" + method);
		out.write("<br/>");
		out.write("pathInfo：" + pathInfo);
		out.write("<br/>");
		out.write("localAddr：" + localAddr);
		out.write("<br/>");
		out.write("localName：" + localName);
	}
}
