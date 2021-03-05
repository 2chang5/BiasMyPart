package changhwan.experiment.gotodiary

import android.animation.ValueAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.FrameLayout
import com.takusemba.spotlight.Spotlight
import com.takusemba.spotlight.Target
import com.takusemba.spotlight.shape.Circle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var plusState : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //플러스 로티
        plusState =  false

        plusButton.setOnClickListener {
            if(plusState==false){
                // Custom animation speed or duration.
                val animator = ValueAnimator.ofFloat(0f, 0.5f).setDuration(2000)
                animator.addUpdateListener {
                    jellyView.setProgress(it.getAnimatedValue() as Float)
                }
                animator.start()

                button1.visibility = View.VISIBLE
                button2.visibility = View.VISIBLE

                plusState = true
            } else {
                // Custom animation speed or duration.
                val animator = ValueAnimator.ofFloat(0.5f, 1f).setDuration(2000)
                animator.addUpdateListener {
                    jellyView.setProgress(it.getAnimatedValue() as Float)
                }
                animator.start()

                button1.visibility = View.GONE
                button2.visibility = View.GONE

                plusState= false
            }
        }


        //스포트라이트 파트

        button1.setOnClickListener {
            //이파트 이해하고 싶다면 안드로이드 1강 섹션3 37강 부분을 참고하라
            val firstRoot = FrameLayout(this)
            val first = layoutInflater.inflate(R.layout.forspotlight, firstRoot)
            val firstTarget = Target.Builder()
                .setAnchor(button1)
                .setShape(Circle(50f))
                .setOverlay(first)
                .build()

            val spotlight = Spotlight.Builder(this@MainActivity)
                .setTargets(firstTarget)
                .setBackgroundColorRes(R.color.spotlightBackground)
                .setDuration(1000L)
                .setAnimation(DecelerateInterpolator(2f))
                .build()

            spotlight.start()


            val closeSpotlight = View.OnClickListener { spotlight.finish() }

            first.findViewById<View>(R.id.background).setOnClickListener(closeSpotlight)

            //다이어리로 넘어가기
            val goToDiary= View.OnClickListener { val intent = Intent(this, DiaryActivity::class.java)
                startActivity(intent)
                spotlight.finish()
            }

            first.findViewById<View>(R.id.goToOne).setOnClickListener(goToDiary)

        }
    }
}