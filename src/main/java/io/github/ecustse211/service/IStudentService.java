package io.github.ecustse211.service;

import io.github.ecustse211.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wwj
 * @since 2024-01-09
 */
public interface IStudentService extends IService<Student> {

    Student login(Student student);
}
