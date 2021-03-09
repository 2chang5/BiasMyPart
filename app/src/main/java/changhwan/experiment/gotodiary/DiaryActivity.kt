package changhwan.experiment.gotodiary

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_diary.*


class DiaryActivity : AppCompatActivity() {

    var softKeyboard: SoftKeyboard? = null
    var coverlayout: RelativeLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)

        //키보드 바 설정용 키보드 올라가고 내려가는 이벤트처리
        coverlayout = findViewById<View>(R.id.coverlayout) as RelativeLayout
        val controlManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        softKeyboard = SoftKeyboard(coverlayout, controlManager)
        softKeyboard!!.setSoftKeyboardCallback(object : SoftKeyboard.SoftKeyboardChanged {
            override fun onSoftKeyboardHide() {
                Handler(Looper.getMainLooper()).post {
                    keyBoardbar.visibility = View.INVISIBLE
                    forKeyboardSpace.visibility = View.GONE
                }
            }

            override fun onSoftKeyboardShow() {
                Handler(Looper.getMainLooper()).post {
                    keyBoardbar.visibility = View.VISIBLE
                    forKeyboardSpace.visibility = View.VISIBLE
                }
            }
        })


        //x버튼 눌렸을떄 돌아가기
        xButton.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
        }

        //날짜 표시
        if(intent.hasExtra("nowDate")){
            val nowDate = intent.getStringExtra("nowDate")
            diaryDate.text = nowDate
        } else if (intent.hasExtra("lastDate")){
            val lastDate = intent.getStringExtra("lastDate")
            diaryDate.text = lastDate
        }


        //누구의 몇번째 젤리표시



        //배경 카드색깔 젤리에 맞추기
        val emotion = intent.getIntExtra("emotion", 1)
        if(emotion == 1){
            diaryScrollCard.setBackgroundResource(R.drawable.for_diary_card1)
        }else if(emotion == 2){
            diaryScrollCard.setBackgroundResource(R.drawable.for_diary_card2)
        }else if(emotion == 3){
            diaryScrollCard.setBackgroundResource(R.drawable.for_diary_card3)
        }else if(emotion == 4){
            diaryScrollCard.setBackgroundResource(R.drawable.for_diary_card4)
        }else if(emotion == 5){
            diaryScrollCard.setBackgroundResource(R.drawable.for_diary_card5)
        }

        //이미지 넣기


        //텍스트 박스 포커스 조절


        //일기 내용 파이어스토어에 쳐넣기


        //일기작성완료
        saveButton.setOnClickListener{
            //로티 재생
            //이거 로티 재생후 넘어가자
            val intent = Intent(this, FinishDiary::class.java)
            startActivity(intent)
        }


    //       if (intent.hasExtra("emotion")){
//            val emotion = intent.getIntExtra("emotion",1).toString()
//            diaryText.text=emotion
//        }
    }

    //키보드 관련 디스트로이
    public override fun onDestroy() {
        super.onDestroy()
        softKeyboard!!.unRegisterSoftKeyboardCallback()
    }
}