package com.sparta.myblog.service;

import com.sparta.myblog.domain.Board;
import com.sparta.myblog.domain.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public Board readOne(Long id) {
        log.info("id: {}", id);
        final Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않는다.")
        );

        log.info("board: {}", board);
        return board;
    }
}
