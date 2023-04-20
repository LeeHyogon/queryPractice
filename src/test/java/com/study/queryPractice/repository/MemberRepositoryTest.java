package com.study.queryPractice.repository;


import com.study.queryPractice.domain.Member;
import com.study.queryPractice.dto.MemberSearchCondition;
import com.study.queryPractice.dto.MemberTeamDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void basicTest() throws Exception {
        Member member = new Member("member1", 10);
        memberRepository.save(member);

        Member findMember = memberRepository.findById(member.getId()).get();
        assertThat(findMember).isEqualTo(member);

        List<Member> result1 = memberRepository.findAll();
        //assertThat(result1).containsExactly(member);

        List<Member> result2 = memberRepository.findByUsername("member1");
        //assertThat(result2).containsExactly(member);
    }

    @Test
    public void searchTest() throws Exception {

        MemberSearchCondition condition = new MemberSearchCondition();
//        condition.setAgeGoe(35);
//        condition.setAgeLoe(40);
        condition.setTeamName("teamB");

        List<MemberTeamDto> result = memberRepository.search(condition);

        //assertThat(result).extracting("username").containsExactly("member3","member4");
    }
}