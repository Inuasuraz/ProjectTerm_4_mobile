package buu.informatics.s59160081.projectterm_4.screens.menu


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import buu.informatics.s59160081.projectterm_4.R
import buu.informatics.s59160081.projectterm_4.databinding.FragmentMenuBinding
import buu.informatics.s59160081.projectterm_4.screens.main.MainFragmentDirections
import buu.informatics.s59160081.projectterm_4.screens.main.MainViewModel

/**
 * A simple [Fragment] subclass.
 */
class MenuFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val args = MenuFragmentArgs.fromBundle(arguments!!)

        val binding = DataBindingUtil.inflate<FragmentMenuBinding>(inflater,
            R.layout.fragment_menu,container,false)



        binding.apply{
//            playButton.setOnClickListener { findNavController()
//                .navigate(R.id.action_menu_to_game) }

            playButton.setOnClickListener { findNavController()
                .navigate(MenuFragmentDirections.actionMenuToGame( args.username , args.userscore )) }

            highscoreButton.setOnClickListener { findNavController()
                .navigate(MenuFragmentDirections.actionMenuToScore( args.username , args.userscore )) }


//            highscoreButton.setOnClickListener { findNavController()
//                .navigate(R.id.action_menu_to_score) }
        }

        Toast.makeText(activity, args.username + " " + args.userscore, Toast.LENGTH_LONG).show()

//        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
//
//        viewModel.name.observe(this, Observer {
//                Toast.makeText(activity, viewModel.name.value.toString(), Toast.LENGTH_LONG).show()
//        })

        return binding.root
    }


}
