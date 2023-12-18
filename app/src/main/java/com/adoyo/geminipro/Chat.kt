package com.adoyo.geminipro

import android.util.Log
import com.google.ai.client.generativeai.GenerativeModel


suspend fun generateText(prompt: String): String? {
    val generativeModel = GenerativeModel(
        modelName = "gemini-pro",
        apiKey = BuildConfig.API_KEY
    )
    val response = generativeModel.generateContent(prompt)
    Log.d("ChatRepositoryImpl", "getPrompt: ${response.text}")

    return response.text
}