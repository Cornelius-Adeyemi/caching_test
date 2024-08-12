package com.adebisi.cache_testimg;


import com.adebisi.cache_testimg.dto.TestBodyObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class service {

    private final String cache= "backoffice";

   private final RedisTemplate<String, Object> redisTemplate;

    @Cacheable(cacheNames = "backoffice", key = "'backoffice'")
    public String getGeneral(String general) throws InterruptedException {


        getCurrentMethodName();
       log.info("this is the general implementation");

       Thread.sleep(5000);
       String returnValue = "This is a general end point";

     //   redisTemplate.opsForValue().set(key, returnValue);

        return returnValue;
    }


    @Cacheable(cacheNames = "backoffice", key = "'water'+'_'+#userId")
    public String uniqueToUseId(String userId) throws InterruptedException {

        getCurrentMethodName();

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
        getCurrentMethodName();
        Thread.sleep(5000);

        return "We are custom";
    }

    @Cacheable(cacheNames = "backoffice", key = "#testBodyObject")
    public HashMap<String, String>  getObjectFull(HashMap<String, String> testBodyObject) throws InterruptedException {
        getCurrentMethodName();
        Thread.sleep(5000);

        return testBodyObject;
    }

    @Cacheable(cacheNames = "backoffice", key = "#testBodyObject.getBola + '_'+ #testBodyObject.getAde")
    public TestBodyObject getObjectField(com.adebisi.cache_testimg.dto.TestBodyObject testBodyObject) throws InterruptedException {
        getCurrentMethodName();
        Thread.sleep(5000);

        return testBodyObject;
    }



    public void evictAllPendingApprovalsForUser() {
        String pattern = "backoffice" + "::" + "*";
        Set<String> keys = redisTemplate.keys(pattern);
        log.info("here {}",keys);
        if (keys != null) {
            redisTemplate.delete(keys);
        }
    }


    public  void getCurrentMethodName() {
        String method =  Thread.currentThread().getStackTrace()[2].getMethodName();

        log.info("invoke method --------------{}", method);
    }


}
