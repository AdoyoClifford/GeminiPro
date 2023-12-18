package com.adoyo.geminipro

import android.util.Log
import com.google.ai.client.generativeai.GenerativeModel


suspend fun generateText(prompt: String): String? {
    val generativeModel = GenerativeModel(
        modelName = "gemini-pro",
        apiKey = "AIzaSyBtf4cWulfZgf9cbiLG9VyWpjhQVU_Kiv4"
    )
    val response = generativeModel.generateContent(prompt)
    Log.d("ChatRepositoryImpl", "getPrompt: ${response.text}")

    return response.text
}