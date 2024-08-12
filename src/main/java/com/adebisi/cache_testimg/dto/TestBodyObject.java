package com.adebisi.cache_testimg.dto;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class TestBodyObject implements Serializable {

    private String bola;

    private String ade;
}
