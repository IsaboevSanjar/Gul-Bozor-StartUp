package gulbozor.uz.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import gulbozor.uz.core.adapters.ViewPagerAdapter
import gulbozor.uz.databinding.ActivityMoreInfoBinding

class MoreInformation : AppCompatActivity() {
    private var _binding: ActivityMoreInfoBinding? = null
    private val binding get() = _binding!!
    var viewAdapter: ViewPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMoreInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewAdapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = viewAdapter
        binding.dot3.attachTo(binding.viewPager)

    }
}