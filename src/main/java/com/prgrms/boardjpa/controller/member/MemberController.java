package com.prgrms.boardjpa.controller.member;

import com.prgrms.boardjpa.domain.member.dto.MemberCreateRequestDto;
import com.prgrms.boardjpa.domain.member.dto.MemberResponseDto;
import com.prgrms.boardjpa.domain.member.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public MemberResponseDto createMember(@RequestBody MemberCreateRequestDto memberCreateRequestDto) {
        return memberService.createMember(memberCreateRequestDto);
    }
}
