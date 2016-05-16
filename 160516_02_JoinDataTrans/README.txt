160516
오재영

과제3.1 다음의 jsp 기본 객체에 대한 용도와 의미를 설명하시오.
request, response, session, application, PageContext, page, out, config

request
	용도 : request 객체는 javax.servlet.http.HttpServletRequest 타입으로 제공한다. 
		String getParameter(name) 파라미터 변수 name에 저장된 변수를 얻어내는 메소드로, 이때 변수의 값은 String으로 리턴된다. 
		String[] getParameterValues(name) 파라미터 변수 name에 저장된 모든 변수값을 얻어내는 메소드로, 이때 변수의 값은 String 배열로 리턴된다. checkbox에서 주로 사용된다.
		Enumeration getParameterNames() 요청에 의해 넘어오는 모든 파라미터 변수를 java.util.Enumeration 타입으로 리턴한다.
			request 내장 객체의 웹 브라우저, 웹 서버 및 요청 헤더의 정보 관련 메소드
			String getProtocol()  웹 서버로 요청 시, 사용 중인 프로토콜을 리턴한다.
			String getServerName() 웹 서버로 요청 시, 서버의 도메인 이름을 리턴한다.
			String getMethod() 웹 서버로 요청 시, 요청에 사용된 요청 방식(GET, POST, PUT 등)을 리턴한다.
			String getQueryString() 웹 서버로 요청 시, 요청에 사용된 QueryString을 리턴한다.
			String getRequestURI() 웹 서버로 요청 시, 요청에 사용된 URL 로부터 URI 값을 리턴한다.
			String getRemoteAddr() 웹 서버로 정보를 요청한 웹 브라우저의 IP주소를 리턴한다.
			int getServerPort() 웹 서버로 요청 시, 서버의 Port번호를 리턴한다.
			String getContextPath() 해당 JSP 페이지가 속한 웹 어플리케이션의 콘텍스트 경로를 리턴한다. 
			String getHeader(name) 웹 서버로 요청 시, HTTP 요청 헤더(header)의 헤더 이름인 name에 해당하는 속성값을 리턴한다. 
			Enumeration getHeaderNames() 웹 서버로 요청 시, HTTP 요청 헤더(header)에 있는 모든 헤더 이름을 리턴한다. 
	의미 : 웹 브라우저에서 JSP 페이지로 전달되는 정보의 모임으로 HTTP 헤더와 HTTP 바디로 구성되어 있다.
response
	용도 : 웹 브라우저에 보내는 응답 정보는 HttpServletResponse 객체를 사용한다. response객체는 응답 정보와 관련하여 주로 헤더 정보 입력, 리다이렉트 하기 등의 기능을 제공한다.
		void setHeader(name, value) 헤더 정보의 값을 수정하는 메소드로, name에 해당하는 헤더 정보를 value값으로 설정한다. 
		void setContentType(type) 웹 브라우저의 요청의 결과로 보일 페이지의 contentType을 설정한다. 
		void sendRedirect(url) 페이지를 이동시키는 메소드로, url로 주어진 페이지로 제어가 이동한다. 
	의미 :  response 객체는 웹 브라우저로 응답할 응답 정보를 가지고 있다
session 
	용도 : javax.servlet.http.HttpSession 객체 타입으로 제공하고, JSP에서는 session 객체로 사용된다.
		String getId() 해당 웹 브라우저에 대한 고유한 세션 ID를 리턴한다.
		long getCreationTime() 해당 세션이 생성된 시간을 리턴한다.
		long getLastAccessedTime()웹 브라우저의 요청이 시도된 마지막 접근시간을 리턴한다. 
		void setMaxInactiveInterval(time) 해당 세션을 유지할 시간을 초단위로 설정한다.
		void invalidate() 현재 정보의 유지로 사용 시, 설정된 세션의 속성 값을 모두 제거한다. 주로 세션을 무효화 시킬때 사용 
	의미 : 객체는 웹 브라우저의 요청 시, 요청한 웹 브라워저에 관한 정보를 저장하고 관리하는 내장 객체이다
application 
	용도 :  javax.servlet.ServletContext 객체 타입으로 제공하고 동일한 어플리케이션의 컨텍스트 정보를 얻기위해 사용된다.
		String getServerInfo() 웹 컨테이너의 이름과 버전을 리턴한다. 
		String getMimeType(fileName) 지정한 파일의 MIME 타입을 리턴한다. 
		String RealPath(path) 지정한 경로를 웹 어플리케이션 시스템상의 경로로 변경하여 리턴한다. 
		void log(message) 로그 파일에 message를 기록한다.
	의미 : application 객체 형태로 사용한다 내장 객체는 웹 어플리케이션의 설정 정보를 갖는 context 와 관련이 있는 객체로, 웹 어플리케이션과 연관이 있다.
