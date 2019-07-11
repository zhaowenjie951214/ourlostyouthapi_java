
package top.ourlostyouth.www.dao.SqlServerMapper;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import top.ourlostyouth.www.domain.User;

import java.util.List;

public interface UserMapper  extends Mapper<User>, MySqlMapper<User> {
    List<User> userList( @Param("UserId") String UserId);
}

