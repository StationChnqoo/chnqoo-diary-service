package net.cctv3.chnqoodiaryservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.cctv3.chnqoodiaryservice.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}