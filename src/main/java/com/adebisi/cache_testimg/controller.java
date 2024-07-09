package com.adebisi.cache_testimg;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
