package io.github.ecustse211.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.ecustse211.common.Constants;
import io.github.ecustse211.entity.Jwteacher;
import io.github.ecustse211.entity.Teacher;
import io.github.ecustse211.exception.ServiceException;
import io.github.ecustse211.mapper.JwteacherMapper;
import io.github.ecustse211.service.IJwteacherService;
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
public class JwteacherServiceImpl extends ServiceImpl<JwteacherMapper, Jwteacher> implements IJwteacherService {

    @Override
    public Jwteacher login(Jwteacher jwteacher) {
        QueryWrapper<Jwteacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", jwteacher.getId());
        queryWrapper.eq("password", jwteacher.getPassword());
        Jwteacher one = getOne(queryWrapper);    //从数据库查询用户信息
        if(one != null){
            return one;
        }
        else{
            throw new ServiceException(Constants.CODE_600, "用户名或密码错误");
        }
    }
}
