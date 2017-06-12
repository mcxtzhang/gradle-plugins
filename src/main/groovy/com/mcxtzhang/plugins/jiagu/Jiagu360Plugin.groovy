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
class Jiagu360Plugin implements Plugin<Project> {
    void apply(Project project) {
        project.extensions.create("Jiagu", JiaguExtension)
        Jiagu360Task jiagu360Task = project.tasks.create("jiagu", Jiagu360Task)
        ZipAndSignTask zipAndSignTask = project.tasks.create("zipSign", ZipAndSignTask);
        zipAndSignTask.dependsOn jiagu360Task

        project.afterEvaluate {
            project.tasks.getByName("assembleReleaseChannels") { task ->
                jiagu360Task.dependsOn task
                project.tasks.create("classOver") {
                    dependsOn zipAndSignTask
                    doLast {
                        println "jiaguZipSign finished.."
                    }
                }
            }
        }
        //zipSign依赖jiagu，jiagu依赖于walle。
        //最终任务依赖ZipSign

/*        project.tasks.create("jiaguZipSign") {
            dependsOn jiagu360Task, zipAndSignTask
            doLast {
                println "jiaguZipSign finished.."
            }
        }*/
    }
}
