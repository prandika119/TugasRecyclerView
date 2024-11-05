package com.example.tugasrecycleview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tugasrecycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        val adapterGallery = GalleryAdapter(generatedataDummy())
        with(binding){
            recyclerViewGallery.apply {
                adapter = adapterGallery
                layoutManager = GridLayoutManager(this@MainActivity, 3)
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun generatedataDummy(): List<Gallery>{
        return listOf(
            Gallery("Gallery 1", R.drawable.galeri1),
            Gallery("Gallery 2", R.drawable.galeri2),
            Gallery("Gallery 3", R.drawable.galeri3),
            Gallery("Gallery 4", R.drawable.galeri4),
            Gallery("Gallery 5", R.drawable.galeri5),
        )
    }
}