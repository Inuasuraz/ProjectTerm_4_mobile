package buu.informatics.s59160081.projectterm_4.screens.main


import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import buu.informatics.s59160081.projectterm_4.R
import buu.informatics.s59160081.projectterm_4.databinding.FragmentMainBinding
import kotlinx.android.synthetic.main.fragment_main.*

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

        val binding = DataBindingUtil.inflate<FragmentMainBinding>(inflater,
            R.layout.fragment_main,container,false)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        binding.mainViewModel = viewModel

        binding.lifecycleOwner = this

        viewModel.eventInputFinish.observe(this, Observer<Boolean> { hasFinished ->
            if (hasFinished) viewModel.checkName(editText.text.toString())
        })

        viewModel.checkNameProcess.observe(this, Observer<Boolean> { hasFinished ->
            if (hasFinished) {
                findNavController()
                    .navigate(MainFragmentDirections.actionMainFragmentToMenuFragment( editText.text.toString(), 0 ))
            }
        })

        viewModel.showPopup.observe(this, Observer<Boolean> { hasFinished ->
            if (hasFinished) {
                Toast.makeText(activity, "Name length must be 4-8 character", Toast.LENGTH_LONG).show()
                viewModel._showPopup.value = false
            }
        })


        setHasOptionsMenu(true)

        Log.i("MainFragment", "Called ViewModelProviders.of")

        return binding.root
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
