package com.mcxtzhang.plugins

/**
 * Intro: 
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/6/8.
 * History:
 */
class GroovyUtils {
    static def fansile(project) {
        def xmlFile = new File(project.rootDir.getAbsolutePath() + "/app/src/main/AndroidManifest.xml")
        def rootManifest = new XmlSlurper().parse(xmlFile)
        return rootManifest['@package']
    }
}
