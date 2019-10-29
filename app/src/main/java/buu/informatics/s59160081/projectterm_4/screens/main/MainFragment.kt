package buu.informatics.s59160081.projectterm_4.screens.main


import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import buu.informatics.s59160081.projectterm_4.R
import buu.informatics.s59160081.projectterm_4.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = DataBindingUtil.inflate<FragmentMainBinding>(inflater,
            R.layout.fragment_main,container,false)

        binding.apply{
            okButton.setOnClickListener { checkName(binding) }
        }

        setHasOptionsMenu(true)

        Log.i("MainFragment", "Called ViewModelProviders.of")
//        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        return binding.root
    }


     fun checkName(fragment: FragmentMainBinding){
        fragment.apply{
            if (editText.text.length >= 3){
//                viewModel.name.postValue(editText.text.toString())

//                 viewModel.updateName(editText.text.toString())

//                Toast.makeText(activity, viewModel.name.value, Toast.LENGTH_LONG).show()

//                findNavController()
//                    .navigate(R.id.action_mainFragment_to_menuFragment)

                var username = editText.text.toString()
                var userscore = 0

                Log.i("MainFragment", "Username : ${username}")
                Log.i("MainFragment", "Userscore : ${userscore}")

                findNavController()
                    .navigate(MainFragmentDirections.actionMainFragmentToMenuFragment( username , userscore ))
            }else{
                Toast.makeText(activity, "Name length must more than 3 character", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.about_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }


}
