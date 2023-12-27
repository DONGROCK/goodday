package com.ohgiraffers.thymeleafspringboot.notice.model.service;

import com.ohgiraffers.thymeleafspringboot.common.exception.notice.NoticeModifyException;
import com.ohgiraffers.thymeleafspringboot.common.exception.notice.NoticeRegistException;
import com.ohgiraffers.thymeleafspringboot.common.exception.notice.NoticeRemoveException;
import com.ohgiraffers.thymeleafspringboot.notice.model.dao.NoticeMapper;
import com.ohgiraffers.thymeleafspringboot.notice.model.dto.NoticeDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class NoticeServiceImpl implements NoticeService {

    private final NoticeMapper mapper;

    public NoticeServiceImpl(NoticeMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * 공지사항 전체 목록 조회용 메소드
     * @return
     */
    @Override
    public List<NoticeDTO> selectAllNoticeList() {
        log.info("");
        log.info("");
        log.info("[NoticeServiceImpl] selectAllNoticeList =================================== start");
        List<NoticeDTO> noticeList = mapper.selectAllNoticeList();

        log.info("[NoticeServiceImpl] selectAllNoticeList =================================== notice \n {}", noticeList);

        return noticeList;
    }


    /**
     * 공지사항 등록용 메소드
     * @param notice
     * @throws NoticeRegistException
     */
    @Override
    @Transactional
    public void registNotice(NoticeDTO notice) throws NoticeRegistException {

        log.info("");
        log.info("");
        log.info("[NoticeServiceImpl] registNotice =================================== start");
        int result = mapper.insertNotice(notice);

        log.info("[NoticeServiceImpl] registNotice =================================== result : {} ", result);
        log.info("[NoticeServiceImpl] registNotice ===================================  end");
        if(!(result > 0)) {
            throw new NoticeRegistException("공지사항 등록에 실패하셨습니다.");
        }
    }


    /**
     * 공지사항 상세 페이지 조회용 메소드
     * @param no
     * @return
     */
    @Override
    public NoticeDTO selectNoticeDetail(Long no) {

        log.info("");
        log.info("");
        log.info("[NoticeServiceImpl] selectNoticeDetail =================================== start");
        NoticeDTO noticeDetail = null;

        int result = mapper.incrementNoticeCount(no);

        log.info("[NoticeServiceImpl] registNotice =================================== result : {} ", result);


        if(result > 0) {
            noticeDetail = mapper.selectNoticeDetail(no);
        }

        log.info("[NoticeServiceImpl] registNotice =================================== noticeDetail : \n {} ", noticeDetail);
        log.info("[NoticeServiceImpl] registNotice ===================================  end");
        return noticeDetail;
    }

    /**
     * 공지사항 수정용 메소드
     * @param notice
     * @throws NoticeModifyException
     */
    @Override
    @Transactional
    public void modifyNotice(NoticeDTO notice) throws NoticeModifyException {

        log.info("");
        log.info("");
        log.info("[NoticeServiceImpl] modifyNotice =================================== start");
        int result = mapper.updateNotice(notice);


        log.info("[NoticeServiceImpl] modifyNotice =================================== result : {}", result);
        log.info("[NoticeServiceImpl] modifyNotice =================================== end");

        if(!(result > 0)) {
            throw new NoticeModifyException("공지사항 수정에 실패하셨습니다.");
        }
    }


    /**
     * 공지사항 삭제용 메소드
     * @param no 공지사항 번호
     * @throws NoticeRemoveException
     */
    @Override
    @Transactional
    public void removeNotice(Long no) throws NoticeRemoveException {
        log.info("");
        log.info("");
        log.info("[NoticeServiceImpl] removeNotice =================================== start");
        int result = mapper.deleteNotice(no);


        log.info("[NoticeServiceImpl] removeNotice =================================== result : {}", result);
        log.info("[NoticeServiceImpl] removeNotice =================================== end");

        if(!(result > 0)) {
            throw new NoticeRemoveException("공지사항 삭제에 실패하셨습니다.");
        }
    }
}
