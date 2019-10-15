package buu.informatics.s59160081.projectterm_4


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import buu.informatics.s59160081.projectterm_4.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = DataBindingUtil.inflate<FragmentMainBinding>(inflater,
            R.layout.fragment_main,container,false)

        binding.apply{
            okButton.setOnClickListener { findNavController()
                .navigate(R.id.action_mainFragment_to_menuFragment) }

            aboutButton.setOnClickListener { findNavController()
                .navigate(R.id.action_main_to_about) }
        }


        return binding.root
    }


}
