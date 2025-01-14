package com.prgrms.boardjpa.domain.member;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prgrms.boardjpa.domain.BaseEntity;
import com.prgrms.boardjpa.domain.post.Post;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Member extends BaseEntity {

    @Id
    @SequenceGenerator(
            name = "MEMBER_SEQ_GENERATOR"
            , sequenceName = "MEMBER_SEQ"
            , initialValue = 1
            , allocationSize = 1
    )
    @GeneratedValue(generator = "MEMBER_SEQ_GENERATOR")
    private Long id;
    @Column(length = 20)
    private String name;
    private int age;
    @Enumerated(value = EnumType.STRING)
    private Hobby hobby;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    @JsonIgnore
    @Builder.Default
    private List<Post> posts = new ArrayList<>();

    public void changeName(String name) {
        this.name = name;
    }
}
