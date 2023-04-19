package com.example.utspember

class Item_data (private val img: Int, private val nama: String, private val nim: String, private val umur: Int) {
    fun getImg(): Int {
        return img
    }

    fun getnama(): String {
        return nama
    }

    fun getnim(): String {
        return nim
    }

    fun getumur(): Int {
        return umur
    }
}
