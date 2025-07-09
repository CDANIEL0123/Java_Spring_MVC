package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/springmvc/v2/members/")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/new-form") //위에 클래스 단에서 앞 경로 선언해줌
    public String process(){
        return "new-form";
    }

    @RequestMapping(value = "save", method= RequestMethod.POST) //이런식으로 GET 인지 POST 인지 제약 걸수있음 => 이걸또 @PostMapping으로 줄일수도있음
    public String save(@RequestParam("username") String username,
                             @RequestParam("age") int age,
                             Model model){
        Member member = new Member(username,age);
        memberRepository.save(member);
        model.addAttribute("member",member);
        return "save-result";
    }

    @RequestMapping
    public String members(Model model){

        List<Member> members = memberRepository.findAll();
        model.addAttribute("members",members);
        return "members";
    }
}


