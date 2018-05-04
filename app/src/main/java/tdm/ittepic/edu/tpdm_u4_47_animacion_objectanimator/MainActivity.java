package tdm.ittepic.edu.tpdm_u4_47_animacion_objectanimator;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private RelativeLayout canvas;
    Button desvanece, giro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.image);
        canvas = (RelativeLayout) findViewById(R.id.animacionCanvas);
        desvanece=(Button)findViewById(R.id.btnDes);
        giro=(Button)findViewById(R.id.btnGiro);


        desvanece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                desvanencer();


            }
        });
        giro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                girar();
            }
        });

    }
    public void onButtonClick(View v){
        int screenHeigth = canvas.getHeight();
        int targetY = screenHeigth + imageView.getHeight();
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "y", targetY, 0).setDuration(10000);
        animator.setInterpolator(new BounceInterpolator());
        animator.start();


    }
    public void desvanencer(){
        ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(imageView, "alpha", 1f, 0f).setDuration(10000);
        fadeAnim.setInterpolator(new BounceInterpolator());
        fadeAnim.setRepeatCount(ValueAnimator.RESTART);
        fadeAnim.setRepeatMode(ValueAnimator.REVERSE);
        fadeAnim.start();

    }
    public void girar(){
        TimeInterpolator inter = new LinearInterpolator();

        ValueAnimator rotateFish = ObjectAnimator.ofFloat(imageView, "rotation", 360, 0);
        rotateFish.setDuration(2000).setRepeatCount(0); // animación solo una ves
        rotateFish.setInterpolator(inter); // establecemos el interpolador
        rotateFish.start();

        //sungset.play( rotateFish );
}
}