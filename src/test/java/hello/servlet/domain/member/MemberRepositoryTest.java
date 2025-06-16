package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {

    //스프링 쓰면 싱글톤 신경쓸필요없지만 일단 이렇게
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach //테스트 끝나면 초기화하기위함
    void afterEach() {
        memberRepository.clearStore();
    }


    @Test
    void getInstance() {
    }

    @Test
    void save() {
        //given
        Member member = new Member("hello",20);

        //when
        Member savedMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(member);
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("member1",20);
        Member member2 = new Member("member2",30);
        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> result = memberRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1,member2);
    }

    @Test
    void clearStore() {
    }
}