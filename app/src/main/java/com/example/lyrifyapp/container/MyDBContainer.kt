package com.example.lyrifyapp.container

import com.example.lyrifyapp.Service.MyDBService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyDBContainer {
    companion object{
        //bekerja seperti static
        val BASE_IMG = ""
        var ACCESS_TOKEN = ""
    }
    //master URL
    //ipv4 address (BASE_URL diganti setiap kali pindah network/wifi)
    private val BASE_URL = "10.0.84.159/VisProgApi/public/api/"


    //token seperti kuncinya
    //client seperti lubang kunci
    private val client = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor(ACCESS_TOKEN))
        .build()

    //untuk mengakses API, perlu informasi yang dimasukkan ke dalam variabel retrofit
    private val retrofit  = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(client)
        .build()

    private val retrofitService: MyDBService by lazy{
        retrofit.create(MyDBService::class.java)
    }


    val myDBRepositories: MyDBRepositories by lazy{
        MyDBRepositories(retrofitService)
    }
}