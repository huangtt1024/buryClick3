package com.hi.data.plugin.visitor

import com.hi.data.plugin.ClassNameAnalytics
import com.hi.data.plugin.common.VersionConstant
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.commons.AdviceAdapter

class UpdateSDKPluginVersionMV(
    api: Int,
    private val mMethodVisitor: MethodVisitor,
    access: Int,
    name: String?,
    desc: String?,
    private val mClassNameAnalytics: ClassNameAnalytics,
) : AdviceAdapter(
    api,
    mMethodVisitor, access, name, desc
) {
    override fun visitFieldInsn(opcode: Int, owner: String, fieldName: String, descriptor: String) {
        if (mClassNameAnalytics.isSensorsDataAPI && "ANDROID_PLUGIN_VERSION" == fieldName && opcode == PUTSTATIC) {
            mMethodVisitor.visitLdcInsn(VersionConstant.VERSION)
        }
        super.visitFieldInsn(opcode, owner, fieldName, descriptor)
    }
}