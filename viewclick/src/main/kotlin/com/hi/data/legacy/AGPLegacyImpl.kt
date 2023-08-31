package com.sensorsdata.analytics.android.gradle.legacy

import com.android.build.gradle.AppExtension
import com.hi.data.gradle.AGPCompatInterface
import com.hi.data.gradle.AGPVersion
import com.hi.data.gradle.AsmCompatFactory

import org.gradle.api.Project

@Suppress("DEPRECATION")
class AGPLegacyImpl(
    project: Project,
    override val asmWrapperFactory: AsmCompatFactory
) : com.hi.data.gradle.AGPCompatInterface {

    init {
        if (project.plugins.hasPlugin("com.android.application")) {
            val android = project.extensions.findByType(AppExtension::class.java)
            android?.registerTransform(AGPLegacyTransform(asmWrapperFactory, android))
        }
    }

    override val agpVersion: com.hi.data.gradle.AGPVersion
        //not real exists, it represents agp < 7.3.1
        get() = com.hi.data.gradle.AGPVersion(7, 3, 0)

}