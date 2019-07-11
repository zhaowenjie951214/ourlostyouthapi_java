package top.ourlostyouth.www.controller;


import ch.qos.logback.core.net.server.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;
import top.ourlostyouth.www.dao.MySqlMapper.MaterielMessgeMapper;

import top.ourlostyouth.www.dao.SqlServerMapper.UserMapper;
import top.ourlostyouth.www.domain.MaterielMessge;
import top.ourlostyouth.www.domain.User;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RestController注解能够使项目支持Rest
@RestController
//@SpringBootApplication
//表示该controller类下所有的方法都公用的一级上下文根
@RequestMapping(value = "/springboot")
public class UserController {

    @Resource
    private MaterielMessgeMapper materielMessgeMapper;

    @Resource
    private UserMapper userMapper;

    //这里使用@RequestMapping注解表示该方法对应的二级上下文路径
    @RequestMapping(value = "/getUserByGet", method = RequestMethod.GET)
    public Map<String, Object> getUserByGet(@RequestParam(value = "userName") String userName) {

        Example example = new Example(MaterielMessge.class);
        Example Userexample = new Example(User.class);
//        Example.Criteria criteria = example.createCriteria();
//        if(StringUtils.isNotBlank(materielMessge.getCrystalNo()))
//            criteria.andEqualTo("crystalNo",materielMessge.getCrystalNo());
//
//        if(StringUtils.isNotBlank(materielMessge.getCrystalGroupNo()))
//            criteria.andEqualTo("crystalGroupNo",materielMessge.getCrystalGroupNo());
//
//        if(StringUtils.isNotBlank(stardate))
//            criteria.andGreaterThan("addtime",stardate);
//
//        if(StringUtils.isNotBlank(enddate)){
//            if(enddate.length() == 10){
//                enddate = enddate + " 23:59:59";
//            }
//            criteria.andLessThanOrEqualTo("addtime",enddate);
//        }
        example.setOrderByClause("addtime desc");
        List<MaterielMessge> materielMessgeList = this.materielMessgeMapper.selectByExample(example);
//        List<MaterielMessge> materielMessgeList = this.materielMessgeMapper.selectAll();
        //List<User> UserList = this.userMapper.userList("1");
        Map<String, Object> rspData = new HashMap<String, Object>();
        //rspData.put("List1", UserList);
        rspData.put("List2", materielMessgeList);
        return rspData;
    }

    /**
     * 邮件发送服务
     */
    @Autowired
    public JavaMailSender mailSender;

    //发送人的邮箱
    @Value("${spring.mail.username}")
    private String from;

    @Async
    @RequestMapping(value = "/sendMail", method = RequestMethod.GET)
    public Map<String, Object> sendMail(String title, String url, String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from); // 发送人的邮箱
        message.setSubject(title); //标题
        String[] emailArr = new String[]{email, "3433739516@qq.com"};
        message.setTo(emailArr); //发给谁  对方邮箱
        message.setText(url); //内容
        mailSender.send(message); //发送

//        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
//        Client client = dcf.createClient("http://127.0.0.1:8080/soap/testWservice?wsdl");
//        Object[] objects = client.invoke("list3",param1,param2);//list3方法名 后面是可变参数
//        //输出调用结果
//        System.out.println(objects[0].getClass());
//        System.out.println(objects[0].toString());

        Map<String, Object> rspData = new HashMap<String, Object>();
        rspData.put("message", "发送成功");
        return rspData;
    }

//    @Test
//    public void contextLoads() throws Exception {
//        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
//        Client client = dcf.createClient("http://127.0.0.1:8080/soap/testWservice?wsdl");
//        Object[] objects = client.invoke("list3",param1,param2);//list3方法名 后面是可变参数
//        //输出调用结果
//        System.out.println(objects[0].getClass());
//        System.out.println(objects[0].toString());
//    }
}
