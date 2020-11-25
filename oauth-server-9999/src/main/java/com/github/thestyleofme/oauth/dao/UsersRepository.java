package com.github.thestyleofme.oauth.dao;

import com.github.thestyleofme.common.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 * description
 * </p>
 *
 * @author isaac 2020/11/26 2:08
 * @since 1.0.0
 */
public interface UsersRepository extends JpaRepository<Users, Long> {

    /**
     * 根据用户名查询用户
     *
     * @param username username
     * @return Users
     */
    Users findByUsername(String username);
}
