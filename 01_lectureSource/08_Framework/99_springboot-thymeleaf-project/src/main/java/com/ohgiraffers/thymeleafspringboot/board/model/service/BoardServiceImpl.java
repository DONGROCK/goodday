package com.ohgiraffers.thymeleafspringboot.board.model.service;

import com.ohgiraffers.thymeleafspringboot.board.model.dao.BoardMapper;
import com.ohgiraffers.thymeleafspringboot.board.model.dto.AttachmentDTO;
import com.ohgiraffers.thymeleafspringboot.board.model.dto.BoardDTO;
import com.ohgiraffers.thymeleafspringboot.board.model.dto.ReplyDTO;
import com.ohgiraffers.thymeleafspringboot.common.exception.board.BoardRegistException;
import com.ohgiraffers.thymeleafspringboot.common.exception.board.ReplyRegistException;
import com.ohgiraffers.thymeleafspringboot.common.exception.board.ReplyRemoveException;
import com.ohgiraffers.thymeleafspringboot.common.exception.thumbnail.ThumbnailRegistException;
import com.ohgiraffers.thymeleafspringboot.common.paging.SelectCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class BoardServiceImpl implements BoardService{

    private final BoardMapper mapper;

    public BoardServiceImpl(BoardMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * 해당 게시글 전체 갯수 조회용 메소드
     * @param searchMap 검색용 객체
     * @return
     */
    @Override
    public int selectTotalCount(Map<String, String> searchMap) {

        int result = mapper.selectTotalCount(searchMap);
        log.info("");
        log.info("");
        log.info("[BoardServiceImpl]  selectTotalCount ===================== {}", result);

        return result;
    }

    /**
     * 게시글 전체 조회용 메소드
     * @param selectCriteria 조회용객체
     * @return
     */
    @Override
    public List<BoardDTO> selectBoardList(SelectCriteria selectCriteria) {

        List<BoardDTO> boardList = mapper.selectBoardList(selectCriteria);
        log.info("");
        log.info("");
        log.info("[BoardServiceImpl]  selectBoardList ===================== {}", boardList);

        return boardList;
    }

    /**
     * 게시글 상세 페이지 조회용 메소드
     * @param no 게시글 번호
     * @return
     */
    @Override
    @Transactional
    public BoardDTO selectBoardDetail(Long no) {
        BoardDTO boardDetail = null;
        /* 조회수 증가 */
        int result = mapper.incrementBoardCount(no);

        if(result > 0){
            boardDetail = mapper.selectBoardDetail(no);
        }

        log.info("");
        log.info("");
        log.info("[BoardServiceImpl]  selectBoardDetail ===================== {}", boardDetail);

        return boardDetail;
    }

    /**
     * 해당 게시글의 전체 댓글 조회용 메소드
     * @param boardNo 게시판번호
     * @return
     */
    @Override
    public List<ReplyDTO> selectAllReplyList(Long boardNo) {
        List<ReplyDTO> replyList = null;

        replyList = mapper.selectReplyList(boardNo);

        log.info("");
        log.info("");
        log.info("[BoardServiceImpl]  selectAllReplyList ===================== {}", replyList);

        return replyList;
    }

    /**
     * 댓글 등록용 메소드
     * @param registReply 댓글정보
     * @return
     * @throws ReplyRegistException
     */
    @Override
    @Transactional
    public List<ReplyDTO> registReply(ReplyDTO registReply) throws ReplyRegistException {

        List<ReplyDTO> replyList = null;

        int result = mapper.insertReply(registReply);

        if(result > 0) {
            replyList = mapper.selectReplyList(registReply.getRefBoardNo());
        } else {
            throw new ReplyRegistException("댓글 등록에 실패하셨습니다.");
        }

        return replyList;
    }

    /**
     * 댓글 삭제용 메소드
     * @param removeReply 댓글정보
     * @return
     * @throws ReplyRemoveException
     */
    @Override
    @Transactional
    public List<ReplyDTO> removeReply(ReplyDTO removeReply) throws ReplyRemoveException {
        List<ReplyDTO> replyList = null;

        int result = mapper.deleteReply(removeReply.getNo());

        if(result > 0) {
            replyList = mapper.selectReplyList(removeReply.getRefBoardNo());
        } else {
            throw new ReplyRemoveException("댓글 삭제에 실패하셨습니다.");
        }

        return replyList;
    }

    /**
     * 게시글 등록용 메소드
     * @param board 게시글등록용정보
     * @throws BoardRegistException
     */
    @Override
    @Transactional
    public void registBoard(BoardDTO board) throws BoardRegistException {
        int result = mapper.insertBoard(board);

        if(!(result > 0)) {
            throw new BoardRegistException("게시글 등록에 실패하셨습니다.");
        }
    }

    /**
     * 전체 썸네일 게시글 조회용 메소드
     * @return
     */
    @Override
    public List<BoardDTO> selectAllThumbnailList() {
        List<BoardDTO> thumbnailList = mapper.selectAllThumbnailList();

        log.info("");
        log.info("");
        log.info("[BoardServiceImpl]  selectAllThumbnailList ===================== {}", thumbnailList);

        return thumbnailList;
    }

    /**
     * 썸네일 게시글 등록용 메소드
     * @param thumbnail
     * @throws ThumbnailRegistException
     */
    @Override
    @Transactional
    public void registThumbnail(BoardDTO thumbnail) throws ThumbnailRegistException {

        int result = 0;

        /* 먼저 board 테이블부터 insert 한다. */
        int boardResult = mapper.insertThumbnailContent(thumbnail);

        /* Attachment 리스트를 불러온다. */
        List<AttachmentDTO> attachmentList = thumbnail.getAttachmentList();

        /* fileList에 boardNo값을 넣는다. */
        for(int i = 0; i < attachmentList.size(); i++) {
            attachmentList.get(i).setRefBoardNo(thumbnail.getNo());
        }

        /* Attachment 테이블에 list size만큼 insert 한다. */
        int attachmentResult = 0;
        for(int i = 0; i < attachmentList.size(); i++) {
            attachmentResult += mapper.insertAttachment(attachmentList.get(i));
        }

        /* 게시글 추가 및 첨부파일 갯수 만큼 첨부파일 내용 insert에 실패 시 예외 발생 */
        if(!(boardResult > 0 && attachmentResult == attachmentList.size())) {
            throw new ThumbnailRegistException("사진 게시판 등록에 실패하셨습니다.");
        }
    }

    /**
     * 게시글 상세 페이지 조회용 메소드
     * @param no 게시글 번호
     * @return
     */
    @Override
    public BoardDTO selectThumbnailDetail(Long no) {
        BoardDTO thumbnailDetail = null;

        int result = mapper.incrementBoardCount(no);

        if(result > 0) {
            thumbnailDetail = mapper.selectThumbnailDetail(no);
        }

        return thumbnailDetail;
    }
}
