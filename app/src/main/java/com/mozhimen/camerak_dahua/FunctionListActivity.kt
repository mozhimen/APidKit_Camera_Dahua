package com.mozhimen.camerak_dahua

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.company.netsdk.R
import com.mozhimen.basick.basek.BaseKActivityVB
import com.mozhimen.basick.extsk.start
import com.mozhimen.basick.utilk.res.UtilKRes
import com.mozhimen.camerak_dahua.databinding.ActivityFunctionListBinding
import com.mozhimen.camerak_dahua.databinding.ItemFuncBinding
import com.mozhimen.uicorek.recyclerk.AdapterKRecycler
import com.mozhimen.uicorek.recyclerk.RecyclerKVBViewHolder

class FunctionListActivity : BaseKActivityVB<ActivityFunctionListBinding>() {
    private val _funcList = listOf(
        FuncBean(UtilKRes.getString(R.string.activity_function_list_live_preview)) {
            start<PreviewActivity>()
        }
    )

    override fun initData(savedInstanceState: Bundle?) {
        vb.recyclerFunc.layoutManager = LinearLayoutManager(this)
        vb.recyclerFunc.adapter = AdapterKRecycler(
            _funcList,
            com.mozhimen.camerak_dahua.R.layout.item_func,
            BR.item_func
        ) { holder: RecyclerKVBViewHolder<ItemFuncBinding>, item: FuncBean, _: Int ->
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