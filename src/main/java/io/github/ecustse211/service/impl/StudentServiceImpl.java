package io.github.ecustse211.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.ecustse211.common.Constants;
import io.github.ecustse211.entity.Student;
import io.github.ecustse211.entity.Teacher;
import io.github.ecustse211.exception.ServiceException;
import io.github.ecustse211.mapper.StudentMapper;
import io.github.ecustse211.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wwj
 * @since 2024-01-09
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Override
    public Student login(Student student) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", student.getId());
        queryWrapper.eq("password", student.getPassword());
        Student one = getOne(queryWrapper);    //从数据库查询用户信息
        if(one != null){
            return one;
        }
        else{
            throw new ServiceException(Constants.CODE_600, "用户名或密码错误");
        }
    }
}
