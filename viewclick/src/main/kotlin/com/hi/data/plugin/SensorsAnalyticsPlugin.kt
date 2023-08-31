package com.hi.data.plugin

import com.hi.data.gradle.loadCompatImpl
import com.hi.data.plugin.manager.SAPluginManager
import org.gradle.api.Plugin
import org.gradle.api.Project

class SensorsAnalyticsPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        println("SensorsAnalyticsPlugin Run Task !!!")
        loadCompatImpl(project, AsmCompatFactoryImpl(SAPluginManager(project)))
    }
}