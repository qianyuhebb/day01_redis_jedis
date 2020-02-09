
package qianfeng.test;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qianfeng.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 时间：  2020/2/9
 * 创建者：  Administrator 钟文
 * 描述：
 * 参数：
 * 返回值：
 **/
//测试的运行由spring接管 ,将此类放入工厂中
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application_redis.xml")
public class APPtest {

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Resource(name="redisTemplate")
    private ValueOperations<String , Object> valueOps;

    @Resource(name="redisTemplate")
    private ListOperations<String , Object> listOps;


    @Resource(name="redisTemplate")
    private SetOperations<String , Object> setOps;

    @Resource(name="redisTemplate")
    private ZSetOperations<String , Object> zsetOps;


    @Resource(name="redisTemplate")
    private HashOperations<String , String,Object> hashOps;

    @Test
    public void testJackSon() throws JsonProcessingException {
        System.out.println();
        //吧对象转化为json  的 string
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(new User("松",1,new Date(),"男"));
        System.out.println(s);
        byte[] s2 = objectMapper.writeValueAsBytes(new User("松",1,new Date(),"男"));
        System.out.println(s2);


    }

//      static {
//          ParserConfig.getGlobalInstance().addAccept("com.qianfeng.pojo.User");
//      }

    @Test
    public  void testRedisTemplate(){
        User user = new User("松", 2, new Date(), "男");
//            ParserConfig.getGlobalInstance().addAccept("com.qianfeng.pojo.User");

          //1.string
      //  ValueOperations<String,Object> vops = redisTemplate.opsForValue();
        valueOps.set("user2",new User("松",2,new Date(),"男"));
       // User user = (User) vops.get("user2");

        System.out.println(user);
        //list
      /*  ListOperations<String, Object> opsForList = redisTemplate.opsForList();
        System.out.println();
        opsForList.leftPush("list01",user);
        List<Object> list01 = opsForList.range("list01", 0, -1);
        for (Object o : list01) {
            System.out.println(o);
        }*/
        //set
       /* SetOperations<String, Object> opsForSet = redisTemplate.opsForSet();
        opsForSet.add("set",user);
        User set = (User) opsForSet.randomMember("set");
        System.out.println(set);*/

        // zset
     //   ZSetOperations<String, Object> opsForZSet = redisTemplate.opsForZSet();
        //hash
       // HashOperations<String, Object, Object> opsForHash = redisTemplate.opsForHash();


    }
}
