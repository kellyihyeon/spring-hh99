package com.sparta.myblog.service;

import com.sparta.myblog.domain.Board;
import com.sparta.myblog.domain.BoardRepository;
import com.sparta.myblog.domain.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long readOne(Long id, BoardRequestDto boardRequestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않는다.")
        );
        board.readOne(boardRequestDto);
        return board.getId();

    }


}
