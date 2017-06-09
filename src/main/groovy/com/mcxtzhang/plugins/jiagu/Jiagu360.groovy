package com.mcxtzhang.plugins.jiagu

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Intro: 
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/6/9.
 * History:
 */
class Jiagu360 implements Plugin<Project> {
    void apply(Project project) {
        project.tasks.create("jiagu",Jiagu360Task)
    }
}
