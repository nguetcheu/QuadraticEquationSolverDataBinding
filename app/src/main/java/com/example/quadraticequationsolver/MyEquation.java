package com.example.quadraticequationsolver;

import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.quadraticequationsolver.databinding.ActivityMainBinding;

public class MyEquation extends BaseObservable {

    String a;
    String b;
    String c;
    ActivityMainBinding binding;

    public MyEquation(ActivityMainBinding binding) {
        this.binding = binding;
    }

    public MyEquation() {
    }

    @Bindable
    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    @Bindable
    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Bindable
    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public void solveEquation(View view){
        // Converting Strings to Integer
        int a = Integer.parseInt(getA());
        int b = Integer.parseInt(getB());
        int c = Integer.parseInt(getC());

        // Calculate the Discriminant
        double discriminant = b*b - 4*a*c;

        // Finding the Solutions (Roots)
        double x1, x2;

        if (discriminant > 0){
            // Two real and distinct roots (solutions)
            x1 = (-b + Math.sqrt(discriminant)) / 2*a;
            x2 = (-b - Math.sqrt(discriminant)) / 2*a;

            // Display the result in the textView
            binding.textView.setText("X1= "+x1+ "X2="+x2 );
        } else if (discriminant < 0) {
            // no real root
            binding.textView.setText("No real roots (complex roots)");
        } else {
            // one real solution (double root)
            x1 = -b / (2 *a);
            binding.textView.setText("X1= "+x1);
        }

    }
}
