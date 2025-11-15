package kotlin.android.navigation

import android.content.context
import android.content.Intent
import kotlin.android.models.Postion
import your.package.name.PostionDetailActivity

object PostionNavigation {

    private const val EXTRA_POSTION = "extra_position"

    fun createDetailIntent(content: Context, position: Position): Intent {
        return Intent(context, PositionDetailActivity::class.java).apply{
            putExtra(EXTRA_POSTION, position)
        }
    }

    fun extractPosition(intent: Intent): Position {
        return intent.getParcelableExtra(EXTRA_POSITION)
            ?: error("Position extra is required")
    }
}