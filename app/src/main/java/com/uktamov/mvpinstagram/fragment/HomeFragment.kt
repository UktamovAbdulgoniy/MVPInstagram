package com.uktamov.mvpinstagram.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uktamov.mvpinstagram.R
import com.uktamov.mvpinstagram.adapter.UserAdapter
import com.uktamov.mvpinstagram.adapter.UserAdapterH
import com.uktamov.mvpinstagram.databinding.FragmentHomeBinding
import com.uktamov.mvpinstagram.model.Data
import com.uktamov.mvpinstagram.model.UserResponse
import com.uktamov.mvpinstagram.presenter.MainPresenterImpl
import com.uktamov.mvpinstagram.presenter.MainView

class HomeFragment : Fragment(),MainView {

    private val adapter1 by lazy { UserAdapter() }
    private val adapter2 by lazy { UserAdapterH() }
    private var _binding:FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var presenter: MainPresenterImpl
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = MainPresenterImpl(this)

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
        }

        binding.rvH.apply {
            layoutManager = LinearLayoutManager(requireContext(),RecyclerView.HORIZONTAL,false)
            adapter = adapter2
        }

        binding.rvV.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapter1
        }
        presenter.getAllUserList()

    }

    override fun onUserListSuccess(data: UserResponse) {
        adapter2.submitList(data.data)
        adapter1.submitList(data.data)
    }

    override fun onUserListFailure(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
        Log.d("@@@", "onUserListFailure: $error")
    }

}