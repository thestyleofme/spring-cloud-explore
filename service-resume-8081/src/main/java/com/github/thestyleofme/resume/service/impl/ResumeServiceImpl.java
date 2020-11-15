package com.github.thestyleofme.resume.service.impl;

import com.github.thestyleofme.common.pojo.Resume;
import com.github.thestyleofme.resume.dao.ResumeDao;
import com.github.thestyleofme.resume.service.ResumeService;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

/**
 * <p>
 * description
 * </p>
 *
 * @author isaac 2020/11/12 3:57
 * @since 1.0.0
 */
@Service
public class ResumeServiceImpl implements ResumeService {

    private final ResumeDao resumeDao;

    public ResumeServiceImpl(ResumeDao resumeDao) {
        this.resumeDao = resumeDao;
    }

    @Override
    public Resume findDefaultResumeByUserId(Long userId) {
        // 查询默认简历
        Resume resume = Resume.builder()
                .userId(userId)
                .isDefault(1)
                .build();
        Example<Resume> example = Example.of(resume);
        return resumeDao.findOne(example).orElse(null);
    }
}
