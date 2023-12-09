package com.project.listdetails

// ProductListActivity.kt
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProductListActivity : AppCompatActivity() {

    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        val productList = generateProductList()

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        productAdapter = ProductAdapter(productList) { selectedProduct, imageView ->
            showProductDetail(selectedProduct, imageView)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = productAdapter
    }

    private fun showProductDetail(product: Product, productImage: ImageView) {
        val intent = Intent(this, ProductDetailActivity::class.java)
        intent.putExtra("product", product)
        intent.putExtra("imageResId", product.imageResId)
        startActivity(intent)
    }

    private fun generateProductList(): List<Product> {
        val productList = mutableListOf<Product>()

        productList.add(Product(1, "Product 1", 19.99, R.drawable.pic1))
        productList.add(Product(2, "Product 2", 29.99, R.drawable.pic2))
        productList.add(Product(3, "Product 3", 39.99, R.drawable.pic3))

        return productList
    }
}

