package com.mcxtzhang.plugins
/**
 * Intro: 定义一些工具函数
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/6/8.
 * History:
 */
class GroovyUtils {
    static def getPkgName(project) {
        def xmlFile = project.file(project.rootDir.getAbsolutePath() + "/app/src/main/AndroidManifest.xml")
        def rootManifest = new XmlSlurper().parse(xmlFile)
        return rootManifest['@package']
    }

    static def getLaunchActivity(project) {
        def xmlFile = project.file(project.rootDir.getAbsolutePath() + "/app/src/main/AndroidManifest.xml")
        def rootManifest = new XmlSlurper().parse(xmlFile)
        def result = "";
        rootManifest.application.activity.each { activity ->
            String action = activity."intent-filter".action['@android:name']
            String category = activity."intent-filter".category['@android:name']
            if ("android.intent.action.MAIN" == action
                    && "android.intent.category.LAUNCHER" == category) {
                if (result == "") {
                    result = activity['@android:name']
                }
            }
        }
        return result
    }
}
