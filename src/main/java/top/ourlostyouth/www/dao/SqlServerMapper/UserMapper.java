
package top.ourlostyouth.www.dao.SqlServerMapper;

import org.springframework.boot.context.properties.ConfigurationProperties;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import top.ourlostyouth.www.domain.MaterielMessge;
import top.ourlostyouth.www.domain.User;

import java.util.List;

public interface UserMapper  extends Mapper<User>, MySqlMapper<User> {
    List<User> UserList(String UserId);
}
