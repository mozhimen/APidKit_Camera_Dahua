package com.mozhimen.camerak_dahua_test

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mozhimen.basick.elemk.activity.bases.BaseActivityVB
import com.mozhimen.basick.utilk.exts.start
import com.mozhimen.basick.utilk.res.UtilKRes
import com.mozhimen.camerak_dahua_test.databinding.ActivityFunctionListBinding
import com.mozhimen.camerak_dahua_test.databinding.ItemFuncBinding
import com.mozhimen.uicorek.recyclerk.RecyclerKVBAdapter
import com.mozhimen.uicorek.recyclerk.RecyclerKVBViewHolder

class FunctionListActivity : BaseActivityVB<ActivityFunctionListBinding>() {
    private val _funcList = listOf(
        FuncBean(UtilKRes.getString(R.string.activity_function_list_live_preview)) {
            start<PreviewActivity>()
        }
    )

    override fun initView(savedInstanceState: Bundle?) {
        vb.recyclerFunc.layoutManager = LinearLayoutManager(this)
        vb.recyclerFunc.adapter = RecyclerKVBAdapter(
            _funcList,
            R.layout.item_func,
            BR.item_func
        ) { holder: RecyclerKVBViewHolder<ItemFuncBinding>, item: FuncBean, position: Int, currentSelectPos: Int ->
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