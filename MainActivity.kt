package com.alefba.club

import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var content: LinearLayout
    private val cream = Color.rgb(247,243,234)
    private val gold = Color.rgb(201,147,45)
    private val dark = Color.rgb(45,45,45)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showHome()
    }

    private fun text(value: String, size: Float = 16f, bold: Boolean = false): TextView =
        TextView(this).apply {
            text = value
            textSize = size
            setTextColor(dark)
            gravity = Gravity.RIGHT or Gravity.CENTER_VERTICAL
            setPadding(20, 16, 20, 16)
            if (bold) setTypeface(typeface, android.graphics.Typeface.BOLD)
        }

    private fun card(value: String) {
        val v = text(value)
        v.setBackgroundColor(Color.WHITE)
        val p = LinearLayout.LayoutParams(-1, -2)
        p.setMargins(0, 8, 0, 8)
        content.addView(v, p)
    }

    private fun base(title: String) {
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(cream)
            layoutDirection = LinearLayout.LAYOUT_DIRECTION_RTL
        }
        val header = LinearLayout(this).apply {
            gravity = Gravity.CENTER_VERTICAL
            setPadding(12, 20, 12, 10)
        }
        header.addView(text("الفبا", 24f, true).apply { setTextColor(gold) })
        header.addView(text(title, 20f, true), LinearLayout.LayoutParams(0, 70, 1))
        root.addView(header)

        val scroll = ScrollView(this)
        content = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(16, 4, 16, 8)
            layoutDirection = LinearLayout.LAYOUT_DIRECTION_RTL
        }
        scroll.addView(content)
        root.addView(scroll, LinearLayout.LayoutParams(-1, 0, 1f))

        val nav = LinearLayout(this).apply {
            gravity = Gravity.CENTER
            setBackgroundColor(Color.WHITE)
            layoutDirection = LinearLayout.LAYOUT_DIRECTION_RTL
        }
        listOf("خانه","برنامه‌ها","پروفایل","مالی").forEach { name ->
            val b = Button(this).apply {
                text = name
                isAllCaps = false
                setTextColor(dark)
            }
            b.setOnClickListener {
                when(name) {
                    "خانه" -> showHome()
                    "برنامه‌ها" -> showEvents()
                    "پروفایل" -> showProfile()
                    "مالی" -> showFinance()
                }
            }
            nav.addView(b, LinearLayout.LayoutParams(0, 64, 1f))
        }
        root.addView(nav)
        setContentView(root)
    }

    private fun showHome() {
        base("خانه")
        card("سلام علی 👋\nبه باشگاه تجربه الفبا خوش آمدی.")
        card("📢 اطلاعیه جدید\nثبت‌نام برنامه بعدی باشگاه آغاز شد.")
        card("🌙 شب، سکوت، کویر\nتجربه آسمان شب، سکوت و کویر\nمشاهده جزئیات  ›")
        card("⭐ وضعیت شما\n۳۸۰ ستاره  •  سطح: تجربه‌گر\n۷ جلسه شرکت کرده‌اید")
    }

    private fun showEvents() {
        base("برنامه‌ها")
        card("برنامه‌های پیش‌رو")
        card("🌙 شب، سکوت، کویر\nپنجشنبه ۲۲ امرداد ۱۴۰۵\nظرفیت: ۲۵ نفر")
        card("🧠 زاویه دید\nجلسه گفت‌وگوی تجربه‌محور\nبه‌زودی")
        card("برنامه‌های گذشته\n۳ تجربه ثبت‌شده")
    }

    private fun showProfile() {
        base("پروفایل من")
        card("👤 علی نجفی\nعضو باشگاه تجربه الفبا")
        card("⭐ ۳۸۰ ستاره\nسطح: تجربه‌گر\nتا سطح بعدی: ۲۲۰ ستاره")
        card("🎟 ۷ جلسه شرکت کرده‌اید")
        card("🏅 نشان‌ها\nکاوشگر نخستین تجربه\nهمراه فعال")
    }

    private fun showFinance() {
        base("امور مالی")
        card("💳 وضعیت عضویت\nعضویت فعال تا ۳۰ شهریور ۱۴۰۵")
        card("مبلغ قابل پرداخت\n۵۰۰,۰۰۰ تومان")
        card("سوابق پرداخت\nشهریور — ۵۰۰,۰۰۰ تومان — تسویه شد\nمرداد — ۵۰۰,۰۰۰ تومان — تسویه شد")
    }
}
