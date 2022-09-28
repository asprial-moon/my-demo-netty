package cn.yong.demo.netty.service;

import cn.yong.demo.netty.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @author Line
 * @desc
 * @date 2022/9/28
 */
public interface UserService {

    void save(User user);

    void deleteById(String id);

    User queryUserById(String id);

    Iterable<User> queryAll();

    Page<User> findByName(String name, PageRequest request);
}
