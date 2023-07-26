package com.dmm.bootcamp.yatter2023.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.dmm.bootcamp.yatter2023.ui.timeline.PublicTimelineActivity
import org.koin.androidx.viewmodel.ext.android.viewModel



class LoginActivity : ComponentActivity() {
    private val viewModel: LoginViewModel by viewModel()
    companion object {
        fun newIntent(context: Context): Intent = Intent(
            context,
            LoginActivity::class.java,
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.navigateToPublicTimeline.observe(this) {
            startActivity(PublicTimelineActivity.newIntent(this))
            finish()
        }

        viewModel.navigateToRegister.observe(this) {
            // 会員登録画面への遷移
        }
    }
}