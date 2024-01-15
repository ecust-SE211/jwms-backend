package io.github.ecustse211.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.ecustse211.entity.Classstudent;
import io.github.ecustse211.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wwj
 * @since 2024-01-09
 */
public interface IClassstudentService extends IService<Classstudent> {

    Classstudent find(Classstudent one);

    Boolean delete(Classstudent one);

    List<Student> getStudentByClassId(Integer clid);
}
