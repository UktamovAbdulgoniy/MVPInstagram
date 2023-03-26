package com.uktamov.mvpinstagram.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.uktamov.mvpinstagram.R
import com.uktamov.mvpinstagram.adapter.UserAdapter
import com.uktamov.mvpinstagram.databinding.FragmentHomeBinding
import com.uktamov.mvpinstagram.databinding.FragmentProfileBinding
import com.uktamov.mvpinstagram.model.Data
import com.uktamov.mvpinstagram.model.UserResponse
import com.uktamov.mvpinstagram.presenter.MainPresenterImpl
import com.uktamov.mvpinstagram.presenter.MainView

class ProfileFragment : Fragment(),MainView {
    private val adapter1 by lazy { UserAdapter() }
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var presenter: MainPresenterImpl

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = MainPresenterImpl(this)

        binding.rv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapter1
        }

        presenter.getAllUserList()
    }

    override fun onUserListSuccess(data: UserResponse) {
        adapter1.submitList(data.data)
    }

    override fun onUserListFailure(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }

}