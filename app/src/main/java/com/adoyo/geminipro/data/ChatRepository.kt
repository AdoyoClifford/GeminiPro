package com.adoyo.geminipro.data

import com.adoyo.geminipro.util.Resource

interface ChatRepository {
   suspend fun getPrompt(prompt: String): Resource<String?>
   //suspend fun getPrompt(prompt: String): String?
}