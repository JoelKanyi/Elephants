package com.kanyideveloper.elephants

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.skydoves.transformationlayout.TransformationAppCompatActivity
import com.skydoves.transformationlayout.TransformationCompat
import com.skydoves.transformationlayout.TransformationLayout
import kotlinx.android.synthetic.main.elephant_details.*

class ElephantDetails : TransformationAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.elephant_details)

        intent.getParcelableExtra<Elephant>(elephantExtraName)?.let {
            Glide.with(this)
                .load(it.image)
                .into(eleph_image)
            eleph_name.text = it.name
            dob_value.text = it.dob
            species_value.text = it.species
            fictional_value.text = it.fictional
            sex_value.text = it.sex
            affiliation_value.text = it.affiliation
            description_value.text = it.description
        }
    }

    companion object {
        const val elephantExtraName = "elephantExtraName"
        fun startActivity(
            context: Context,
            transformationLayout: TransformationLayout,
            elephant: Elephant
        ) {
            val intent = Intent(context, ElephantDetails::class.java)
            intent.putExtra(elephantExtraName, elephant)
            TransformationCompat.startActivity(transformationLayout, intent)
        }
    }
}