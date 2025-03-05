package com.example.examenprueba;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textSignIn = findViewById(R.id.textSignIn);
        String text = "Already have an account? Sign In";

        SpannableString spannable = new SpannableString(text);

        // Aplicar negrita a "Already have an account?"
        spannable.setSpan(new StyleSpan(Typeface.BOLD), 0, 25, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Aplicar color y subrayado a "Sign In"
        spannable.setSpan(new ForegroundColorSpan(Color.parseColor("#FF8A80")), 26, text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new UnderlineSpan(), 26, text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Hacer "Sign In" clickeable
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                // Aquí puedes abrir la actividad de inicio de sesión
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(true);
            }
        };
        spannable.setSpan(clickableSpan, 26, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Aplicar el Spannable al TextView
        textSignIn.setText(spannable);
        textSignIn.setMovementMethod(LinkMovementMethod.getInstance());
    }
}