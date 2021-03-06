package changhwan.experiment.gotodiary

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.widget.FrameLayout
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.takusemba.spotlight.Spotlight
import com.takusemba.spotlight.Target
import com.takusemba.spotlight.shape.Circle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.forspotlight.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class MainActivity : AppCompatActivity() {

    var plusState : Boolean = false

    @RequiresApi(Build.VERSION_CODES.O)
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

            jelly_exp.visibility = View.GONE

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


        //인텐트시 날짜 넘겨주기 위해 받는거
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd EE")
        val formatted = current.format(formatter)

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

            //나머지 버튼가리기
            first.findViewById<View>(R.id.goToTwo).visibility = View.GONE
            first.findViewById<View>(R.id.goToThree).visibility = View.GONE
            first.findViewById<View>(R.id.goToFour).visibility = View.GONE
            first.findViewById<View>(R.id.goToFive).visibility = View.GONE


            val closeSpotlight = View.OnClickListener {
                //잠시 버튼 죽이기
                first.findViewById<View>(R.id.goToOne).visibility = View.GONE
                //레이아웃 터치 죽여야함
                first.findViewById<View>(R.id.background).visibility = View.GONE
                //스포트라이트 끄기
                spotlight.finish()
                //잠시 시간거쳐 애니메이션 효과후 살리기,백그라운드도 살리기
                Handler().postDelayed({
                    first.findViewById<View>(R.id.goToOne).visibility = View.VISIBLE
                    first.findViewById<View>(R.id.background).visibility = View.VISIBLE
                }, 1000)
                //버튼 다시 살려내기
                first.findViewById<View>(R.id.goToTwo).visibility = View.VISIBLE
                first.findViewById<View>(R.id.goToThree).visibility = View.VISIBLE
                first.findViewById<View>(R.id.goToFour).visibility = View.VISIBLE
                first.findViewById<View>(R.id.goToFive).visibility = View.VISIBLE
            }

            first.findViewById<View>(R.id.background).setOnClickListener(closeSpotlight)

            //다이어리로 넘어가기
            val goToDiary= View.OnClickListener { val intent = Intent(this, DiaryActivity::class.java)
                intent.putExtra("nowDate",formatted)
                intent.putExtra("emotion", 1)
                startActivity(intent)
                spotlight.finish()
            }

            first.findViewById<View>(R.id.goToOne).setOnClickListener(goToDiary)
        }

        //2번젤리
        jelly_button2.setOnClickListener {
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

            //나머지 버튼가리기
            first.findViewById<View>(R.id.goToOne).visibility = View.GONE
            first.findViewById<View>(R.id.goToThree).visibility = View.GONE
            first.findViewById<View>(R.id.goToFour).visibility = View.GONE
            first.findViewById<View>(R.id.goToFive).visibility = View.GONE


            val closeSpotlight = View.OnClickListener {
                //잠시 버튼 죽이기
                first.findViewById<View>(R.id.goToTwo).visibility = View.GONE
                //레이아웃 터치 죽여야함
                first.findViewById<View>(R.id.background).visibility = View.GONE
                //스포트라이트 끄기
                spotlight.finish()
                //잠시 시간거쳐 애니메이션 효과후 살리기,백그라운드도 살리기
                Handler().postDelayed({
                    first.findViewById<View>(R.id.goToTwo).visibility = View.VISIBLE
                    first.findViewById<View>(R.id.background).visibility = View.VISIBLE
                }, 1000)
                //버튼 다시 살려내기
                first.findViewById<View>(R.id.goToOne).visibility = View.VISIBLE
                first.findViewById<View>(R.id.goToThree).visibility = View.VISIBLE
                first.findViewById<View>(R.id.goToFour).visibility = View.VISIBLE
                first.findViewById<View>(R.id.goToFive).visibility = View.VISIBLE
            }

            first.findViewById<View>(R.id.background).setOnClickListener(closeSpotlight)

            //다이어리로 넘어가기
            val goToDiary= View.OnClickListener { val intent = Intent(this, DiaryActivity::class.java)
                intent.putExtra("nowDate",formatted)
                intent.putExtra("emotion", 2)
                startActivity(intent)
                spotlight.finish()
            }

            first.findViewById<View>(R.id.goToTwo).setOnClickListener(goToDiary)

        }

        //3번젤리
        jelly_button3.setOnClickListener {
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

            //나머지 버튼가리기
            first.findViewById<View>(R.id.goToOne).visibility = View.GONE
            first.findViewById<View>(R.id.goToTwo).visibility = View.GONE
            first.findViewById<View>(R.id.goToFour).visibility = View.GONE
            first.findViewById<View>(R.id.goToFive).visibility = View.GONE

            val closeSpotlight = View.OnClickListener {
                //잠시 버튼 죽이기
                first.findViewById<View>(R.id.goToThree).visibility = View.GONE
                //레이아웃 터치 죽여야함
                first.findViewById<View>(R.id.background).visibility = View.GONE
                //스포트라이트 끄기
                spotlight.finish()
                //잠시 시간거쳐 애니메이션 효과후 살리기,백그라운드도 살리기
                Handler().postDelayed({
                    first.findViewById<View>(R.id.goToThree).visibility = View.VISIBLE
                    first.findViewById<View>(R.id.background).visibility = View.VISIBLE
                }, 1000)
                //버튼 다시 살려내기
                first.findViewById<View>(R.id.goToOne).visibility = View.VISIBLE
                first.findViewById<View>(R.id.goToTwo).visibility = View.VISIBLE
                first.findViewById<View>(R.id.goToFour).visibility = View.VISIBLE
                first.findViewById<View>(R.id.goToFive).visibility = View.VISIBLE
            }

            first.findViewById<View>(R.id.background).setOnClickListener(closeSpotlight)

            //다이어리로 넘어가기
            val goToDiary= View.OnClickListener { val intent = Intent(this, DiaryActivity::class.java)
                intent.putExtra("nowDate",formatted)
                intent.putExtra("emotion", 3)
                startActivity(intent)
                spotlight.finish()
            }

            first.findViewById<View>(R.id.goToThree).setOnClickListener(goToDiary)

        }

        //4번젤리
        jelly_button4.setOnClickListener {
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

            //나머지 버튼가리기
            first.findViewById<View>(R.id.goToOne).visibility = View.GONE
            first.findViewById<View>(R.id.goToTwo).visibility = View.GONE
            first.findViewById<View>(R.id.goToThree).visibility = View.GONE
            first.findViewById<View>(R.id.goToFive).visibility = View.GONE


            val closeSpotlight = View.OnClickListener {
                //잠시 버튼 죽이기
                first.findViewById<View>(R.id.goToFour).visibility = View.GONE
                //레이아웃 터치 죽여야함
                first.findViewById<View>(R.id.background).visibility = View.GONE
                //스포트라이트 끄기
                spotlight.finish()
                //잠시 시간거쳐 애니메이션 효과후 살리기,백그라운드도 살리기
                Handler().postDelayed({
                    first.findViewById<View>(R.id.goToFour).visibility = View.VISIBLE
                    first.findViewById<View>(R.id.background).visibility = View.VISIBLE
                }, 1000)
                //버튼 다시 살려내기
                first.findViewById<View>(R.id.goToOne).visibility = View.VISIBLE
                first.findViewById<View>(R.id.goToTwo).visibility = View.VISIBLE
                first.findViewById<View>(R.id.goToThree).visibility = View.VISIBLE
                first.findViewById<View>(R.id.goToFive).visibility = View.VISIBLE
            }

            first.findViewById<View>(R.id.background).setOnClickListener(closeSpotlight)

            //다이어리로 넘어가기
            val goToDiary= View.OnClickListener { val intent = Intent(this, DiaryActivity::class.java)
                intent.putExtra("nowDate",formatted)
                intent.putExtra("emotion", 4)
                startActivity(intent)
                spotlight.finish()
            }

            first.findViewById<View>(R.id.goToFour).setOnClickListener(goToDiary)

        }

        //5번젤리
        jelly_button5.setOnClickListener {
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

            //나머지 버튼가리기
            first.findViewById<View>(R.id.goToOne).visibility = View.GONE
            first.findViewById<View>(R.id.goToTwo).visibility = View.GONE
            first.findViewById<View>(R.id.goToThree).visibility = View.GONE
            first.findViewById<View>(R.id.goToFour).visibility = View.GONE

            val closeSpotlight = View.OnClickListener { //잠시 버튼 죽이기
                first.findViewById<View>(R.id.goToFive).visibility = View.GONE
                //레이아웃 터치 죽여야함
                first.findViewById<View>(R.id.background).visibility = View.GONE
                //스포트라이트 끄기
                spotlight.finish()
                //잠시 시간거쳐 애니메이션 효과후 살리기,백그라운드도 살리기
                Handler().postDelayed({
                    first.findViewById<View>(R.id.goToFive).visibility = View.VISIBLE
                    first.findViewById<View>(R.id.background).visibility = View.VISIBLE
                }, 1000)
                //버튼 다시 살려내기
                first.findViewById<View>(R.id.goToOne).visibility = View.VISIBLE
                first.findViewById<View>(R.id.goToTwo).visibility = View.VISIBLE
                first.findViewById<View>(R.id.goToThree).visibility = View.VISIBLE
                first.findViewById<View>(R.id.goToFour).visibility = View.VISIBLE }

            first.findViewById<View>(R.id.background).setOnClickListener(closeSpotlight)

            //다이어리로 넘어가기
            val goToDiary= View.OnClickListener { val intent = Intent(this, DiaryActivity::class.java)
                intent.putExtra("nowDate",formatted)
                intent.putExtra("emotion", 5)
                startActivity(intent)
                spotlight.finish()
            }

            first.findViewById<View>(R.id.goToFive).setOnClickListener(goToDiary)

        }
    }
}