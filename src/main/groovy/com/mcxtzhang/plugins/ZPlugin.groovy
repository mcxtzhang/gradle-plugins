package com.mcxtzhang.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project


class ZPlugin implements Plugin<Project> {
    void apply(Project project) {
/*        project.gradle.buildFinished {
            println 'I can go to sleep!!!!!!!!'
            println 'I can go to sleep!!!!!!!!'
            println 'I can go to sleep!!!!!!!!'
            println 'I can go to sleep!!!!!!!!'
            println 'I can go to sleep!!!!!!!!'
            println 'I can go to sleep!!!!!!!!'
            println 'I can go to sleep!!!!!!!!'
            println 'I can go to sleep!!!!!!!!'
            println 'I can go to sleep!!!!!!!!'
            println 'I can go to sleep!!!!!!!!'
            println 'I can go to sleep!!!!!!!!'
        }*/
/*        project.task('testTask') << {
            println "Hello gradle plugin!!!!@!@#!@#!@#!@#!#!@#!"
        }*/

/*        println "launch activity:"+GroovyUtils.getLaunchActivity(project)
        println "package name:"+GroovyUtils.getPkgName(project)*/

        //exec那些事
/*        project.task("startLaunchActivity") {
            def pkgName = GroovyUtils.getPkgName(project)
            def actName = GroovyUtils.getLaunchActivity(project)
            doLast {
                exec {
                    commandLine 'adb', 'shell', 'am', 'start', '-n', "$pkgName/$actName"
                }
            }
        }

        def pkgName = GroovyUtils.getPkgName(project)
        def actName = GroovyUtils.getLaunchActivity(project)
        project.tasks.create('test2'){
            doLast{
                project.exec{
                    commandLine 'adb', 'shell', 'am', 'start', '-n', "$pkgName/$actName"
                }
                project.exec{
                    commandLine 'adb', 'shell', 'dumpsys'
                }
            }
        }*/

        project.tasks.create("launchActivity", StartLaunchActivityTask)
        project.gradle.taskGraph.whenReady {
            project.tasks.getByName('installDebug') {
                it.doLast {
                    project.tasks.launchActivity.execute()
/*                    project.tasks.getByName('launchActivity') {
                        it.execute()
                    }*/
                }
            }
        }
    }
}
