package com.example.lottonumber.controller;

import com.example.lottonumber.service.LottoMainLogic;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Map;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class LottoMain {

    private final LottoMainLogic lottoMainLogic;
    @GetMapping("/generate")
    public ResponseEntity<Map<String,Object>> generateLottoNumber(){
        log.info("테스트");
        Map<String,Object> lottoNumber = lottoMainLogic.randomNumber();
        return ResponseEntity.ok(lottoNumber);
    }
}
