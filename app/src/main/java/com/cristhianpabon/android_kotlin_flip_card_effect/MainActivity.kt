package com.cristhianpabon.android_kotlin_flip_card_effect

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    internal lateinit var frontCard : AnimatorSet
    internal lateinit var backCard : AnimatorSet
    internal var isFront = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scale : Float = applicationContext.resources.displayMetrics.density
        front_card.cameraDistance = 8000 * scale
        back_card.cameraDistance = 8000 * scale

        frontCard = AnimatorInflater.loadAnimator(applicationContext,R.animator.front_animator) as AnimatorSet
        backCard = AnimatorInflater.loadAnimator(applicationContext,R.animator.back_animator) as AnimatorSet

        rotateButton.setOnClickListener {
                 if(isFront){
                     frontCard.setTarget(front_card)
                     backCard.setTarget(back_card)
                     frontCard.start()
                     backCard.start()
                     isFront = false
                 } else {
                     frontCard.setTarget(back_card)
                     backCard.setTarget(front_card)
                     frontCard.start()
                     backCard.start()
                     isFront = true
                 }
        }


    }
}
