package buu.informatics.s59160081.projectterm_4


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import buu.informatics.s59160081.projectterm_4.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = DataBindingUtil.inflate<FragmentMainBinding>(inflater,
            R.layout.fragment_main,container,false)

        binding.apply{
            okButton.setOnClickListener { checkName(binding) }

            aboutButton.setOnClickListener { findNavController()
                .navigate(R.id.action_main_to_about) }

        }


        return binding.root
    }


     fun checkName(fragment: FragmentMainBinding){
        fragment.apply{
            if (editText.text.length >= 3){
//                Player.name = editText.text.toString()
//                Player.score = "0"
//                Player.

//                Toast.makeText(activity, Player.getName(), Toast.LENGTH_LONG).show()

                findNavController()
                    .navigate(R.id.action_mainFragment_to_menuFragment)
            }else{
                Toast.makeText(activity, "Name length must more than 3 character", Toast.LENGTH_LONG).show()
            }
        }
    }


}
