package com.github.thestyleofme.common.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


/**
 * <p>
 * description
 * </p>
 *
 * @author isaac 2020/11/12 3:46
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "r_resume")
public class Resume {

    @Id
    private Long id;
    private String sex;
    private String birthday;
    /**
     * 工作年限
     */
    private String workYear;
    private String phone;
    private String email;
    /**
     * 目前状态
     */
    private String status;
    /**
     * 简历名称
     */
    private String resumeName;
    private String name;
    private String createTime;
    /**
     * 头像
     */
    private String headPic;
    /**
     * 是否删除 默认值0-未删除 1-已删除
     */
    private Integer isDel;
    private String updateTime;
    private Long userId;
    /**
     * 是否为默认简历 0-默认 1-非默认
     */
    private Integer isDefault;
    /**
     * 最高学历
     */
    private String highestEducation;
    /**
     * 投递附件简历确认 0-需要确认 1-不需要确认
     */
    private Integer deliverNearByConfirm;
    /**
     * 简历被拒绝次数
     */
    private Integer refuseCount;
    /**
     * 被标记为可面试次数
     */
    private Integer markCanInterviewCount;
    /**
     * 已通知面试次数
     */
    private Integer haveNoticeInterCount;
    /**
     * 一句话介绍自己
     */
    private String oneWord;
    private String liveCity;
    /**
     * 简历得分
     */
    private Integer resumeScore;
    /**
     * 用户身份1-学生 2-工人
     */
    private Integer userIdentity;
    /**
     * 人才搜索-开放简历 0-关闭，1-打开，2-简历未达到投放标准被动关闭 3-从未设置过开放简历
     */
    private Integer isOpenResume;
}
