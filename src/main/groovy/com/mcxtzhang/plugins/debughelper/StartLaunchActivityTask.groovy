package com.mcxtzhang.plugins.debughelper

import com.mcxtzhang.plugins.GroovyUtils
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
/**
 * Intro: 
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/6/9.
 * History:
 */
class StartLaunchActivityTask extends DefaultTask {

    @TaskAction
    def launch() {
        def pkgName = GroovyUtils.getPkgName(project)
        def actName = GroovyUtils.getLaunchActivity(project)
        println "jump $pkgName/$actName"
/*        println "jump $pkgName/$actName"
        println "jump $pkgName/$actName"
        println "jump $pkgName/$actName"
        println "jump $pkgName/$actName"
        println "jump $pkgName/$actName"
        println "jump $pkgName/$actName"
        println "jump $pkgName/$actName"
        println "jump $pkgName/$actName"
        println "jump $pkgName/$actName"
        println "jump $pkgName/$actName"*/
        project.exec{
            commandLine 'adb', 'shell', 'am', 'start', '-n', "$pkgName/$actName"
        }
    }
}
