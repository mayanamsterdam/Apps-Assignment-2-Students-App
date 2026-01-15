import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.students.R

class StudentsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var nameTextView: TextView? = null
    private var idTextView: TextView? = null
    private var checkBox: CheckBox? = null
    private var student: Student? = null

    init {
        nameTextView = itemView.findViewById(R.id.student_row_layout_name_text_view)
        idTextView = itemView.findViewById(R.id.student_row_layout_id_text_view)
        checkBox = itemView.findViewById(R.id.student_row_layout_check_box)

        checkBox?.apply {
            setOnClickListener { view ->
                (tag as? Int)?.let {
                    student?.isChecked = (view as? CheckBox)?.isChecked ?: false
                }
            }
        }

        itemView.setOnClickListener { adapterPosition }
    }

    fun bind(student: Student?, position: Int) {
        this.student = student

        nameTextView?.text = student?.name
        idTextView?.text = student?.id
        checkBox?.apply {
            isChecked = student?.isChecked ?: false
            tag = position
        }
    }
}