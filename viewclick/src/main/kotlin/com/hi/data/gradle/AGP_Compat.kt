package com.hi.data.gradle

import com.sensorsdata.analytics.android.gradle.legacy.AGPLegacyImpl
import com.sensorsdata.analytics.android.gradle.v7_3.V73Impl
import org.gradle.api.Project

fun loadCompatImpl(project: Project, asmWrapperFactory: AsmCompatFactory): com.hi.data.gradle.AGPCompatInterface {
    val version = com.hi.data.gradle.AGPVersion.CURRENT_AGP_VERSION
    return if (version >= com.hi.data.gradle.AGPVersion.AGP_7_3_1) {
        V73Impl(project, asmWrapperFactory)
    } else {
        AGPLegacyImpl(project, asmWrapperFactory)
    }
}