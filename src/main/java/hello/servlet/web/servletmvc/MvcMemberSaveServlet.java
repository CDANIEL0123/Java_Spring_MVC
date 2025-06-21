package hello.servlet.web.servletmvc;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name ="mvcMemberSaveServlet", urlPatterns = "/servlet-mvc/members/save")
public class MvcMemberSaveServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String ageString = request.getParameter("age"); //request.getparameter 의 응답은 항상 문자형식임
        int age = Integer.parseInt(ageString);

        Member member = new Member(username,age);
        memberRepository.save(member);

        //Model에 데이터를 보관한다.
        request.setAttribute("member",member);

        String viewPath = "/WEB-INF/views/save-result.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath); //이 경로로 이동
        dispatcher.forward(request, response); //다른 서블릿이나 jsp로 이동 / 서버 내부에서 다시 호출이 발생! (클라이언트로 다시가는 redirect가 아님)
    }
}
