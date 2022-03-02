package com.aelsayed.bitpanda.presentation.main

import android.os.Bundle
import com.aelsayed.bitpanda.R
import com.aelsayed.bitpanda.presentation.base.activity.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun getNavControllerId(): Int = R.id.activityMainBitzHostFragment

}