package com.sparta.myblog.controller;

import com.sparta.myblog.domain.Board;
import com.sparta.myblog.domain.BoardRepository;
import com.sparta.myblog.domain.BoardRequestDto;
import com.sparta.myblog.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// 스프링에게 이 녀석이 자동응답기라는 걸 알려줘야 하는데, 빼먹음.(까먹지 말것)
@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository boardRepository;
    private final BoardService boardService;

//    @GetMapping("/")
//    public String home(){
//        return "index.html";
//    }

    @PostMapping("/api/boards")
    public Board createBoard(@RequestBody BoardRequestDto boardRequestDto) {
        Board board = new Board(boardRequestDto);
        boardRepository.save(board);
        return board;
    }

    @GetMapping("api/boards")
    public List<Board> readBoard() {
        return boardRepository.findAllByOrderByCreatedAtDesc();
    }

    @GetMapping("/api/boards/{id}")
    public Board getOneBoard(@PathVariable Long id) {
        return boardService.readOne(id);
    }
}
