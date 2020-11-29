package com.github.thestyleofme.resume.service.impl;

import java.util.Optional;

import com.github.thestyleofme.common.pojo.Resume;
import com.github.thestyleofme.dubbo.api.ResumeService;
import com.github.thestyleofme.resume.dao.ResumeDao;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.data.domain.Example;

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
    public Integer findDefaultResumeByUserId(Long userId) {
        // 查询默认简历
        Resume resume = Resume.builder()
                .userId(userId)
                .isDefault(1)
                .build();
        Example<Resume> example = Example.of(resume);
        Optional<Resume> one = resumeDao.findOne(example);
        if (one.isPresent()) {
            return one.get().getIsOpenResume();
        }
        return -1;
    }
}
