package com;

import com.imooc.GirlApplication;
import com.imooc.domain.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GirlApplication.class)
public class ApplicationTests {

    private static final Log logger = LogFactory.getLog(ApplicationTests.class);

    @Autowired(required = false)
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, User> redisTemplate;



    @Test
    public void testRedis(){

        stringRedisTemplate.opsForValue().set("denzel","123456");
        Assert.assertEquals("123456",stringRedisTemplate.opsForValue().get("denzel"));
    }

//    @Test
    public void testRedisObject(){

        User user1 = new User("chaoren",20);
        redisTemplate.opsForValue().set(user1.getUsername(),user1);

        User user2 = new User("bianfuxia",30);
        redisTemplate.opsForValue().set(user2.getUsername(),user2);

        User user3 = new User("zhizhuxia",40);
        redisTemplate.opsForValue().set(user3.getUsername(),user3);


        logger.info("********超人=="+redisTemplate.opsForValue().get("chaoren").getAge());
        logger.info("********蝙蝠侠=="+redisTemplate.opsForValue().get("bianfuxia").getAge());
        logger.info("********蜘蛛侠=="+redisTemplate.opsForValue().get("zhizhuxia").getAge());

        Assert.assertEquals(20, redisTemplate.opsForValue().get("chaoren").getAge());
        Assert.assertEquals(30, redisTemplate.opsForValue().get("bianfuxia").getAge());
        Assert.assertEquals(40, redisTemplate.opsForValue().get("zhizhuxia").getAge());

    }


}
