package com.adebisi.cache_testimg;


import com.adebisi.cache_testimg.dto.TestBodyObject;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test/")
public class controller {

  private final service service;


  @GetMapping("general")
    public String getGeneral(@RequestParam String id) throws InterruptedException {

        return service.getGeneral(id);
    }


    @GetMapping("unique")
    public String getUnique(@RequestParam String id) throws InterruptedException {

        return service.uniqueToUseId(id);
    }


    @GetMapping("delete")
    public String getDelete() throws InterruptedException {

        return service.deleteAll();
    }

    @GetMapping("custom")
    public String getCustom(@RequestParam Channel channel) throws InterruptedException {

        return service.getCustom(channel);
    }


    @GetMapping("custom-object")
    public HashMap<String, String>  getCustomCacheTest(@RequestBody HashMap<String, String> channel) throws InterruptedException {

        return service.getObjectFull(channel);
    }

    @GetMapping("custom-object-field")
    public TestBodyObject getCustomCacheTestField(@RequestBody com.adebisi.cache_testimg.dto.TestBodyObject channel) throws InterruptedException {

        return service.getObjectField(channel);
    }
}
