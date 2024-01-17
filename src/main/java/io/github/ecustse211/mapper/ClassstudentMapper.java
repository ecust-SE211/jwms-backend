package io.github.ecustse211.mapper;

import io.github.ecustse211.entity.Classstudent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.ecustse211.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wwj
 * @since 2024-01-09
 */
public interface ClassstudentMapper extends BaseMapper<Classstudent> {
    public List<Student> getStudentByClassId(@Param("clid") Integer clid);
}
