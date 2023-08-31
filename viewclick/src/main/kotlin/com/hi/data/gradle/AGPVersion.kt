/*
 * Created by zhangwei on 2023/05/06.
 * Copyright 2015－2023 Sensors Data Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hi.data.gradle

/**
 * Represents current Android Gradle Plugin version.
 */
class AGPVersion(val major: Int, private val minor: Int, private val micro: Int) :
    Comparable<com.hi.data.gradle.AGPVersion> {

    override fun compareTo(other: com.hi.data.gradle.AGPVersion): Int {
        var delta = this.major - other.major
        if (delta != 0) {
            return delta
        }
        delta = this.minor - other.minor
        if (delta != 0) {
            return delta
        }
        delta = this.micro - other.micro
        if (delta != 0) {
            return delta
        }
        return 0
    }

    companion object {
        val CURRENT_AGP_VERSION: com.hi.data.gradle.AGPVersion by lazy {
            com.hi.data.gradle.AGPVersion.Companion.parseVersion()
        }

        val AGP_7_3_1: com.hi.data.gradle.AGPVersion by lazy {
            com.hi.data.gradle.AGPVersion(7, 3, 1)
        }

        private fun calVersionStr(): String {
            var clazz =
                com.hi.data.gradle.loadClass("com.android.Version")
                    ?: com.hi.data.gradle.loadClass("com.android.builder.model.Version")
            clazz?.apply {
                return getDeclaredField("ANDROID_GRADLE_PLUGIN_VERSION").get(this).toString()
            }
            error("Could not find Android Gradle Plugin version.")
        }

        private fun parseVersion(): com.hi.data.gradle.AGPVersion {
            val vs = com.hi.data.gradle.AGPVersion.Companion.calVersionStr()
            val list: List<String> = vs.split(".")
            val result = "\\d*".toRegex().find(list[2])
            return com.hi.data.gradle.AGPVersion(list[0].toInt(), list[1].toInt(), result?.value?.toInt() ?: 0)
        }
    }
}