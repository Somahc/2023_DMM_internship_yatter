package com.dmm.bootcamp.yatter2023.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.dmm.bootcamp.yatter2023.ui.theme.Yatter2023Theme
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
        Log.d("Login Activity", "onCreate")
        super.onCreate(savedInstanceState)

        viewModel.navigateToPublicTimeline.observe(this) {
            startActivity(PublicTimelineActivity.newIntent(this))
            finish()
        }

        viewModel.navigateToRegister.observe(this) {
            // 会員登録画面への遷移
        }
        setContent {
            Yatter2023Theme {
                Surface {
                    LoginPage(viewModel = viewModel)
                }
            }
        }
    }
}