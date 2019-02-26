package com.imooc;

import com.imooc.dao.GirlRepository;
import com.imooc.domain.Girl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlApplicationTests {


    @Autowired
    private GirlRepository girlRepository;

    @Before
    public void before() {
        System.out.println("**************开始执行 before 方法***********");
        Girl girl = new Girl();
        girl.setAge(21);
        girl.setCupSize("D");
//		girlRepository.save(girl);
        System.out.println("**************执行 before方法完毕***********");
    }

    @Test
    public void contextLoads() {
		/*List<Girl> girls= girlRepository.findByAge(20);

		System.out.println("###########girls.size=="+girls.size());
		System.out.println("**********第一次查询......age: " + girls.get(0).getAge() + ",cupsize: " + girls.get(0).getCupSize());

		List<Girl> girls2 = girlRepository.findByAge(20);
		System.out.println("###########girls2.size=="+girls2.size());
		System.out.println("**********第二次次查询......age: " + girls2.get(0).getAge() + ",cupsize: " + girls2.get(0).getCupSize());
*/

        Girl girl2 = girlRepository.findByName("rose");
        System.out.println("**********第一次查询......age: " + girl2.getAge() + ",cupsize: " + girl2.getCupSize());


        Girl girl3 = girlRepository.findByName("rose");
        System.out.println("**********第一次查询......age: " + girl3.getAge() + ",cupsize: " + girl3.getCupSize());

    }

}
