package io.github.ecustse211.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.ecustse211.common.Constants;
import io.github.ecustse211.common.Result;
import io.github.ecustse211.entity.Teacher;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import io.github.ecustse211.service.IJwteacherService;
import io.github.ecustse211.entity.Jwteacher;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wwj
 * @since 2024-01-09
 */
@RestController
@RequestMapping("/jwteacher")
public class JwteacherController {

    @Resource
    private IJwteacherService jwteacherService;

    //新增或者更新
    @PostMapping
    public Result save(@RequestBody Jwteacher jwteacher) {
            return Result.success(jwteacherService.saveOrUpdate(jwteacher));
    }

    //删除
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
            return Result.success(jwteacherService.removeById(id));
    }

    //批量删除
    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids){
            return Result.success(jwteacherService.removeByIds(ids));
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(jwteacherService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize) {
        QueryWrapper<Jwteacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return Result.success(jwteacherService.page(new Page<>(pageNum, pageSize),queryWrapper));
    }

    @PostMapping("/login")
    public Result login(@RequestBody Jwteacher jwteacher){
        String id = jwteacher.getId().toString();
        String password = jwteacher.getPassword();
        if(id.isEmpty() || password == null || password.isEmpty()){
            return Result.error(Constants.CODE_400,"参数错误");
        }
        Jwteacher teach = jwteacherService.login(jwteacher);
        return Result.success(teach);
    }
}
