package hello.servlet.web.springmvc.v2;


import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/springmvc/v2/members/")
public class SpringMemberControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/new-form") //위에 클래스 단에서 앞 경로 선언해줌
    public ModelAndView process(){
        return new ModelAndView("new-form");
    }

    @RequestMapping("save")
    public ModelAndView save(){
        return new ModelAndView("new-form");
    }

    @RequestMapping
    public ModelAndView members(){
        return new ModelAndView("new-form");
    }

}
