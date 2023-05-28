package com.developer.myapplication.ui.profil

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.developer.myapplication.MenuLokasiPengambilanActivity
import com.developer.myapplication.R
import com.developer.myapplication.databinding.ActivityMainBinding
import com.developer.myapplication.databinding.FragmentProfilBinding
import com.developer.myapplication.databinding.FragmentRiwayatBinding
import com.developer.myapplication.ui.riwayat.RiwayatFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class ProfilFragment : Fragment() {

    private var _binding: FragmentProfilBinding? = null
    private lateinit var buttonRiwayat:Button
    private lateinit var buttonPengaturan:Button
    private lateinit var buttonKeluar:Button


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val profilViewModel =
//            ViewModelProvider(this).get(ProfilViewModel::class.java)

        _binding = FragmentProfilBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textProfil
//        profilViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
//        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        return root
    }
//    override fun onResume() {
//        super.onResume()
//        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
//    }
//
//    override fun onStop() {
//        super.onStop()
//        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonRiwayat= this.requireView().findViewById<Button>(R.id.button_riwayat_donasi_akun);
        buttonPengaturan= this.requireView().findViewById<Button>(R.id.button_pengaturan_akun);
        buttonKeluar= this.requireView().findViewById<Button>(R.id.button_keluar_akun);

        buttonRiwayat.setOnClickListener {
            requireActivity().run {
                startActivity(Intent(this, RiwayatFragment::class.java))
                finish()
            }
        }


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.


    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}