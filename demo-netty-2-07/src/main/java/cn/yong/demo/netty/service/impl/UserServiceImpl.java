package cn.yong.demo.netty.service.impl;

import cn.yong.demo.netty.domain.User;
import cn.yong.demo.netty.service.UserRepository;
import cn.yong.demo.netty.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Line
 * @desc
 * @date 2022/9/28
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private UserRepository dataRepository;

    @Autowired
    public void setUserRepository(UserRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public void save(User user) {
        dataRepository.save(user);
    }

    @Override
    public void deleteById(String id) {
        dataRepository.deleteById(id);
    }

    @Override
    public User queryUserById(String id) {
        Optional<User> optionalUser = dataRepository.findById(id);
        return optionalUser.get();
    }

    @Override
    public Iterable<User> queryAll() {
        return dataRepository.findAll();
    }

    @Override
    public Page<User> findByName(String name, PageRequest request) {
        return dataRepository.findByName(name, request);
    }
}
