package gulbozor.uz.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import gulbozor.uz.R
import gulbozor.uz.core.adapters.ChildAdapter
import gulbozor.uz.core.exampleModels.ExampleModel
import gulbozor.uz.databinding.FragmentHomeBinding
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val adapter = ChildAdapter()
    private var layoutManager: StaggeredGridLayoutManager? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewState()
        loadData()
    }

    @SuppressLint("SimpleDateFormat")
    private fun loadData() {
        adapter.clearData()
        val formatter = SimpleDateFormat("EEE, d MMM yyyy HH:mm a")
        val date = Date()
        val childItems: ArrayList<ExampleModel> = ArrayList()
        val item1 = ExampleModel(
            "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.ygTqdnNKaCM37SL2BpROQwHaFj%26pid%3DApi&f=1",
            "Atirgul",
            formatter.format(date),
            300000
        )
        val item2 = ExampleModel(
            "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.aO91QYJjZ36B0RivNtRCbAHaFj%26pid%3DApi&f=1",
            "Savatdagi gul",
            formatter.format(date),
            500000
        )
        val item3 = ExampleModel(
            "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse3.mm.bing.net%2Fth%3Fid%3DOIP.xYziNyTJYtJRS9-j6rvz-AHaEK%26pid%3DApi&f=1",
            "Moychechak",
            formatter.format(date),
            40000
        )
        val item4 = ExampleModel(
            "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.OHnOWmJ2tZi5gTR3vEO1YgHaJ4%26pid%3DApi&f=1",
            "Tuvakli kaktus",
            formatter.format(date),
            30000
        )
        val item5 = ExampleModel(
            "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.UsUmDLmOl7Nmjn-_ooPxOQHaHa%26pid%3DApi&f=1",
            "Tuvakli kaktus",
            formatter.format(date),
            60000
        )
        childItems.add(item1)
        childItems.add(item2)
        childItems.add(item3)
        childItems.add(item4)
        childItems.add(item5)
        adapter.setChildItems(childItems)
    }

    private fun setViewState() {
        layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        binding.recyclerHomeFragment.adapter = adapter
        layoutManager.let {
            binding.recyclerHomeFragment.layoutManager = it
        }
        binding.recyclerHomeFragment.setHasFixedSize(true)
    }
}