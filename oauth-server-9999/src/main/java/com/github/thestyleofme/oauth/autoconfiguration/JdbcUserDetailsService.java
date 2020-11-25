package com.github.thestyleofme.oauth.autoconfiguration;

import java.util.Collections;

import com.github.thestyleofme.common.pojo.Users;
import com.github.thestyleofme.oauth.dao.UsersRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * description
 * </p>
 *
 * @author isaac 2020/11/26 2:07
 * @since 1.0.0
 */
@Service
public class JdbcUserDetailsService implements UserDetailsService {

    private final UsersRepository usersRepository;

    public JdbcUserDetailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    /**
     * 根据username查询出该用户的所有信息，封装成UserDetails类型的对象返回，至于密码，框架会自动匹配
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        Users users = usersRepository.findByUsername(username);
        return new User(users.getUsername(), users.getPassword(), Collections.emptyList());
    }
}
