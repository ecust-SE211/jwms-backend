package io.github.ecustse211.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.ecustse211.common.Constants;
import io.github.ecustse211.entity.Teacher;
import io.github.ecustse211.exception.ServiceException;
import io.github.ecustse211.mapper.TeacherMapper;
import io.github.ecustse211.service.ITeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wwj
 * @since 2024-01-05
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {

    @Override
    public Teacher login(Teacher teacher) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", teacher.getId());
        queryWrapper.eq("password", teacher.getPassword());
        Teacher one = getOne(queryWrapper);    //从数据库查询用户信息
        if(one != null){
            return one;
        }
        else{
            throw new ServiceException(Constants.CODE_600, "用户名或密码错误");
        }
    }
}
