package com.study.queryPractice.repository;

import com.study.queryPractice.dto.MemberSearchCondition;
import com.study.queryPractice.dto.MemberTeamDto;

import java.util.List;

public interface MemberRepositoryCustom {
    List<MemberTeamDto> search(MemberSearchCondition condition);
}
