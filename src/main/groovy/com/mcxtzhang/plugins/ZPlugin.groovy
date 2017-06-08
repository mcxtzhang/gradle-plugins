package com.mcxtzhang.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

class ZPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.gradle.buildFinished {
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
        }
        project.task('testTask') << {
            println "Hello gradle plugin!!!!@!@#!@#!@#!@#!#!@#!"
        }
        def xmlFile = new File(project.rootDir.getAbsolutePath() + "/app/src/main/AndroidManifest.xml")
        def rootManifest = new XmlSlurper().parse(xmlFile)
        String name = rootManifest['@package']
        println "task pkg name is :"+name

        String hahaahah= GroovyUtils.fansile(project)
        println "aaaaaaaaaaaaaaaaaaaa:"+hahaahah
    }
}
