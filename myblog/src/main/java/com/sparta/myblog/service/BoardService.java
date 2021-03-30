package com.sparta.myblog.service;

import com.sparta.myblog.model.Board;
import com.sparta.myblog.repository.BoardRepository;
import com.sparta.myblog.dto.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// 로그를 찍어보자.
@Slf4j
@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;



//    @Transactional
//    public Board showOne(Long id) {
//        System.out.println(id);
//        Board board = boardRepository.findById(id).orElseThrow(
//                () -> new IllegalArgumentException("아이디 없음. 익셉션 터짐")
//        );
//
////      board.getOne(boardRequestDto);  // 아이디에 해당하는 보드 데이터를 빼와야 하는데
//                                        // select * from board where id = 'id' 이걸 어떻게 하는 거냐고...
//        System.out.println(board);
//    }

    @Transactional(readOnly = true)
    public Board readOne(Long id) {
        log.info("id: {}", id);
        final Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않는다.")
        );

        log.info("board: {}", board);
        return board;
    }

    @Transactional
    public Long update(Long id, BoardRequestDto boardRequestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재 하지 않는다. 익셉션 터짐")
        );
        board.update(boardRequestDto);
        return board.getId();
    }

}
