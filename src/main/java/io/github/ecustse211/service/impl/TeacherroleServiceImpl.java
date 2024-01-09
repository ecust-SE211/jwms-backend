package io.github.ecustse211.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.ecustse211.common.Constants;
import io.github.ecustse211.entity.Classstudent;
import io.github.ecustse211.entity.Teacherrole;
import io.github.ecustse211.exception.ServiceException;
import io.github.ecustse211.mapper.TeacherroleMapper;
import io.github.ecustse211.service.ITeacherroleService;
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
public class TeacherroleServiceImpl extends ServiceImpl<TeacherroleMapper, Teacherrole> implements ITeacherroleService {

    @Override
    public Boolean delete(Teacherrole one) {
        QueryWrapper<Teacherrole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tid", one.getTid());
        queryWrapper.eq("clid", one.getClid());
        remove(queryWrapper);    //从数据库查询用户信息
        return true;
    }

    @Override
    public Teacherrole find(Teacherrole one) {
        QueryWrapper<Teacherrole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tid", one.getTid());
        queryWrapper.eq("clid", one.getClid());
        Teacherrole res = getOne(queryWrapper);    //从数据库查询用户信息
        if(one != null){
            return res;
        }
        else{
            throw new ServiceException(Constants.CODE_600, "查找不到记录");
        }
    }
}