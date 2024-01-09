package io.github.ecustse211.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.ecust_se211.recognition.recognition_camera.FaceRecognize;
import io.github.ecustse211.common.Constants;
import io.github.ecustse211.common.Result;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import io.github.ecustse211.service.ITeacherService;
import io.github.ecustse211.entity.Teacher;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* <p>
 *  前端控制器
 * </p>
 *
 * @author wwj
 * @since 2024-01-05
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Resource
    private ITeacherService teacherService;

    //新增或者更新
    @PostMapping
    public Result save(@RequestBody Teacher teacher) {
            return Result.success(teacherService.saveOrUpdate(teacher));
    }

    //删除
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
            return Result.success(teacherService.removeById(id));
    }

    //批量删除
    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids){
        return Result.success(teacherService.removeByIds(ids));
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(teacherService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return Result.success(teacherService.page(new Page<>(pageNum, pageSize),queryWrapper));
    }

    @PostMapping("/login")
    public Result login(@RequestBody Teacher teacher){
        String id = teacher.getId().toString();
        String password = teacher.getPassword();
        if(id.isEmpty() || password == null || password.isEmpty()){
            return Result.error(Constants.CODE_400,"参数错误");
        }
        Teacher teach = teacherService.login(teacher);
        return Result.success(teach);
    }
}
