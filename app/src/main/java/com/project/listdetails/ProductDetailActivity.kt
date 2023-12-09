package com.project.listdetails

// ProductDetailActivity.kt
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProductDetailActivity : AppCompatActivity() {

    private var quantity: Int = 1
    private lateinit var product: Product
    private var totalPrice: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        product = intent.getSerializableExtra("product") as Product

        val imageResId = intent.getIntExtra("imageResId", R.drawable.pic1)

        val productImageDetail: ImageView = findViewById(R.id.productImageDetail)
        val productNameTextView: TextView = findViewById(R.id.productNameDetail)
        val productPriceTextView: TextView = findViewById(R.id.productPriceDetail)
        val quantityTextView: TextView = findViewById(R.id.quantityTextView)

        productImageDetail.setImageResource(imageResId)
        productNameTextView.text = product.name
        productPriceTextView.text = "Price: $${product.price}"
        quantityTextView.text = quantity.toString()
        updateTotalPrice()
    }

    fun increaseQuantity(view: View) {
        quantity++
        val quantityTextView: TextView = findViewById(R.id.quantityTextView)
        quantityTextView.text = quantity.toString()
        updateTotalPrice()
    }

    fun backToProductList(view: View) {
        finish()
    }

    private fun updateTotalPrice() {
        totalPrice = quantity * product.price
        val totalPriceTextView: TextView = findViewById(R.id.totalPriceTextView)
        totalPriceTextView.text = "Total Price: $$totalPrice"
    }

}
