package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

    // POST의 사용
    // HTML <form>
    // ajax 검색
    // 검색 파라미터가 많은 경우
    // POST는 http post body 에다가 데이터를 집어 넣어 전송한다. -> 그러므로 @RequestBody 사용
    // POST를 지원하는 형태 : json, xml, multipart-form, text-plain (@PostMapping(produces) 속성으로 지정 가능), 기본 형태는 Json


    @PostMapping("/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam) {
        return searchParam;
    }

}
