package com.example.StartApp.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.StartApp.App.App
import com.example.StartApp.R
import com.example.StartApp.domain.model.SomeData
import com.example.StartApp.presentation.viewmodel.SomeViewModel
import com.example.StartApp.presentation.viewmodel.SomeViewModelFactory
import kotlinx.coroutines.launch
import javax.inject.Inject


class SomeFragment : BaseFragment() {

    @Inject
    lateinit var vmFactory:SomeViewModelFactory
    val wm by lazy {
        ViewModelProvider(this, vmFactory).get(SomeViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_some, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val out:TextView = view.findViewById(R.id.success)
        val butToGet:Button = view.findViewById(R.id.butOfGetData)
        val inputOfSaveFirstName:EditText = view.findViewById(R.id.inputOfSaveFirstName)
        val butToSave:Button = view.findViewById(R.id.butOfSaveData)

        (getActivity()?.getApplicationContext() as App).appComponent.injectSomeFragment(this)
//
//        launch {
//            vmFactory.insertToDatabase(SomeDataStorage(
//                id = 12,
//                some = "adsf"
//            ))
//      }


        wm.lifeResultDatabaseConst.observe(viewLifecycleOwner){

            out.text = it.some.toString()
        }

        butToSave.setOnClickListener {
            Log.d("lolk","DSF")
            launch {
                wm.insertToDatabase(
                    SomeData(
                        some = inputOfSaveFirstName.text.toString()
                    )
                )
            }
        }

        butToGet.setOnClickListener {
            Log.d("lolk","DSF")
            launch {
                wm.getFromDatabase()
            }
        }


    }
}