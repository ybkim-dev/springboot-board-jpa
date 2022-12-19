package com.prgrms.boardjpa.domain.member.service;

import com.prgrms.boardjpa.domain.member.Member;
import com.prgrms.boardjpa.domain.member.dto.MemberCreateRequestDto;
import com.prgrms.boardjpa.domain.member.dto.MemberResponseDto;
import com.prgrms.boardjpa.domain.member.repository.MemberJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
@AllArgsConstructor
public class MemberService {
    private final MemberJPARepository memberJPARepository;

    public MemberResponseDto createMember(MemberCreateRequestDto memberCreateRequestDto) {
        Member member = memberCreateRequestDto.toMember();
        member.setCreatedBy(member.getName());
        member.setCreatedAt(LocalDateTime.now());
        return MemberResponseDto.from(memberJPARepository.save(member));
    }
}