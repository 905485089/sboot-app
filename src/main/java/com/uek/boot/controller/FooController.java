package com.uek.boot.controller;

import com.github.pagehelper.Page;
import com.uek.boot.entity.Account;
import com.uek.boot.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 测试页面处理的控制器
 *
 * @author PK时发型不乱
 */
@Controller
public class FooController {

    @Autowired
    private IAccountService actService;

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        Page<Account> accounts = (Page<Account>)actService.searchAccount(1, 5);

        mv.setViewName("index");
        mv.addObject(
                "page",
                accounts);
        return mv;
    }

}
//-- 第一步 ：缺少页面
//--        页面位置：注意和传统的SSM项目的区别
//--            SSM:src/main/webapp/WEB-INF/
//--        SpringBoot
//--            SB:src/main/resources/templates
/**
 * 第二步 ：SpringBoot的页面形式和SSM项目的区别
 * SSM ：页面使用JSP技术，页面的后缀是xxx.jsp
 * SpringBoot 页面使用Thymeleaf模板引擎技术，他的后缀是很标准的xxx.html
 * 第三步 ；引入thymeleaf模板引擎 否则页面没办法解析
 * 第四步 ：处理页面中的数据
 * a. 前后端分离，前端采用ajax获取到json数据，他再利用jquery去动态做展示
 * 这样只需要做接口
 * b. 前端只会html和css ，你就要自己处理
 * 利用thymeleaf的标签进行处理<th:each></th:each>
 * 第五步 ：引入静态资源的方式
 * i. springBoot框架静态资源的存放位置和ssm不一样
 * ssm的静态资源的存放位置在 src/main/webapp/(assets)
 * 而SpringBoot静态资源的位置在 src/main/resources/static
 * ii.如果自己配置springmvc 那么需要自己设置静态资源访问路径
 * 自己继承字WebMvcConfigurationSupport就会破坏掉SpringBoot2默认的配置
 * 第六步 ：
 * 第七步 :
 */