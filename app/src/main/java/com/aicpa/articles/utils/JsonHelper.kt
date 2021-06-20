package com.aicpa.articles.utils

import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.reflect.TypeToken
import java.util.*

/**
 * Created by Noor aka Thor on 6/6/21.
 */
object JsonHelper {

    /**
     * @param object model class
     * @param classOfT Class to convert to json
     * @return jsonString converted from given object
     */
    fun parseObject(`object`: Any, classOfT: Class<*>): String? {
        return Gson().toJson(`object`, classOfT)
    }

    /**
     * @param jsonString should be a JsonObject
     * @param classOfT Class to filled from jsonString
     * @param <T> Generics
     * @return classOfT filled from jsonString
    </T> */
    fun <T> parseObject(jsonString: String, classOfT: Class<T>): T {
        return Gson().fromJson(jsonString, classOfT)
    }

    /**
     * @param jsonElement directly from ResponseBody. It should have a jsonArray but i'm also check might be it have jsonObject
     * @param classOfT Class to filled from jsonElement
     * @param <T> Generics
     * @return classOfT filled from jsonElement
    </T> */
    fun <T> parseObject(jsonElement: JsonElement?, classOfT: Class<T>): T? {
        val gson = Gson()
        if (jsonElement != null) {
            if (jsonElement.isJsonArray) {
                val jsonArray = jsonElement.asJsonArray
                if (jsonArray != null && jsonArray.size() > 0) {
                    val jsonObject = jsonArray[0].asJsonObject
                    return gson.fromJson(jsonObject.toString(), classOfT)
                }
            } else if (jsonElement.isJsonObject) {
                return gson.fromJson(jsonElement.asJsonObject.toString(), classOfT)
            }
        }
        return null
    }

    /**
     * @param jsonElement directly from ResponseBody. It should have a jsonArray but i'm also check might be it have jsonObject
     * @param classOfT Class to filled from jsonElement
     * @param <T> Generics
     * @return List<classOfT></classOfT> filled from jsonElement
     *
     * use TypeToken.getParameterized this method to achieve parsing using Generics
    </T> */
    fun <T> parseArray(jsonElement: JsonElement?, classOfT: Class<T>): List<T> {
        val gson = Gson()
        var list: MutableList<T> = ArrayList()
        if (jsonElement != null) {
            if (jsonElement.isJsonArray) {
                val jsonArray = jsonElement.asJsonArray
                if (jsonArray != null && jsonArray.size() > 0) {
//                Type type = new TypeToken<List<T>>() {}.getType();
                    val type = TypeToken.getParameterized(MutableList::class.java, classOfT).type
                    list = gson.fromJson(jsonArray.toString(), type)
                }
            } else if (jsonElement.isJsonObject) {
                list.add(gson.fromJson(jsonElement.asJsonObject.toString(), classOfT))
            }
        }
        return list
    }

    /**
     * @param jsonArrayString json string of objects as array
     * @param classOfT Class to filled from jsonElement
     * @param <T> Generics
     * @return List<classOfT></classOfT> filled from jsonElement
     *
     * use TypeToken.getParameterized this method to achieve parsing using Generics
    </T> */
    fun <T> parseArray(jsonArrayString: String, classOfT: Class<T>): List<T>? {
        val gson = Gson()
        val type = TypeToken.getParameterized(MutableList::class.java, classOfT).type
        return gson.fromJson(jsonArrayString, type)
    }

    /**
     * @param jsonElement directly from ResponseBody. It should have a jsonObject but i'm also check might be it have jsonArray
     * @param key key of value to extract
     * @return String value
     */
    fun getStringValue(jsonElement: JsonElement?, key: String): String? {
        if (jsonElement != null) {
            if (jsonElement.isJsonArray) {
                val jsonArray = jsonElement.asJsonArray
                if (jsonArray != null && jsonArray.size() > 0) {
                    val jsonObject = jsonArray[0].asJsonObject
                    return jsonObject[key].toString()
                }
            } else if (jsonElement.isJsonObject) {
                return jsonElement.asJsonObject[key].asString
            }
        }
        return ""
    }

    /**
     * @param jsonElement directly from ResponseBody.
     * @param key key of value to extract
     * @return boolean value
     */
    fun getBooleanValue(jsonElement: JsonElement?, key: String): Boolean {
        return if (jsonElement != null && jsonElement.isJsonObject) {
            jsonElement.asJsonObject[key].asBoolean
        } else false
    }
}





























