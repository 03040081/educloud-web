package zsc.gof.tool;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieTools {
	// 根据cookie的名称获取cookie的值
		public static String getCookieValue(String cookieName,
				HttpServletRequest request) {
			String value = null; //
			// 读取当前客户端cookie,返回为Cookie数组
			Cookie[] cookies = request.getCookies();
			// 如果cookies不为空
			if (cookies != null) {
				// 遍历数组,寻找相应的名称是否存在
				for (int i = 0; i < cookies.length; i++) {
					Cookie cookie = cookies[i];
					if (cookie.getName().equals(cookieName)) {
						value = cookie.getValue();
					}
				}
			}
			return value;
		}

		// 将cookie写入客户端
		public static void writeCookie(String name, String value,
				HttpServletResponse response) {
			// 根据key-value的方式创建一个cookie
			Cookie cookie = new Cookie(name, value);
			// 设置cookie的生存期
			cookie.setMaxAge(24 * 3600 * 7); // 时间为一个星期
			// 设置cookie的位置,设置为'/'路径表示主目录下所有文件都能读取到
			cookie.setPath("/");
			// 将cookie写入客户端
			response.addCookie(cookie);
		}

		// 将命名为name的cookie删除
		public static void removeCookie(String name, HttpServletRequest request,
				HttpServletResponse response) {
			Cookie[] cookies = request.getCookies();
			// 如果cookies不为空
			if (cookies != null) {
				// 遍历数组,寻找相应的名称是否存在
				for (int i = 0; i < cookies.length; i++) {
					if (cookies[i].getName().equals(name)) {
						Cookie cookie = cookies[i];
						// 设置cookie的生存期为0
						cookie.setMaxAge(0); // 时间为一个星期
						// 设置cookie的位置,设置为'/'路径表示主目录下所有文件都能读取到
						cookie.setPath("/");
						// 将cookie写入客户端
						response.addCookie(cookie);
					}
				}
			}

		}
}
