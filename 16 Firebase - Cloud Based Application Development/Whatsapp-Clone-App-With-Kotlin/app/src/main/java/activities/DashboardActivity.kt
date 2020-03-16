package activities

import adapters.SectionPagerAdapter
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mychatapp.R
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        var sectionAdapter:SectionPagerAdapter? = null

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        supportActionBar!!.title = "Dashboard"

        sectionAdapter = SectionPagerAdapter(supportFragmentManager)
        dashViewPagerId.adapter = sectionAdapter
        mainTabs.setupWithViewPager(dashViewPagerId)
        mainTabs.setTabTextColors(Color.WHITE, Color.GREEN)

        if(intent.extras != null)
        {
            var username = intent.extras!!.get("name")
            Toast.makeText(this, username.toString(), Toast.LENGTH_LONG).show()
        }
    }
}
