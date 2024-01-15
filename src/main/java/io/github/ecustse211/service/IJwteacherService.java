package io.github.ecustse211.service;

import io.github.ecustse211.entity.Jwteacher;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wwj
 * @since 2024-01-09
 */
public interface IJwteacherService extends IService<Jwteacher> {

    Jwteacher login(Jwteacher jwteacher);
}
