package com.developer.myapplication.ui.donasi

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.developer.myapplication.LandingPageActivity
import com.developer.myapplication.MapsActivity
import com.developer.myapplication.MenuLokasiPengambilanActivity
import com.developer.myapplication.R
import com.developer.myapplication.RegisActivity
import com.developer.myapplication.databinding.FragmentDonasiBinding

class DonasiFragment : Fragment() {

    private var _binding: FragmentDonasiBinding? = null
    private lateinit var buttonBack:Button
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val donasiViewModel =
//            ViewModelProvider(this).get(DonasiViewModel::class.java)

        _binding = FragmentDonasiBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textDonasi
//        donasiViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonBack= this.requireView().findViewById<Button>(R.id.button_donasi_makanan);
        buttonBack.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, MenuLokasiPengambilanActivity::class.java))
                finish()
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}