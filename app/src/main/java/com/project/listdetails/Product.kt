package com.project.listdetails

import java.io.Serializable

data class Product(val id: Int, val name: String, val price: Double, val imageResId: Int) : Serializable
