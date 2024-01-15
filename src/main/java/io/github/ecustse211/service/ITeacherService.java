package io.github.ecustse211.service;

import io.github.ecustse211.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wwj
 * @since 2024-01-05
 */
public interface ITeacherService extends IService<Teacher> {

    Teacher login(Teacher teacher);
}
