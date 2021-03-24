package com.sparta.myblog.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Entity
@ToString
public class Board extends Timestamped{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    // 게시글 작성 할 때
    public Board(BoardRequestDto boardRequestDto) {
        this.username = boardRequestDto.getUsername();
        this.title = boardRequestDto.getTitle();
        this.contents = boardRequestDto.getContents();
    }

    // 클라이언트에서 요청을 할 때, 변화가 생기는 경우 Dto를 생성해서 작업 (게시글 수정)
    public void update(BoardRequestDto boardRequestDto) {
        this.title = boardRequestDto.getTitle();
        this.username = boardRequestDto.getUsername();
        this.contents = boardRequestDto.getContents();

    }

}
