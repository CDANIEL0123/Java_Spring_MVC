package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemberRepository {

    //동시성 문제가 고려되지 않았기에, 실무에서는 ConcurrentHashMap 사용해야함
    private Map<Long,Member> store = new HashMap<>();
    private static long sequence = 0L;
    //Id 가 하나씩 증가하는 시퀀스 static으로 선언되었기에 아무리 많은 객체가 생성되어도 하나만 생성

    private static final MemberRepository instance = new MemberRepository();
    //싱글톤으로 생성

    private MemberRepository() {
        //싱글톤은 아무나 생성못하게 private으로 막아줌
    }

    public static MemberRepository getInstance() {
        return instance;
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
