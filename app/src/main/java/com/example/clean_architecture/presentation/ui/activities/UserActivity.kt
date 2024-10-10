package com.example.clean_architecture.presentation.ui.activities

import android.os.Bundle

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clean_architecture.R
import com.example.clean_architecture.databinding.ActivityUserBinding
import com.example.clean_architecture.presentation.model.toUserModel
import com.example.clean_architecture.presentation.ui.adapter.UserAdapter
import com.example.clean_architecture.presentation.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserActivity : AppCompatActivity() {
    private val userViewModel: UserViewModel by viewModels()
    private lateinit var binding: ActivityUserBinding
    private lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user)
        userAdapter = UserAdapter()
        binding.rvUserList.apply {
            layoutManager = LinearLayoutManager(this@UserActivity)
            adapter = userAdapter
        }

        binding.viewModel = userViewModel
        binding.lifecycleOwner = this


        searchView()

        userViewModel.users.observe(this) { users ->
            userAdapter.submitList(users.map { it.toUserModel() })
        }
        userViewModel.fetchUsers()
    }

    private fun searchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { userViewModel.searchUsers(it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { userViewModel.searchUsers(it) }
                return true
            }
        })
    }
}