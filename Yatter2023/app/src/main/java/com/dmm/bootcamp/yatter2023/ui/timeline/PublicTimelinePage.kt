package com.dmm.bootcamp.yatter2023.ui.timeline

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dmm.bootcamp.yatter2023.ui.timeline.PublicTimelineTemplate
import com.dmm.bootcamp.yatter2023.ui.timeline.PublicTimelineViewModel

// viewModelから状態を取り出し、Templateコンポーザブルに渡す
@Composable
fun PublicTimelinePage(viewModel: PublicTimelineViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    PublicTimelineTemplate(
        statusList = uiState.statusList,
        isLoading = uiState.isLoading,
        isRefreshing = uiState.isRefreshing,
        onRefresh = viewModel::onRefresh,
    )
}