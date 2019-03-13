package com.Mrs.Wang.project.utils;

import java.util.UUID;

/**
 * @program: spring-boot-api-project-seed
 * @description: UUID生成工具类
 * @author: hezijian6338
 * @create: 2019-03-13 15:16
 **/

public class UUIDUtils {
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
