package com.adebisi.cache_testimg;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class service {

    private final String cache= "backoffice";

   private final RedisTemplate<String, Object> redisTemplate;

    @Cacheable(cacheNames = "backoffice", key = "'backoffice'")
    public String getGeneral(String general) throws InterruptedException {



       log.info("this is the general implementation");

       Thread.sleep(5000);
       String returnValue = "This is a general end point";

     //   redisTemplate.opsForValue().set(key, returnValue);

        return returnValue;
    }


    @Cacheable(cacheNames = "backoffice", key = "'water'+'_'+#userId")
    public String uniqueToUseId(String userId) throws InterruptedException {



        log.info("this is the unique implementation {}",userId);
        Thread.sleep(5000);


        String returnValue = "this is a unique one "+ userId;


        return returnValue;
    }


    public String deleteAll(){
       evictAllPendingApprovalsForUser();

       return "We are here let's hope it work";

    }

    @Cacheable(cacheNames = "backoffice", key = "#channel")
    public String getCustom(Channel channel) throws InterruptedException {
        Thread.sleep(5000);

        return "We are custom";
    }



    public void evictAllPendingApprovalsForUser() {
        String pattern = "backoffice" + "::" + "*";
        Set<String> keys = redisTemplate.keys(pattern);
        log.info("here {}",keys);
        if (keys != null) {
            redisTemplate.delete(keys);
        }
    }


}
