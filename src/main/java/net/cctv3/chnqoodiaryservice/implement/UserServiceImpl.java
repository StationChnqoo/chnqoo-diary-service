package net.cctv3.chnqoodiaryservice.implement;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.cctv3.chnqoodiaryservice.constants.StringUtils;
import net.cctv3.chnqoodiaryservice.controller.JsonResponser;
import net.cctv3.chnqoodiaryservice.entity.User;
import net.cctv3.chnqoodiaryservice.mapper.UserMapper;
import net.cctv3.chnqoodiaryservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

@Service
public class UserServiceImpl implements UserService {

    @Autowired UserMapper userMapper;

    @Override
    public boolean saveBatch(Collection<User> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<User> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<User> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(User entity) {
        return false;
    }

    @Override
    public User getOne(Wrapper<User> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<User> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<User> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<User> getBaseMapper() {
        return null;
    }

    @Override
    public Class<User> getEntityClass() {
        return null;
    }

    private boolean insertOrUpdate(User user) {
        User u = userMapper.selectById(user.getId());
        int rows = 0;
        if(u == null) {
            rows = userMapper.insert(user);
        }
        else {
            rows = userMapper.updateById(user);
        }
        return rows > 0;
    }

    @Override
    public String sendSms(String mobile) {
        QueryWrapper qr = new QueryWrapper();
        qr.eq("mobile", mobile);
        User user = userMapper.selectOne(qr);
        if(user == null) {
            String idQoo = "";
            QueryWrapper idQooQr = new QueryWrapper();
            do {
                idQoo = StringUtils.buildRandomNumbers(7);
                idQooQr.eq("id_qoo", idQoo);
            }while(userMapper.exists(idQooQr));
            user = new User(UUID.randomUUID().toString(), idQoo, "", mobile, "", "", "", "", "用户Qoo" + UUID.randomUUID().toString().substring(0, 8), "", "", "", "","", false, StringUtils.currentTime(), "");
        }
        user.setSmsCode(StringUtils.buildRandomNumbers(6));
        user.setSmsTime(StringUtils.currentTime());
        user.setUpdateTime(StringUtils.currentTime());
        insertOrUpdate(user);
        return new JsonResponser().ok();
    }
}