PageContext
	용도 : PageContext객체는 javax.servlet.jsp.PageContext 객체 타입으로 주로 다른 내장 객체를 구하거나 페이지의 흐름 제어 그리고 에러 데이터를 얻어낼 때 사용된다.
		ServletRequest getRequest() 페이지 요청 정보를 가지고 있는 request 내장 객체를 리턴한다. 
		ServletResponse getResponse() 페이지 요청에 대한 응답 정보를 가지고 있는 response 내장 객체를 리턴한다. 
		JSPWriter getOut() 페이지 요청에 대한 출력 스트림인 out 내장 객체를 리턴한다. 
		HttpSession getSessoin() 요청한 웹 브라우저의 세션 정보를 담고 있는 session 내장 객체를 리턴한다. 
		ServletContext getServletContext() 페이지에 대한 서블릿 실행 환경 정보를 담고 있는 application 내장 객체를 리턴한다. 
		Object getPage() page 내장 객체를 리턴한다. 
		ServletConfig getServletConfig() 해당 페이지의 서블릿 초기 정보 설정 정보를 담고 있는 config 내장 객체를 리턴한다. 
		Exception getException() 페이지 실행 중에 발생되는 에러 페이지에 대한 예외 정보를 갖고 있는 exception 내장 객체를 리턴한다. 
	의미 : 현재 JSP 페이지의 컨텍스트(Context)를 나타내며, 페이지 실행에 필요한 컨텍스트 정보를 저장한 객체
config
	용도 : 내장 객체는 javax.servlet.ServletConfig 객체 타입이다, 주로 서블릿의 설정 정보를 얻기위해 사용한다.
		Enumeration getInitParameterNames() 모든 초기화 파라미터 이름을 리턴한다.
 		String getInitParameter(name) 이름이 name인 초기화 파라미터의 값을 리턴한다. 
		String getServletName() 서블릿의 이름을 리턴한다. 
		ServletContext getServletContext() 실행하는 서블릿 ServletContext 객체를 리턴한다. 
	의미 :  해당 페이지의 서블릿 설정 정보(초기화 정보)를 저장한 객체
page
	용도 : 하나의 jsp 페이지를 처리할 때 사용하며 자바 이외의 다른 언어가 사용될 수 있도록 허용된다면, page 객체를 참조하는 경우가 발생할 수 있다
	의미 : 타입은 javax.servlet.jsp.HttpJspPage 에 속해있으며 해당 페이지 서블릿 객체(인스턴스)이다.
out
	용도 : javax.servlet.jsp.JspWriter 객체 타입으로 제공되며  JSP 페이지가 웹 브라우저에게 보내는 모든 정보는 out 객체를 통해서 전송된다.
		boolean isAutoFlush() 출력 버퍼가 다 찼을 때 처리 여부를 결정하는 것으로, 자동으로 플러시 할 경우에는 true를 리턴하고, 그렇지 않을 경우 false를 리턴한다. 
		int getBufferSize() 출력 버퍼의 전체 크기를 리턴한다. 
		int getRemaining() 현재 남아 있는 출력 버퍼의 크기를 리턴한다. 
		void clearBuffer() 현재 출력 버퍼에 저장되어 있는 내용을 웹 브라우저에 전송하지 않고 비운다. 
		String println(str) 주어진 str 값을 웹 브라워저에 출력한다. 이때 줄 바꿈은 적용되지 않는다. 
		void flush() 현재 출력 버퍼에 저장되어 있는 내용을 웹 브라우저에 전송하고 비운다. 
		void close() 현재 출력 버퍼에 저장되어 있는 내용을 웹 브라우저에 전송하고 출력 스트림을 닫는다.  
	의미 : out객체는 JSP 페이지가 생성한 결과를 웹 브라우저에 전송해 주는 출력 스트림이다 응답 페이지를 클라이언트로 전송하기 위한 출력 스트림 객체


과제3.2_회원가입_데이터전송

설명:
	회원 가입 내용을 사용자가 다시한번 확인 후 가입 하는 프로그램입니다.
	간략 data 전송구조 : join_input > JoinConroller.java > join_Check.jsp > Joincontroller.java > join_result.jsp 
 
상세 설명:
	WebContent>html>join_input.html이 첫번째 시작입니다.
	join_input.html 에서 입력 받은 값을 kr.co.wodud.cont 패키지의 JoinController.java 에 전송받습니다.
	파라미터로 전송받은 joinCheck 초기 값이 fail이므로 join_Check.jsp로 전송합니다.
	사용자가 javascript의 Confirm 메소드에서 확인을 누르면 hidden 타입으로 설정된 joinCheck를 success로 변경후 JoinController.java로 전송합니다.
	JoinConroller.java에서 파라미터로 받은 joinCheck값이 success이므로 join_result로 가입완료된 id값을 전송합니다.
	join_result.jsp에서는 사용자에게 최종 가입이 완료되었음을 알려줍니다.

소스 코드:
	첨부파일 참조