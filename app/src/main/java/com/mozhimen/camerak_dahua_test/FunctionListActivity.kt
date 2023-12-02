package com.mozhimen.camerak_dahua_test

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mozhimen.basick.elemk.androidx.appcompat.bases.BaseActivityVB
import com.mozhimen.basick.utilk.android.content.UtilKRes
import com.mozhimen.basick.utilk.android.content.startContext
import com.mozhimen.camerak_dahua_test.databinding.ActivityFunctionListBinding
import com.mozhimen.camerak_dahua_test.databinding.ItemFuncBinding
import com.mozhimen.uicorek.adapterk.quick.AdapterKQuickRecyclerVB
import com.mozhimen.uicorek.vhk.VHKRecyclerVB

class FunctionListActivity : BaseActivityVB<ActivityFunctionListBinding>() {
    private val _funcList = mutableListOf(
        FuncBean(UtilKRes.getString(R.string.activity_function_list_live_preview)) {
            startContext<PreviewActivity>()
        }
    )

    override fun initView(savedInstanceState: Bundle?) {
        vb.recyclerFunc.layoutManager = LinearLayoutManager(this)
        vb.recyclerFunc.adapter = AdapterKQuickRecyclerVB<FuncBean,ItemFuncBinding>(
            _funcList,
            R.layout.item_func,
            BR.item_func
        ) { holder: VHKRecyclerVB<ItemFuncBinding>, item: FuncBean, position: Int, currentSelectPos: Int ->
            holder.vb.btnFunc.setOnClickListener {
                item.func.invoke()
            }
        }
    }

    data class FuncBean(
        val name: String,
        val func: () -> Unit
    )
}