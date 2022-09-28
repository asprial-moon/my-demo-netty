package cn.yong.demo.netty.service;

import cn.yong.demo.netty.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author Line
 * @desc
 * @date 2022/9/28
 */
public interface UserRepository extends ElasticsearchRepository<User, String> {

    Page<User> findByName(String name, Pageable pageable);
}
