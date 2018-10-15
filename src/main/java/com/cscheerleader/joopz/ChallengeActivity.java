package com.cscheerleader.joopz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//import bsh.Interpreter;
//import org.joor.Reflect;
//import java.util.function.Supplier;
//import javax.tools.JavaCompiler;

public class ChallengeActivity extends AppCompatActivity {

    private TextView result;
    private EditText incomplete_loop, start_value, condition_operator, condition_value, value_change;
    //private Interpreter interpreter;
    private Button button_compile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

        incomplete_loop = (EditText) findViewById(R.id.incomplete_loop);
        //start_value = (EditText) findViewById(R.id.start_value);
        //condition_value = (EditText) findViewById(R.id.condition_value);
        //value_change = (EditText) findViewById(R.id.value_change);
        result = (TextView) findViewById(R.id.result);
        button_compile = (Button) findViewById(R.id.button_compile);

        //interpreter = new Interpreter();
        /*button_compile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    interpreter.set("myapp", ChallengeActivity.this); //a reference to activity
                    interpreter.set("code", incomplete_loop);
                    interpreter.set("button", button_compile);
                    result.setText("bob" + interpreter.eval(incomplete_loop.getText().toString()));
                    Log.v("MMMMMMMMMM", ""+interpreter.eval(incomplete_loop.getText().toString()));

                }
                catch(Exception e){}

            }
        });*/
        //String loop = "for int i = init_value; i < upper_bound; increment \n" +
        //       "\tSystem.out.println(i); \n";
        //String expected_output = "5 6 7 8";
        //displayProblem(loop, expected_output);
    }



    /*public void displayProblem(String problem, String expected_result) {

        //System.out.println("For the loop below --> \n");
        //System.out.println(problem);

        //incomplete_loop.setText(problem + "and\n" + expected_result);

        //System.out.println("With output --> \n");
        //System.out.println(expected_result);
        //System.out.println();
        //System.out.print("Enter init_value: ");
        String init = start_value.getText().toString();
        //System.out.print("Enter upper_bound: ");
        String condition_termination = condition_value.getText().toString();
        //System.out.print("Enter increment statement: ");
        String increment_statement = value_change.getText().toString();

        //result.setText(test(init, condition_termination, increment_statement));
    }

    /*public String test(String init, String condition_termination, String increment_statement) {
        try{
            //basic example was from https://blog.jooq.org/2018/04/03/how-to-compile-a-class-at-runtime-with-java-8-and-9/
            Supplier<String> supplier = Reflect.compile(
                    "com.example.CompileTest",
                    "package com.example;\n" +
                            "class CompileTest\n" +
                            "implements java.util.function.Supplier<String> {\n" +
                            "  public String get() {\n" +
                            "    String str=\"\";\n " +
                            "    for (int i=" + init + "; i <" + condition_termination + "; " + increment_statement + "){\n" +
                            "       str+=i;\n"  +
                            "       str+=\" \";\n" +
                            "    }\n" +
                            "    return str;\n" +
                            "  }\n" +
                            "}\n"
            ).create().get();
            String output = supplier.get();
            return output;
        }
        catch(Exception e){
            String message = e.toString();
            if (message.contains("Compilation"))
                return "Compilation error";
            return e.toString();
        }


    }*/

}