package com.geoquiz.ui;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.geoquiz.R;
import com.geoquiz.model.Question;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QuizActivity extends AppCompatActivity {

    @BindView(R.id.tv_question_text)
    TextView tvQuestionText;

    private int currentIndex = 0;

    private Question[] mQuestions = new Question[]{
            new Question((R.string.question_oceans), true),
            new Question((R.string.question_mideast), false),
            new Question((R.string.question_africa), false),
            new Question((R.string.question_americas), true),
            new Question((R.string.question_asia), true),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        tvQuestionText.setText(getCurrentIndex(currentIndex, mQuestions));
    }

    @OnClick(R.id.btn_true)
    void onClickTrue() {
        checkAnswer(true);
    }

    @OnClick(R.id.btn_false)
    void onClickFalse() {
        checkAnswer(false);
    }

    @OnClick(R.id.btn_next)
    void onClickNext() {
        currentIndex = (currentIndex + 1) % mQuestions.length;
        updateQuestion();
    }

    private void showToast(Activity activity, String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

    private int getCurrentIndex(int currentIndex, Question[] questions) {
        return questions[currentIndex].getTextResId();
    }

    private void updateQuestion() {
        tvQuestionText.setText(mQuestions[currentIndex].getTextResId());
    }

    private void checkAnswer(boolean chosenAnswer) {
        boolean answerIsTrue = mQuestions[currentIndex].isAnswerTrue();
        if (chosenAnswer == answerIsTrue) {
            showToast(this, getResources().getString(R.string.correct_toast));
        } else {
            showToast(this, getResources().getString(R.string.incorrect_toast));
        }

    }
}
