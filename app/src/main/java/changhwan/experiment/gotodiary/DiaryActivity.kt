package changhwan.experiment.gotodiary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_diary.*

class DiaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)

        if (intent.hasExtra("emotion")){
            val emotion = intent.getIntExtra("emotion",1).toString()
            diaryText.text=emotion
        }

    }
}