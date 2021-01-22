package work.nbcc.kotlinassignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import work.nbcc.kotlinassignment1.databinding.ActivityMainBinding

const val KEY_COUNTER = "counter_key"

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    private val counter: Counter = Counter(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnCountDown.setOnClickListener {count( -1)}
        binding.btnCountUp.setOnClickListener {count( 1)}
        binding.btnToast.setOnClickListener {showCounter(it)}

        if (savedInstanceState != null) {
            counter.counter = savedInstanceState.getInt(KEY_COUNTER, 0)
        }

        binding.counter = counter
    }

    private fun count( step: Int){
        val newCounter: Int = ((binding.counter?.counter ) ?: 0) + step
        binding.apply {
            if(counter != null) {
                counter?.counter = newCounter;
            }
            invalidateAll();
        }
    }

    private fun showCounter(view: View){
        Toast.makeText(view.context, "Hello: ${counter.counter}", Toast.LENGTH_SHORT).show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNTER, counter.counter)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            counter.counter = savedInstanceState.getInt(KEY_COUNTER, 0)
        }
    }
}