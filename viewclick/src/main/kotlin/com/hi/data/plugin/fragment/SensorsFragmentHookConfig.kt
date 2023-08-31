package com.hi.data.plugin.fragment

import com.hi.data.plugin.visitor.SensorsAnalyticsMethodCell
import org.objectweb.asm.Opcodes
import java.util.*

object SensorsFragmentHookConfig {
    const val SENSORS_FRAGMENT_TRACK_HELPER_API =
        "com/hi/data/autotrack/aop/FragmentLifecycleHelper"

    /**
     * Fragment中的方法
     */
    val FRAGMENT_METHODS = HashMap<String, SensorsAnalyticsMethodCell>()

    init {
        FRAGMENT_METHODS["onResume()V"] = SensorsAnalyticsMethodCell(
            "onResume",
            "()V",
            "",  // parent省略，均为 android/app/Fragment 或 android/support/v4/app/Fragment
            "trackFragmentResume",
            "(Ljava/lang/Object;)V",
            0, 1, listOf(Opcodes.ALOAD)
        )
        FRAGMENT_METHODS["setUserVisibleHint(Z)V"] =
            SensorsAnalyticsMethodCell(
                "setUserVisibleHint",
                "(Z)V",
                "",  // parent省略，均为 android/app/Fragment 或 android/support/v4/app/Fragment
                "trackFragmentSetUserVisibleHint",
                "(Ljava/lang/Object;Z)V",
                0, 2,
                Arrays.asList(Opcodes.ALOAD, Opcodes.ILOAD)
            )
        FRAGMENT_METHODS["onHiddenChanged(Z)V"] =
            SensorsAnalyticsMethodCell(
                "onHiddenChanged",
                "(Z)V",
                "",
                "trackOnHiddenChanged",
                "(Ljava/lang/Object;Z)V",
                0, 2,
                Arrays.asList(Opcodes.ALOAD, Opcodes.ILOAD)
            )
        FRAGMENT_METHODS["onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V"] =
            SensorsAnalyticsMethodCell(
                "onViewCreated",
                "(Landroid/view/View;Landroid/os/Bundle;)V",
                "",
                "onFragmentViewCreated",
                "(Ljava/lang/Object;Landroid/view/View;Landroid/os/Bundle;)V",
                0, 3,
                Arrays.asList(Opcodes.ALOAD, Opcodes.ALOAD, Opcodes.ALOAD)
            )
        FRAGMENT_METHODS["onPause()V"] = SensorsAnalyticsMethodCell(
            "onPause",
            "()V",
            "",  // parent省略，均为 android/app/Fragment 或 android/support/v4/app/Fragment
            "trackFragmentPause",
            "(Ljava/lang/Object;)V",
            0, 1, listOf(Opcodes.ALOAD)
        )
        FRAGMENT_METHODS["onDestroyView()V"] = SensorsAnalyticsMethodCell(
            "onDestroyView",
            "()V",
            "",  // parent省略，均为 android/app/Fragment 或 android/support/v4/app/Fragment
            "trackFragmentDestroyView",
            "(Ljava/lang/Object;)V",
            0, 1, listOf(Opcodes.ALOAD)
        )
    }
}