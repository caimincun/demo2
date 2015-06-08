import cn.springmvc.model.User;
import cn.springmvc.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by cmc on 14-12-9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserTest {

//    private static Log logger = LogFactory.getLog(UserTest.class.getClass());
static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
//static Logger logger = LogManager.getLogger(UserTest.class.getClass());// 似乎是传递的类的名称有问题

    @Test
    public void testLog(){

        User user=new User();
        user.setId(4);
        user.setName("cmc");
        user.setPassword("123456");

        //  记录 debug 级别的信息

        logger.debug("This log message leavel.debug:"+user);

        //  记录 info 级别的信息

        logger.info("This log message leavel.info:"+user);

        //  记录 error 级别的信息

        logger.error("This log message leavel.error:"+user);

        userService.add(user);

    }


    @Autowired
    private UserService userService;


    /**
     * 简单的springmvc mybatis junit 插入测试
     */
    @Test
    public void addUser(){
        try {
            User user=new User();
            user.setId(2);
            user.setName("cmc");
            user.setPassword("123456");
            userService.add(user);
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("测试成功");

    }




    @Test
    public void testNumberFormatException() {
        //这里就会发生NumberFormatException，然后就会返回定义在SpringMVC配置文件中的number视图
        Integer.parseInt("abc");
    }
}
