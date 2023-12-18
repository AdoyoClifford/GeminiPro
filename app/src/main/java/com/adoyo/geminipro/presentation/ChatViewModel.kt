package com.adoyo.geminipro.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adoyo.geminipro.data.ChatRepository
import com.adoyo.geminipro.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class ChatViewModel(
    private val chatRepository: ChatRepository
) : ViewModel() {
    private val state = MutableStateFlow(ChatState())
    val chatState = state.asStateFlow()

    fun promptChanged(newPrompt: String) {
        state.update {
            it.copy(prompt = newPrompt)
        }

    }

    fun result() {
        viewModelScope.launch {
            chatRepository.getPrompt(chatState.value.prompt).let { resource ->
                when (resource) {
                    is Resource.Success -> {
                        state.update {
                            it.copy(result = resource.data ?: "")
                        }
                    }

                    is Resource.Error -> {
                        state.update {
                            it.copy(result = resource.message ?: "Check Your Internet Connection")
                        }
                    }

                    is Resource.Loading -> {
                        state.update {
                            it.copy(isLoading = true)
                        }
                    }
                }
            }
        }
    }


}