package com.mozhimen.pidk.camera.dahua.test

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mozhimen.basick.elemk.androidx.appcompat.bases.databinding.BaseActivityVDB
import com.mozhimen.basick.utilk.android.content.UtilKRes
import com.mozhimen.basick.utilk.android.content.startContext
import com.mozhimen.pidk.camera.dahua.test.databinding.ActivityFunctionListBinding
import com.mozhimen.pidk.camera.dahua.test.databinding.ItemFuncBinding
import com.mozhimen.xmlk.recyclerk.quick.AdapterKQuickRecyclerVB
import com.mozhimen.xmlk.vhk.VHKRecyclerVDB

class FunctionListActivity : BaseActivityVDB<ActivityFunctionListBinding>() {
    private val _funcList = mutableListOf(
        FuncBean(UtilKRes.gainString(R.string.activity_function_list_live_preview)) {
            startContext<PreviewActivity>()
        }
    )

    override fun initView(savedInstanceState: Bundle?) {
        vdb.recyclerFunc.layoutManager = LinearLayoutManager(this)
        vdb.recyclerFunc.adapter = AdapterKQuickRecyclerVB<FuncBean, ItemFuncBinding>(
            _funcList,
            R.layout.item_func,
            BR.item_func
        ) { holder: VHKRecyclerVDB<ItemFuncBinding>, item: FuncBean, position: Int, currentSelectPos: Int ->
            holder.vdb.btnFunc.setOnClickListener {
                item.func.invoke()
            }
        }
    }

    data class FuncBean(
        val name: String,
        val func: () -> Unit
    )
}