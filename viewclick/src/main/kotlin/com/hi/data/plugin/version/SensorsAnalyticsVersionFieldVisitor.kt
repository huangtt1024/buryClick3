package com.hi.data.plugin.version

import com.hi.data.plugin.ClassNameAnalytics
import com.hi.data.plugin.common.VersionConstant.MIN_SDK_VERSION
import com.hi.data.plugin.common.VersionConstant.VERSION
import com.hi.data.plugin.utils.Logger.error
import com.hi.data.plugin.utils.SAUtils.compareVersion
import com.hi.data.plugin.utils.TextUtil.isEmpty
import org.objectweb.asm.FieldVisitor

class SensorsAnalyticsVersionFieldVisitor(
    api: Int,
    fieldVisitor: FieldVisitor?,
    private val mName: String?,
    private val mValue: Any?,
    private val mSdkVersionHelper: SensorsDataSDKVersionHelper,
    private val mClassNameAnalytics: ClassNameAnalytics
) : FieldVisitor(api, fieldVisitor) {

    override fun visitEnd() {
        if (mClassNameAnalytics.isSensorsDataAPI) {
            if ("VERSION" == mName) {
                val version = mValue as String
                if (compareVersion(MIN_SDK_VERSION, version) > 0) {
                    val errMessage = String.format(
                        "你目前集成的神策埋点 SDK 版本号为 v%s，请升级到 v%s 及以上的版本。详情请参考：https://github.com/sensorsdata/sa-sdk-android",
                        version,
                        MIN_SDK_VERSION
                    )
                    error(errMessage)
                    throw Error(errMessage)
                }
                val message = mSdkVersionHelper.getMessageBySDKCurrentVersion(mClassNameAnalytics.className, version)
                if (!isEmpty(message)) {
                    throw Error(message)
                }
            } else if ("MIN_PLUGIN_VERSION" == mName) {
                val minPluginVersion = mValue as String
                if (!isEmpty(minPluginVersion)) {
                    if (compareVersion(VERSION, minPluginVersion) < 0) {
                        val errMessage = String.format(
                            "你目前集成的神策插件版本号为 v%s，请升级到 v%s 及以上的版本。详情请参考：https://github.com/sensorsdata/sa-sdk-android-plugin2",
                            VERSION,
                            minPluginVersion
                        )
                        error(errMessage)
                        throw Error(errMessage)
                    }
                }
            }
        } else if (mClassNameAnalytics.isSensorsDataVersion) {
            if (SensorsDataSDKVersionHelper.VERSION_KEY_CURRENT_VERSION == mName) {
                val version = mValue as String
                val message = mSdkVersionHelper.getMessageBySDKCurrentVersion(mClassNameAnalytics.className, version)
                if (!isEmpty(message)) {
                    throw Error(message)
                }
            } else if (SensorsDataSDKVersionHelper.VERSION_KEY_DEPENDENT_SDK_VERSION == mName) {
                val relatedOtherSDK = mValue as String
                val message =
                    mSdkVersionHelper.getMessageBySDKRelyVersion(mClassNameAnalytics.className, relatedOtherSDK)
                if (!isEmpty(message)) {
                    throw Error(message)
                }
            }
        }
        super.visitEnd()
    }
}