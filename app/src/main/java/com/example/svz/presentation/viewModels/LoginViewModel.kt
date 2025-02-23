package com.example.svz.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.svz.domain.models.TokenResponse
import com.example.svz.domain.useCase.GetTokensUseCase
import com.example.svz.domain.useCase.LoginUseCase
import kotlinx.coroutines.launch

