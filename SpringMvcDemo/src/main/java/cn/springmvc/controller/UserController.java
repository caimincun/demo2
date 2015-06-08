package cn.springmvc.controller;

import cn.springmvc.model.User;
import cn.springmvc.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by cmc on 14-12-9.
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value="/user/add") /*返回String格式的数据有问题？？*/
    public String addUser(User user){
        System.out.println("user:"+user);
//       userService.add(user);
        return "success";/*前台页面直接展示返回的string,而不知道是哪个页面*/
    }

    @RequestMapping(value="/user/add2") /*似乎不能返回json格式的数据*/
    public ModelAndView addUser2(User user){
        System.out.println("user:"+user);
//        userService.add(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("success");
        return modelAndView;

    }
    @RequestMapping(value="/numberException")
    public void testNumberFormatException(User user) {
        //这里就会发生NumberFormatException，然后就会返回定义在SpringMVC配置文件中的number视图
        Integer.parseInt("abc");
    }

    @RequestMapping(value = "/welcome")
    public String registPost() {
        return "/welcome";
    }

}
