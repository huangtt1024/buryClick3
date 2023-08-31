package com.sensorsdata.analytics.android.gradle.legacy

import com.hi.data.gradle.AGPContext
import com.hi.data.gradle.AsmCompatFactory


object AGPLegacyContextImpl : com.hi.data.gradle.AGPContext {
    override var asmCompatFactory: AsmCompatFactory? = null
}