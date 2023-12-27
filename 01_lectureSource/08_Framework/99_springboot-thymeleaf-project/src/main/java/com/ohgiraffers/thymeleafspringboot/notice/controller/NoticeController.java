package com.ohgiraffers.thymeleafspringboot.notice.controller;

import com.ohgiraffers.thymeleafspringboot.common.exception.notice.NoticeModifyException;
import com.ohgiraffers.thymeleafspringboot.common.exception.notice.NoticeRegistException;
import com.ohgiraffers.thymeleafspringboot.common.exception.notice.NoticeRemoveException;
import com.ohgiraffers.thymeleafspringboot.notice.model.dto.NoticeDTO;
import com.ohgiraffers.thymeleafspringboot.notice.model.service.NoticeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/notice")
@Slf4j
public class NoticeController {
    private final NoticeServiceImpl noticeService;

    public NoticeController(NoticeServiceImpl noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping("/list")
    public ModelAndView noticeList(ModelAndView mv) {
        log.info("");
        log.info("");
        log.info("[NoticeController] ========================================================= start");

        List<NoticeDTO> noticeList = noticeService.selectAllNoticeList();
        log.info("[NoticeController] noticeList : " + noticeList);

        mv.addObject("noticeList", noticeList);

        mv.setViewName("content/notice/noticeList");

        log.info("[NoticeController] ========================================================= end");

        return mv;
    }

    @GetMapping("/regist")
    public String goRegister() {
        return "content/notice/noticeRegist";
    }

    @PostMapping("/regist")
    public String registNotice(@ModelAttribute NoticeDTO notice, RedirectAttributes rttr) throws NoticeRegistException {

        log.info("");
        log.info("");
        log.info("[NoticeController] registBoard ========================================================= start");
        log.info("[NoticeController] registBoard Request : " + notice);

        noticeService.registNotice(notice);

        rttr.addFlashAttribute("message", "공지사항 등록에 성공하셨습니다!");

        log.info("[NoticeController] registBoard ========================================================= end");

        return "redirect:/notice/list";
    }

    @GetMapping("/detail")
    public String selectNoticeDetail(@RequestParam Long no, Model model) {

        log.info("");
        log.info("");
        log.info("[NoticeController] selectNoticeDetail ========================================================= start");

        log.info("[NoticeController] selectNoticeDetail No : " + no);

        NoticeDTO noticeDetail = noticeService.selectNoticeDetail(no);
        log.info("[NoticeController] noticeDetail : " + noticeDetail);
        model.addAttribute("notice", noticeDetail);

        log.info("[NoticeController] selectNoticeDetail ========================================================= end");

        return "content/notice/noticeDetail";
    }

    @GetMapping("/update")
    public String goModifyNotice(@RequestParam Long no, Model model) {

        log.info("");
        log.info("");
        log.info("[NoticeController] modifyNotice ========================================================= start");

        NoticeDTO notice = noticeService.selectNoticeDetail(no);

        model.addAttribute("notice", notice);

        log.info("[NoticeController] modifyNotice ========================================================= start");

        return "content/notice/noticeUpdate";
    }

    @PostMapping("/update")
    public String modifyNotice(@ModelAttribute NoticeDTO notice, RedirectAttributes rttr) throws NoticeModifyException {

        log.info("");
        log.info("");
        log.info("[NoticeController] modifyNotice ========================================================= start");

        log.info("[NoticeController] notice : "+ notice);
        noticeService.modifyNotice(notice);


        rttr.addFlashAttribute("message", "공지사항 수정에 성공하셨습니다!");

        log.info("[NoticeController] modifyNotice ========================================================= end");
        return "redirect:/notice/list";
    }

    @GetMapping("/delete")
    public String removeNotice(@RequestParam Long no, RedirectAttributes rttr) throws NoticeRemoveException {

        log.info("");
        log.info("");
        log.info("[NoticeController] removeNotice ========================================================= start");
        log.info("[NoticeController] removeNotice ========================================================= no : {} ", no);
        noticeService.removeNotice(no);

        rttr.addFlashAttribute("message", "공지사항 삭제에 성공하셨습니다!");
        log.info("[NoticeController] removeNotice ========================================================= end");
        return "redirect:/notice/list";
    }

    @GetMapping("/test")
    public String noticeRegistTest(Model model){

        return "/content/notice/registTest";
    }

    @PostMapping("/test")
    public String noticeRegistContent(@RequestParam String editordata){
        log.info("");
        log.info("");
        log.info("[NoticeController] noticeRegistContent ========================================================= start");
        log.info("[NoticeController] noticeRegistContent ========================================================= editordata : {} ", editordata);

        log.info("[NoticeController] noticeRegistContent ========================================================= end");
        return "redirect:/";
    }
    @PostMapping(value="/uploadSummernoteImageFile", produces = "application/json")
    @ResponseBody
    public Map<String, String> uploadSummernoteImgFile(@RequestParam("file")MultipartFile multipartFile){

        log.info("");
        log.info("");
        log.info("[NoticeController] uploadSummernoteImgFile ========================================================= start");
        Map<String, String> returnMap = new HashMap<>();
        String fileRoot = "c:\\dev\\summernote_image\\";
        String originFileName = multipartFile.getOriginalFilename();
        String ext = originFileName.substring(originFileName.lastIndexOf("."));

        String savedFileName = UUID.randomUUID().toString().replace("-","") + ext;
        System.out.println("savedFileName = " + savedFileName);
        File targetFile = new File(fileRoot + savedFileName);

        try {
            InputStream fileStream = multipartFile.getInputStream();
            FileUtils.copyInputStreamToFile(fileStream, targetFile);	//파일 저장
            returnMap.put("url", "/summernoteImage/"+savedFileName);
            returnMap.put("responseCode", "success");
        } catch (IOException e) {
            FileUtils.deleteQuietly(targetFile);	//저장된 파일 삭제
            e.printStackTrace();
        }

        log.info("[NoticeController] uploadSummernoteImgFile ===================================================== return \n {}", returnMap);
        log.info("[NoticeController] uploadSummernoteImgFile ========================================================= end");
        return returnMap;
    }
}