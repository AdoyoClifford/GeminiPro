package com.adoyo.geminipro.data

import android.util.Log
import com.adoyo.geminipro.BuildConfig
import com.adoyo.geminipro.util.Resource
import com.google.ai.client.generativeai.GenerativeModel

class ChatRepositoryImpl : ChatRepository {
        override suspend fun getPrompt(prompt: String): Resource<String?> {
       // emit(Resource.Loading())
        val generativeModel = GenerativeModel(
            modelName = "gemini-pro",
            apiKey = BuildConfig.API_KEY
        )

        try {
            val response = generativeModel.generateContent(prompt).text
            Log.d("ChatRepositoryImpl", "getPrompt: $response")
            return Resource.Success(response)

        } catch (e: Exception) {

            Log.d("ChatRepositoryImpl", "getPrompt: ${e.message.toString()}")
        }
        return Resource.Error("Error", null)
    }
//    override suspend fun getPrompt(prompt: String): String? {
//        val generativeModel = GenerativeModel(
//            modelName = "gemini-pro",
//            apiKey = "AIzaSyCDAz0DybTqG6x1MvtRyiBZ28ioLphm4FM"
//        )
//        val response = generativeModel.generateContent(prompt)
//        Log.d("ChatRepositoryImpl", "getPrompt: ${response.text}")
//
//        return response.text
//    }

}