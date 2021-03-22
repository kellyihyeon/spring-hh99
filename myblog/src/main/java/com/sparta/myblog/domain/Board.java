package com.sparta.myblog.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Entity
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

//    // 게시글 상세 조회
//    public Board(Long id, BoardRequestDto boardRequestDto) {
//        this.id = id;
//        this.username = boardRequestDto.getUsername();
//        this.title = boardRequestDto.getTitle();
//        this.contents = boardRequestDto.getContents();
//    }
    // 게시글 상세 조회
    public void readOne(BoardRequestDto boardRequestDto) {
        this.username = boardRequestDto.getUsername();
        this.title = boardRequestDto.getTitle();
        this.contents = boardRequestDto.getContents();
    }
}
