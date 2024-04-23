package com.org.userstory101.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.org.userstory101.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val h1_black = TextStyle(
    fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
    fontSize = 24.sp,
    color = Color(0xFF1E1E1E)
)

val h2_black = TextStyle(
    fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
    fontSize = 20.sp,
    color = Color(0xFF121212)
)

val h3_black = TextStyle(
    fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
    fontSize = 18.sp,
    color = Color(0xFF121212)
)

val h4_bold = TextStyle(
    fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
    fontSize = 16.sp,
    color = Color(0xFF121212)
)

val h5_black = TextStyle(
    fontFamily = FontFamily(Font(R.font.poppins_medium)),
    fontSize = 16.sp,
    color = Color(0xFF121212)
)

val h6_bold = TextStyle(
    fontFamily = FontFamily(Font(R.font.poppins_medium)),
    fontSize = 14.sp,
    color = Color(0xFF121212)
)

val h6_black = TextStyle(
    fontFamily = FontFamily(Font(R.font.poppins_light)),
    fontSize = 14.sp,
    color = Color(0xFF121212)
)

val h7_black = TextStyle(
    fontFamily = FontFamily(Font(R.font.poppins_light)),
    fontSize = 12.sp,
    color = Color.Black
)

val h7_bold = TextStyle(
    fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
    fontSize = 12.sp,
    color = Color(0xFF121212)
)

val h8_black = TextStyle(
    fontFamily = FontFamily(Font(R.font.poppins_extra_light)),
    fontSize = 10.sp,
    color = Color(0xFF121212)
)