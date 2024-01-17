package io.github.ecustse211.mapper;

import io.github.ecustse211.entity.Course;
import io.github.ecustse211.entity.Student;
import io.github.ecustse211.entity.Teacherrole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface TeacherroleMapper extends BaseMapper<Teacherrole> {
    public List<Course> getCourseListByTeacherId(@Param("tid") Integer tid);
    public List<Integer> getStudentIdByTeacherId(@Param("tid") Integer tid);
}
