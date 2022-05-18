package com.example.housekeeping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment

class BookServiceDialogFragment: DialogFragment() {
    override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v:View=inflater.inflate(R.layout.fragment_book_service_dialog,container,false)
        var flag = "Choose the service "
        var flag2 = "Choose hours "
        val findBT: Button = v.findViewById(R.id.findBT)
        val cancelBT: Button = v.findViewById(R.id.canselBT)
        val spinnerVal1: Spinner = v.findViewById(R.id.categorySP)
        val spinnerVal2: Spinner = v.findViewById(R.id.hoursSP)

        var opt = arrayOf("cooking", "washing", "dusting", "dog walking")
        var hou = arrayOf("1","7","9")
        val textFR : TextView =v.findViewById(R.id.textView2)
        spinnerVal1.adapter=
            activity?.let{
                ArrayAdapter<String>(it, android.R.layout.simple_expandable_list_item_1,opt)
            }
        // If you are working with Fragments it will not be resolved
        // You must call the activity context like this.
        //val adapter = activity?.let {
        //        ArrayAdapter<String>(
        //            it,
        //            android.R.layout.simple_spinner_item,
        //            campaignsType
        //        )
        //    }
        spinnerVal2.adapter= activity?.let{
            ArrayAdapter<String>(it ,android.R.layout.simple_expandable_list_item_1,hou)
        }


        findBT.setOnClickListener{view ->
            if (flag == "cooking") {
                if (flag2 == "1") {
                    textFR.text = "you will pay "+(1 * 3.75).toString() + " JOD"+" for "+flag2+" hour"
                }
                else if (flag2 == "2") {
                    textFR.text = "you will pay "+(2 * 3.75).toString() + " JOD"+" for "+flag2+" hours"
                }
                else if (flag2 == "7") {
                    textFR.text = "you will pay "+(7 * 3.75).toString() + " JOD"+" for "+flag2+" hours"
                }
                else if (flag2 == "9") {
                    textFR.text = "you will pay "+(9 * 3.75).toString() + " JOD"+" for "+flag2+" hours"
                }

            }
            else if (flag == "washing") {
                if (flag2 == "1") {
                    textFR.text = "you will pay "+(1 * 4.75).toString() + " JOD"+" for "+flag2+" hour"
                }
                else if (flag2 == "2") {
                    textFR.text = "you will pay "+(2 * 4.75).toString() + " JOD"+" for "+flag2+" hours"
                }
                else if (flag2 == "7") {
                    textFR.text = "you will pay "+(7 * 4.75).toString() + " JOD"+" for "+flag2+" hours"
                }
                else if (flag2 == "9") {
                    textFR.text = "you will pay "+(9 * 4.75).toString() + " JOD"+" for "+flag2+" hours"
                }
            }
            else if (flag == "dusting") {
                if (flag2 == "1") {
                    textFR.text = "you will pay "+(1*5).toString()+" JOD"+" for "+flag2+" hour"
                }
                else if (flag2 == "2") {
                    textFR.text = "you will pay "+(2*5).toString()+" JOD"+" for "+flag2+" hours"
                }
                else if (flag2 == "7") {
                    textFR.text = "you will pay "+(7*5).toString()+" JOD"+" for "+flag2+" hours"
                }
                else if (flag2 == "9") {
                    textFR.text = "you will pay "+(9*5).toString()+" JOD"+" for "+flag2+" hours"
                }
            }
            else if (flag == "dog walking") {
                if (flag2 == "1") {
                    textFR.text = "you will pay "+(1*7).toString()+" JOD"+" for "+flag2+" hour"
                }
                else if (flag2 == "2") {
                    textFR.text = "you will pay "+(2*7).toString()+" JOD"+" for "+flag2+" hours"
                }
                else if (flag2 == "7") {
                    textFR.text = "you will pay "+(7*7).toString()+" JOD"+" for "+flag2+" hours"
                }
                else if (flag2 == "9") {
                    textFR.text = "you will pay "+(9*7).toString()+" JOD"+" for "+flag2+" hours"
                }
            }

        }

        spinnerVal1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = opt.get(p2) // p2 is the index of selected ite

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }
        spinnerVal2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag2 = hou.get(p2) // p2 is the index of selected ite
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }
        cancelBT.setOnClickListener {
            dismiss()
        }
        return v
    }
}