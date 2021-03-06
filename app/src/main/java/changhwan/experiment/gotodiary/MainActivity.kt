package changhwan.experiment.gotodiary

import android.animation.ValueAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
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

        //최초 이미지 편법
        val animator = ValueAnimator.ofFloat(1f, 1f).setDuration(1)
        animator.addUpdateListener {
            jellyView.setProgress(it.getAnimatedValue() as Float)
        }
        animator.start()
        
        //plusbutton 설정
        plusButton.setOnClickListener {
            if(plusState==false){
                // Custom animation speed or duration.
                val animator = ValueAnimator.ofFloat(1f, 0f).setDuration(2000)
                animator.addUpdateListener {
                    jellyView.setProgress(it.getAnimatedValue() as Float)
                }
                animator.start()

                // 버튼 연타 금지
                plusButton.visibility = View.GONE

                Handler().postDelayed({
                    plusButton.visibility = View.VISIBLE
                }, 1300)


                jelly_button1.visibility = View.VISIBLE
                jelly_button2.visibility = View.VISIBLE
                jelly_button3.visibility = View.VISIBLE
                jelly_button4.visibility = View.VISIBLE
                jelly_button5.visibility = View.VISIBLE



                plusState = true
            } else {
                // Custom animation speed or duration.
                val animator = ValueAnimator.ofFloat(0f, 1f).setDuration(2000)
                animator.addUpdateListener {
                    jellyView.setProgress(it.getAnimatedValue() as Float)
                }
                animator.start()

                // 버튼 연타 금지
                plusButton.visibility = View.GONE

                Handler().postDelayed({
                    plusButton.visibility = View.VISIBLE
                }, 1300)


                jelly_button1.visibility = View.GONE
                jelly_button2.visibility = View.GONE
                jelly_button3.visibility = View.GONE
                jelly_button4.visibility = View.GONE
                jelly_button5.visibility = View.GONE


                plusState= false
            }
        }


        //스포트라이트 파트

        //1번젤리
        jelly_button1.setOnClickListener {
            //이파트 이해하고 싶다면 안드로이드 1강 섹션3 37강 부분을 참고하라
            val firstRoot = FrameLayout(this)
            val first = layoutInflater.inflate(R.layout.forspotlight, firstRoot)
            val firstTarget = Target.Builder()
                .setAnchor(jelly_button1)
                .setShape(Circle(120f))
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

        //2번젤리
        jelly_button2.setOnClickListener {
            //이파트 이해하고 싶다면 안드로이드 1강 섹션3 37강 부분을 참고하라
            val firstRoot = FrameLayout(this)
            val first = layoutInflater.inflate(R.layout.forspotlight, firstRoot)
            val firstTarget = Target.Builder()
                    .setAnchor(jelly_button2)
                    .setShape(Circle(120f))
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

            first.findViewById<View>(R.id.goToTwo).setOnClickListener(goToDiary)

        }

        //3번젤리
        jelly_button3.setOnClickListener {
            //이파트 이해하고 싶다면 안드로이드 1강 섹션3 37강 부분을 참고하라
            val firstRoot = FrameLayout(this)
            val first = layoutInflater.inflate(R.layout.forspotlight, firstRoot)
            val firstTarget = Target.Builder()
                    .setAnchor(jelly_button3)
                    .setShape(Circle(120f))
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

            first.findViewById<View>(R.id.goToThree).setOnClickListener(goToDiary)

        }

        //4번젤리
        jelly_button4.setOnClickListener {
            //이파트 이해하고 싶다면 안드로이드 1강 섹션3 37강 부분을 참고하라
            val firstRoot = FrameLayout(this)
            val first = layoutInflater.inflate(R.layout.forspotlight, firstRoot)
            val firstTarget = Target.Builder()
                    .setAnchor(jelly_button4)
                    .setShape(Circle(120f))
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

            first.findViewById<View>(R.id.goToFour).setOnClickListener(goToDiary)

        }

        //5번젤리
        jelly_button5.setOnClickListener {
            //이파트 이해하고 싶다면 안드로이드 1강 섹션3 37강 부분을 참고하라
            val firstRoot = FrameLayout(this)
            val first = layoutInflater.inflate(R.layout.forspotlight, firstRoot)
            val firstTarget = Target.Builder()
                    .setAnchor(jelly_button5)
                    .setShape(Circle(120f))
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

            first.findViewById<View>(R.id.goToFive).setOnClickListener(goToDiary)

        }
    }
}