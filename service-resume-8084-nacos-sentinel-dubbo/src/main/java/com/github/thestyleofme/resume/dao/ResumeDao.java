package com.github.thestyleofme.resume.dao;

import com.github.thestyleofme.common.pojo.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 * description
 * </p>
 *
 * @author isaac 2020/11/12 3:58
 * @since 1.0.0
 */
public interface ResumeDao extends JpaRepository<Resume, Long> {

}
