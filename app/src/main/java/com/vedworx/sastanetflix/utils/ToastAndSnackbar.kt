
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.vedworx.sastanetflix.activities.fragmentholder
import com.vedworx.sastanetflix.authenticationActivity
import com.vedworx.sastanetflix.ui.informationenter

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.login() {
    val intent = Intent(this, fragmentholder::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }
    startActivity(intent)
}

fun Context.profileEnter() {
    val intent = Intent(this, informationenter::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }
    startActivity(intent)
}

fun Context.authentication() {
    val intent = Intent(this, authenticationActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }
    startActivity(intent)
}