/*
 * Copyright (C) 2018 Drake, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.drake.brv.sample.ui.fragment

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.drake.brv.sample.R
import com.drake.brv.sample.model.DoubleItemModel
import com.drake.brv.sample.model.Model
import com.drake.brv.utils.linear
import com.drake.brv.utils.setup
import kotlinx.android.synthetic.main.fragment_state_layout.*


class StateLayoutFragment : Fragment(R.layout.fragment_state_layout) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setHasOptionsMenu(true)
        rv.linear().setup {
            addType<Model>(R.layout.item_multi_type_simple)
            addType<DoubleItemModel>(R.layout.item_multi_type_two)
        }.models = getData()

    }

    private fun getData(): List<Any> {
        return listOf(
            Model(),
            DoubleItemModel(),
            DoubleItemModel(),
            Model(),
            Model(),
            Model(),
            Model(),
            DoubleItemModel(),
            DoubleItemModel(),
            DoubleItemModel(),
            Model(),
            Model(),
            Model()
        )
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_state, menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_loading -> state.showLoading()  // 加载中
            R.id.menu_content -> state.showContent() // 加载成功
            R.id.menu_error -> state.showError() // 加载错误
            R.id.menu_empty -> state.showEmpty() // 加载失败
        }
        return super.onOptionsItemSelected(item)
    }

}
