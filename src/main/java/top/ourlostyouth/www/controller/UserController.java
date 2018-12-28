package top.ourlostyouth.www.controller;


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
    public Map<String, Object> getUserByGet(@RequestParam(value = "userName") String userName){

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
        List<User> UserList = this.userMapper.UserList("1");
        Map<String, Object> rspData = new HashMap<String, Object>();
        rspData.put("List1", UserList);
        rspData.put("List2", materielMessgeList);
        return rspData;
    }
}
