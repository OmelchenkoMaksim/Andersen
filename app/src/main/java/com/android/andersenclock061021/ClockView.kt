package com.android.andersenclock061021

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Log
import android.util.TypedValue
import android.view.View
import androidx.core.content.ContextCompat
import java.util.*
import kotlin.math.cos
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sin

class ClockView @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyle: Int = 0
) : View(context, attr, defStyle) {

    private var init = false
    private var min = 0
    private var max = 0
    private var fontSize = 0
    private var padding = 0
    private var radius = 0
    private var handTruncation = 0
    private var hourHandTruncation = 0
    private var numbers = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    private val rect = Rect()
    private var myPaint: Paint = Paint()

    private fun init() {
        padding = 50
        fontSize = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP, 13f,
            resources.displayMetrics
        ).toInt()
        min = min(height, width)
        max = max(height, width)
        radius = min / 2 - padding
        myPaint.apply {
            color = ContextCompat.getColor(context, R.color.black)
            isAntiAlias = true
            style = Paint.Style.STROKE
            strokeWidth = 10f
            init = true
            handTruncation = min / 18
            hourHandTruncation = min / 7
        }
    }

    override fun onDraw(canvas: Canvas) {
        if (!init) {
            init()
        }
        super.onDraw(canvas)
        drawClockCircle(canvas)
        drawClockCenter(canvas)
        drawNumbers(canvas)
        drawHands(canvas)

        postInvalidateDelayed(25)
    }

    private fun drawHand(canvas: Canvas, location: Double) {
        val angle = Math.PI * location / 30 - Math.PI / 2
        val handRadius = radius - handTruncation - hourHandTruncation
        canvas.drawLine(
            (width / 2).toFloat(), (height / 2).toFloat(),
            (width / 2 + cos(angle) * handRadius).toFloat(),
            (height / 2 + sin(angle) * handRadius).toFloat(),
            myPaint
        )
    }

    private fun drawHands(canvas: Canvas) {
        val c = Calendar.getInstance()
        var hour = c[Calendar.HOUR_OF_DAY].toFloat()
        hour = if (hour > 12) hour - 12 else hour
        myPaint.apply {
            strokeWidth = 8f
            color = ContextCompat.getColor(context, R.color.black)
        }
        drawHand(canvas, ((hour + c[Calendar.MINUTE] / 60) * 5f).toDouble())
        drawMinute(canvas, c)
        drawSecond(canvas, c)
    }

    private fun drawSecond(canvas: Canvas, c: Calendar) {
        myPaint.apply {
            strokeWidth = 4f
            color = ContextCompat.getColor(context, R.color.white)
        }
        drawMillisecondHand(
            canvas,
            c[Calendar.MILLISECOND].toDouble() + c[Calendar.SECOND] * 1000.toDouble()
        )
    }

    private fun drawMillisecondHand(canvas: Canvas, location: Double) {
        val angle = Math.PI * location / (30 * 1000) - Math.PI / 2
        val handRadius = radius - handTruncation
        canvas.drawLine(
            (width / 2).toFloat(), (height / 2).toFloat(),
            (width / 2 + cos(angle) * handRadius).toFloat(),
            (height / 2 + sin(angle) * handRadius).toFloat(),
            myPaint
        )
    }

    private fun drawMinute(canvas: Canvas, c: Calendar) {
        myPaint.apply {
            strokeWidth = 6f
            color = ContextCompat.getColor(context, R.color.dark_red)
        }
        drawSecondMinuteHand(
            canvas,
            c[Calendar.SECOND].toDouble() + c[Calendar.MINUTE] * 60.toDouble()
        )
    }

    private fun drawSecondMinuteHand(canvas: Canvas, location: Double) {
        Log.w("MyClock", "Location: $location")
        val angle = Math.PI * location / (30 * 60) - Math.PI / 2
        val handRadius = radius - handTruncation
        canvas.drawLine(
            (width / 2).toFloat(), (height / 2).toFloat(),
            (width / 2 + cos(angle) * handRadius).toFloat(),
            (height / 2 + sin(angle) * handRadius).toFloat(),
            myPaint
        )
    }

    private fun drawNumbers(canvas: Canvas) {
        myPaint.textSize = fontSize.toFloat()
        myPaint.apply {
            strokeWidth = 4f
            color = ContextCompat.getColor(context, R.color.dark_red)
        }
        numbers.forEach { number ->
            myPaint.getTextBounds(number.toString(), 0, number.toString().length, rect)
            val angle = Math.PI / 6 * (number - 3)
            val x = (width / 2 + cos(angle) * radius - rect.width() / 2).toInt()
            val y = (height / 2 + sin(angle) * radius + rect.height() / 2).toInt()
            canvas.drawText(number.toString(), x.toFloat(), y.toFloat(), myPaint)
        }
    }

    private fun drawClockCircle(canvas: Canvas) {
        canvas.drawCircle(width / 2.toFloat(), height / 2.toFloat(), min / 2.05f,
            myPaint.apply {
                color = ContextCompat.getColor(context, R.color.dark_red)
                strokeWidth = 10f
                style = Paint.Style.STROKE
            })
    }

    private fun drawClockCenter(canvas: Canvas) {
        canvas.drawCircle(width / 2.toFloat(), height / 2.toFloat(), min / 100f,
            myPaint.apply {
                color = ContextCompat.getColor(context, R.color.black)
                style = Paint.Style.FILL_AND_STROKE
            })
    }
}