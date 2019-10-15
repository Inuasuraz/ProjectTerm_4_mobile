package buu.informatics.s59160081.projectterm_4


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import buu.informatics.s59160081.projectterm_4.databinding.FragmentMainBinding
import buu.informatics.s59160081.projectterm_4.databinding.FragmentMenuBinding
import kotlinx.android.synthetic.main.fragment_score.*

/**
 * A simple [Fragment] subclass.
 */
class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentMenuBinding>(inflater,
            R.layout.fragment_menu,container,false)

        binding.apply{
            playButton.setOnClickListener { findNavController()
                .navigate(R.id.action_menu_to_game) }

            highscoreButton.setOnClickListener { findNavController()
                .navigate(R.id.action_menu_to_score) }
        }

        return binding.root
    }


}
