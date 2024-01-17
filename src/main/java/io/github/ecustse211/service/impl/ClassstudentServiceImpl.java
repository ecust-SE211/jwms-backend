package io.github.ecustse211.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.ecustse211.common.Constants;
import io.github.ecustse211.entity.Classstudent;
import io.github.ecustse211.entity.Student;
import io.github.ecustse211.exception.ServiceException;
import io.github.ecustse211.mapper.ClassstudentMapper;
import io.github.ecustse211.service.IClassstudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wwj
 * @since 2024-01-09
 */
@Service
public class ClassstudentServiceImpl extends ServiceImpl<ClassstudentMapper, Classstudent> implements IClassstudentService {

    @Override
    public Classstudent find(Classstudent one) {
        QueryWrapper<Classstudent> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sid", one.getSid());
        queryWrapper.eq("clid", one.getClid());
        Classstudent res = getOne(queryWrapper);    //从数据库查询用户信息
        if(one != null){
            return res;
        }
        else{
            throw new ServiceException(Constants.CODE_600, "查找不到记录");
        }
    }

    @Override
    public Boolean delete(Classstudent one) {
            QueryWrapper<Classstudent> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("sid", one.getSid());
            queryWrapper.eq("clid", one.getClid());
            remove(queryWrapper);    //从数据库查询用户信息
            return true;
    }

    @Override
    public List<Student> getStudentByClassId(Integer clid) {
        List<Student> studentIdList = this.baseMapper.getStudentByClassId(clid);
        return studentIdList;
    }
}
