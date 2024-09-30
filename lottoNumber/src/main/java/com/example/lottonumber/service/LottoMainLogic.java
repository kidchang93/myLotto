package com.example.lottonumber.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
public class LottoMainLogic {
    // 랜덤 인스턴스
    Random random = new Random();
    int [] lottoNumber = new int[6];
    Map<String,Object> generatedLottoNum = new ConcurrentHashMap<>();

    public Map<String, Object> randomNumber(){


        int[] generatedNum = randomGenerate();

        generatedLottoNum.put("lotto",generatedNum);

        return generatedLottoNum;
    };

    public int[] randomGenerate(){
        for(int i = 0; i < 6; i++){
            int num = random.nextInt(45) + 1;
            for (int j = 0; j < i; j++){
                if (lottoNumber[j] == num) {
                    num = random.nextInt(45) + 1;
                    j = -1;
                }
            }
            lottoNumber[i] = num;
        }
        log.info("로또 번호 : {}", lottoNumber);
        return lottoNumber;
    };
}
