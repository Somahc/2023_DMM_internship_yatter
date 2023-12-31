package com.dmm.bootcamp.yatter2023.ui.timeline

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Surface
import com.dmm.bootcamp.yatter2023.ui.post.PostActivity
import com.dmm.bootcamp.yatter2023.ui.theme.Yatter2023Theme
import org.koin.androidx.viewmodel.ext.android.viewModel

class PublicTimelineActivity : AppCompatActivity() {
    companion object {
        fun newIntent(context: Context): Intent = Intent(
            context,
            PublicTimelineActivity::class.java,
        )
    }

    private val viewModel: PublicTimelineViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.navigateToPost.observe(this) {
            startActivity(PostActivity.newIntent(this))
        }

        setContent {
            Yatter2023Theme {
                Surface {
                    PublicTimelinePage(viewModel = viewModel)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.onResume()
    }
}
