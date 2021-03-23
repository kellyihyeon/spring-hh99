package com.sparta.myblog.service;

import com.sparta.myblog.domain.Board;
import com.sparta.myblog.domain.BoardRepository;
import com.sparta.myblog.domain.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;


    @Transactional
    public Board showOne(Long id) {
        System.out.println(id);
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디 없음. 익셉션 터짐")
        );

//      board.getOne(boardRequestDto);  // 아이디에 해당하는 보드 데이터를 빼와야 하는데
                                        // select * from board where id = 'id' 이걸 어떻게 하는 거냐고...
        System.out.println(board);
        return board;
    }


}
