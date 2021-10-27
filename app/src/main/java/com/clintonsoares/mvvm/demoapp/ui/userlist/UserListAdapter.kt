package com.clintonsoares.mvvm.demoapp.ui.userlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.clintonsoares.mvvm.demoapp.R
import com.clintonsoares.mvvm.demoapp.model.User

class UserListAdapter(
    private val users: ArrayList<User>
) : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        holder.userName.text = user.name
        holder.userEmail.text = user.email
        Glide.with(holder.userImage.context)
            .load(user.avatar)
            .into(holder.userImage)

    }

    fun addData(list: List<User>) {
        users.addAll(list)
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val userName: TextView = itemView.findViewById(R.id.textViewUserName)
        val userEmail: TextView = itemView.findViewById(R.id.textViewUserEmail)
        val userImage: ImageView = itemView.findViewById(R.id.imageViewAvatar)
    }
}