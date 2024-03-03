package net.cctv3.chnqoodiaryservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.cctv3.chnqoodiaryservice.entity.User;

public interface UserService extends IService<User> {
    String sendSms(String mobile);
}