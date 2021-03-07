package changhwan.experiment.gotodiary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_diary.*

class DiaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)

        //x버튼 눌렸을떄 돌아가기
        xButton.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
        }

        //날짜 표시
        if(intent.hasExtra("nowDate")){
            val date = intent.getStringExtra("nowDate")
            diaryDate.text = date
        } else if (intent.hasExtra("lastDate")){

        }


        //누구의 몇번째 젤리표시



//        if (intent.hasExtra("emotion")){
//            val emotion = intent.getIntExtra("emotion",1).toString()
//            diaryText.text=emotion
//        }
    }
}