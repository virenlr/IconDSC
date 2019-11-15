package com.lukehere.app.icondsc.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lukehere.app.icondsc.R;

import androidx.appcompat.app.AppCompatActivity;

public class SpeakerDetailsActivity extends AppCompatActivity {
    public static final String SPEAKER_NUMBER = "speaker_number";
    private int speakerNumber;
    private ImageView mSpeakerImageView;
    private TextView mSpeakerTopicHeaderOneTextView, mSpeakerTopicBodyOneTextView, mSpeakerTopicHeaderTwoTextView, mSpeakerTopicBodyTwoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaker_details);

        Intent startingIntent = getIntent();
        speakerNumber = startingIntent.getIntExtra(SPEAKER_NUMBER, 1);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.speaker_details_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        mSpeakerImageView = findViewById(R.id.speaker_image_one);
        mSpeakerTopicHeaderOneTextView = findViewById(R.id.speaker_topic_header_one_text_view);
        mSpeakerTopicBodyOneTextView = findViewById(R.id.speaker_topic_body_one_text_view);
        mSpeakerTopicHeaderTwoTextView = findViewById(R.id.speaker_topic_header_two_text_view);
        mSpeakerTopicBodyTwoTextView = findViewById(R.id.speaker_topic_body_two_text_view);

        setSpeaker();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            SpeakerDetailsActivity.super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setSpeaker() {
        switch (speakerNumber) {
            case 1:
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle("Dr. Aynur Ünal");
                }
                mSpeakerImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_speaker_one));
                mSpeakerTopicHeaderOneTextView.setText("Digital Game-based Learning (DGBL)");
                mSpeakerTopicBodyOneTextView.setText("•DGBL is an instructional method that incorporates educational content or learning principles into (video) digital games with the goal of engaging learners.\n" +
                        "•Applications of DGBL draw upon the constructivist theory of education and connects educational content with computer or (video) digital games and can be used in almost all subjects and skill levels.\n" +
                        "•It provides learning opportunities that engage students in interactive instruction and helps prepare them to participate in the globalized, technological society of the 21st Century. DGBL involves activities that can range from completing very simple tasks to the development of intricate problem-solving skills.\n" +
                        "•According to Patricia Deubel, games can be categorized as “action, adventure, fighting, puzzle, role-playing, sports, and strategy.” DGBL has the potential to engage and motivate students and offer custom learning experiences while promoting long-term memory and providing practical experience.");
                mSpeakerTopicHeaderTwoTextView.setText("Open Innovation");
                mSpeakerTopicBodyTwoTextView.setText("Open Innovation is an engine to productivity and results in cheaper and faster innovative product development. Robot Operating Systems (ROS) which is available to all as open source software reduced the time to develop and the cost involved while creating a self-learning environment among the student teams with their professors as guides. “Tele-Nurse” where we have an Artificial Neural Network based intelligent module to help with the information gathering and decision making under uncertainty and with activating necessary actions such as calling the ambulance with a proper kind of tools and nurse help as described in the following schematics. Here the module we are developing is an open source module which we will be sharing with all, in order to reduce the cost and the time of development in Mobile Health Systems and Services (MHISS).");
                break;
            case 2:
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle("Dr. Dong Seog Han");
                }
                mSpeakerImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_speaker_two));
                mSpeakerTopicHeaderOneTextView.setText("Human Behavior Prediction with Deep Learning Technology");
                mSpeakerTopicBodyOneTextView.setText("The recent technological advances in sensor miniaturization and embedded processing have provided new challenges and possibilities in the field of wearable computing. Two research areas are particularly interested by this innovation: healthcare technology applications that are devoted to analyzing the daily activities of a person to evaluate their general health, and personal dead reckoning (PDR) systems that focus on the analysis of the person’s movements to keep track of his/her position in dangerous environments and situations. Results from these two research areas are a valid benchmark for developing systems that can predict human behavior in a given period of time. Therefore, the identification of suitable algorithms and techniques to process wearable sensors data is a research challenge that must be overcome for both areas. Apart from collecting data for experimentation, the possibility to compare different solutions over public test benches is as well crucial to this aim. May I say that, human behavior prediction research is a new dimension which research Engineers and Scientists must take on in this new age.");
                mSpeakerTopicHeaderTwoTextView.setVisibility(View.GONE);
                mSpeakerTopicBodyTwoTextView.setVisibility(View.GONE);
                break;
            case 3:
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle("Dr. A K Nayak");
                }
                mSpeakerImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_speaker_three));
                mSpeakerTopicHeaderOneTextView.setVisibility(View.GONE);
                mSpeakerTopicBodyOneTextView.setText("Modern technology enables society with the help of data communication & high speed networking. It is making the best use of the power of ICT in transforming the lives of the people. The amalgamation of human lives & ICT in current times has given rise to a massive force in stimulating the sense of involvement among the people of the country. India has a diverse population of 1.35 billion with 69% of them living in rural villages. The biggest challenge is to take the level of growth to this larger section of the society for the inclusive growth of the country and this is where the proper rural governance shall play a vital role.");
                mSpeakerTopicHeaderTwoTextView.setVisibility(View.GONE);
                mSpeakerTopicBodyTwoTextView.setVisibility(View.GONE);
                break;
            case 4:
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle("Dr. Damodran Subramanian");
                }
                mSpeakerImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_speaker_four));
                mSpeakerTopicHeaderOneTextView.setText("Emerging Trends in Aerospace Technologies using Digitalization and Data sciences");
                mSpeakerTopicBodyOneTextView.setText("Industrial revolution over the past few centuries have witnessed multitude challenges, disruptions, resulting in digital technologies as a key solution for sustenance and survival. Information technology and connectivity have revolutionized in the past decades helped to connect innovative minds to Design anywhere, Produce anywhere, and assemble anywhere, as you like. Digital Technologies and Data Sciences have emerged as a forerunner in the top 10 emerging technologies. We are in the Era of Digital and Digital continuity leading to Industry 4.0 and witnessing multi-dimensional disruptions. These technologies are going to change the speed of ideation, design, and manufacturing throughput to an unprecedented value creation, precision, performance and productivity. Cross breed of technologies, bring new dimensions, scale and effective utilization of capital assets. This keynote presentation on “Emerging Trends in Aerospace Technologies using Digitalization and Data sciences” is an attempt to revisit the evolution of the technologies over past decades and emerging techniques lined up in front of us as future technologies. Key technologies like Data Analytics, Machine Learning, IoT, IIoT and Augmented/ Virtual Reality are going to change the next decades significantly.");
                mSpeakerTopicHeaderTwoTextView.setVisibility(View.GONE);
                mSpeakerTopicBodyTwoTextView.setText("When we analyze this proliferation through deep dive, we discover the technology backbone is digitalization, When digitalization technologies mutate with other advanced technologies, we see a great outcome, which solves several problems and unbelievable results. Thanks to the digital continuity, which enables bi-directional communication with very high speed, to predict and enhance the way of life and identify potential problems, which was not possible earlier and a huge dependency on human expertise. In summary, Digitalization and Data Sciences not only bring novel technologies but also greater efficiency, productivity resulting in high performance. Moving forward, other enabling technologies like Industry 4.0 when combine with Data analytics and Machine learning enhances industrial automation the next level, let us welcome Industry 5.0 – Intelligence beyond automation.");
                break;
            case 5:
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle("Dr. Navin Kumar");
                }
                mSpeakerImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_speaker_five));
                mSpeakerTopicHeaderOneTextView.setText("5G Technology");
                mSpeakerTopicBodyOneTextView.setText("It's the next - fifth-generation of mobile internet connectivity promising much faster data download and upload speeds, wider coverage and more stable connections. It’s all about making better use of the radio spectrum and enabling far more devices to access the mobile internet at the same time. 5G will enable tomorrow's hyper-connected world, characterized by the global spread of smartphones and increasingly sophisticated applications for mobile technologies. It will be a world in which more and more objects are connected online, making our homes, cities, farms, and factories more efficient and smarter.");
                mSpeakerTopicHeaderTwoTextView.setVisibility(View.GONE);
                mSpeakerTopicBodyTwoTextView.setVisibility(View.GONE);
                break;
        }
    }
}