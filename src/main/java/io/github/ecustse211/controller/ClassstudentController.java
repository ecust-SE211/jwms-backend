package io.github.ecustse211.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.ecustse211.common.Result;
import io.github.ecustse211.entity.Classstudent;
import io.github.ecustse211.entity.Student;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import io.github.ecustse211.service.IClassstudentService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wwj
 * @since 2024-01-09
 */
@RestController
@RequestMapping("/classstudent")
public class ClassstudentController {

    @Resource
    private IClassstudentService classstudentService;

    //新增或者更新
    @PostMapping
    public Result save(@RequestBody Classstudent classstudent) {
            return Result.success(classstudentService.saveOrUpdate(classstudent));
    }

    //删除
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
            return Result.success(classstudentService.removeById(id));
    }

    @GetMapping("/{id}")    //按照Classstudent变量查找
    public Result findOne(@PathVariable Integer id) {
        return Result.success(classstudentService.getById(id));
    }

    @DeleteMapping("/delete")   //按照Classstudent变量删除
    public Result deleteOne(@RequestBody Classstudent one) {
        Boolean res = classstudentService.delete(one);
        return Result.success(res);
    }

    @GetMapping("/find")
    public Result findOne(@RequestBody Classstudent one) {
        Classstudent res = classstudentService.find(one);
        return Result.success(res);
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize) {
        QueryWrapper<Classstudent> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return Result.success(classstudentService.page(new Page<>(pageNum, pageSize),queryWrapper));
    }

    //根据班级id查找学生
    @GetMapping("/student")
    public Result getStudentByClassId(@RequestParam Integer clid){
        List<Student> studentIdList = classstudentService.getStudentByClassId(clid);
        return Result.success(studentIdList);
    }

    //根据学生id查找教学班
    @GetMapping("/class")
    public Result getClassByStudentId(@RequestParam Integer sid){
        QueryWrapper<Classstudent> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sid", sid);
        queryWrapper.orderByDesc("id");
        return Result.success(classstudentService.page(new Page<>(1, 100),queryWrapper));
    }
}
