package com.example.takvim

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.takvim.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var myViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Activity'ye bağlı ViewModel kullanıyoruz
        myViewModel = ViewModelProvider(this)[MyViewModel::class.java]

        // Sayaç değişikliklerini gözlemliyoruz
        myViewModel.counter.observe(this) { counter ->
            Toast.makeText(this, "Sayaç Değeri $counter", Toast.LENGTH_LONG).show()
            binding.textViewCounter.text = counter.toString()
        }

        // BirinciFragment'ı başlatıyoruz
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView, BirinciFragment())
            .addToBackStack(null)
            .commit()

        // Fragment değiştirme butonuna tıklama işlemi
        binding.btnFragmentDegistir.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, IkinciFragment())
                .addToBackStack(null)
                .commit()
        }

        // Sayaç arttırma butonuna tıklama işlemi
        binding.btnArttir.setOnClickListener {
            myViewModel.incrementCounter()
        }

        // Sayaç azaltma butonuna tıklama işlemi
        binding.btnAzalt.setOnClickListener {
            myViewModel.decrementCounter()
        }
    }
}
