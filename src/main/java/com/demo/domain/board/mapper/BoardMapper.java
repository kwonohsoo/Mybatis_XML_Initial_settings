package com.demo.domain.board.mapper;

import com.demo.domain.board.dto.BoardRequest;
import com.demo.domain.board.entity.Board;
import com.demo.domain.board.model.BoardPageData;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Mapper
public interface BoardMapper {

    // 게시글 작성
    void save(Board board);

    // 게시글 전체 조회
    List<BoardPageData> findAllBoards();

    // 검색어로 페이징
    List<BoardPageData> findBoardsBySearch(@Param("search") String search);

    // 게시글 번호별 조회
    Map<String, Object> findBoardById(Long id);

    // 게시글 수정
    int updateBoard(@Param("id") Long id, @Param("request") BoardRequest request);

    // 삭제 시 UseYn 0(사용 ) -> 9(사용 안함) 변경
    int changeUseYnWhenDeleted(Long id);

    // ID 존재 여부
    boolean existsBooleanId(Long id);

    // Optional findById
    Optional<Board> findById(Long id);

}
