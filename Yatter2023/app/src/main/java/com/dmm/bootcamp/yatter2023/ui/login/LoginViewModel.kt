package com.dmm.bootcamp.yatter2023.ui.login

import androidx.lifecycle.ViewModel
import com.dmm.bootcamp.yatter2023.domain.model.Password
import com.dmm.bootcamp.yatter2023.domain.model.Username
import com.dmm.bootcamp.yatter2023.usecase.login.LoginUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel(
    private val loginUseCase: LoginUseCase,
) : ViewModel() {
    fun onChangedUsername(username: String) {
        val snapshotBindingModel = uiState.value.loginBindingModel
        _uiState.update {
            it.copy(
                validUsername = Username(username).validate(),
                loginBindingModel = snapshotBindingModel.copy(
                    username = username
                )
            )
        }
    }

    fun onChangedPassword(password: String) {
        val snapshotBindingModel = uiState.value.loginBindingModel
        _uiState.update {
            it.copy(
                validPassword = Password(password).validate(),
                loginBindingModel = snapshotBindingModel.copy(
                    password = password
                )
            )
        }
    }

    fun onClickLogin() {}

    fun onClickRegister() {}

    private val _uiState: MutableStateFlow<LoginUiState> = MutableStateFlow(LoginUiState.empty())
    val uiState: StateFlow<LoginUiState> = _uiState
}