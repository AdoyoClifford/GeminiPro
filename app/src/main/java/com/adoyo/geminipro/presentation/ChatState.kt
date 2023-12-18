package com.adoyo.geminipro.presentation

data class ChatState(
    var prompt: String = "",
    var result: String = "",
    var isLoading: Boolean = false
)